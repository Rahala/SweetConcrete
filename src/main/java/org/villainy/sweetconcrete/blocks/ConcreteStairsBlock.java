package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.DyeColor;

public class ConcreteStairsBlock extends StairsBlock {

    public ConcreteStairsBlock(DyeColor dyeColor, BlockState blockState) {
        super(blockState, Block.Properties.from(Blocks.WHITE_CONCRETE));
        setRegistryName(dyeColor.getName() + "_concrete_stairs");
    }
}
