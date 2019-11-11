package org.villainy.sweetconcrete.config;

import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;


public class FlagRecipeCondition implements ICondition {

    private final String flag;
    private final ResourceLocation loc;

    public FlagRecipeCondition(String flag, ResourceLocation loc) {
        this.flag = flag;
        this.loc = loc;
    }


    @Override
    public ResourceLocation getID() {
        return loc;
    }

    @Override
    public boolean test() {
        if (flag.equals("slabs")) {
            return SweetConcreteConfig.enableSlabs;
        }
        if (flag.equals("stairs")) {
            return SweetConcreteConfig.enableStairs;
        }
        if (flag.equals("walls")) {
            return SweetConcreteConfig.enableWalls;
        }
        if (flag.equals("buttons")) {
            return SweetConcreteConfig.enableButtons;
        }
        if (flag.equals("pressure_plates")) {
            return SweetConcreteConfig.enablePressurePlates;
        }
        if (flag.equals("fences")) {
            return SweetConcreteConfig.enableFences;
        }
        return true;
    }

    public static class Serializer implements IConditionSerializer<FlagRecipeCondition> {
        private final ResourceLocation location;

        public Serializer(ResourceLocation location) {
            this.location = location;
        }

        @Override
        public void write(JsonObject json, FlagRecipeCondition value) {
            json.addProperty("flag", value.flag);
        }

        @Override
        public FlagRecipeCondition read(JsonObject json) {
            return new FlagRecipeCondition(json.getAsJsonPrimitive("flag").getAsString(), location);
        }

        @Override
        public ResourceLocation getID() {
            return location;
        }
    }
}

