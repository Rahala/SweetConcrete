package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import org.villainy.sweetconcrete.objectholders.ConcreteCakeBlocks;

import java.util.stream.Stream;

public class ConcreteCakeBlock extends FallingBlock {

    public static final IntegerProperty BITES = BlockStateProperties.BITES_0_6;
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(3.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(5.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(7.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(9.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(11.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D), Block.makeCuboidShape(13.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D)};

    public ConcreteCakeBlock() {
        super(Block.Properties.create(Material.ROCK));
        this.setDefaultState(this.stateContainer.getBaseState().with(BITES, 0));
        setRegistryName("concrete_cake");
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.get(BITES)];
    }

    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            return this.eatCake(worldIn, pos, state, player);
        } else {
            ItemStack itemstack = player.getHeldItem(handIn);
            return this.eatCake(worldIn, pos, state, player) || itemstack.isEmpty();
        }
    }

    private boolean eatCake(IWorld worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canEat(false)) {
            return false;
        } else {
            player.addStat(Stats.EAT_CAKE_SLICE);
            player.getFoodStats().addStats(2, 0.1F);
            int i = state.get(BITES);
            if (i < 6) {
                worldIn.setBlockState(pos, state.with(BITES, Integer.valueOf(i + 1)), 3);
            } else {
                worldIn.removeBlock(pos, false);
            }

            return true;
        }
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).getMaterial().isSolid();
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
        return (7 - blockState.get(BITES)) * 2;
    }

    public boolean hasComparatorInputOverride(BlockState state) {
        return true;
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }

    protected void onStartFalling(FallingBlockEntity fallingEntity) {
        fallingEntity.setHurtEntities(true);
    }

    public void onEndFalling(World worldIn, BlockPos pos, BlockState fallingState, BlockState hitState) {
        worldIn.playEvent(1031, pos, 0);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                ConcreteCakeBlocks.CONCRETE_CAKE
        );
    }
}
