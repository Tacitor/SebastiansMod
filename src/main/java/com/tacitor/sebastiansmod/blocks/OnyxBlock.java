/*
 * Tacitor
 * Sep 26, 2020
 * A block of Onyx
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
public class OnyxBlock extends Block {
    
    public OnyxBlock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(7.0f, 6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
        );
    }
    
}
