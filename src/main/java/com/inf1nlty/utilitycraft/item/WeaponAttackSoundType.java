package com.inf1nlty.utilitycraft.item;

import com.inf1nlty.utilitycraft.UCConfigs;
import com.inf1nlty.utilitycraft.client.UCSounds;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import net.minecraft.EntityPlayer;
import net.minecraft.ResourceLocation;

public enum WeaponAttackSoundType {

    SABER(UCSounds.weaponSweep, UCConfigs.saberAttackSound, 0.4F),
    RAPIER(UCSounds.weaponRapier, UCConfigs.rapierAttackSound, 0.4F),
    NUNCHAKU(UCSounds.weaponNunchaku, UCConfigs.nunchakuAttackSound, 1.0F);

    private final ResourceLocation sound;
    private final ConfigBoolean enabled;
    private final float volume;

    WeaponAttackSoundType(ResourceLocation sound, ConfigBoolean enabled, float volume) {
        this.sound = sound;
        this.enabled = enabled;
        this.volume = volume;
    }

    public boolean isEnabled() {
        return this.enabled.getBooleanValue();
    }

    public void broadcast(EntityPlayer source, float pitch) {
        source.worldObj.playSoundAtEntity(source, this.sound.toString(), this.volume, pitch);
    }

    public static WeaponAttackSoundType fromSoundName(String soundName) {
        for (WeaponAttackSoundType type : values()) {
            if (type.sound.toString().equals(soundName)) {
                return type;
            }
        }
        return null;
    }
}
