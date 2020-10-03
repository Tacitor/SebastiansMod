/*
 * Lukas Krampitz
 * Oct 3, 2020
 * Custom tool item, made for the hackaxe, and axe pickaxe multitool
 */
package com.tacitor.sebastiansmod.tools;

import com.google.common.collect.ImmutableSet;
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
        //Import an object holding all the large variables
        HackaxeData HACKAXE_VAR = new HackaxeData();
        
        return HACKAXE_VAR.getHackaxeEffectiveOn().contains(block.getBlock()) ? true : super.canHarvestBlock(block);
    }
    
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        //Import an object holding all the large variables
        HackaxeData HACKAXE_VAR = new HackaxeData();
        
        Material material = state.getMaterial();
        if (material == Material.WOOD && material == Material.PLANTS) {
            return this.efficiency;
        }

        return HACKAXE_VAR.getHackaxeEffectiveOn().contains(state.getBlock()) ? this.efficiency : super.getDestroySpeed(stack, state);
    }
}
