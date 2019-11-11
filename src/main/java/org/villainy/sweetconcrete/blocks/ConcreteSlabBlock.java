package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;

public class ConcreteSlabBlock extends SlabBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableSlabs;
    }

    public ConcreteSlabBlock(DyeColor dyeColor) {
        super(Block.Properties.create(Material.ROCK, dyeColor).hardnessAndResistance(1.8F));
        setRegistryName(dyeColor.getName() + "_concrete_slab");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if(group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }
}
