package org.villainy.sweetconcrete.objectholders;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;
import org.villainy.sweetconcrete.tileEntities.ConcreteSignTileEntity;

@ObjectHolder("sweetconcrete")
public class TileEntityTypes {

    @ObjectHolder("concrete_sign")
    public static final TileEntityType<ConcreteSignTileEntity> CONCRETE_SIGN = null;
}
