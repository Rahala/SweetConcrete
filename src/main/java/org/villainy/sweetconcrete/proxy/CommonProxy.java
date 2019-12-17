package org.villainy.sweetconcrete.proxy;

import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.villainy.sweetconcrete.tileEntities.ConcreteSignTileEntity;

public class CommonProxy implements IProxy {

    public static TileEntityType<ConcreteSignTileEntity> concreteSignType;

    @Override
    public void init() {

    }

    @Override
    public void onFMLClientSetup(FMLClientSetupEvent event) {
    }

    @Override
    public void onFMLCommonSetup(FMLCommonSetupEvent event) {
    }

    @Override
    public void openSignButtonGui(BlockPos pos) {
    }

}