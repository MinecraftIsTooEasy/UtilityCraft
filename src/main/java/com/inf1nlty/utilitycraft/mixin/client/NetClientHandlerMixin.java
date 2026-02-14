package com.inf1nlty.utilitycraft.mixin.client;

import com.inf1nlty.utilitycraft.block.BlockSteelChest;
import com.inf1nlty.utilitycraft.client.gui.GuiLocker;
import com.inf1nlty.utilitycraft.entity.EntityObsidianBoat;
import com.inf1nlty.utilitycraft.network.UCChestNet;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetClientHandler.class)
public abstract class NetClientHandlerMixin {

    @Inject(method = "handleOpenWindow", at = @At("HEAD"), cancellable = true)
    private void utilitycraft$handleOpenWindow(Packet100OpenWindow packet, CallbackInfo ci) {
        if (packet.inventoryType != BlockSteelChest.CUSTOM_WINDOW_TYPE) return;

        Minecraft mc = Minecraft.getMinecraft();
        EntityClientPlayerMP player = mc.thePlayer;
        if (player == null) {
            ci.cancel();
            return;
        }

        int size = packet.slotsCount > 0 ? packet.slotsCount : 133;
        String title = packet.windowTitle != null ? packet.windowTitle : "SteelChest";
        boolean localized = packet.useProvidedWindowTitle;

        IInventory fake;
        try {
            fake = new InventoryBasic(title, localized, size);
        } catch (Throwable t) {
            fake = new InventoryBasic("SteelChest", false, 133);
        }

        GuiLocker gui = new GuiLocker(player.inventory, fake);
        mc.displayGuiScreen(gui);

        if (player.openContainer != null) {
            player.openContainer.windowId = packet.windowId & 0xFF;
        }

        ci.cancel();
    }

    @Inject(method = "handleCustomPayload", at = @At("HEAD"), cancellable = true)
    private void utilitycraft$handlePacket(Packet250CustomPayload packet, CallbackInfo ci) {
        if (packet == null) return;
        String channel = packet.channel;
        if (UCChestNet.CHANNEL != null && UCChestNet.CHANNEL.equals(channel)) {
            EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
            if (!(player instanceof EntityClientPlayerMP)) return;
            UCChestNet.handleClientPacket(packet, player);
            ci.cancel();
        }
    }

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