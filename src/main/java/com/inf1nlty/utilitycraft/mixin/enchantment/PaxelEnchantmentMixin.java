package com.inf1nlty.utilitycraft.mixin.enchantment;

import com.inf1nlty.utilitycraft.item.paxel.IPaxel;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = {
        EnchantmentDigging.class,
        EnchantmentDurability.class,
        EnchantmentTreeFelling.class,
        EnchantmentLootBonus.class,
        EnchantmentPiercing.class,
        EnchantmentUntouching.class
}, priority = 999)

public class PaxelEnchantmentMixin {

    @Inject(method = "canEnchantItem", at = @At("HEAD"), cancellable = true)
    private void onCanEnchantItem(Item item, CallbackInfoReturnable<Boolean> cir) {

        if (((Object) this) instanceof EnchantmentLootBonus) {
            EnchantmentLootBonus elb = (EnchantmentLootBonus) (Object) this;

            if (elb == EnchantmentLootBonus.looting) {
                return;
            }
        }

        if (item instanceof IPaxel) {
            cir.setReturnValue(true);
        }
    }
}