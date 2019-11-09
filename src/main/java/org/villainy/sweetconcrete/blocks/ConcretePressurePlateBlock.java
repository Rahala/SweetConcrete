package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.item.DyeColor;

public class ConcretePressurePlateBlock extends PressurePlateBlock {

    public ConcretePressurePlateBlock(DyeColor dyeColor) {
        super(Sensitivity.EVERYTHING, Block.Properties.from(Blocks.STONE_PRESSURE_PLATE));
        setRegistryName(dyeColor.getName() + "_concrete_pressure_plate");
    }
}
