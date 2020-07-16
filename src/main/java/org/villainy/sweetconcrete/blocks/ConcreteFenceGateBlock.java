package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteFenceGateBlocks;

import java.util.stream.Stream;

public class ConcreteFenceGateBlock extends FenceGateBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableFences;
    }

    public ConcreteFenceGateBlock(DyeColor dyeColor) {
        super(Block.Properties.create(Material.ROCK, dyeColor)
                .hardnessAndResistance(2.0F, 6.0F)
                .sound(SoundType.STONE));
        setRegistryName(dyeColor.getTranslationKey() + "_concrete_fence_gate");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                ConcreteFenceGateBlocks.WHITE,
                ConcreteFenceGateBlocks.ORANGE,
                ConcreteFenceGateBlocks.MAGENTA,
                ConcreteFenceGateBlocks.LIGHT_BLUE,
                ConcreteFenceGateBlocks.YELLOW,
                ConcreteFenceGateBlocks.LIME,
                ConcreteFenceGateBlocks.PINK,
                ConcreteFenceGateBlocks.GRAY,
                ConcreteFenceGateBlocks.LIGHT_GRAY,
                ConcreteFenceGateBlocks.CYAN,
                ConcreteFenceGateBlocks.PURPLE,
                ConcreteFenceGateBlocks.BLUE,
                ConcreteFenceGateBlocks.BROWN,
                ConcreteFenceGateBlocks.GREEN,
                ConcreteFenceGateBlocks.RED,
                ConcreteFenceGateBlocks.BLACK
        );
    }
}
