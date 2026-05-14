package com.inf1nlty.utilitycraft.item.armor;

public interface IHeavyArmor {

    int EXTRA_MATERIAL_PROTECTION = 2;

    default int getHeavyArmorMaterialProtection(int materialProtection) {
        return materialProtection + EXTRA_MATERIAL_PROTECTION;
    }
}
