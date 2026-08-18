package com.inf1nlty.utilitycraft.mixin.entity;

import com.inf1nlty.utilitycraft.entity.EntityObsidianBoat;
import com.inf1nlty.utilitycraft.item.nunchaku.INunchakuSpinState;
import com.inf1nlty.utilitycraft.network.s2c.S2CNunchakuSpinPacket;
import moddedmite.rustedironcore.network.Network;
import net.minecraft.EntityTrackerEntry;
import net.minecraft.Entity;
import net.minecraft.Packet;
import net.minecraft.Packet23VehicleSpawn;
import net.minecraft.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityTrackerEntry.class)
public class EntityTrackerEntryMixin {

    @Inject(method = "getPacketForThisEntity", at = @At("HEAD"), cancellable = true)
    private void utilitycraft$customObsidianBoatPacket(CallbackInfoReturnable<Packet> cir) {
        Entity self = ((EntityTrackerEntry)(Object)this).myEntity;
        if (self instanceof EntityObsidianBoat) {
            cir.setReturnValue(new Packet23VehicleSpawn(self, 110));
        }
    }

    @Inject(method = "tryStartWachingThis", at = @At("RETURN"))
    private void utilitycraft$syncNunchakuSpinningToNewTracker(ServerPlayer player, CallbackInfo ci) {
        Entity self = ((EntityTrackerEntry)(Object)this).myEntity;
        if (self instanceof INunchakuSpinState spinState && spinState.utilitycraft$isNunchakuSpinning()) {
            Network.sendToClient(player, new S2CNunchakuSpinPacket(self.entityId, true));
        }
    }
}
