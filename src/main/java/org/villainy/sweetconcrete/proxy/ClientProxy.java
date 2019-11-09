package org.villainy.sweetconcrete.proxy;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientProxy implements IProxy {

    private static final Logger LOG = LogManager.getLogger();

    @Override
    public void init() { }

    @Override
    public void onFMLClientSetup(FMLClientSetupEvent event) {
        LOG.info("onFMLClientSetup");
    }

    @Override
    public void onFMLCommonSetup(FMLCommonSetupEvent event) {
        LOG.info("onFMLCommonSetup");
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }
}
