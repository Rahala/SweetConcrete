package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcretePressurePlateBlocks;

import java.util.stream.Stream;

public class ConcretePressurePlateBlock extends PressurePlateBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enablePressurePlates;
    }

    public ConcretePressurePlateBlock(DyeColor dyeColor) {
        super(Sensitivity.EVERYTHING,
                Block.Properties.create(Material.ROCK, dyeColor)
                        .doesNotBlockMovement()
                        .hardnessAndResistance(0.5F));
        setRegistryName(dyeColor.getName() + "_concrete_pressure_plate");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
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
