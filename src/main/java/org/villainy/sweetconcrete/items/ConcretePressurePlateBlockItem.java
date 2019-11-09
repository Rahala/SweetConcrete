package org.villainy.sweetconcrete.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import java.util.Objects;

public class ConcretePressurePlateBlockItem extends BlockItem {

    public ConcretePressurePlateBlockItem(Block block) {
        super(block, new Item.Properties().group(ItemGroup.REDSTONE));
        this.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
    }
}
