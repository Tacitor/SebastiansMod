/*
 * Tacitor
 * Oct 17, 2020
 * Custom Block and model
 */
package com.tacitor.sebastiansmod.blocks;

import java.util.stream.Stream;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
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
import net.minecraftforge.common.ToolType;

/**
 *
 * @author Tacitor
 */
public class SebTest extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 15, 14, 15),
            Block.makeCuboidShape(11, 5, 0, 14, 6, 1),
            Block.makeCuboidShape(11, 7, 0, 14, 8, 1),
            Block.makeCuboidShape(11, 6, 0, 12, 7, 1),
            Block.makeCuboidShape(13, 8, 0, 14, 9, 1),
            Block.makeCuboidShape(11, 9, 0, 14, 10, 1),
            Block.makeCuboidShape(7, 5, 0, 9, 6, 1),
            Block.makeCuboidShape(7, 7, 0, 9, 8, 1),
            Block.makeCuboidShape(7, 9, 0, 9, 10, 1),
            Block.makeCuboidShape(9, 5, 0, 10, 10, 1),
            Block.makeCuboidShape(5, 6, 0, 6, 9, 1),
            Block.makeCuboidShape(3, 5, 0, 6, 6, 1),
            Block.makeCuboidShape(3, 9, 0, 6, 10, 1),
            Block.makeCuboidShape(2, 6, 0, 3, 7, 1),
            Block.makeCuboidShape(3, 7, 0, 5, 8, 1),
            Block.makeCuboidShape(2, 8, 0, 3, 9, 1),
            Block.makeCuboidShape(0, 7, 8, 1, 8, 11),
            Block.makeCuboidShape(0, 8, 8, 1, 9, 9),
            Block.makeCuboidShape(0, 9, 8, 1, 10, 11),
            Block.makeCuboidShape(0, 5, 8, 1, 6, 11),
            Block.makeCuboidShape(0, 6, 10, 1, 7, 11),
            Block.makeCuboidShape(0, 5, 6, 1, 8, 7),
            Block.makeCuboidShape(0, 9, 6, 1, 10, 7),
            Block.makeCuboidShape(5, 7, 15, 6, 8, 16),
            Block.makeCuboidShape(4, 8, 15, 5, 9, 16),
            Block.makeCuboidShape(6, 8, 15, 7, 9, 16),
            Block.makeCuboidShape(3, 9, 15, 4, 12, 16),
            Block.makeCuboidShape(7, 9, 15, 8, 12, 16),
            Block.makeCuboidShape(10, 11, 15, 12, 12, 16),
            Block.makeCuboidShape(9, 7, 15, 10, 12, 16),
            Block.makeCuboidShape(10, 9, 15, 12, 10, 16),
            Block.makeCuboidShape(10, 7, 15, 12, 8, 16),
            Block.makeCuboidShape(3, 1, 15, 4, 5, 16),
            Block.makeCuboidShape(4, 5, 15, 6, 6, 16),
            Block.makeCuboidShape(6, 4, 15, 7, 5, 16),
            Block.makeCuboidShape(4, 3, 15, 6, 4, 16),
            Block.makeCuboidShape(6, 1, 15, 7, 3, 16),
            Block.makeCuboidShape(10, 1, 15, 11, 3, 16),
            Block.makeCuboidShape(11, 3, 15, 12, 4, 16),
            Block.makeCuboidShape(9, 3, 15, 10, 4, 16),
            Block.makeCuboidShape(8, 4, 15, 9, 6, 16),
            Block.makeCuboidShape(12, 4, 15, 13, 6, 16),
            Block.makeCuboidShape(15, 8, 11, 16, 11, 12),
            Block.makeCuboidShape(15, 11, 9, 16, 12, 11),
            Block.makeCuboidShape(15, 7, 9, 16, 8, 11),
            Block.makeCuboidShape(15, 11, 5, 16, 12, 7),
            Block.makeCuboidShape(15, 8, 7, 16, 11, 8),
            Block.makeCuboidShape(15, 7, 5, 16, 8, 7),
            Block.makeCuboidShape(15, 8, 4, 16, 11, 5),
            Block.makeCuboidShape(15, 2, 11, 16, 5, 12),
            Block.makeCuboidShape(15, 1, 9, 16, 2, 11),
            Block.makeCuboidShape(15, 2, 8, 16, 5, 9),
            Block.makeCuboidShape(15, 5, 9, 16, 6, 11),
            Block.makeCuboidShape(15, 1, 3, 16, 2, 6),
            Block.makeCuboidShape(15, 2, 6, 16, 6, 7)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    public static VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 15, 14, 15),
            Block.makeCuboidShape(15, 5, 11, 16, 6, 14),
            Block.makeCuboidShape(15, 7, 11, 16, 8, 14),
            Block.makeCuboidShape(15, 6, 11, 16, 7, 12),
            Block.makeCuboidShape(15, 8, 13, 16, 9, 14),
            Block.makeCuboidShape(15, 9, 11, 16, 10, 14),
            Block.makeCuboidShape(15, 5, 7, 16, 6, 9),
            Block.makeCuboidShape(15, 7, 7, 16, 8, 9),
            Block.makeCuboidShape(15, 9, 7, 16, 10, 9),
            Block.makeCuboidShape(15, 5, 9, 16, 10, 10),
            Block.makeCuboidShape(15, 6, 5, 16, 9, 6),
            Block.makeCuboidShape(15, 5, 3, 16, 6, 6),
            Block.makeCuboidShape(15, 9, 3, 16, 10, 6),
            Block.makeCuboidShape(15, 6, 2, 16, 7, 3),
            Block.makeCuboidShape(15, 7, 3, 16, 8, 5),
            Block.makeCuboidShape(15, 8, 2, 16, 9, 3),
            Block.makeCuboidShape(5, 7, 0, 8, 8, 1),
            Block.makeCuboidShape(7, 8, 0, 8, 9, 1),
            Block.makeCuboidShape(5, 9, 0, 8, 10, 1),
            Block.makeCuboidShape(5, 5, 0, 8, 6, 1),
            Block.makeCuboidShape(5, 6, 0, 6, 7, 1),
            Block.makeCuboidShape(9, 5, 0, 10, 8, 1),
            Block.makeCuboidShape(9, 9, 0, 10, 10, 1),
            Block.makeCuboidShape(0, 7, 5, 1, 8, 6),
            Block.makeCuboidShape(0, 8, 4, 1, 9, 5),
            Block.makeCuboidShape(0, 8, 6, 1, 9, 7),
            Block.makeCuboidShape(0, 9, 3, 1, 12, 4),
            Block.makeCuboidShape(0, 9, 7, 1, 12, 8),
            Block.makeCuboidShape(0, 11, 10, 1, 12, 12),
            Block.makeCuboidShape(0, 7, 9, 1, 12, 10),
            Block.makeCuboidShape(0, 9, 10, 1, 10, 12),
            Block.makeCuboidShape(0, 7, 10, 1, 8, 12),
            Block.makeCuboidShape(0, 1, 3, 1, 5, 4),
            Block.makeCuboidShape(0, 5, 4, 1, 6, 6),
            Block.makeCuboidShape(0, 4, 6, 1, 5, 7),
            Block.makeCuboidShape(0, 3, 4, 1, 4, 6),
            Block.makeCuboidShape(0, 1, 6, 1, 3, 7),
            Block.makeCuboidShape(0, 1, 10, 1, 3, 11),
            Block.makeCuboidShape(0, 3, 11, 1, 4, 12),
            Block.makeCuboidShape(0, 3, 9, 1, 4, 10),
            Block.makeCuboidShape(0, 4, 8, 1, 6, 9),
            Block.makeCuboidShape(0, 4, 12, 1, 6, 13),
            Block.makeCuboidShape(4, 8, 15, 5, 11, 16),
            Block.makeCuboidShape(5, 11, 15, 7, 12, 16),
            Block.makeCuboidShape(5, 7, 15, 7, 8, 16),
            Block.makeCuboidShape(9, 11, 15, 11, 12, 16),
            Block.makeCuboidShape(8, 8, 15, 9, 11, 16),
            Block.makeCuboidShape(9, 7, 15, 11, 8, 16),
            Block.makeCuboidShape(11, 8, 15, 12, 11, 16),
            Block.makeCuboidShape(4, 2, 15, 5, 5, 16),
            Block.makeCuboidShape(5, 1, 15, 7, 2, 16),
            Block.makeCuboidShape(7, 2, 15, 8, 5, 16),
            Block.makeCuboidShape(5, 5, 15, 7, 6, 16),
            Block.makeCuboidShape(10, 1, 15, 13, 2, 16),
            Block.makeCuboidShape(9, 2, 15, 10, 6, 16)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    public static VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 15, 14, 15),
            Block.makeCuboidShape(2, 5, 15, 5, 6, 16),
            Block.makeCuboidShape(2, 7, 15, 5, 8, 16),
            Block.makeCuboidShape(4, 6, 15, 5, 7, 16),
            Block.makeCuboidShape(2, 8, 15, 3, 9, 16),
            Block.makeCuboidShape(2, 9, 15, 5, 10, 16),
            Block.makeCuboidShape(7, 5, 15, 9, 6, 16),
            Block.makeCuboidShape(7, 7, 15, 9, 8, 16),
            Block.makeCuboidShape(7, 9, 15, 9, 10, 16),
            Block.makeCuboidShape(6, 5, 15, 7, 10, 16),
            Block.makeCuboidShape(10, 6, 15, 11, 9, 16),
            Block.makeCuboidShape(10, 5, 15, 13, 6, 16),
            Block.makeCuboidShape(10, 9, 15, 13, 10, 16),
            Block.makeCuboidShape(13, 6, 15, 14, 7, 16),
            Block.makeCuboidShape(11, 7, 15, 13, 8, 16),
            Block.makeCuboidShape(13, 8, 15, 14, 9, 16),
            Block.makeCuboidShape(15, 7, 5, 16, 8, 8),
            Block.makeCuboidShape(15, 8, 7, 16, 9, 8),
            Block.makeCuboidShape(15, 9, 5, 16, 10, 8),
            Block.makeCuboidShape(15, 5, 5, 16, 6, 8),
            Block.makeCuboidShape(15, 6, 5, 16, 7, 6),
            Block.makeCuboidShape(15, 5, 9, 16, 8, 10),
            Block.makeCuboidShape(15, 9, 9, 16, 10, 10),
            Block.makeCuboidShape(10, 7, 0, 11, 8, 1),
            Block.makeCuboidShape(11, 8, 0, 12, 9, 1),
            Block.makeCuboidShape(9, 8, 0, 10, 9, 1),
            Block.makeCuboidShape(12, 9, 0, 13, 12, 1),
            Block.makeCuboidShape(8, 9, 0, 9, 12, 1),
            Block.makeCuboidShape(4, 11, 0, 6, 12, 1),
            Block.makeCuboidShape(6, 7, 0, 7, 12, 1),
            Block.makeCuboidShape(4, 9, 0, 6, 10, 1),
            Block.makeCuboidShape(4, 7, 0, 6, 8, 1),
            Block.makeCuboidShape(12, 1, 0, 13, 5, 1),
            Block.makeCuboidShape(10, 5, 0, 12, 6, 1),
            Block.makeCuboidShape(9, 4, 0, 10, 5, 1),
            Block.makeCuboidShape(10, 3, 0, 12, 4, 1),
            Block.makeCuboidShape(9, 1, 0, 10, 3, 1),
            Block.makeCuboidShape(5, 1, 0, 6, 3, 1),
            Block.makeCuboidShape(4, 3, 0, 5, 4, 1),
            Block.makeCuboidShape(6, 3, 0, 7, 4, 1),
            Block.makeCuboidShape(7, 4, 0, 8, 6, 1),
            Block.makeCuboidShape(3, 4, 0, 4, 6, 1),
            Block.makeCuboidShape(0, 8, 4, 1, 11, 5),
            Block.makeCuboidShape(0, 11, 5, 1, 12, 7),
            Block.makeCuboidShape(0, 7, 5, 1, 8, 7),
            Block.makeCuboidShape(0, 11, 9, 1, 12, 11),
            Block.makeCuboidShape(0, 8, 8, 1, 11, 9),
            Block.makeCuboidShape(0, 7, 9, 1, 8, 11),
            Block.makeCuboidShape(0, 8, 11, 1, 11, 12),
            Block.makeCuboidShape(0, 2, 4, 1, 5, 5),
            Block.makeCuboidShape(0, 1, 5, 1, 2, 7),
            Block.makeCuboidShape(0, 2, 7, 1, 5, 8),
            Block.makeCuboidShape(0, 5, 5, 1, 6, 7),
            Block.makeCuboidShape(0, 1, 10, 1, 2, 13),
            Block.makeCuboidShape(0, 2, 9, 1, 6, 10)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    public static VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(1, 0, 1, 15, 14, 15),
            Block.makeCuboidShape(0, 5, 2, 1, 6, 5),
            Block.makeCuboidShape(0, 7, 2, 1, 8, 5),
            Block.makeCuboidShape(0, 6, 4, 1, 7, 5),
            Block.makeCuboidShape(0, 8, 2, 1, 9, 3),
            Block.makeCuboidShape(0, 9, 2, 1, 10, 5),
            Block.makeCuboidShape(0, 5, 7, 1, 6, 9),
            Block.makeCuboidShape(0, 7, 7, 1, 8, 9),
            Block.makeCuboidShape(0, 9, 7, 1, 10, 9),
            Block.makeCuboidShape(0, 5, 6, 1, 10, 7),
            Block.makeCuboidShape(0, 6, 10, 1, 9, 11),
            Block.makeCuboidShape(0, 5, 10, 1, 6, 13),
            Block.makeCuboidShape(0, 9, 10, 1, 10, 13),
            Block.makeCuboidShape(0, 6, 13, 1, 7, 14),
            Block.makeCuboidShape(0, 7, 11, 1, 8, 13),
            Block.makeCuboidShape(0, 8, 13, 1, 9, 14),
            Block.makeCuboidShape(8, 7, 15, 11, 8, 16),
            Block.makeCuboidShape(8, 8, 15, 9, 9, 16),
            Block.makeCuboidShape(8, 9, 15, 11, 10, 16),
            Block.makeCuboidShape(8, 5, 15, 11, 6, 16),
            Block.makeCuboidShape(10, 6, 15, 11, 7, 16),
            Block.makeCuboidShape(6, 5, 15, 7, 8, 16),
            Block.makeCuboidShape(6, 9, 15, 7, 10, 16),
            Block.makeCuboidShape(15, 7, 10, 16, 8, 11),
            Block.makeCuboidShape(15, 8, 11, 16, 9, 12),
            Block.makeCuboidShape(15, 8, 9, 16, 9, 10),
            Block.makeCuboidShape(15, 9, 12, 16, 12, 13),
            Block.makeCuboidShape(15, 9, 8, 16, 12, 9),
            Block.makeCuboidShape(15, 11, 4, 16, 12, 6),
            Block.makeCuboidShape(15, 7, 6, 16, 12, 7),
            Block.makeCuboidShape(15, 9, 4, 16, 10, 6),
            Block.makeCuboidShape(15, 7, 4, 16, 8, 6),
            Block.makeCuboidShape(15, 1, 12, 16, 5, 13),
            Block.makeCuboidShape(15, 5, 10, 16, 6, 12),
            Block.makeCuboidShape(15, 4, 9, 16, 5, 10),
            Block.makeCuboidShape(15, 3, 10, 16, 4, 12),
            Block.makeCuboidShape(15, 1, 9, 16, 3, 10),
            Block.makeCuboidShape(15, 1, 5, 16, 3, 6),
            Block.makeCuboidShape(15, 3, 4, 16, 4, 5),
            Block.makeCuboidShape(15, 3, 6, 16, 4, 7),
            Block.makeCuboidShape(15, 4, 7, 16, 6, 8),
            Block.makeCuboidShape(15, 4, 3, 16, 6, 4),
            Block.makeCuboidShape(11, 8, 0, 12, 11, 1),
            Block.makeCuboidShape(9, 11, 0, 11, 12, 1),
            Block.makeCuboidShape(9, 7, 0, 11, 8, 1),
            Block.makeCuboidShape(5, 11, 0, 7, 12, 1),
            Block.makeCuboidShape(7, 8, 0, 8, 11, 1),
            Block.makeCuboidShape(5, 7, 0, 7, 8, 1),
            Block.makeCuboidShape(4, 8, 0, 5, 11, 1),
            Block.makeCuboidShape(11, 2, 0, 12, 5, 1),
            Block.makeCuboidShape(9, 1, 0, 11, 2, 1),
            Block.makeCuboidShape(8, 2, 0, 9, 5, 1),
            Block.makeCuboidShape(9, 5, 0, 11, 6, 1),
            Block.makeCuboidShape(3, 1, 0, 6, 2, 1),
            Block.makeCuboidShape(6, 2, 0, 7, 6, 1)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    public SebTest() {
        super(Block.Properties.create(Material.ROCK)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .hardnessAndResistance(3.5f, 30f)
                .sound(SoundType.SLIME)
        );
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /*
    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.1f;
    }
    */
}
