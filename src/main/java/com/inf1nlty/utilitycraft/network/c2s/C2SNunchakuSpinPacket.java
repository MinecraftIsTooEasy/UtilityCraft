package com.inf1nlty.utilitycraft.network.c2s;

import com.inf1nlty.utilitycraft.item.nunchaku.INunchakuSpinState;
import com.inf1nlty.utilitycraft.item.nunchaku.ItemNunchaku;
import com.inf1nlty.utilitycraft.network.UCNunchakuS2C;
import moddedmite.rustedironcore.network.Packet;
import moddedmite.rustedironcore.network.PacketByteBuf;
import net.minecraft.EntityLivingBase;
import net.minecraft.EntityPlayer;
import net.minecraft.ItemStack;
import net.minecraft.ResourceLocation;
import net.minecraft.ServerPlayer;

public class C2SNunchakuSpinPacket implements Packet {

    public static final ResourceLocation CHANNEL = new ResourceLocation("utilitycraft", "nunchaku_spin");

    private final boolean spinning;

    public C2SNunchakuSpinPacket(PacketByteBuf buf) {
        this.spinning = buf.readBoolean();
    }

    public C2SNunchakuSpinPacket(boolean spinning) {
        this.spinning = spinning;
    }

    @Override
    public void write(PacketByteBuf buf) {
        buf.writeBoolean(this.spinning);
    }

    @Override
    public void apply(EntityPlayer player) {
        if (!(player instanceof ServerPlayer serverPlayer)) {
            return;
        }

        boolean syncedSpinning = this.spinning && isHoldingNunchaku(serverPlayer);
        setSpinning(serverPlayer, syncedSpinning);
        UCNunchakuS2C.broadcastSpinning(serverPlayer, syncedSpinning);
    }

    @Override
    public ResourceLocation getChannel() {
        return CHANNEL;
    }

    private static boolean isHoldingNunchaku(EntityLivingBase entity) {
        ItemStack stack = entity.getHeldItemStack();
        return stack != null && stack.getItem() instanceof ItemNunchaku;
    }

    private static void setSpinning(EntityPlayer player, boolean spinning) {
        if (player instanceof INunchakuSpinState spinState) {
            spinState.setNunchakuSpinning(spinning);
        }
    }
}
