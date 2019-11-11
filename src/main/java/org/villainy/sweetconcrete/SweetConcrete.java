package org.villainy.sweetconcrete;

import net.minecraft.block.Block;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.villainy.sweetconcrete.blocks.*;
import org.villainy.sweetconcrete.config.ConfigHelper;
import org.villainy.sweetconcrete.config.ConfigHolder;
import org.villainy.sweetconcrete.config.FlagRecipeCondition;
import org.villainy.sweetconcrete.items.helper.BlockItemHelper;
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
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();

        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC);

        CraftingHelper.register(new FlagRecipeCondition.Serializer(new ResourceLocation(SweetConcrete.MODID, "flag")));

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
                blockRegistry.register(new ConcreteFenceBlock(dyeColor));
                blockRegistry.register(new ConcreteFenceGateBlock(dyeColor));
            });
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> itemRegistry = event.getRegistry();

            Stream.of(
                    ConcreteSlabBlocks.WHITE,
                    ConcreteSlabBlocks.ORANGE,
                    ConcreteSlabBlocks.MAGENTA,
                    ConcreteSlabBlocks.LIGHT_BLUE,
                    ConcreteSlabBlocks.YELLOW,
                    ConcreteSlabBlocks.LIME,
                    ConcreteSlabBlocks.PINK,
                    ConcreteSlabBlocks.GRAY,
                    ConcreteSlabBlocks.LIGHT_GRAY,
                    ConcreteSlabBlocks.CYAN,
                    ConcreteSlabBlocks.PURPLE,
                    ConcreteSlabBlocks.BLUE,
                    ConcreteSlabBlocks.BROWN,
                    ConcreteSlabBlocks.GREEN,
                    ConcreteSlabBlocks.RED,
                    ConcreteSlabBlocks.BLACK
            ).forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.BUILDING_BLOCKS))
            );

            Stream.of(
                    ConcreteStairsBlocks.WHITE,
                    ConcreteStairsBlocks.ORANGE,
                    ConcreteStairsBlocks.MAGENTA,
                    ConcreteStairsBlocks.LIGHT_BLUE,
                    ConcreteStairsBlocks.YELLOW,
                    ConcreteStairsBlocks.LIME,
                    ConcreteStairsBlocks.PINK,
                    ConcreteStairsBlocks.GRAY,
                    ConcreteStairsBlocks.LIGHT_GRAY,
                    ConcreteStairsBlocks.CYAN,
                    ConcreteStairsBlocks.PURPLE,
                    ConcreteStairsBlocks.BLUE,
                    ConcreteStairsBlocks.BROWN,
                    ConcreteStairsBlocks.GREEN,
                    ConcreteStairsBlocks.RED,
                    ConcreteStairsBlocks.BLACK
            ).forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.BUILDING_BLOCKS))
            );

            Stream.of(
                    ConcreteWallBlocks.WHITE,
                    ConcreteWallBlocks.ORANGE,
                    ConcreteWallBlocks.MAGENTA,
                    ConcreteWallBlocks.LIGHT_BLUE,
                    ConcreteWallBlocks.YELLOW,
                    ConcreteWallBlocks.LIME,
                    ConcreteWallBlocks.PINK,
                    ConcreteWallBlocks.GRAY,
                    ConcreteWallBlocks.LIGHT_GRAY,
                    ConcreteWallBlocks.CYAN,
                    ConcreteWallBlocks.PURPLE,
                    ConcreteWallBlocks.BLUE,
                    ConcreteWallBlocks.BROWN,
                    ConcreteWallBlocks.GREEN,
                    ConcreteWallBlocks.RED,
                    ConcreteWallBlocks.BLACK
            ).forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.DECORATIONS))
            );

            Stream.of(
                    ConcreteButtonBlocks.WHITE,
                    ConcreteButtonBlocks.ORANGE,
                    ConcreteButtonBlocks.MAGENTA,
                    ConcreteButtonBlocks.LIGHT_BLUE,
                    ConcreteButtonBlocks.YELLOW,
                    ConcreteButtonBlocks.LIME,
                    ConcreteButtonBlocks.PINK,
                    ConcreteButtonBlocks.GRAY,
                    ConcreteButtonBlocks.LIGHT_GRAY,
                    ConcreteButtonBlocks.CYAN,
                    ConcreteButtonBlocks.PURPLE,
                    ConcreteButtonBlocks.BLUE,
                    ConcreteButtonBlocks.BROWN,
                    ConcreteButtonBlocks.GREEN,
                    ConcreteButtonBlocks.RED,
                    ConcreteButtonBlocks.BLACK
            ).forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.REDSTONE))
            );

            Stream.of(
                    ConcretePressurePlateBlocks.WHITE,
                    ConcretePressurePlateBlocks.ORANGE,
                    ConcretePressurePlateBlocks.MAGENTA,
                    ConcretePressurePlateBlocks.LIGHT_BLUE,
                    ConcretePressurePlateBlocks.YELLOW,
                    ConcretePressurePlateBlocks.LIME,
                    ConcretePressurePlateBlocks.PINK,
                    ConcretePressurePlateBlocks.GRAY,
                    ConcretePressurePlateBlocks.LIGHT_GRAY,
                    ConcretePressurePlateBlocks.CYAN,
                    ConcretePressurePlateBlocks.PURPLE,
                    ConcretePressurePlateBlocks.BLUE,
                    ConcretePressurePlateBlocks.BROWN,
                    ConcretePressurePlateBlocks.GREEN,
                    ConcretePressurePlateBlocks.RED,
                    ConcretePressurePlateBlocks.BLACK
            ).forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.REDSTONE))
            );

            Stream.of(
                    ConcreteFenceBlocks.WHITE,
                    ConcreteFenceBlocks.ORANGE,
                    ConcreteFenceBlocks.MAGENTA,
                    ConcreteFenceBlocks.LIGHT_BLUE,
                    ConcreteFenceBlocks.YELLOW,
                    ConcreteFenceBlocks.LIME,
                    ConcreteFenceBlocks.PINK,
                    ConcreteFenceBlocks.GRAY,
                    ConcreteFenceBlocks.LIGHT_GRAY,
                    ConcreteFenceBlocks.CYAN,
                    ConcreteFenceBlocks.PURPLE,
                    ConcreteFenceBlocks.BLUE,
                    ConcreteFenceBlocks.BROWN,
                    ConcreteFenceBlocks.GREEN,
                    ConcreteFenceBlocks.RED,
                    ConcreteFenceBlocks.BLACK
            ).forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.DECORATIONS))
            );

            Stream.of(
                    ConcreteFenceGateBlocks.WHITE,
                    ConcreteFenceGateBlocks.ORANGE,
                    ConcreteFenceGateBlocks.MAGENTA,
                    ConcreteFenceGateBlocks.LIGHT_BLUE,
                    ConcreteFenceGateBlocks.YELLOW,
                    ConcreteFenceGateBlocks.LIME,
                    ConcreteFenceGateBlocks.PINK,
                    ConcreteFenceGateBlocks.GRAY,
                    ConcreteFenceGateBlocks.LIGHT_GRAY,
                    ConcreteFenceGateBlocks.CYAN,
                    ConcreteFenceGateBlocks.PURPLE,
                    ConcreteFenceGateBlocks.BLUE,
                    ConcreteFenceGateBlocks.BROWN,
                    ConcreteFenceGateBlocks.GREEN,
                    ConcreteFenceGateBlocks.RED,
                    ConcreteFenceGateBlocks.BLACK
            ).forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.DECORATIONS))
            );
        }

        @SubscribeEvent
        public static void onModConfigEvent(final ModConfig.ModConfigEvent event) {
            final ModConfig config = event.getConfig();
            if (config.getSpec() == ConfigHolder.COMMON_SPEC) {
                ConfigHelper.bakeCommon(config);
            }
        }
    }
}
