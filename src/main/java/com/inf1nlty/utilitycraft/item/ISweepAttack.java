package com.inf1nlty.utilitycraft.item;

import net.minecraft.Entity;
import net.minecraft.EntityPlayer;

public interface ISweepAttack {

    void onSweepAttack(EntityPlayer player, Entity target);
}