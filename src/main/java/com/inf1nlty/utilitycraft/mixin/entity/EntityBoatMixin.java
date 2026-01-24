package com.inf1nlty.utilitycraft.mixin.entity;

import com.inf1nlty.utilitycraft.entity.EntityObsidianBoat;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityBoat.class)
public abstract class EntityBoatMixin {

    @ModifyVariable(method = "onUpdate", at = @At(value = "STORE"), ordinal = 0)
    private float utilitycraft$adjustSubmergenceForObsidian(float submergence) {
        EntityBoat boat = (EntityBoat)(Object)this;
        if (boat instanceof EntityObsidianBoat) {

            int blockX = MathHelper.floor_double(boat.posX);
            int blockY = MathHelper.floor_double(boat.posY - 0.2D);
            int blockZ = MathHelper.floor_double(boat.posZ);

            Material material = boat.worldObj.getBlockMaterial(blockX, blockY, blockZ);
            if (material == Material.lava) {

                byte var1 = 10;
                float dy = 0.2F / (float)var1;
                float lavaSubmergence = 0.0F;

                for(int i = 0; i < var1; ++i) {
                    float offset_y = (float)i * dy - 0.25F;
                    if (boat.worldObj.getBlockMaterial(
                            MathHelper.floor_double(boat.posX),
                            MathHelper.floor_double(boat.posY + (double)offset_y),
                            MathHelper.floor_double(boat.posZ)) != Material.lava) {
                        break;
                    }
                    lavaSubmergence += 1.0F / (float)var1;
                }

                return lavaSubmergence > 0 ? lavaSubmergence : submergence;
            }
        }
        return submergence;
    }

    @Inject(method = "onUpdate", at = @At(value = "INVOKE", target = "Lnet/minecraft/World;spawnParticle(Lnet/minecraft/EnumParticle;DDDDDD)V"))
    private void utilitycraft$spawnLavaParticles(CallbackInfo ci) {
        EntityBoat boat = (EntityBoat)(Object)this;

        if (boat instanceof EntityObsidianBoat && !boat.worldObj.isRemote) {
            int blockX = MathHelper.floor_double(boat.posX);
            int blockY = MathHelper.floor_double(boat.posY - 0.2D);
            int blockZ = MathHelper.floor_double(boat.posZ);

            Material material = boat.worldObj.getBlockMaterial(blockX, blockY, blockZ);
            if (material == Material.lava) {

                double var23 = Math.sqrt(boat.motionX * boat.motionX + boat.motionZ * boat.motionZ);
                if (var23 > 0.1875D) {
                    double var6 = Math.cos((double)boat.rotationYaw * Math.PI / 180.0D);
                    double var8 = Math.sin((double)boat.rotationYaw * Math.PI / 180.0D);

                    for(int var10 = 0; (double)var10 < 1.0D + var23 * 60.0D; ++var10) {
                        double var11 = (double)(boat.rand.nextFloat() * 2.0F - 1.0F);
                        double var13 = (double)(boat.rand.nextInt(2) * 2 - 1) * 0.7D;

                        if (boat.rand.nextBoolean()) {
                            double var15 = boat.posX - var6 * var11 * 0.8D + var8 * var13;
                            double var17 = boat.posZ - var8 * var11 * 0.8D - var6 * var13;
                            boat.worldObj.spawnParticle(EnumParticle.smoke, var15, boat.posY - 0.125D, var17, boat.motionX, boat.motionY, boat.motionZ);
                        } else {
                            double var15 = boat.posX + var6 + var8 * var11 * 0.7D;
                            double var17 = boat.posZ + var8 - var6 * var11 * 0.7D;
                            boat.worldObj.spawnParticle(EnumParticle.smoke, var15, boat.posY - 0.125D, var17, boat.motionX, boat.motionY, boat.motionZ);
                        }
                    }
                }
            }
        }
    }
}