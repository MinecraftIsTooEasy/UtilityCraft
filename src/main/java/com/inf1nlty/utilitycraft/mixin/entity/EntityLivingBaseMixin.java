package com.inf1nlty.utilitycraft.mixin.entity;

import com.inf1nlty.utilitycraft.item.rapier.IRapier;
import com.inf1nlty.utilitycraft.util.UCDamageUtils;

import net.minecraft.*;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityLivingBase.class)
public abstract class EntityLivingBaseMixin extends Entity {

    @Shadow public int maxHurtResistantTime;

    public EntityLivingBaseMixin(World par1World) {
        super(par1World);
    }

    @Redirect(method = "getProtectionFromArmor", at = @At(value = "INVOKE", target = "Lnet/minecraft/ItemArmor;getTotalArmorProtection([Lnet/minecraft/ItemStack;Lnet/minecraft/DamageSource;ZLnet/minecraft/EntityLivingBase;)F"))
    private float utilitycraft$halveArmorProtectionForRapier(ItemStack[] armors, DamageSource damage_source, boolean include_enchantments, EntityLivingBase owner) {

        float originalProtection = ItemArmor.getTotalArmorProtection(armors, damage_source, include_enchantments, owner);

        if (damage_source == null) {
            return originalProtection;
        }
        Entity attacker = damage_source.getResponsibleEntity();
        if (!(attacker instanceof EntityLivingBase)) {
            return originalProtection;
        }
        ItemStack held = ((EntityLivingBase) attacker).getHeldItemStack();
        if (held == null || !(held.getItem() instanceof IRapier)) {
            return originalProtection;
        }

        Material rapierMat;
        try {
            rapierMat = ((IRapier) held.getItem()).getMaterial();
        } catch (Throwable t) {
            return originalProtection;
        }

        float maxPenetration = 0.0f;
        if (armors != null) {
            for (ItemStack armorStack : armors) {
                if (armorStack == null) continue;
                Item item = armorStack.getItem();
                if (!(item instanceof ItemArmor armorItem)) continue;

                Material armorMat = armorItem.getArmorMaterial();
                if (armorMat == null) continue;

                float penetration = UCDamageUtils.getArmorPenetration(rapierMat, armorMat);
                if (penetration > maxPenetration) maxPenetration = penetration;
                if (maxPenetration >= 1.0f) break;
            }
        }

        if (maxPenetration <= 0.0f) {
            return originalProtection;
        }

        float adjusted = originalProtection * (1.0f - maxPenetration);
        return Math.max(0.0f, adjusted);
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