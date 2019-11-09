package org.villainy.sweetconcrete;

import net.minecraft.block.Block;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.villainy.sweetconcrete.blocks.*;
import org.villainy.sweetconcrete.items.*;
import org.villainy.sweetconcrete.objectholders.*;
import org.villainy.sweetconcrete.proxy.ClientProxy;
import org.villainy.sweetconcrete.proxy.IProxy;
import org.villainy.sweetconcrete.proxy.CommonProxy;

import java.util.stream.Stream;

@Mod("sweetconcrete")
public class SweetConcrete
{
    public static final String MODID = "sweetconcrete";

    public static IProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    private static final Logger LOG = LogManager.getLogger();

    public SweetConcrete() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(proxy::onFMLClientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(proxy::onFMLCommonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            final IForgeRegistry<Block> blockRegistry = event.getRegistry();

            Stream.of(DyeColor.values()).forEach(dyeColor -> {
                ConcreteSlabBlock slab = new ConcreteSlabBlock(dyeColor);

                blockRegistry.register(slab);
                blockRegistry.register(new ConcreteStairsBlock(dyeColor, slab.getDefaultState()));
                blockRegistry.register(new ConcreteWallBlock(dyeColor));
                blockRegistry.register(new ConcreteButtonBlock(dyeColor));
                blockRegistry.register(new ConcretePressurePlateBlock(dyeColor));
            });
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> itemRegistry = event.getRegistry();

            Stream.of(
                    ConcreteSlabBlocks.RED,
                    ConcreteSlabBlocks.YELLOW,
                    ConcreteSlabBlocks.GREEN,
                    ConcreteSlabBlocks.BLACK,
                    ConcreteSlabBlocks.BROWN,
                    ConcreteSlabBlocks.BLUE,
                    ConcreteSlabBlocks.WHITE,
                    ConcreteSlabBlocks.ORANGE,
                    ConcreteSlabBlocks.LIGHT_BLUE,
                    ConcreteSlabBlocks.MAGENTA,
                    ConcreteSlabBlocks.PINK,
                    ConcreteSlabBlocks.LIGHT_GRAY,
                    ConcreteSlabBlocks.LIME,
                    ConcreteSlabBlocks.CYAN,
                    ConcreteSlabBlocks.PURPLE,
                    ConcreteSlabBlocks.GRAY).forEach (block ->
                    itemRegistry.register(new ConcreteSlabBlockItem(block))
            );

            Stream.of(
                    ConcreteStairsBlocks.RED,
                    ConcreteStairsBlocks.YELLOW,
                    ConcreteStairsBlocks.GREEN,
                    ConcreteStairsBlocks.BLACK,
                    ConcreteStairsBlocks.BROWN,
                    ConcreteStairsBlocks.BLUE,
                    ConcreteStairsBlocks.WHITE,
                    ConcreteStairsBlocks.ORANGE,
                    ConcreteStairsBlocks.LIGHT_BLUE,
                    ConcreteStairsBlocks.MAGENTA,
                    ConcreteStairsBlocks.PINK,
                    ConcreteStairsBlocks.LIGHT_GRAY,
                    ConcreteStairsBlocks.LIME,
                    ConcreteStairsBlocks.CYAN,
                    ConcreteStairsBlocks.PURPLE,
                    ConcreteStairsBlocks.GRAY).forEach (block ->
                    itemRegistry.register(new ConcreteStairsBlockItem(block))
            );

            Stream.of(
                    ConcreteWallBlocks.RED,
                    ConcreteWallBlocks.YELLOW,
                    ConcreteWallBlocks.GREEN,
                    ConcreteWallBlocks.BLACK,
                    ConcreteWallBlocks.BROWN,
                    ConcreteWallBlocks.BLUE,
                    ConcreteWallBlocks.WHITE,
                    ConcreteWallBlocks.ORANGE,
                    ConcreteWallBlocks.LIGHT_BLUE,
                    ConcreteWallBlocks.MAGENTA,
                    ConcreteWallBlocks.PINK,
                    ConcreteWallBlocks.LIGHT_GRAY,
                    ConcreteWallBlocks.LIME,
                    ConcreteWallBlocks.CYAN,
                    ConcreteWallBlocks.PURPLE,
                    ConcreteWallBlocks.GRAY).forEach (block ->
                    itemRegistry.register(new ConcreteWallBlockItem(block))
            );

            Stream.of(
                    ConcreteButtonBlocks.RED,
                    ConcreteButtonBlocks.YELLOW,
                    ConcreteButtonBlocks.GREEN,
                    ConcreteButtonBlocks.BLACK,
                    ConcreteButtonBlocks.BROWN,
                    ConcreteButtonBlocks.BLUE,
                    ConcreteButtonBlocks.WHITE,
                    ConcreteButtonBlocks.ORANGE,
                    ConcreteButtonBlocks.LIGHT_BLUE,
                    ConcreteButtonBlocks.MAGENTA,
                    ConcreteButtonBlocks.PINK,
                    ConcreteButtonBlocks.LIGHT_GRAY,
                    ConcreteButtonBlocks.LIME,
                    ConcreteButtonBlocks.CYAN,
                    ConcreteButtonBlocks.PURPLE,
                    ConcreteButtonBlocks.GRAY).forEach (block ->
                    itemRegistry.register(new ConcreteButtonBlockItem(block))
            );

            Stream.of(
                    ConcretePressurePlateBlocks.RED,
                    ConcretePressurePlateBlocks.YELLOW,
                    ConcretePressurePlateBlocks.GREEN,
                    ConcretePressurePlateBlocks.BLACK,
                    ConcretePressurePlateBlocks.BROWN,
                    ConcretePressurePlateBlocks.BLUE,
                    ConcretePressurePlateBlocks.WHITE,
                    ConcretePressurePlateBlocks.ORANGE,
                    ConcretePressurePlateBlocks.LIGHT_BLUE,
                    ConcretePressurePlateBlocks.MAGENTA,
                    ConcretePressurePlateBlocks.PINK,
                    ConcretePressurePlateBlocks.LIGHT_GRAY,
                    ConcretePressurePlateBlocks.LIME,
                    ConcretePressurePlateBlocks.CYAN,
                    ConcretePressurePlateBlocks.PURPLE,
                    ConcretePressurePlateBlocks.GRAY).forEach (block ->
                    itemRegistry.register(new ConcretePressurePlateBlockItem(block))
            );
        }
    }
}
