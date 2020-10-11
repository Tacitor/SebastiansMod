/*
 * Tacitor
 * Oct 10, 2020
 * 
 */
package com.tacitor.sebastiansmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

/**
 *
 * @author Tacitor
 */
public class SebastainiumOre extends OreBlock {
    
    public SebastainiumOre() {
        super(Block.Properties.create(Material.ROCK)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.STONE)
                .hardnessAndResistance(3.5f, 20)
        );
    }
    
}
