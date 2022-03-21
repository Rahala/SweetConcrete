package org.villainy.sweetconcrete.blocks;

import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteVerticalSlabBlocks;

import java.util.stream.Stream;

public class ConcreteVerticalSlabBlock extends VerticalSlabBlock {
    private boolean isEnabled() {
        return SweetConcreteConfig.enableVerticalSlabs;
    }

    public ConcreteVerticalSlabBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor).requiresCorrectToolForDrops().strength(1.25F, 4.2F));
        setRegistryName(dyeColor.getSerializedName() + "_concrete_vertical_slab");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
    }

    static public Stream<Block> allBlocks() {
        return Stream.of(
                ConcreteVerticalSlabBlocks.WHITE,
                ConcreteVerticalSlabBlocks.ORANGE,
                ConcreteVerticalSlabBlocks.MAGENTA,
                ConcreteVerticalSlabBlocks.LIGHT_BLUE,
                ConcreteVerticalSlabBlocks.YELLOW,
                ConcreteVerticalSlabBlocks.LIME,
                ConcreteVerticalSlabBlocks.PINK,
                ConcreteVerticalSlabBlocks.GRAY,
                ConcreteVerticalSlabBlocks.LIGHT_GRAY,
                ConcreteVerticalSlabBlocks.CYAN,
                ConcreteVerticalSlabBlocks.PURPLE,
                ConcreteVerticalSlabBlocks.BLUE,
                ConcreteVerticalSlabBlocks.BROWN,
                ConcreteVerticalSlabBlocks.GREEN,
                ConcreteVerticalSlabBlocks.RED,
                ConcreteVerticalSlabBlocks.BLACK
        );
    }
}
