package org.villainy.sweetconcrete.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.material.Material;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteFenceBlocks;

import java.util.stream.Stream;

public class ConcreteFenceBlock extends FenceBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableFences;
    }

    public ConcreteFenceBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor).explosionResistance(1.8F));
        setRegistryName(dyeColor.getSerializedName() + "_concrete_fence");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
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
