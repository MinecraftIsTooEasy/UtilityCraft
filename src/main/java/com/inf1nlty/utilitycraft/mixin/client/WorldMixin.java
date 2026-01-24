package com.inf1nlty.utilitycraft.mixin.client;

import com.inf1nlty.utilitycraft.client.ParticleHelper;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(World.class)
public class WorldMixin {

    @Inject(method = "playAuxSFX", at = @At("HEAD"), cancellable = true)
    private void utilitycraft$handleSweepEffect(int event_id, int x, int y, int z, int extra, CallbackInfo ci) {

        World world = (World)(Object)this;

        if (!world.isRemote) {
            return;
        }

        if (event_id == 2010) {

            float yaw = Float.intBitsToFloat(extra);

            double px = x + 0.5D - Math.sin(Math.toRadians(yaw)) * 0.5D;
            double py = y + 0.5D;
            double pz = z + 0.5D + Math.cos(Math.toRadians(yaw)) * 0.5D;

            ParticleHelper.spawnSweepAttack(world, px, py, pz);

            ci.cancel();
        }
    }
}