package org.villainy.sweetconcrete.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StoneButtonBlock;
import net.minecraft.world.level.material.Material;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteButtonBlocks;

import java.util.stream.Stream;

public class ConcreteButtonBlock extends StoneButtonBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableButtons;
    }

    public ConcreteButtonBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE).color(dyeColor.getMaterialColor()));
        setRegistryName(dyeColor.getSerializedName() + "_concrete_button");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
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
