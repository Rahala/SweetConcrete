package org.villainy.sweetconcrete.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteStairsBlocks;

import java.util.stream.Stream;

public class ConcreteStairsBlock extends StairBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableStairs;
    }

    public ConcreteStairsBlock(DyeColor dyeColor, BlockState blockState) {
        super(blockState, Block.Properties.of(Material.STONE, dyeColor).requiresCorrectToolForDrops().strength(1.25F, 4.2F));
        setRegistryName(dyeColor.getSerializedName() + "_concrete_stairs");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                ConcreteStairsBlocks.WHITE,
                ConcreteStairsBlocks.ORANGE,
                ConcreteStairsBlocks.MAGENTA,
                ConcreteStairsBlocks.LIGHT_BLUE,
                ConcreteStairsBlocks.YELLOW,
                ConcreteStairsBlocks.LIME,
                ConcreteStairsBlocks.PINK,
                ConcreteStairsBlocks.GRAY,
                ConcreteStairsBlocks.LIGHT_GRAY,
                ConcreteStairsBlocks.CYAN,
                ConcreteStairsBlocks.PURPLE,
                ConcreteStairsBlocks.BLUE,
                ConcreteStairsBlocks.BROWN,
                ConcreteStairsBlocks.GREEN,
                ConcreteStairsBlocks.RED,
                ConcreteStairsBlocks.BLACK
        );
    }
}
