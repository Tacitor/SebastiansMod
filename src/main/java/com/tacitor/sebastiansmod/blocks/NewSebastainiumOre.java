/*
 * Tacitor
 * Oct 17, 2020
 * Epic new texture for the ore block
 */
package com.tacitor.sebastiansmod.blocks;

import java.util.stream.Stream;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

/**
 *
 * @author Tacitor
 */
public class NewSebastainiumOre extends OreBlock {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape VOXEL_SHAPE = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 16, 16),
            Block.makeCuboidShape(16, 13, 2, 17, 14, 4),
            Block.makeCuboidShape(16, 1, 10, 17, 2, 12),
            Block.makeCuboidShape(16, 8, 9, 17, 9, 11),
            Block.makeCuboidShape(16, 12, 11, 17, 13, 13),
            Block.makeCuboidShape(16, 12, 7, 17, 13, 9),
            Block.makeCuboidShape(16, 11, 7, 17, 12, 8),
            Block.makeCuboidShape(16, 5, 11, 17, 6, 12),
            Block.makeCuboidShape(16, 13, 11, 17, 14, 12),
            Block.makeCuboidShape(16, 6, 13, 17, 7, 14),
            Block.makeCuboidShape(16, 7, 12, 17, 8, 15),
            Block.makeCuboidShape(16, 4, 2, 17, 5, 5),
            Block.makeCuboidShape(16, 10, 9, 17, 11, 12),
            Block.makeCuboidShape(16, 10, 3, 17, 11, 6),
            Block.makeCuboidShape(16, 2, 10, 17, 3, 14),
            Block.makeCuboidShape(16, 2, 4, 17, 3, 8),
            Block.makeCuboidShape(16, 5, 6, 17, 6, 10),
            Block.makeCuboidShape(16, 7, 5, 17, 8, 8),
            Block.makeCuboidShape(16, 9, 8, 17, 10, 13),
            Block.makeCuboidShape(16, 6, 4, 17, 7, 10),
            Block.makeCuboidShape(16, 3, 3, 17, 4, 9),
            Block.makeCuboidShape(16, 9, 2, 17, 10, 7),
            Block.makeCuboidShape(16, 12, 3, 17, 13, 5),
            Block.makeCuboidShape(16, 13, 2, 17, 14, 4),
            Block.makeCuboidShape(16, 1, 10, 17, 2, 12),
            Block.makeCuboidShape(16, 8, 9, 17, 9, 11),
            Block.makeCuboidShape(16, 12, 11, 17, 13, 13),
            Block.makeCuboidShape(16, 12, 7, 17, 13, 9),
            Block.makeCuboidShape(16, 11, 7, 17, 12, 8),
            Block.makeCuboidShape(16, 5, 11, 17, 6, 12),
            Block.makeCuboidShape(16, 13, 11, 17, 14, 12),
            Block.makeCuboidShape(16, 6, 13, 17, 7, 14),
            Block.makeCuboidShape(16, 7, 12, 17, 8, 15),
            Block.makeCuboidShape(16, 4, 2, 17, 5, 5),
            Block.makeCuboidShape(16, 10, 9, 17, 11, 12),
            Block.makeCuboidShape(16, 10, 3, 17, 11, 6),
            Block.makeCuboidShape(16, 2, 10, 17, 3, 14),
            Block.makeCuboidShape(16, 2, 4, 17, 3, 8),
            Block.makeCuboidShape(16, 5, 6, 17, 6, 10),
            Block.makeCuboidShape(16, 7, 5, 17, 8, 8),
            Block.makeCuboidShape(16, 9, 8, 17, 10, 13),
            Block.makeCuboidShape(16, 6, 4, 17, 7, 10),
            Block.makeCuboidShape(16, 3, 3, 17, 4, 9),
            Block.makeCuboidShape(16, 9, 2, 17, 10, 7),
            Block.makeCuboidShape(16, 12, 3, 17, 13, 5),
            Block.makeCuboidShape(3, 12, -1, 5, 13, 0),
            Block.makeCuboidShape(2, 13, -1, 4, 14, 0),
            Block.makeCuboidShape(10, 1, -1, 12, 2, 0),
            Block.makeCuboidShape(9, 8, -1, 11, 9, 0),
            Block.makeCuboidShape(11, 12, -1, 13, 13, 0),
            Block.makeCuboidShape(7, 12, -1, 9, 13, 0),
            Block.makeCuboidShape(7, 11, -1, 8, 12, 0),
            Block.makeCuboidShape(11, 5, -1, 12, 6, 0),
            Block.makeCuboidShape(11, 13, -1, 12, 14, 0),
            Block.makeCuboidShape(13, 6, -1, 14, 7, 0),
            Block.makeCuboidShape(12, 7, -1, 15, 8, 0),
            Block.makeCuboidShape(2, 4, -1, 5, 5, 0),
            Block.makeCuboidShape(9, 10, -1, 12, 11, 0),
            Block.makeCuboidShape(3, 10, -1, 6, 11, 0),
            Block.makeCuboidShape(10, 2, -1, 14, 3, 0),
            Block.makeCuboidShape(4, 2, -1, 8, 3, 0),
            Block.makeCuboidShape(6, 5, -1, 10, 6, 0),
            Block.makeCuboidShape(5, 7, -1, 8, 8, 0),
            Block.makeCuboidShape(8, 9, -1, 13, 10, 0),
            Block.makeCuboidShape(4, 6, -1, 10, 7, 0),
            Block.makeCuboidShape(3, 3, -1, 9, 4, 0),
            Block.makeCuboidShape(2, 9, -1, 7, 10, 0),
            Block.makeCuboidShape(12, 13, 16, 14, 14, 17),
            Block.makeCuboidShape(4, 1, 16, 6, 2, 17),
            Block.makeCuboidShape(5, 8, 16, 7, 9, 17),
            Block.makeCuboidShape(3, 12, 16, 5, 13, 17),
            Block.makeCuboidShape(7, 12, 16, 9, 13, 17),
            Block.makeCuboidShape(8, 11, 16, 9, 12, 17),
            Block.makeCuboidShape(4, 5, 16, 5, 6, 17),
            Block.makeCuboidShape(4, 13, 16, 5, 14, 17),
            Block.makeCuboidShape(2, 6, 16, 3, 7, 17),
            Block.makeCuboidShape(1, 7, 16, 4, 8, 17),
            Block.makeCuboidShape(11, 4, 16, 14, 5, 17),
            Block.makeCuboidShape(4, 10, 16, 7, 11, 17),
            Block.makeCuboidShape(10, 10, 16, 13, 11, 17),
            Block.makeCuboidShape(2, 2, 16, 6, 3, 17),
            Block.makeCuboidShape(8, 2, 16, 12, 3, 17),
            Block.makeCuboidShape(6, 5, 16, 10, 6, 17),
            Block.makeCuboidShape(8, 7, 16, 11, 8, 17),
            Block.makeCuboidShape(3, 9, 16, 8, 10, 17),
            Block.makeCuboidShape(6, 6, 16, 12, 7, 17),
            Block.makeCuboidShape(7, 3, 16, 13, 4, 17),
            Block.makeCuboidShape(9, 9, 16, 14, 10, 17),
            Block.makeCuboidShape(11, 12, 16, 13, 13, 17),
            Block.makeCuboidShape(-1, 13, 12, 0, 14, 14),
            Block.makeCuboidShape(-1, 1, 4, 0, 2, 6),
            Block.makeCuboidShape(-1, 8, 5, 0, 9, 7),
            Block.makeCuboidShape(-1, 12, 3, 0, 13, 5),
            Block.makeCuboidShape(-1, 12, 7, 0, 13, 9),
            Block.makeCuboidShape(-1, 11, 8, 0, 12, 9),
            Block.makeCuboidShape(-1, 5, 4, 0, 6, 5),
            Block.makeCuboidShape(-1, 13, 4, 0, 14, 5),
            Block.makeCuboidShape(-1, 6, 2, 0, 7, 3),
            Block.makeCuboidShape(-1, 7, 1, 0, 8, 4),
            Block.makeCuboidShape(-1, 4, 11, 0, 5, 14),
            Block.makeCuboidShape(-1, 10, 4, 0, 11, 7),
            Block.makeCuboidShape(-1, 10, 10, 0, 11, 13),
            Block.makeCuboidShape(-1, 2, 2, 0, 3, 6),
            Block.makeCuboidShape(-1, 2, 8, 0, 3, 12),
            Block.makeCuboidShape(-1, 5, 6, 0, 6, 10),
            Block.makeCuboidShape(-1, 7, 8, 0, 8, 11),
            Block.makeCuboidShape(-1, 9, 3, 0, 10, 8),
            Block.makeCuboidShape(-1, 6, 6, 0, 7, 12),
            Block.makeCuboidShape(-1, 3, 7, 0, 4, 13),
            Block.makeCuboidShape(-1, 9, 9, 0, 10, 14),
            Block.makeCuboidShape(-1, 12, 11, 0, 13, 13),
            Block.makeCuboidShape(2, 16, 13, 4, 17, 14),
            Block.makeCuboidShape(10, 16, 1, 12, 17, 2),
            Block.makeCuboidShape(9, 16, 8, 11, 17, 9),
            Block.makeCuboidShape(11, 16, 12, 13, 17, 13),
            Block.makeCuboidShape(7, 16, 12, 9, 17, 13),
            Block.makeCuboidShape(7, 16, 11, 8, 17, 12),
            Block.makeCuboidShape(11, 16, 5, 12, 17, 6),
            Block.makeCuboidShape(11, 16, 13, 12, 17, 14),
            Block.makeCuboidShape(13, 16, 6, 14, 17, 7),
            Block.makeCuboidShape(12, 16, 7, 15, 17, 8),
            Block.makeCuboidShape(2, 16, 4, 5, 17, 5),
            Block.makeCuboidShape(9, 16, 10, 12, 17, 11),
            Block.makeCuboidShape(3, 16, 10, 6, 17, 11),
            Block.makeCuboidShape(10, 16, 2, 14, 17, 3),
            Block.makeCuboidShape(4, 16, 2, 8, 17, 3),
            Block.makeCuboidShape(6, 16, 5, 10, 17, 6),
            Block.makeCuboidShape(5, 16, 7, 8, 17, 8),
            Block.makeCuboidShape(8, 16, 9, 13, 17, 10),
            Block.makeCuboidShape(4, 16, 6, 10, 17, 7),
            Block.makeCuboidShape(3, 16, 3, 9, 17, 4),
            Block.makeCuboidShape(2, 16, 9, 7, 17, 10),
            Block.makeCuboidShape(3, 16, 12, 5, 17, 13),
            Block.makeCuboidShape(2, -1, 13, 4, 0, 14),
            Block.makeCuboidShape(10, -1, 1, 12, 0, 2),
            Block.makeCuboidShape(9, -1, 8, 11, 0, 9),
            Block.makeCuboidShape(11, -1, 12, 13, 0, 13),
            Block.makeCuboidShape(7, -1, 12, 9, 0, 13),
            Block.makeCuboidShape(7, -1, 11, 8, 0, 12),
            Block.makeCuboidShape(11, -1, 5, 12, 0, 6),
            Block.makeCuboidShape(11, -1, 13, 12, 0, 14),
            Block.makeCuboidShape(13, -1, 6, 14, 0, 7),
            Block.makeCuboidShape(12, -1, 7, 15, 0, 8),
            Block.makeCuboidShape(2, -1, 4, 5, 0, 5),
            Block.makeCuboidShape(9, -1, 10, 12, 0, 11),
            Block.makeCuboidShape(3, -1, 10, 6, 0, 11),
            Block.makeCuboidShape(10, -1, 2, 14, 0, 3),
            Block.makeCuboidShape(4, -1, 2, 8, 0, 3),
            Block.makeCuboidShape(6, -1, 5, 10, 0, 6),
            Block.makeCuboidShape(5, -1, 7, 8, 0, 8),
            Block.makeCuboidShape(8, -1, 9, 13, 0, 10),
            Block.makeCuboidShape(4, -1, 6, 10, 0, 7),
            Block.makeCuboidShape(3, -1, 3, 9, 0, 4),
            Block.makeCuboidShape(2, -1, 9, 7, 0, 10),
            Block.makeCuboidShape(3, -1, 12, 5, 0, 13)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    public NewSebastainiumOre() {
        super(Block.Properties.create(Material.ROCK)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.STONE)
                .hardnessAndResistance(4.5f, 50)
        );
    }
    
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VOXEL_SHAPE;
    }

    /*
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
    
    
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }
     */
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.7f;
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        int exp = 3; //base
        //check for silk touch
        if (silktouch < 1) {
            //fortune multiplyer
            exp += exp * fortune;
            //random value added
            exp += (int) (Math.random() * 3);
        } else {
            exp = 0;
        }
        //System.out.println(exp);
        return exp;
    }
}
