package com.inf1nlty.utilitycraft.item.rapier;

import net.minecraft.EntityLivingBase;
import net.minecraft.EntityPlayer;
import net.minecraft.Material;

public interface IRapier {

    float getDamage();

    default Material getMaterial() {
        return null;
    }

    default void playAttackSound(EntityPlayer player, EntityLivingBase target) {}
}