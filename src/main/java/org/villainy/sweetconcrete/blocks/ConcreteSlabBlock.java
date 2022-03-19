package org.villainy.sweetconcrete.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.material.Material;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteSlabBlocks;

import java.util.stream.Stream;

public class ConcreteSlabBlock extends SlabBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableSlabs;
    }

    public ConcreteSlabBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor).explosionResistance(1.8F));
        setRegistryName(dyeColor.getSerializedName() + "_concrete_slab");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
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
