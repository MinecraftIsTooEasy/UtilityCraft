package com.inf1nlty.utilitycraft.mixin.enchantment;

import com.inf1nlty.utilitycraft.item.rapier.IRapier;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = {
        EnchantmentDamage.class,
        EnchantmentPiercing.class
}, priority = 999)
public class RapierEnchantmentMixin {

    @Inject(method = "canEnchantItem", at = @At("HEAD"), cancellable = true)
    private void onCanEnchantItem(Item item, CallbackInfoReturnable<Boolean> cir) {

        Enchantment self = (Enchantment) (Object) this;

        if (self instanceof EnchantmentDamage) {
            if (self == EnchantmentDamage.smite && item instanceof IRapier) {
                cir.setReturnValue(true);
            }
            return;
        }

        if (self instanceof EnchantmentPiercing) {
            if (item instanceof IRapier) {
                cir.setReturnValue(true);
            }
        }
    }
}