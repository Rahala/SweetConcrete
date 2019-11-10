package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;

public class ConcreteButtonBlock extends StoneButtonBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableButtons;
    }

    public ConcreteButtonBlock(DyeColor dyeColor) {
        super(Block.Properties.from(Blocks.STONE_BUTTON));
        setRegistryName(dyeColor.getName() + "_concrete_button");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if(group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }
}
