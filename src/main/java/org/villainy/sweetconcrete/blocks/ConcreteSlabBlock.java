package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteSlabBlocks;

import java.util.stream.Stream;

public class ConcreteSlabBlock extends SlabBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableSlabs;
    }

    public ConcreteSlabBlock(DyeColor dyeColor) {
        super(Block.Properties.create(Material.ROCK, dyeColor).hardnessAndResistance(1.8F));
        setRegistryName(dyeColor.getName() + "_concrete_slab");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }

    static public Stream<Block> allBlocks() {
        return Stream.of(
                ConcreteSlabBlocks.WHITE,
                ConcreteSlabBlocks.ORANGE,
                ConcreteSlabBlocks.MAGENTA,
                ConcreteSlabBlocks.LIGHT_BLUE,
                ConcreteSlabBlocks.YELLOW,
                ConcreteSlabBlocks.LIME,
                ConcreteSlabBlocks.PINK,
                ConcreteSlabBlocks.GRAY,
                ConcreteSlabBlocks.LIGHT_GRAY,
                ConcreteSlabBlocks.CYAN,
                ConcreteSlabBlocks.PURPLE,
                ConcreteSlabBlocks.BLUE,
                ConcreteSlabBlocks.BROWN,
                ConcreteSlabBlocks.GREEN,
                ConcreteSlabBlocks.RED,
                ConcreteSlabBlocks.BLACK
        );
    }
}
