package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteButtonBlocks;

import java.util.stream.Stream;

public class ConcreteButtonBlock extends StoneButtonBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableButtons;
    }

    public ConcreteButtonBlock(DyeColor dyeColor) {
        super(Block.Properties.create(Material.ROCK, dyeColor));
        setRegistryName(dyeColor.getTranslationKey() + "_concrete_button");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if(group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                ConcreteButtonBlocks.WHITE,
                ConcreteButtonBlocks.ORANGE,
                ConcreteButtonBlocks.MAGENTA,
                ConcreteButtonBlocks.LIGHT_BLUE,
                ConcreteButtonBlocks.YELLOW,
                ConcreteButtonBlocks.LIME,
                ConcreteButtonBlocks.PINK,
                ConcreteButtonBlocks.GRAY,
                ConcreteButtonBlocks.LIGHT_GRAY,
                ConcreteButtonBlocks.CYAN,
                ConcreteButtonBlocks.PURPLE,
                ConcreteButtonBlocks.BLUE,
                ConcreteButtonBlocks.BROWN,
                ConcreteButtonBlocks.GREEN,
                ConcreteButtonBlocks.RED,
                ConcreteButtonBlocks.BLACK
        );
    }
}
