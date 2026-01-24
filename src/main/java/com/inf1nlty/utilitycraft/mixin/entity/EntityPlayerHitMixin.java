package com.inf1nlty.utilitycraft.mixin.entity;

import com.inf1nlty.utilitycraft.item.rapier.IRapier;
import com.inf1nlty.utilitycraft.item.saber.ISaber;

import net.minecraft.Entity;
import net.minecraft.EntityLivingBase;
import net.minecraft.EntityPlayer;
import net.minecraft.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayer.class)
public class EntityPlayerHitMixin {

    @Inject(method = "attackTargetEntityWithCurrentItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/ItemStack;hitEntity(Lnet/minecraft/EntityLivingBase;Lnet/minecraft/EntityPlayer;)V", shift = At.Shift.AFTER))
    private void playWeaponHitEffects(Entity targetEntity, CallbackInfo ci) {

        EntityPlayer player = (EntityPlayer)(Object)this;
        ItemStack stack = player.getHeldItemStack();

        if (stack == null) {
            return;
        }

        if (targetEntity instanceof EntityLivingBase living && living.hurtTime == living.maxHurtTime) {
            if (stack.getItem() instanceof IRapier rapier) {
                rapier.playAttackSound(player, living);
            }
            else if (stack.getItem() instanceof ISaber saber) {
                saber.playAttackSound(player, living);

                if (!player.worldObj.isRemote) {
                    float yaw = player.rotationYaw;
                    double x = player.posX - Math.sin(Math.toRadians(yaw)) * 0.5D;
                    double y = player.posY + player.getEyeHeight() - 0.4D;
                    double z = player.posZ + Math.cos(Math.toRadians(yaw)) * 0.5D;

                    player.worldObj.playAuxSFX(2010, (int)x, (int)y, (int)z, Float.floatToIntBits(yaw));
                }
            }
        }
    }
}