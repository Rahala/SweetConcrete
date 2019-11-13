package org.villainy.sweetconcrete.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteLadderBlocks;

import java.util.stream.Stream;

public class ConcreteLadderBlock extends LadderBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableLadders;
    }

    public ConcreteLadderBlock(DyeColor dyeColor) {
        super(Block.Properties.create(Material.MISCELLANEOUS, dyeColor).hardnessAndResistance(0.4F).sound(SoundType.LADDER));
        setRegistryName(dyeColor.getName() + "_concrete_ladder");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                ConcreteLadderBlocks.WHITE,
                ConcreteLadderBlocks.ORANGE,
                ConcreteLadderBlocks.MAGENTA,
                ConcreteLadderBlocks.LIGHT_BLUE,
                ConcreteLadderBlocks.YELLOW,
                ConcreteLadderBlocks.LIME,
                ConcreteLadderBlocks.PINK,
                ConcreteLadderBlocks.GRAY,
                ConcreteLadderBlocks.LIGHT_GRAY,
                ConcreteLadderBlocks.CYAN,
                ConcreteLadderBlocks.PURPLE,
                ConcreteLadderBlocks.BLUE,
                ConcreteLadderBlocks.BROWN,
                ConcreteLadderBlocks.GREEN,
                ConcreteLadderBlocks.RED,
                ConcreteLadderBlocks.BLACK
        );
    }
}
