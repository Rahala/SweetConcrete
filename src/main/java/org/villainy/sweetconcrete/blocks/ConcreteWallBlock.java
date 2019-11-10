package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallBlock;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;

public class ConcreteWallBlock extends WallBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableWalls;
    }

    public ConcreteWallBlock(DyeColor dyeColor) {
        super(Block.Properties.from(Blocks.WHITE_CONCRETE));
        setRegistryName(dyeColor.getName() + "_concrete_wall");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if(group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }
}
