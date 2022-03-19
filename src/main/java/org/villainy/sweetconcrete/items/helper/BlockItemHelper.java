package org.villainy.sweetconcrete.items.helper;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Objects;

public class BlockItemHelper {

    public static Item createBasicBlockItem(Block block, CreativeModeTab group) {
        return new BlockItem(block, new Item.Properties().tab(group))
                .setRegistryName(Objects.requireNonNull(block.getRegistryName()));
    }

}
