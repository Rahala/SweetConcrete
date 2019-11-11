package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;

public class ConcreteStairsBlock extends StairsBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableStairs;
    }

    public ConcreteStairsBlock(DyeColor dyeColor, BlockState blockState) {
        super(blockState, Block.Properties.create(Material.ROCK, dyeColor).hardnessAndResistance(1.8F));
        setRegistryName(dyeColor.getName() + "_concrete_stairs");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if(group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }
}
