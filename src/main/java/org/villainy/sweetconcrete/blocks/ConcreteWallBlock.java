package org.villainy.sweetconcrete.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.material.Material;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteWallBlocks;

import java.util.stream.Stream;

public class ConcreteWallBlock extends WallBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableWalls;
    }

    public ConcreteWallBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor).requiresCorrectToolForDrops().strength(1.25F, 4.2F));
        setRegistryName(dyeColor.getSerializedName() + "_concrete_wall");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
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
