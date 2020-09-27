/*
 * Tacitor
 * Sep 26, 2020
 * Basic Block Items
 */
package com.tacitor.sebastiansmod.blocks;

import com.tacitor.sebastiansmod.SebastiansMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

/**
 *
 * @author Tacitor
 */
public class BlockItemBase extends BlockItem{
    
    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(SebastiansMod.MODTAB));
    }
    
}
