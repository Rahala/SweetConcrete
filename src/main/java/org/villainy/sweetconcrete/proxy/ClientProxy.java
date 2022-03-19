package org.villainy.sweetconcrete.proxy;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ClientProxy implements IProxy {

    @Override
    public void init() {
    }

    @Override
    public void onFMLClientSetup(FMLClientSetupEvent event) {
        setRenderTypes(event);
    }

    @Override
    public void onFMLCommonSetup(FMLCommonSetupEvent event) { }

    private void setRenderTypes(final FMLClientSetupEvent event)
    {
//        ConcreteLadderBlock.allBlocks().forEach (block -> RenderTypeLookup.setRenderLayer(block, RenderType.getCutout()));
    }

}
