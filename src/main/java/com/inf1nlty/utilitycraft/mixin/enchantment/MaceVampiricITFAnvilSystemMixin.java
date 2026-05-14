package com.inf1nlty.utilitycraft.mixin.enchantment;

import com.inf1nlty.utilitycraft.compat.UCEnchantmentCompat;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.Enchantment;
import net.minecraft.Item;
import net.oilcake.mitelros.feat.anvil.AnvilSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;

@Pseudo
@Mixin(value = AnvilSystem.class, remap = false)
public class MaceVampiricITFAnvilSystemMixin {

    @WrapOperation(method = "calcXPDiffOnEnchanting", at = @At(value = "INVOKE", target = "Lnet/minecraft/Enchantment;canEnchantItem(Lnet/minecraft/Item;)Z"), require = 0)
    private static boolean utilitycraft$allowVampiricMaceInITFAnvil(Enchantment enchantment, Item item, Operation<Boolean> original) {
        return UCEnchantmentCompat.canEnchantVampiricVibraniumMace(enchantment, item, original.call(enchantment, item));
    }
}
