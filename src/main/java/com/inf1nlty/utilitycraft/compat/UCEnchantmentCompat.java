package com.inf1nlty.utilitycraft.compat;

import com.inf1nlty.utilitycraft.item.mace.ItemMace;
import net.minecraft.Enchantment;
import net.minecraft.Item;

public final class UCEnchantmentCompat {
    private UCEnchantmentCompat() {
    }

    public static boolean canEnchantVampiricVibraniumMace(Enchantment enchantment, Item item, boolean original) {
        return original || isVampiricVibraniumMace(enchantment, item);
    }

    public static boolean isVampiricVibraniumMace(Enchantment enchantment, Item item) {
        return enchantment == Enchantment.vampiric && ItemMace.isVibraniumMace(item);
    }
}
