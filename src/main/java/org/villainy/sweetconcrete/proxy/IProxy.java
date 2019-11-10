package org.villainy.sweetconcrete.proxy;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public interface IProxy {

    void onFMLClientSetup(final FMLClientSetupEvent event);
    void onFMLCommonSetup(final FMLCommonSetupEvent event);
}
