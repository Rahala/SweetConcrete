package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.item.DyeColor;

public class ConcreteButtonBlock extends StoneButtonBlock {

    public ConcreteButtonBlock(DyeColor dyeColor) {
        super(Block.Properties.from(Blocks.STONE_BUTTON));
        setRegistryName(dyeColor.getName() + "_concrete_button");
    }
}
