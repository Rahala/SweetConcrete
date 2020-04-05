package org.villainy.sweetconcrete.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.villainy.sweetconcrete.blocks.ConcreteLadderBlock;
import org.villainy.sweetconcrete.client.ConcreteSignEditScreen;
import org.villainy.sweetconcrete.tileEntities.ConcreteSignTileEntity;
import org.villainy.sweetconcrete.tileEntities.renderers.ConcreteSignTileEntityRenderer;

public class ClientProxy implements IProxy {

    @Override
    public void init() {
        ClientRegistry.bindTileEntityRenderer(ConcreteSignTileEntity.TYPE, ConcreteSignTileEntityRenderer::new);
    }

    @Override
    public void onFMLClientSetup(FMLClientSetupEvent event) {
        setRenderTypes(event);
    }

    @Override
    public void onFMLCommonSetup(FMLCommonSetupEvent event) { }

    @Override
    public void openSignButtonGui(BlockPos pos)
    {
        Minecraft mc = Minecraft.getInstance();
        mc.execute(() -> {
            World world = mc.world;
            TileEntity te = world.getTileEntity(pos);
            if (te instanceof ConcreteSignTileEntity) {
                mc.displayGuiScreen(new ConcreteSignEditScreen((ConcreteSignTileEntity) te));
            }
        });
    }

    private void setRenderTypes(final FMLClientSetupEvent event)
    {
        ConcreteLadderBlock.allBlocks().forEach (block -> RenderTypeLookup.setRenderLayer(block, RenderType.getCutout()));
    }

}
