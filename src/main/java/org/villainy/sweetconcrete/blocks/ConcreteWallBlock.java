package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallBlock;
import net.minecraft.item.DyeColor;

public class ConcreteWallBlock extends WallBlock {

    public ConcreteWallBlock(DyeColor dyeColor) {
        super(Block.Properties.from(Blocks.WHITE_CONCRETE));
        setRegistryName(dyeColor.getName() + "_concrete_wall");
    }
}
