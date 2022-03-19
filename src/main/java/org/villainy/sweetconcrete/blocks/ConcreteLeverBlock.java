package org.villainy.sweetconcrete.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.material.Material;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteLeverBlocks;

import java.util.stream.Stream;

public class ConcreteLeverBlock extends LeverBlock {
    private boolean isEnabled() {
        return SweetConcreteConfig.enableLevers;
    }

    public ConcreteLeverBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE).color(dyeColor.getMaterialColor()));
        setRegistryName(dyeColor.getSerializedName() + "_concrete_lever");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if(group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
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
