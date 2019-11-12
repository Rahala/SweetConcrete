package org.villainy.sweetconcrete.config;

import net.minecraftforge.fml.config.ModConfig;


public final class ConfigHelper {

    private static ModConfig commonConfig;

    public static void bakeCommon(final ModConfig config) {
        commonConfig = config;

        SweetConcreteConfig.enableSlabs = ConfigHolder.COMMON.enableSlabs.get();
        SweetConcreteConfig.enableStairs = ConfigHolder.COMMON.enableStairs.get();
        SweetConcreteConfig.enableWalls = ConfigHolder.COMMON.enableWalls.get();
        SweetConcreteConfig.enableButtons = ConfigHolder.COMMON.enableButtons.get();
        SweetConcreteConfig.enablePressurePlates = ConfigHolder.COMMON.enablePressurePlates.get();
        SweetConcreteConfig.enableFences = ConfigHolder.COMMON.enableFences.get();
        SweetConcreteConfig.enableLadders = ConfigHolder.COMMON.enableLadders.get();
    }

    public static void setValueAndSave(final ModConfig modConfig, final String path, final Object newValue) {
        modConfig.getConfigData().set(path, newValue);
        modConfig.save();
    }

}
