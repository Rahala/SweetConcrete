package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.*;
import net.minecraft.item.DyeColor;

public class ConcreteSlabBlock extends SlabBlock {

    public ConcreteSlabBlock(DyeColor dyeColor) {
        super(Block.Properties.from(Blocks.WHITE_CONCRETE));
        setRegistryName(dyeColor.getName() + "_concrete_slab");
    }
}
