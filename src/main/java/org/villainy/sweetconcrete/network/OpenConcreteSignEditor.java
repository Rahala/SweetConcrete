package org.villainy.sweetconcrete.network;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;
import org.villainy.sweetconcrete.SweetConcrete;

import java.util.function.Supplier;

public class OpenConcreteSignEditor {
    public BlockPos position;

    public OpenConcreteSignEditor(BlockPos position) {
        this.position = position;
    }

    public OpenConcreteSignEditor(PacketBuffer buffer) {
        position = buffer.readBlockPos();
    }

    public void encode(PacketBuffer buffer) {
        buffer.writeBlockPos(position);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        SweetConcrete.proxy.openSignButtonGui(position);
    }
}
