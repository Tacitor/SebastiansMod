/*
 * Tacitor
 * Oct 3, 2020
 * Custom tool item, made for the hackaxe, and axe pickaxe multitool
 */
package com.tacitor.sebastiansmod.tools;

import com.google.common.collect.ImmutableSet;
import com.tacitor.sebastiansmod.SebastiansMod;
import com.tacitor.sebastiansmod.util.HackaxeData;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;

/**
 *
 * @author Tacitor
 */
public class MultiPickaxeItem extends PickaxeItem{    
    
    public MultiPickaxeItem(IItemTier tier, int damage, float attackSpeed, Set<Block> newBlocks, Item.Properties properties) {
        super(tier, damage, attackSpeed, properties);
    }
    
    //@Override
    public Set<String> getToolClasses(ItemStack stack) {
        return ImmutableSet.of("pickaxe", "axe");
    }
    
    @Override
    public boolean canHarvestBlock(BlockState block) {
        
        if (true) {
            
            SebastiansMod.LOGGER.info("Block: " + block.getMaterial());
        }
        
        return HackaxeData.HACKAXE_EFFECTIVE_ON.contains(block.getBlock()) ? true : super.canHarvestBlock(block);
    }
    
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        
        Material material = state.getMaterial();
        if (material == Material.WOOD && material == Material.PLANTS) {
            return this.efficiency;
        }

        return HackaxeData.HACKAXE_EFFECTIVE_ON.contains(state.getBlock()) ? this.efficiency : super.getDestroySpeed(stack, state);
    }
}
