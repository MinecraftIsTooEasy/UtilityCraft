package com.inf1nlty.utilitycraft.item.saber;

import net.minecraft.EntityLivingBase;
import net.minecraft.EntityPlayer;

public interface ISaber {

    float getDamage();

    default void playAttackSound(EntityPlayer player, EntityLivingBase target) {}
}