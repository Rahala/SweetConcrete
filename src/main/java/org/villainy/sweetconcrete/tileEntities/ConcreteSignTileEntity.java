package org.villainy.sweetconcrete.tileEntities;

import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ConcreteSignTileEntity extends SignTileEntity {
    @ObjectHolder("sweetconcrete:concrete_sign")
    public static TileEntityType<ConcreteSignTileEntity> TYPE;

    @Override
    public TileEntityType<?> getType() {
        return TYPE;
    }
}
