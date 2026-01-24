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

        float maxIgnore = 0.0f;
        if (armors != null) {
            for (ItemStack armorStack : armors) {
                if (armorStack == null) continue;
                Item item = armorStack.getItem();
                if (!(item instanceof ItemArmor armorItem)) continue;

                Material mat = armorItem.getArmorMaterial();
                if (mat == null) continue;

                float ignore = getIgnore(mat);
                if (ignore > maxIgnore) maxIgnore = ignore;
                if (maxIgnore >= 1.0f) break;
            }
        }

        if (maxIgnore <= 0.0f) {
            return originalProtection;
        }

        float adjusted = originalProtection * (1.0f - maxIgnore);
        return Math.max(0.0f, adjusted);
    }

    @Unique
    private static float getIgnore(Material mat) {

        // Leather -> 100%
        // Copper/Silver/Gold -> 50%
        // Iron/Rusted_iron -> 40%
        // Ancient_Metal -> 30%
        // Mithril -> 25%
        // Adamantium -> 15%
        if (mat == Material.leather) {
            return 1.0f;

        } else if (mat == Material.copper || mat == Material.silver || mat == Material.gold) {
            return 0.5f;

        } else if (mat == Material.iron || mat == Material.rusted_iron) {
            return 0.4f;

        } else if (mat == Material.ancient_metal) {
            return 0.3f;

        } else if (mat == Material.mithril) {
            return 0.25f;

        } else if (mat == Material.adamantium) {
            return 0.15f;

        } else {
            return 0.0f;
        }
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