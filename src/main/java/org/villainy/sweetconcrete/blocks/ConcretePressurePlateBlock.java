package org.villainy.sweetconcrete.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.material.Material;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcretePressurePlateBlocks;

import java.util.stream.Stream;

public class ConcretePressurePlateBlock extends PressurePlateBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enablePressurePlates;
    }

    public ConcretePressurePlateBlock(DyeColor dyeColor) {
        super(Sensitivity.EVERYTHING,
                Block.Properties.of(Material.STONE, dyeColor)
                        .explosionResistance(1.8F)
                        .noCollission());
        setRegistryName(dyeColor.getSerializedName() + "_concrete_pressure_plate");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                ConcretePressurePlateBlocks.WHITE,
                ConcretePressurePlateBlocks.ORANGE,
                ConcretePressurePlateBlocks.MAGENTA,
                ConcretePressurePlateBlocks.LIGHT_BLUE,
                ConcretePressurePlateBlocks.YELLOW,
                ConcretePressurePlateBlocks.LIME,
                ConcretePressurePlateBlocks.PINK,
                ConcretePressurePlateBlocks.GRAY,
                ConcretePressurePlateBlocks.LIGHT_GRAY,
                ConcretePressurePlateBlocks.CYAN,
                ConcretePressurePlateBlocks.PURPLE,
                ConcretePressurePlateBlocks.BLUE,
                ConcretePressurePlateBlocks.BROWN,
                ConcretePressurePlateBlocks.GREEN,
                ConcretePressurePlateBlocks.RED,
                ConcretePressurePlateBlocks.BLACK
        );
    }
}
