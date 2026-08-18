package com.inf1nlty.utilitycraft.item.rapier;

import net.minecraft.Material;

public interface IRapier {

    float getDamage();

    default Material getMaterial() {
        return null;
    }
}
