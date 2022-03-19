package org.villainy.sweetconcrete.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.helper.Shape;
import org.villainy.sweetconcrete.objectholders.ConcreteLadderBlocks;

import java.util.stream.Stream;

public class ConcreteLadderBlock extends LadderBlock {

    protected static final AABB LADDER_UNROTATED_AABB = Shape.getPixeledAABB(1.75, 0, 0, 14.25, 16, 1.5);
    protected static final VoxelShape LADDER_SOUTH_AABB =  Shapes.create(Shape.getRotatedAABB(LADDER_UNROTATED_AABB, Direction.SOUTH, false));
    protected static final VoxelShape LADDER_EAST_AABB  = Shapes.create(Shape.getRotatedAABB(LADDER_UNROTATED_AABB, Direction.EAST, false));
    protected static final VoxelShape LADDER_WEST_AABB  = Shapes.create(Shape.getRotatedAABB(LADDER_UNROTATED_AABB, Direction.WEST, false));
    protected static final VoxelShape LADDER_NORTH_AABB = Shapes.create(Shape.getRotatedAABB(LADDER_UNROTATED_AABB, Direction.NORTH, false));

    private boolean isEnabled() {
        return SweetConcreteConfig.enableLadders;
    }

    public ConcreteLadderBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor).noOcclusion().explosionResistance(0.4F).sound(SoundType.LADDER));
        setRegistryName(dyeColor.getSerializedName() + "_concrete_ladder");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
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
