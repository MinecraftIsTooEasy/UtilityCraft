package com.inf1nlty.utilitycraft.network.s2c;

import com.inf1nlty.utilitycraft.item.nunchaku.INunchakuSpinState;
import moddedmite.rustedironcore.network.Packet;
import moddedmite.rustedironcore.network.PacketByteBuf;
import net.minecraft.Entity;
import net.minecraft.EntityPlayer;
import net.minecraft.ResourceLocation;
import net.minecraft.World;

public class S2CNunchakuSpinPacket implements Packet {

    public static final ResourceLocation CHANNEL = new ResourceLocation("utilitycraft", "nunchaku_spin_sync");

    private final int entityId;
    private final boolean spinning;

    public S2CNunchakuSpinPacket(PacketByteBuf buf) {
        this.entityId = buf.readInt();
        this.spinning = buf.readBoolean();
    }

    public S2CNunchakuSpinPacket(int entityId, boolean spinning) {
        this.entityId = entityId;
        this.spinning = spinning;
    }

    @Override
    public void write(PacketByteBuf buf) {
        buf.writeInt(this.entityId);
        buf.writeBoolean(this.spinning);
    }

    @Override
    public void apply(EntityPlayer player) {
        if (player == null) {
            return;
        }

        Entity entity = player.entityId == this.entityId ? player : getEntity(player.worldObj, this.entityId);
        if (entity instanceof INunchakuSpinState spinState) {
            spinState.setNunchakuSpinning(this.spinning);
        }
    }

    @Override
    public ResourceLocation getChannel() {
        return CHANNEL;
    }

    private static Entity getEntity(World world, int entityId) {
        return world == null ? null : world.getEntityByID(entityId);
    }
}
