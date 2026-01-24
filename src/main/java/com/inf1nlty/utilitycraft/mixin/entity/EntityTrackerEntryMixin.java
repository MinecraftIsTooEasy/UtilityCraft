package com.inf1nlty.utilitycraft.mixin.entity;

import com.inf1nlty.utilitycraft.entity.EntityObsidianBoat;
import net.minecraft.EntityTrackerEntry;
import net.minecraft.Entity;
import net.minecraft.Packet;
import net.minecraft.Packet23VehicleSpawn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
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
}