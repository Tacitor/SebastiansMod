/*
 * Lukas Krampitz
 * Oct 1, 2020
 * Custom tool item, made for the hackaxe, and axe pickaxe multitool
 */
package com.tacitor.sebastiansmod.tools;

import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;

/**
 *
 * @author Tacitor
 */
public class SebToolItem extends ToolItem {
    
    public SebToolItem(float damage, float attackSpeed, IItemTier tier, Set<Block> blocks, Item.Properties properties) {
        super(damage, attackSpeed, tier, blocks, properties);
    }
    
}
