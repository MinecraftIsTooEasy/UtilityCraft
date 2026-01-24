package com.inf1nlty.utilitycraft.mixin.entity;

import com.inf1nlty.utilitycraft.entity.EntityObsidianBoat;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityBoat.class)
public abstract class EntityBoatMixin {

    @ModifyVariable(method = "onUpdate", at = @At(value = "STORE"), name = "submergence")
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

    @Redirect(method = "onUpdate", at = @At(value = "INVOKE", target = "Lnet/minecraft/World;spawnParticle(Lnet/minecraft/EnumParticle;DDDDDD)V"))
    private void utilitycraft$dynamicSplashEnum(World world, EnumParticle particle, double x, double y, double z, double dx, double dy, double dz) {

        EntityBoat boat = (EntityBoat)(Object)this;
        EnumParticle useParticle = particle;

        if (boat instanceof EntityObsidianBoat && world.isRemote) {

            int blockX = MathHelper.floor_double(x);
            int blockY = MathHelper.floor_double(y - 0.2D);
            int blockZ = MathHelper.floor_double(z);
            int blockId = world.getBlockId(blockX, blockY, blockZ);

            if (blockId == Block.lavaStill.blockID || blockId == Block.lavaMoving.blockID) {
                useParticle = EnumParticle.smoke;

            } else if (blockId == Block.waterStill.blockID || blockId == Block.waterMoving.blockID) {
                useParticle = EnumParticle.splash;
            }
        }

        world.spawnParticle(useParticle, x, y, z, dx, dy, dz);
    }
}