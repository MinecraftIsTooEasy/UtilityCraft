package com.inf1nlty.utilitycraft.mixin.enchantment;

import com.inf1nlty.utilitycraft.item.mace.ItemMace;
import net.minecraft.EnchantmentVampiric;
import net.minecraft.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EnchantmentVampiric.class, priority = 4000)
public class MaceVampiricEnchantmentMixin {

    @Inject(method = "canEnchantItem", at = @At("HEAD"), cancellable = true)
    private void utilitycraft$allowVibraniumMace(Item item, CallbackInfoReturnable<Boolean> cir) {
        if (ItemMace.isVibraniumMace(item)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "canEnchantItem", at = @At("RETURN"), cancellable = true)
    private void utilitycraft$allowVibraniumMaceOnReturn(Item item, CallbackInfoReturnable<Boolean> cir) {
        if (ItemMace.isVibraniumMace(item)) {
            cir.setReturnValue(true);
        }
    }
}
