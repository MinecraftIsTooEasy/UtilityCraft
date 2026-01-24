package com.inf1nlty.utilitycraft.mixin.client;

import com.inf1nlty.utilitycraft.entity.EntityObsidianBoat;
import net.minecraft.NetClientHandler;
import net.minecraft.Packet23VehicleSpawn;
import net.minecraft.SpatialScaler;
import net.minecraft.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetClientHandler.class)
public abstract class NetClientHandlerMixin {

    @Shadow public WorldClient worldClient;

    @Inject(method = "handleVehicleSpawn", at = @At("HEAD"), cancellable = true)
    private void utilitycraft$handleObsidianBoat(Packet23VehicleSpawn packet, CallbackInfo ci) {
        if (packet.type != 110) {
            return;
        }

        double x = SpatialScaler.getPosX(packet.scaled_pos_x);
        double y = SpatialScaler.getPosY(packet.scaled_pos_y);
        double z = SpatialScaler.getPosZ(packet.scaled_pos_z);
        float yaw = SpatialScaler.getRotation(packet.scaled_yaw);
        float pitch = SpatialScaler.getRotation(packet.scaled_pitch);

        EntityObsidianBoat boat = new EntityObsidianBoat(worldClient, x, y, z);

        boat.rotationYaw = yaw;
        boat.rotationPitch = pitch;
        boat.prevRotationYaw = boat.rotationYaw;

        boat.setPositionAndRotation2(boat.posX, boat.posY, boat.posZ, boat.rotationYaw, boat.rotationPitch, 3);

        boat.prevPosX = boat.lastTickPosX = boat.posX;
        boat.prevPosY = boat.lastTickPosY = boat.posY;
        boat.prevPosZ = boat.lastTickPosZ = boat.posZ;

        boat.entityId = packet.entityId;
        this.worldClient.addEntityToWorld(packet.entityId, boat);

        ci.cancel();
    }
}