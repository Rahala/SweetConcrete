package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcretePowderLayerBlocks;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class ConcretePowderLayerBlock extends Block {
    public static final IntegerProperty LAYERS = BlockStateProperties.LAYERS_1_8;
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{
            VoxelShapes.empty(),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public ConcretePowderLayerBlock(DyeColor dyeColor) {
        super(Block.Properties.create(Material.SAND, dyeColor).hardnessAndResistance(0.5F).sound(SoundType.SAND));
        this.setDefaultState(this.stateContainer.getBaseState().with(LAYERS, Integer.valueOf(1)));
        setRegistryName(dyeColor.getName() + "_concrete_powder_layer");
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        switch (type) {
            case LAND:
                return state.get(LAYERS) < 5;
            case WATER:
                return false;
            case AIR:
                return false;
            default:
                return false;
        }
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.get(LAYERS)];
    }

    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.get(LAYERS) - 1];
    }

    public boolean isTransparent(BlockState state) {
        return true;
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockState blockstate = worldIn.getBlockState(pos.down());
        Block block = blockstate.getBlock();

        if (block != Blocks.HONEY_BLOCK && block != Blocks.SOUL_SAND) {
            return Block.doesSideFillSquare(blockstate.getCollisionShape(worldIn, pos.down()), Direction.UP) || block == this && blockstate.get(LAYERS) == 8;
        } else {
            return true;
        }
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        int i = state.get(LAYERS);
        if (useContext.getItem().getItem() == this.asItem() && i < 8) {
            if (useContext.replacingClickedOnBlock()) {
                return useContext.getFace() == Direction.UP;
            } else {
                return true;
            }
        } else {
            return i == 1;
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = context.getWorld().getBlockState(context.getPos());
        if (blockstate.getBlock() == this) {
            int i = blockstate.get(LAYERS);
            return blockstate.with(LAYERS, Integer.valueOf(Math.min(8, i + 1)));
        } else {
            return super.getStateForPlacement(context);
        }
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }

    static public Stream<Block> allBlocks() {
        return Stream.of(
                ConcretePowderLayerBlocks.WHITE,
                ConcretePowderLayerBlocks.ORANGE,
                ConcretePowderLayerBlocks.MAGENTA,
                ConcretePowderLayerBlocks.LIGHT_BLUE,
                ConcretePowderLayerBlocks.YELLOW,
                ConcretePowderLayerBlocks.LIME,
                ConcretePowderLayerBlocks.PINK,
                ConcretePowderLayerBlocks.GRAY,
                ConcretePowderLayerBlocks.LIGHT_GRAY,
                ConcretePowderLayerBlocks.CYAN,
                ConcretePowderLayerBlocks.PURPLE,
                ConcretePowderLayerBlocks.BLUE,
                ConcretePowderLayerBlocks.BROWN,
                ConcretePowderLayerBlocks.GREEN,
                ConcretePowderLayerBlocks.RED,
                ConcretePowderLayerBlocks.BLACK
        );
    }

    private boolean isEnabled() {
        return SweetConcreteConfig.enablePowderLayers;
    }
}
