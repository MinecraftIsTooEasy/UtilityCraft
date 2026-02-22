package com.inf1nlty.utilitycraft.mixin.accessor;

import net.minecraft.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Entity.class)
public interface EntityAccessor {

    @Accessor("inWater")
    boolean getInWater();

}