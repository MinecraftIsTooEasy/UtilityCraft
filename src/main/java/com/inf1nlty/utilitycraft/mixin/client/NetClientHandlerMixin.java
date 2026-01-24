package com.inf1nlty.utilitycraft.mixin.client;

import com.inf1nlty.utilitycraft.entity.EntityObsidianBoat;
import net.minecraft.NetClientHandler;
import net.minecraft.Packet23VehicleSpawn;
import net.minecraft.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetClientHandler.class)
public abstract class NetClientHandlerMixin {

    @Shadow public WorldClient worldClient;

    @Inject(method = "handleVehicleSpawn", at = @At("HEAD"), cancellable = true, remap = false)
    private void utilitycraft$handleObsidianBoat(Packet23VehicleSpawn packet, CallbackInfo ci) {
        if (packet.type == 110) {
            double x = (double)packet.scaled_pos_x / 32.0D;
            double y = (double)packet.scaled_pos_y / 32.0D;
            double z = (double)packet.scaled_pos_z / 32.0D;

            EntityObsidianBoat boat = new EntityObsidianBoat(worldClient, x, y, z);

            boat.rotationPitch = (float)(packet.scaled_pitch * 360) / 256.0F;
            boat.rotationYaw = (float)(packet.scaled_yaw * 360) / 256.0F;
            boat.entityId = packet.entityId;

            worldClient.addEntityToWorld(packet.entityId, boat);

            ci.cancel();
        }
    }
}