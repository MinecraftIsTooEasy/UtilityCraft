package com.inf1nlty.utilitycraft.item;

import net.minecraft.EntityLivingBase;
import net.minecraft.World;

public interface IWeaponAttackSound {

    WeaponAttackSoundType getAttackSoundType();

    default float getAttackSoundPitch(World world) {
        return 1.0F + (world.rand.nextFloat() - 0.5F) * 0.4F;
    }

    default boolean canPlayAttackSound(EntityLivingBase target) {
        return true;
    }
}
