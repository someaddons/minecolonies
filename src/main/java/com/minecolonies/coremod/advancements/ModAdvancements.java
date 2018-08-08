package com.minecolonies.coremod.advancements;

import com.minecolonies.api.util.AdvancementsUtils.BuildingTrigger;
import com.minecolonies.api.util.AdvancementsUtils.GenericTrigger;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

import static com.minecolonies.api.util.constant.Constants.MOD_ID;
import static com.minecolonies.api.util.constant.WindowConstants.HUT_PREFIX;

/**
* List of all triggers and advancements init
*/
public final class ModAdvancements
{
    /**
     * Private constructor to hide public one.
     */
    private ModAdvancements()
    {
        /**
         * Intentionally left empty.
         */
    }

    // triggers
    public static final GenericTrigger GENERIC = new GenericTrigger();
    public static final BuildingTrigger BUILDING = new BuildingTrigger();

    public static final void init()
    {
        Method method;

        method = ReflectionHelper.findMethod(CriteriaTriggers.class, "register", "func_192118_a", ICriterionTrigger.class);

        method.setAccessible(true);

        try
        {
            method.invoke(null, GENERIC);
            method.invoke(null, BUILDING);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Unlock all our recipes except huts, triggered when finishing a builder1
     */
    public static final void unlockAllRecipes(EntityPlayerMP playerMP)
    {
        List<IRecipe> recipesToUnlock = new ArrayList<IRecipe>();

        for (IRecipe irecipe : ForgeRegistries.RECIPES) {
            String name = irecipe.getRegistryName().toString();
            if (name.contains(MOD_ID) && !name.contains(HUT_PREFIX))
            {
                recipesToUnlock.add(irecipe);
            }
        }
        playerMP.unlockRecipes(recipesToUnlock);
    }
}