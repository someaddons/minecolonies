package com.minecolonies.coremod.advancements;

import com.minecolonies.api.util.constant.AdvancementsConstants;
import com.minecolonies.api.util.constant.Constants;
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

    // non-generic triggers
    public static final BuildingTrigger BUILDING = new BuildingTrigger();

    // the beginning
    //TODO: onItemUse guidebook - vanilla trigger

    public static final GenericTrigger WALK_AROUND = new GenericTrigger("walkAround");

    public static final GenericTrigger BUILD_SUPPLY = new GenericTrigger("buildSupply");
    // a colony base
    public static final GenericTrigger CHALLENGE_TH = new GenericTrigger(AdvancementsConstants.CHALLENGE + "TownHall");

    public static final GenericTrigger CHALLENGE_BUILDER = new GenericTrigger(AdvancementsConstants.CHALLENGE + "Builder");

    public static final GenericTrigger GOAL_TH1_BUILDER1 = new GenericTrigger(AdvancementsConstants.GOAL + "TH1andB1");
    // buildings first level
    //TODO: add chal for dman and wh - maybe combined?
    // buildings second level, by branches, should end with a challenge advancement
    public static final GenericTrigger CHALLENGE_BAKER = new GenericTrigger(AdvancementsConstants.CHALLENGE + "Baker");

    public static final GenericTrigger CHALLENGE_BARRACKS = new GenericTrigger(AdvancementsConstants.CHALLENGE + "Barracks");

    public static final GenericTrigger CHALLENGE_CHICKEN = new GenericTrigger(AdvancementsConstants.CHALLENGE + "ChickenHerder");

    public static final GenericTrigger CHALLENGE_COMPOSTER = new GenericTrigger(AdvancementsConstants.CHALLENGE + "Composter");

    public static final GenericTrigger CHALLENGE_COOK = new GenericTrigger(AdvancementsConstants.CHALLENGE + "Cook");

    public static final GenericTrigger CHALLENGE_COWBOY = new GenericTrigger(AdvancementsConstants.CHALLENGE + "Cowboy");

    public static final GenericTrigger CHALLENGE_FARMER = new GenericTrigger(AdvancementsConstants.CHALLENGE + "Farmer");

    public static final GenericTrigger CHALLENGE_FISHER = new GenericTrigger(AdvancementsConstants.CHALLENGE + "Fisherman");

    public static final GenericTrigger CHALLENGE_GUARDTOWER = new GenericTrigger(AdvancementsConstants.CHALLENGE + "GuardTower");

    public static final GenericTrigger CHALLENGE_LUMBERJACK = new GenericTrigger(AdvancementsConstants.CHALLENGE + "Lumberjack");

    public static final GenericTrigger CHALLENGE_MINER = new GenericTrigger(AdvancementsConstants.CHALLENGE + "Miner");

    public static final GenericTrigger CHALLENGE_SHEPHERD = new GenericTrigger(AdvancementsConstants.CHALLENGE + "Shepherd");

    public static final GenericTrigger CHALLENGE_SMELTER = new GenericTrigger(AdvancementsConstants.CHALLENGE + "Smeltery");

    public static final GenericTrigger CHALLENGE_SWINE = new GenericTrigger(AdvancementsConstants.CHALLENGE + "SwineHerder");

    public static final void init()
    {
        Method method;

        method = ReflectionHelper.findMethod(CriteriaTriggers.class, "register", "func_192118_a", ICriterionTrigger.class);

        method.setAccessible(true);

        try
        {
            method.invoke(null, WALK_AROUND);
            method.invoke(null, BUILD_SUPPLY);
            method.invoke(null, BUILDING);
            method.invoke(null, GOAL_TH1_BUILDER1);
            /*
            method.invoke(null, CHALLENGE_TH);
            method.invoke(null, CHALLENGE_BUILDER);
            method.invoke(null, CHALLENGE_BAKER);
            method.invoke(null, CHALLENGE_BARRACKS);
            method.invoke(null, CHALLENGE_CHICKEN);
            method.invoke(null, CHALLENGE_COMPOSTER);
            method.invoke(null, CHALLENGE_COOK);
            method.invoke(null, CHALLENGE_COWBOY);
            method.invoke(null, CHALLENGE_FARMER);
            method.invoke(null, CHALLENGE_FISHER);
            method.invoke(null, CHALLENGE_GUARDTOWER);
            method.invoke(null, CHALLENGE_LUMBERJACK);
            method.invoke(null, CHALLENGE_MINER);
            method.invoke(null, CHALLENGE_SHEPHERD);
            method.invoke(null, CHALLENGE_SMELTER);
            method.invoke(null, CHALLENGE_SWINE);*/
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Unlock all our recipes, triggered when finishing a builder1
     */
    public static final void unlockAllRecipes(EntityPlayerMP playerMP)
    {
        List<IRecipe> recipesToUnlock = new ArrayList<IRecipe>();

        for (IRecipe irecipe : ForgeRegistries.RECIPES) {
            if (irecipe.getRegistryName().toString().contains(Constants.MOD_ID))
            {
                recipesToUnlock.add(irecipe);
            }
        }
        playerMP.unlockRecipes(recipesToUnlock);
    }
}