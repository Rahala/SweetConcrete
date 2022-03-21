package org.villainy.sweetconcrete.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import org.villainy.sweetconcrete.config.SweetConcreteConfig;
import org.villainy.sweetconcrete.objectholders.ConcreteLadderBlocks;

import java.util.stream.Stream;

public class ConcreteLadderBlock extends LadderBlock {

    private boolean isEnabled() {
        return SweetConcreteConfig.enableLadders;
    }

    public ConcreteLadderBlock(DyeColor dyeColor) {
        super(Block.Properties.of(Material.STONE, dyeColor).noOcclusion().strength(0.4F).sound(SoundType.LADDER));
        setRegistryName(dyeColor.getSerializedName() + "_concrete_ladder");
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (group == CreativeModeTab.TAB_SEARCH || isEnabled())
            super.fillItemCategory(group, items);
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
