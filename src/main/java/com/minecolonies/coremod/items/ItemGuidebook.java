package com.minecolonies.coremod.items;

import com.minecolonies.api.util.Log;
import com.minecolonies.coremod.client.gui.WindowGuideBook;
import com.minecolonies.coremod.creativetab.ModCreativeTabs;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Class describing the Guide Book item.
 */
public class ItemGuidebook extends AbstractItemMinecolonies
{
    private static final String LOCATION_OF_GUIDEBOOKS = "/assets/minecolonies/gui/guidebook";
    /**
     * Sets the name, creative tab, and registers the Guide Book item.
     */
    public ItemGuidebook()
    {
        super("guidebook");
        super.setCreativeTab(ModCreativeTabs.MINECOLONIES);
        maxStackSize = 1;
    }

    @NotNull
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World worldIn, final EntityPlayer playerIn, final EnumHand hand)
    {
        final ItemStack stack = playerIn.getHeldItem(hand);
        String clientLanguage = Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode();

        //TODO: check if a book translation (LOCATION_OF_GUIDEBOOKS) exists and then use it
        if (!worldIn.isRemote)
        {
            if (true)
            {
                clientLanguage = "en_us";
            }
            Log.getLogger().info(worldIn.isRemote);

            @Nullable final WindowGuideBook window = new WindowGuideBook(stack, ((EntityPlayerMP) playerIn).getAdvancements(), clientLanguage);
            window.open();
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
}