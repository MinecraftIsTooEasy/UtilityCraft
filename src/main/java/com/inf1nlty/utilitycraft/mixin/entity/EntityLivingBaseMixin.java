package com.inf1nlty.utilitycraft.mixin.entity;

import com.inf1nlty.utilitycraft.item.rapier.IRapier;

import net.minecraft.*;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityLivingBase.class)
public abstract class EntityLivingBaseMixin extends Entity {

    @Shadow public int maxHurtResistantTime;

    @Unique
    private static final ThreadLocal<Damage> utilitycraft$currentDamage = new ThreadLocal<>();

    public EntityLivingBaseMixin(World par1World) {
        super(par1World);
    }

    @Inject(method = "attackEntityFrom", at = @At("HEAD"))
    private void utilitycraft$storeDamageContext(Damage damage, CallbackInfoReturnable<EntityDamageResult> cir) {
        utilitycraft$currentDamage.set(damage);
    }

    @Redirect(method = "getProtectionFromArmor", at = @At(value = "INVOKE", target = "Lnet/minecraft/ItemArmor;getTotalArmorProtection([Lnet/minecraft/ItemStack;Lnet/minecraft/DamageSource;ZLnet/minecraft/EntityLivingBase;)F"))
    private float utilitycraft$halveArmorProtectionForRapier(ItemStack[] armors, DamageSource damage_source, boolean include_enchantments, EntityLivingBase owner) {
        Damage damage = utilitycraft$currentDamage.get();
        float originalProtection = ItemArmor.getTotalArmorProtection(armors, damage_source, include_enchantments, owner);

        if (damage != null) {
            Entity attacker = damage.getResponsibleEntity();
            if (attacker instanceof EntityLivingBase) {
                ItemStack held = ((EntityLivingBase)attacker).getHeldItemStack();
                if (held != null && held.getItem() instanceof IRapier) {
                    return originalProtection * 0.5F;
                }
            }
        }

        return originalProtection;
    }

    @Inject(method = "attackEntityFrom", at = @At("RETURN"))
    private void utilitycraft$adjustRapierHurtResistance(Damage damage, CallbackInfoReturnable<EntityDamageResult> cir) {

        if (damage == null) return;

        Entity attacker = damage.getResponsibleEntity();
        if (!(attacker instanceof EntityLivingBase)) return;

        ItemStack held = ((EntityLivingBase) attacker).getHeldItemStack();

        if (held == null || !(held.getItem() instanceof IRapier)) return;

        if (this.hurtResistantTime == this.maxHurtResistantTime) {
            this.hurtResistantTime = 18;
        }
    }
}