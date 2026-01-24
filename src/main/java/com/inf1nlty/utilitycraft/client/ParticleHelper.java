package com.inf1nlty.utilitycraft.client;

import net.minecraft.Minecraft;
import net.minecraft.World;

public class ParticleHelper {
    public static void spawnSweepAttack(World world, double x, double y, double z) {

        ParticleSpawnQueue.enqueue(() -> Minecraft.getMinecraft().effectRenderer.addEffect(
                new EntitySweepAttackFX(world, x, y, z)
        ));
    }
}