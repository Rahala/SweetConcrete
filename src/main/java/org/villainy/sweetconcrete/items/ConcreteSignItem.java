package org.villainy.sweetconcrete.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkDirection;
import org.villainy.sweetconcrete.SweetConcrete;
import org.villainy.sweetconcrete.network.OpenConcreteSignEditor;
import org.villainy.sweetconcrete.tileEntities.ConcreteSignTileEntity;

import javax.annotation.Nullable;
import java.util.Objects;

public class ConcreteSignItem extends BlockItem {
    public ConcreteSignItem(Block block) {
        super(block, new Item.Properties().group(ItemGroup.DECORATIONS));
        setRegistryName(Objects.requireNonNull(block.getRegistryName()).toString());
    }

    @Override
    protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity player, ItemStack stack, BlockState state) {
        boolean flag = super.onBlockPlaced(pos, worldIn, player, stack, state);
        if (!worldIn.isRemote && !flag && player != null) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof ConcreteSignTileEntity) {
                ((ConcreteSignTileEntity) tileEntity).setPlayer(player);
                SweetConcrete.channel.sendTo(new OpenConcreteSignEditor(pos), ((ServerPlayerEntity) player).connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
            }
        }
        return flag;
    }
}
