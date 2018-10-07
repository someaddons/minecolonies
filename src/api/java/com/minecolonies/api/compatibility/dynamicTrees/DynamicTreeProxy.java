package com.minecolonies.api.compatibility.dynamicTrees;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * This is the fallback for when dynamictrees is not present!
 */
public class DynamicTreeProxy {

    /**
     * Default method for when dynamic Tree's mod is not present, returns false
     * @param block Block to check
     * @return false
     */
    boolean checkForDynamicTreeBlock(final Block block)
    {
        return false;
    }

    /**
     * Default method for when dynamic Tree's mod is not present, returns false
     * @param block Block to check
     * @return false
     */
    boolean checkForDynamicLeavesBlock(final Block block)
    {
        return false;
    }

    /**
     * Get the list of Drops from a Dynamic leaf
     * @param leaf The leaf to check
     * @return NonNullList<ItemStack> Drops
     */
    NonNullList<ItemStack> getDropsForLeaf(final IBlockAccess world, final BlockPos pos, final IBlockState blockstate, final int fortune, final Block leaf) {return NonNullList.create();}

    /**
     * Default method for when dynamic Tree's mod is not present, returns false
     * @param item Block to check
     * @return false
     */
    boolean checkForDynamicSapling( final Item item)
    {
        return false;
    }

    /**
     * Default method when dynamic tree's isnt present
     * @param world null
     * @param blockToBreak null
     * @param toolToUse null
     * @param workerPos null
     * @return null
     */
    Runnable getTreeBreakActionCompat(final World world, final BlockPos blockToBreak, final ItemStack toolToUse, final BlockPos workerPos) {return null;}


    boolean plantDynamicSaplingCompat(World world,BlockPos location,ItemStack sapling) {return false;}

}
