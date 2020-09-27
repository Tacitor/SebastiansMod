/*
 * Tacitor
 * Sep 26, 2020
 * Block of cool
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
public class SebastianBlock extends Block{
    
    public SebastianBlock() {
        super(Block.Properties.create(Material.SHULKER)
                .hardnessAndResistance(0f, 100.0f)
                .sound(SoundType.WET_GRASS)
                .harvestLevel(0)
                .harvestTool(ToolType.SHOVEL)
                .lightValue(0)
                .jumpFactor(50)
        );
    }
    
}
