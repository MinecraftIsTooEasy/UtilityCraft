package com.inf1nlty.utilitycraft.mixin.enchantment;

import com.inf1nlty.utilitycraft.compat.UCEnchantmentCompat;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.Enchantment;
import net.minecraft.EnchantmentHelper;
import net.minecraft.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EnchantmentHelper.class)
public class MaceVampiricEnchantmentHelperMixin {

    @WrapOperation(method = "hasValidEnchantmentForItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/Enchantment;canEnchantItem(Lnet/minecraft/Item;)Z"))
    private static boolean utilitycraft$allowVampiricMaceBook(Enchantment enchantment, Item item, Operation<Boolean> original) {
        return UCEnchantmentCompat.canEnchantVampiricVibraniumMace(enchantment, item, original.call(enchantment, item));
    }

    @WrapOperation(method = "mapEnchantmentData", at = @At(value = "INVOKE", target = "Lnet/minecraft/Enchantment;canEnchantItem(Lnet/minecraft/Item;)Z"))
    private static boolean utilitycraft$allowVampiricMaceTable(Enchantment enchantment, Item item, Operation<Boolean> original) {
        return UCEnchantmentCompat.canEnchantVampiricVibraniumMace(enchantment, item, original.call(enchantment, item));
    }
}
