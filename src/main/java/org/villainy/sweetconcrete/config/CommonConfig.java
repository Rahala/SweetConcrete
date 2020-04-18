package org.villainy.sweetconcrete.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.villainy.sweetconcrete.SweetConcrete;

final class CommonConfig {

    final ForgeConfigSpec.BooleanValue enableSlabs;
    final ForgeConfigSpec.BooleanValue enableStairs;
    final ForgeConfigSpec.BooleanValue enableWalls;
    final ForgeConfigSpec.BooleanValue enableButtons;
    final ForgeConfigSpec.BooleanValue enablePressurePlates;
    final ForgeConfigSpec.BooleanValue enableFences;
    final ForgeConfigSpec.BooleanValue enableLadders;
    final ForgeConfigSpec.BooleanValue enableCake;
    final ForgeConfigSpec.BooleanValue enableSigns;
    final ForgeConfigSpec.BooleanValue enableLevers;
    final ForgeConfigSpec.BooleanValue enableVerticalSlabs;
    final ForgeConfigSpec.BooleanValue enablePowderLayers;

    CommonConfig(final ForgeConfigSpec.Builder builder) {
        builder.push("general");
        enableSlabs = builder
                .comment("Enable concrete slabs")
                .translation(SweetConcrete.MODID + ".config.enableSlabs")
                .define("enableSlabs", true);
        enableStairs = builder
                .comment("Enable concrete stairs")
                .translation(SweetConcrete.MODID + ".config.enableStairs")
                .define("enableStairs", true);
        enableWalls = builder
                .comment("Enable concrete walls")
                .translation(SweetConcrete.MODID + ".config.enableWalls")
                .define("enableWalls", true);
        enableButtons = builder
                .comment("Enable concrete buttons")
                .translation(SweetConcrete.MODID + ".config.enableButtons")
                .define("enableButtons", true);
        enablePressurePlates = builder
                .comment("Enable concrete pressure plates")
                .translation(SweetConcrete.MODID + ".config.enablePressurePlates")
                .define("enablePressurePlates", true);
        enableFences = builder
                .comment("Enable concrete fences")
                .translation(SweetConcrete.MODID + ".config.enableFences")
                .define("enableFences", true);
        enableLadders = builder
                .comment("Enable concrete ladders")
                .translation(SweetConcrete.MODID + ".config.enableLadders")
                .define("enableLadders", true);
        enableCake = builder
                .comment("Enable concrete cake")
                .translation(SweetConcrete.MODID + ".config.enableCake")
                .define("enableCake", true);
        enableSigns = builder
                .comment("Enable concrete signs")
                .translation(SweetConcrete.MODID + ".config.enableSigns")
                .define("enableSigns", true);
        enableLevers = builder
                .comment("Enable concrete levers")
                .translation(SweetConcrete.MODID + ".config.enableLevers")
                .define("enableLevers", true);
        enableVerticalSlabs = builder
                .comment("Enable concrte vertical slabs")
                .translation(SweetConcrete.MODID + ".config.enableVerticalSlabs")
                .define("enableVerticalSlabs", true);
        enablePowderLayers = builder
                .comment("Enable concrete powder layers")
                .translation(SweetConcrete.MODID + ".config.enablePowderLayers")
                .define("enablePowderLayers", true);
        builder.pop();
    }

}