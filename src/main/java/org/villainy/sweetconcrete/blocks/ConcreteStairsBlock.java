package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteStairsBlocks;

import java.util.stream.Stream;

public class ConcreteStairsBlock extends StairsBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableStairs;
    }

    public ConcreteStairsBlock(DyeColor dyeColor, BlockState blockState) {
        super(blockState, Block.Properties.create(Material.ROCK, dyeColor).hardnessAndResistance(1.8F));
        setRegistryName(dyeColor.getTranslationKey() + "_concrete_stairs");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
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
