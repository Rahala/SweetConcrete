package org.villainy.sweetconcrete.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import java.util.Objects;

public class ConcreteSlabBlockItem extends BlockItem {

    public ConcreteSlabBlockItem(Block block) {
        super(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
        this.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
    }
}
