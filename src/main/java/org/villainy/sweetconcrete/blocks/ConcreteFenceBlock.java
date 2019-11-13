package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteFenceBlocks;

import java.util.stream.Stream;

public class ConcreteFenceBlock extends FenceBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableFences;
    }

    public ConcreteFenceBlock(DyeColor dyeColor) {
        super(Block.Properties.create(Material.ROCK, dyeColor).hardnessAndResistance(2.0F, 6.0F));
        setRegistryName(dyeColor.getName() + "_concrete_fence");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                ConcreteFenceBlocks.WHITE,
                ConcreteFenceBlocks.ORANGE,
                ConcreteFenceBlocks.MAGENTA,
                ConcreteFenceBlocks.LIGHT_BLUE,
                ConcreteFenceBlocks.YELLOW,
                ConcreteFenceBlocks.LIME,
                ConcreteFenceBlocks.PINK,
                ConcreteFenceBlocks.GRAY,
                ConcreteFenceBlocks.LIGHT_GRAY,
                ConcreteFenceBlocks.CYAN,
                ConcreteFenceBlocks.PURPLE,
                ConcreteFenceBlocks.BLUE,
                ConcreteFenceBlocks.BROWN,
                ConcreteFenceBlocks.GREEN,
                ConcreteFenceBlocks.RED,
                ConcreteFenceBlocks.BLACK
        );
    }
}
