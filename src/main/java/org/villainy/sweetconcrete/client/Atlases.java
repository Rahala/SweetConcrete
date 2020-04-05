package org.villainy.sweetconcrete.client;

import net.minecraft.client.renderer.model.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.EnumMap;
import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class Atlases {
    private static final Map<DyeColor, Material> CONCRETE_MATERIALS;

    static {
        CONCRETE_MATERIALS = makeConcreteMaterials();
    }

    private Atlases() {
    }

    private static Map<DyeColor, Material> makeConcreteMaterials() {
        final EnumMap<DyeColor, Material> materials = new EnumMap<>(DyeColor.class);
        for (final DyeColor dyeColor : DyeColor.values()) {
            materials.put(dyeColor, new Material(net.minecraft.client.renderer.Atlases.SIGN_ATLAS,
                    new ResourceLocation("block/" + dyeColor.getTranslationKey() + "_concrete")));
        }
        return materials;
    }

    public static Material getConcreteMaterial(final DyeColor dyeColor) {
        return CONCRETE_MATERIALS.get(dyeColor);
    }

    @SubscribeEvent
    public static void onTextureStitchPre(final TextureStitchEvent.Pre event) {
        final ResourceLocation atlas = event.getMap().getTextureLocation();
        CONCRETE_MATERIALS.values().stream()
                .filter(material -> material.getAtlasLocation().equals(atlas))
                .forEach(material -> event.addSprite(material.getTextureLocation()));

    }
}
