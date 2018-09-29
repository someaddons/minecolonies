package com.minecolonies.coremod.network.messages;

import com.minecolonies.api.colony.permissions.Action;
import com.minecolonies.api.util.LanguageHandler;
import com.minecolonies.api.util.Log;
import com.minecolonies.coremod.colony.CitizenData;
import com.minecolonies.coremod.colony.Colony;
import com.minecolonies.coremod.colony.ColonyManager;
import com.minecolonies.coremod.colony.buildings.workerbuildings.BuildingTownHall;
import com.minecolonies.coremod.entity.EntityCitizen;
import com.minecolonies.coremod.util.TeleportHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * Used to handle citizen recalls to the townhall.
 */
public class RecallTownhallMessage extends AbstractMessage<RecallTownhallMessage, IMessage>
{
    private int colonyId;

    /**
     * The dimension of the message.
     */
    private int dimension;

    /**
     * Empty public constructor.
     */
    public RecallTownhallMessage()
    {
        super();
    }

    /**
     * Object creation for the recall.
     *
     * @param townhall View of the townhall.
     */
    public RecallTownhallMessage(@NotNull final BuildingTownHall.View townhall)
    {
        super();
        this.colonyId = townhall.getColony().getID();
        this.dimension = townhall.getColony().getDimension();
    }

    @Override
    public void fromBytes(final ByteBuf buf)
    {
        colonyId = buf.readInt();
        dimension = buf.readInt();
    }

    @Override
    public void toBytes(final ByteBuf buf)
    {
        buf.writeInt(colonyId);
        buf.writeInt(dimension);
    }

    @Override
    public void messageOnServerThread(final RecallTownhallMessage message, final EntityPlayerMP player)
    {
        final Colony colony = ColonyManager.getColonyByDimension(message.colonyId, message.dimension);
        if (colony != null)
        {
            //Verify player has permission to change this huts settings
            if (!colony.getPermissions().hasPermission(player, Action.MANAGE_HUTS))
            {
                return;
            }

            @Nullable final BuildingTownHall building = colony.getBuildingManager().getTownHall();
            if (building != null)
            {
                final BlockPos location = building.getLocation();
                final World world = colony.getWorld();
                for (final CitizenData citizenData : colony.getCitizenManager().getCitizens())
                {
                    Optional<EntityCitizen> optionalEntityCitizen = citizenData.getCitizenEntity();
                    if (!optionalEntityCitizen.isPresent())
                    {
                        Log.getLogger().warn(String.format("Citizen #%d:%d has gone AWOL, respawning them!", colony.getID(), citizenData.getId()));
                        citizenData.updateCitizenEntityIfNecessary();
                        optionalEntityCitizen = citizenData.getCitizenEntity();
                    }

                    if (optionalEntityCitizen.isPresent() && !TeleportHelper.teleportCitizen(optionalEntityCitizen.get(), world, location))
                    {
                        LanguageHandler.sendPlayerMessage(player, "com.minecolonies.coremod.workerHuts.recallFail");
                    }
                }
            }
        }
    }
}
