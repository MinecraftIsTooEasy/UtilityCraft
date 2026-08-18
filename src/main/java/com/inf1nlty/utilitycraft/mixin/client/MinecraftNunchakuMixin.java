package com.inf1nlty.utilitycraft.mixin.client;

import com.inf1nlty.utilitycraft.item.nunchaku.ItemNunchaku;
import com.inf1nlty.utilitycraft.item.nunchaku.INunchakuSpinState;
import com.inf1nlty.utilitycraft.network.UCNunchakuC2S;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftNunchakuMixin {

    @Shadow private int leftClickCounter;

    @Shadow
    private void clickMouse(int button) {}

    @Unique private int utilitycraft$nunchakuAttackCooldown;

    @Unique private boolean utilitycraft$wasNunchakuAttackHeld;

    @Inject(method = "runTick", at = @At("TAIL"))
    private void utilitycraft$autoNunchakuAttack(CallbackInfo ci) {
        Minecraft mc = (Minecraft)(Object)this;

        if (!utilitycraft$canSpinNunchaku(mc)) {
            if (this.utilitycraft$wasNunchakuAttackHeld && mc.thePlayer != null) {
                utilitycraft$clearNunchakuSwing(mc.thePlayer);
            }
            utilitycraft$setNunchakuSpinning(mc, false);
            this.utilitycraft$nunchakuAttackCooldown = 0;
            this.utilitycraft$wasNunchakuAttackHeld = false;
            return;
        }

        utilitycraft$setNunchakuSpinning(mc, true);
        utilitycraft$clearNunchakuSwing(mc.thePlayer);

        if (!this.utilitycraft$wasNunchakuAttackHeld) {
            this.utilitycraft$wasNunchakuAttackHeld = true;
            this.utilitycraft$nunchakuAttackCooldown = ItemNunchaku.AUTO_ATTACK_INTERVAL_TICKS;
            return;
        }

        if (this.utilitycraft$nunchakuAttackCooldown > 0) {
            --this.utilitycraft$nunchakuAttackCooldown;
        }

        if (this.utilitycraft$nunchakuAttackCooldown <= 0 && utilitycraft$hasNunchakuAttackTarget(mc)) {
            this.leftClickCounter = 0;
            this.clickMouse(0);
            utilitycraft$clearNunchakuSwing(mc.thePlayer);
            this.utilitycraft$nunchakuAttackCooldown = ItemNunchaku.AUTO_ATTACK_INTERVAL_TICKS;
        }
    }

    @Unique
    private boolean utilitycraft$canSpinNunchaku(Minecraft mc) {
        if (mc.thePlayer == null || mc.theWorld == null || mc.playerController == null || mc.gameSettings == null) {
            return false;
        }

        if (!mc.inGameHasFocus || mc.isGuiOpen(true) || mc.thePlayer.isUsingItem() || mc.thePlayer.fishEntity != null || mc.thePlayer.ridingEntity instanceof EntityBoat) {
            return false;
        }

        if (!mc.gameSettings.keyBindAttack.pressed || mc.gameSettings.keyBindUseItem.pressed) {
            return false;
        }

        ItemStack held = mc.thePlayer.getHeldItemStack();
        return held != null && held.getItem() instanceof ItemNunchaku;
    }

    @Unique
    private boolean utilitycraft$hasNunchakuAttackTarget(Minecraft mc) {
        if (mc.objectMouseOver == null || !mc.objectMouseOver.isEntity()) {
            return false;
        }

        Entity target = mc.objectMouseOver.getEntityHit();
        return target != null && target != mc.thePlayer && target.canBeAttackedBy(mc.thePlayer);
    }

    @Unique
    private void utilitycraft$setNunchakuSpinning(Minecraft mc, boolean spinning) {
        INunchakuSpinState spinState = INunchakuSpinState.as(mc.thePlayer);
        if (spinState == null || spinState.utilitycraft$isNunchakuSpinning() == spinning) {
            return;
        }

        spinState.utilitycraft$setNunchakuSpinning(spinning);
        UCNunchakuC2S.sendSpinning(spinning);
    }

    @Unique
    private void utilitycraft$clearNunchakuSwing(EntityClientPlayerMP player) {
        player.swing_item_pending = false;
        player.isSwingInProgress = false;
        player.swingProgressInt = 0;
        player.swingProgress = 0.0F;
        player.prevSwingProgress = 0.0F;
    }
}
