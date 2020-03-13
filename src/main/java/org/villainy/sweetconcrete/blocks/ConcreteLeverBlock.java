package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteLeverBlocks;

import java.util.stream.Stream;

public class ConcreteLeverBlock extends LeverBlock {
    private boolean isEnabled() {
        return SweetConcreteConfig.enableLevers;
    }

    public ConcreteLeverBlock(DyeColor dyeColor) {
        super(Block.Properties.create(Material.ROCK, dyeColor));
        setRegistryName(dyeColor.getName() + "_concrete_lever");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if(group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                ConcreteLeverBlocks.WHITE,
                ConcreteLeverBlocks.ORANGE,
                ConcreteLeverBlocks.MAGENTA,
                ConcreteLeverBlocks.LIGHT_BLUE,
                ConcreteLeverBlocks.YELLOW,
                ConcreteLeverBlocks.LIME,
                ConcreteLeverBlocks.PINK,
                ConcreteLeverBlocks.GRAY,
                ConcreteLeverBlocks.LIGHT_GRAY,
                ConcreteLeverBlocks.CYAN,
                ConcreteLeverBlocks.PURPLE,
                ConcreteLeverBlocks.BLUE,
                ConcreteLeverBlocks.BROWN,
                ConcreteLeverBlocks.GREEN,
                ConcreteLeverBlocks.RED,
                ConcreteLeverBlocks.BLACK
        );
    }
}
