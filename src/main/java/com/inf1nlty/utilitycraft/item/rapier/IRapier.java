package com.inf1nlty.utilitycraft.item.rapier;

import net.minecraft.EntityLivingBase;
import net.minecraft.EntityPlayer;

public interface IRapier {

    float getDamage();

    default void playAttackSound(EntityPlayer player, EntityLivingBase target) {}
}