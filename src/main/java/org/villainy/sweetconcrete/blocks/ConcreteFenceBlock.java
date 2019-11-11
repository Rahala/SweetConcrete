package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;

public class ConcreteFenceBlock extends FenceBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableFences;
    }

    public ConcreteFenceBlock(DyeColor dyeColor) {
        super(Block.Properties.from(Blocks.WHITE_CONCRETE).hardnessAndResistance(2.0F, 6.0F));
        setRegistryName(dyeColor.getName() + "_concrete_fence");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if(group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }
}
