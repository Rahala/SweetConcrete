package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.helper.Shape;
import org.villainy.sweetconcrete.objectholders.ConcreteLadderBlocks;

import java.util.stream.Stream;

public class ConcreteLadderBlock extends LadderBlock {

    protected static final AxisAlignedBB LADDER_UNROTATED_AABB = Shape.getPixeledAABB(1.75, 0, 0, 14.25, 16, 1.5);
    protected static final VoxelShape LADDER_SOUTH_AABB =  VoxelShapes.create(Shape.getRotatedAABB(LADDER_UNROTATED_AABB, Direction.SOUTH, false));
    protected static final VoxelShape LADDER_EAST_AABB  = VoxelShapes.create(Shape.getRotatedAABB(LADDER_UNROTATED_AABB, Direction.EAST, false));
    protected static final VoxelShape LADDER_WEST_AABB  = VoxelShapes.create(Shape.getRotatedAABB(LADDER_UNROTATED_AABB, Direction.WEST, false));
    protected static final VoxelShape LADDER_NORTH_AABB = VoxelShapes.create(Shape.getRotatedAABB(LADDER_UNROTATED_AABB, Direction.NORTH, false));

    private boolean isEnabled() {
        return SweetConcreteConfig.enableLadders;
    }

    public ConcreteLadderBlock(DyeColor dyeColor) {
        super(Block.Properties.create(Material.ROCK, dyeColor).notSolid().hardnessAndResistance(0.4F).sound(SoundType.LADDER));
        setRegistryName(dyeColor.getTranslationKey() + "_concrete_ladder");
    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, LivingEntity entity) {
        return true;
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH: return LADDER_NORTH_AABB;
            case SOUTH: return LADDER_SOUTH_AABB;
            case WEST: return LADDER_WEST_AABB;
            default: return LADDER_EAST_AABB;
        }
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                ConcreteLadderBlocks.WHITE,
                ConcreteLadderBlocks.ORANGE,
                ConcreteLadderBlocks.MAGENTA,
                ConcreteLadderBlocks.LIGHT_BLUE,
                ConcreteLadderBlocks.YELLOW,
                ConcreteLadderBlocks.LIME,
                ConcreteLadderBlocks.PINK,
                ConcreteLadderBlocks.GRAY,
                ConcreteLadderBlocks.LIGHT_GRAY,
                ConcreteLadderBlocks.CYAN,
                ConcreteLadderBlocks.PURPLE,
                ConcreteLadderBlocks.BLUE,
                ConcreteLadderBlocks.BROWN,
                ConcreteLadderBlocks.GREEN,
                ConcreteLadderBlocks.RED,
                ConcreteLadderBlocks.BLACK
        );
    }
}
