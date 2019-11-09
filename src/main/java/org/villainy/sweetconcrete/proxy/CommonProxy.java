package org.villainy.sweetconcrete.proxy;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonProxy implements IProxy {

    @Override
    public void init() { }

    @Override
    public void onFMLClientSetup(FMLClientSetupEvent event) {
    }

    @Override
    public void onFMLCommonSetup(FMLCommonSetupEvent event) {
    }

    @Override
    public World getClientWorld() {
        throw new IllegalStateException("Only run this on the client!");
    }

    @Override
    public PlayerEntity getClientPlayer() {
        throw new IllegalStateException("Only run this on the client!");
    }
}