package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteVerticalSlabBlocks;

import java.util.stream.Stream;

public class ConcreteVerticalSlabBlock extends VerticalSlabBlock {
    private boolean isEnabled() {
        return SweetConcreteConfig.enableVerticalSlabs;
    }

    public ConcreteVerticalSlabBlock(DyeColor dyeColor) {
        super(Block.Properties.create(Material.ROCK, dyeColor).hardnessAndResistance(1.8F));
        setRegistryName(dyeColor.getTranslationKey() + "_concrete_vertical_slab");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }

    static public Stream<Block> allBlocks() {
        return Stream.of(
                ConcreteVerticalSlabBlocks.WHITE,
                ConcreteVerticalSlabBlocks.ORANGE,
                ConcreteVerticalSlabBlocks.MAGENTA,
                ConcreteVerticalSlabBlocks.LIGHT_BLUE,
                ConcreteVerticalSlabBlocks.YELLOW,
                ConcreteVerticalSlabBlocks.LIME,
                ConcreteVerticalSlabBlocks.PINK,
                ConcreteVerticalSlabBlocks.GRAY,
                ConcreteVerticalSlabBlocks.LIGHT_GRAY,
                ConcreteVerticalSlabBlocks.CYAN,
                ConcreteVerticalSlabBlocks.PURPLE,
                ConcreteVerticalSlabBlocks.BLUE,
                ConcreteVerticalSlabBlocks.BROWN,
                ConcreteVerticalSlabBlocks.GREEN,
                ConcreteVerticalSlabBlocks.RED,
                ConcreteVerticalSlabBlocks.BLACK
        );
    }
}
