package org.villainy.sweetconcrete.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteFenceGateBlocks;

import java.util.stream.Stream;

public class ConcreteFenceGateBlock extends FenceGateBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableFences;
    }

    public ConcreteFenceGateBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor).requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.STONE));
        setRegistryName(dyeColor.getSerializedName() + "_concrete_fence_gate");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
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
