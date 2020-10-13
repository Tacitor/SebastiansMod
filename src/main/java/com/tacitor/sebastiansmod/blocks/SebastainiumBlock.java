/*
 * Tacitor
 * Oct 3, 2020
 * sebastainium_block
 */
package com.tacitor.sebastiansmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

/**
 *
 * @author Tacitor
 */
public class SebastainiumBlock extends Block{
    
    public SebastainiumBlock() {
        super(Block.Properties.create(Material.ROCK)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.METAL)
                .hardnessAndResistance(5.5f, 40)        
        );
    }
    
}
