package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteWallBlocks;

import java.util.stream.Stream;

public class ConcreteWallBlock extends WallBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableWalls;
    }

    public ConcreteWallBlock(DyeColor dyeColor) {
        super(Block.Properties.create(Material.ROCK, dyeColor).hardnessAndResistance(1.8F));
        setRegistryName(dyeColor.getName() + "_concrete_wall");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                ConcreteWallBlocks.WHITE,
                ConcreteWallBlocks.ORANGE,
                ConcreteWallBlocks.MAGENTA,
                ConcreteWallBlocks.LIGHT_BLUE,
                ConcreteWallBlocks.YELLOW,
                ConcreteWallBlocks.LIME,
                ConcreteWallBlocks.PINK,
                ConcreteWallBlocks.GRAY,
                ConcreteWallBlocks.LIGHT_GRAY,
                ConcreteWallBlocks.CYAN,
                ConcreteWallBlocks.PURPLE,
                ConcreteWallBlocks.BLUE,
                ConcreteWallBlocks.BROWN,
                ConcreteWallBlocks.GREEN,
                ConcreteWallBlocks.RED,
                ConcreteWallBlocks.BLACK
        );
    }
}
