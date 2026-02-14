package com.inf1nlty.utilitycraft.mixin;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetServerHandler.class)
public class NetServerHandlerMixin {

    @Inject(method = "handleRightClick", at = @At("HEAD"), cancellable = true)
    private void onHandleRightClick_head(Packet81RightClick packet, CallbackInfo ci) {
        if (packet == null || !packet.ctrl_is_down) return;

        ServerPlayer player = ((NetServerHandler) (Object) this).playerEntity;
        if (player == null) return;

        World world = player.worldObj;
        if (world == null || world.isRemote) return;

        ItemStack stack = null;

        if (player.inventory != null) {
            int idx = player.inventory.currentItem;
            if (player.inventory.mainInventory != null && idx >= 0 && idx < player.inventory.mainInventory.length) {
                stack = player.inventory.mainInventory[idx];
            }
        }

        if (stack == null) return;

        Item heldItem = stack.getItem();

        if (heldItem == null) return;

        int heldM = -1;
        if (heldItem == Item.ingotCopper) heldM = 1;
        else if (heldItem == Item.ingotSilver) heldM = 2;
        else if (heldItem == Item.ingotGold) heldM = 3;
        else if (heldItem == Item.ingotIron) heldM = 4;
        else if (heldItem == Item.ingotAncientMetal) heldM = 5;
        else if (heldItem == Item.ingotMithril) heldM = 6;
        else if (heldItem == Item.ingotAdamantium) heldM = 7;

        if (heldM == -1) return; // not an upgrade ingot

        double reach = 5.0D;
        double yawRad = Math.toRadians(player.rotationYaw);
        double pitchRad = Math.toRadians(player.rotationPitch);
        double cosPitch = Math.cos(pitchRad);
        double dirX = -Math.sin(yawRad) * cosPitch;
        double dirY = -Math.sin(pitchRad);
        double dirZ = Math.cos(yawRad) * cosPitch;

        double sx = player.posX;
        double sy = player.posY + player.getEyeHeight();
        double sz = player.posZ;

        Integer targetX = null, targetY = null, targetZ = null;
        for (double d = 0.0; d <= reach; d += 0.5) {
            double px = sx + dirX * d;
            double py = sy + dirY * d;
            double pz = sz + dirZ * d;
            int bx = (int) Math.floor(px);
            int by = (int) Math.floor(py);
            int bz = (int) Math.floor(pz);

            Block b = world.getBlock(bx, by, bz);
            if (b != null && !world.isAirBlock(bx, by, bz)) {
                targetX = bx;
                targetY = by;
                targetZ = bz;
                break;
            }
        }
        if (targetX == null) return;

        int bx = targetX;
        int by = targetY;
        int bz = targetZ;

        Block block = world.getBlock(bx, by, bz);
        if (block == null) return;

        if (block != Block.workbench) return;

        int meta = world.getBlockMetadata(bx, by, bz);
        int curM = (meta < 4) ? 0 : (meta > 10 ? 8 : meta - 3);

        int curGroup;
        if (curM == 0) curGroup = 0;
        else if (curM == 8) curGroup = 0; // obsidian => treat as flint
        else if (curM >= 1 && curM <= 3) curGroup = 1;
        else if (curM == 4) curGroup = 2;
        else if (curM == 5) curGroup = 3;
        else if (curM == 6) curGroup = 4;
        else if (curM == 7) curGroup = 5;
        else curGroup = 0;

        int heldGroup;
        if (heldM >= 1 && heldM <= 3) heldGroup = 1;
        else if (heldM == 4) heldGroup = 2;
        else if (heldM == 5) heldGroup = 3;
        else if (heldM == 6) heldGroup = 4;
        else if (heldM == 7) heldGroup = 5;
        else heldGroup = 6;

        if (heldGroup != curGroup + 1) {
            int needGroup = curGroup + 1;
            String needKey = getNeedNextTierKeyForGroup(needGroup);
            player.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey(needKey).setColor(EnumChatFormatting.YELLOW));
            return;
        }

        int newMeta = heldM + 3; // 1..7 -> 4..10
        world.setBlockMetadataWithNotify(bx, by, bz, newMeta, 3);

        if (player.capabilities == null || !player.capabilities.isCreativeMode) {
            stack.stackSize--;
            int idx = player.inventory.currentItem;
            if (stack.stackSize <= 0) player.inventory.setInventorySlotContents(idx, null);
            else player.inventory.setInventorySlotContents(idx, stack);
        }

        int materialIndex = (newMeta < 4) ? 0 : (newMeta > 10 ? 8 : newMeta - 3);
        String upgradedKey = getUpgradedKeyForMaterial(materialIndex);
        player.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey(upgradedKey).setColor(EnumChatFormatting.GREEN));

        world.playSoundEffect(bx + 0.5D, by + 0.5D, bz + 0.5D, "random.pop", 0.8F, 1.0F);

        ci.cancel();
    }

    @Unique private String getNeedNextTierKeyForGroup(int group) {
        return switch (group) {
            case 1 -> "utilitycraft.workbench.need_next_tier.group1";
            case 2 -> "utilitycraft.workbench.need_next_tier.group2";
            case 3 -> "utilitycraft.workbench.need_next_tier.group3";
            case 4 -> "utilitycraft.workbench.need_next_tier.group4";
            case 5 -> "utilitycraft.workbench.need_next_tier.group5";
            default -> "utilitycraft.workbench.need_next_tier.default";
        };
    }

    @Unique private String getUpgradedKeyForMaterial(int materialIndex) {
        return switch (materialIndex) {
            case 1 -> "utilitycraft.workbench.upgraded.copper";
            case 2 -> "utilitycraft.workbench.upgraded.silver";
            case 3 -> "utilitycraft.workbench.upgraded.gold";
            case 4 -> "utilitycraft.workbench.upgraded.iron";
            case 5 -> "utilitycraft.workbench.upgraded.ancient_metal";
            case 6 -> "utilitycraft.workbench.upgraded.mithril";
            case 7 -> "utilitycraft.workbench.upgraded.adamantium";
            default -> "utilitycraft.workbench.upgraded.unknown";
        };
    }
}