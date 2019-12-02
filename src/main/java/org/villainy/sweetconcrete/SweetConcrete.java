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

        MinecraftForge.EVENT_BUS.register(this);
    }

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
                blockRegistry.register(new ConcreteLadderBlock(dyeColor));
            });

            blockRegistry.register(new ConcreteCakeBlock());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> itemRegistry = event.getRegistry();

            ConcreteSlabBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.BUILDING_BLOCKS))
            );
            ConcreteStairsBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.BUILDING_BLOCKS))
            );
            ConcreteWallBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.DECORATIONS))
            );
            ConcreteButtonBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.REDSTONE))
            );
            ConcretePressurePlateBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.REDSTONE))
            );
            ConcreteFenceBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.DECORATIONS))
            );
            ConcreteFenceGateBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.DECORATIONS))
            );
            ConcreteLadderBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.DECORATIONS))
            );
            ConcreteCakeBlock.allBlocks().forEach (block ->
                    itemRegistry.register(BlockItemHelper.createBasicBlockItem(block, ItemGroup.FOOD))
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
