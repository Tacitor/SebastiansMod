/*
 * Tacitor
 * Oct 10, 2020
 * 
 */
package com.tacitor.sebastiansmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
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
                .hardnessAndResistance(4.5f, 50)
        );
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        int exp = 3; //base
        //check for silk touch
        if (silktouch < 1) {
            //fortune multiplyer
            exp += exp * fortune;
            //random value added
            exp += (int)(Math.random() * 3);
        } else {
            exp = 0;
        }
        System.out.println(exp);
        return exp;
    }
    
    
    
}
