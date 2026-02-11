package com.inf1nlty.utilitycraft.item.saber;

import com.inf1nlty.utilitycraft.UCEnchantments;
import com.inf1nlty.utilitycraft.client.UCSounds;
import com.inf1nlty.utilitycraft.creativetab.UCCreativeTab;
import com.inf1nlty.utilitycraft.item.ISweepAttack;
import com.inf1nlty.utilitycraft.util.UCDamageUtils;
import net.minecraft.*;
import net.xiaoyu233.fml.api.item.SwordItem;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class ItemSaber extends SwordItem implements ISaber, ISweepAttack {

    private final float damage;

    public ItemSaber(int id, Material material, float damage, String name) {
        super(id, material);
        this.damage = damage;
        this.setUnlocalizedName(name);
        this.setCreativeTab(UCCreativeTab.TAB);
    }

    @Override
    public float getDamage() {
        return this.damage;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (attacker instanceof EntityPlayer player) {
            onSweepAttack(player, target);
        }
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public void onSweepAttack(EntityPlayer player, Entity target) {
        float mainDamage = this.getDamage();
        double sweepRange = 1.0D;
        int sweepLevel = EnchantmentHelper.getEnchantmentLevel(UCEnchantments.sweepingEdge.effectId, player.getHeldItemStack());
        float sweepDamage = UCDamageUtils.getSweepDamage(mainDamage, sweepLevel);

        DamageSource damageSource = DamageSource.causePlayerDamage(player);
        Damage mainTargetDamage = new Damage(damageSource, mainDamage);
        target.attackEntityFrom(mainTargetDamage);

        @SuppressWarnings("unchecked")
        List<EntityLivingBase> sweepTargets = player.worldObj.getEntitiesWithinAABB(
                EntityLivingBase.class,
                target.boundingBox.expand(sweepRange, 0.25D, sweepRange));

        float knockbackStrength = 0.4F;

        for (EntityLivingBase nearby : sweepTargets) {
            if (nearby != target && nearby != player && player.canSeeEntity(nearby) && nearby.isEntityAlive()) {
                double dx = player.posX - nearby.posX;
                double dz = player.posZ - nearby.posZ;
                nearby.knockBack(player, knockbackStrength, dx, dz);

                Damage sweepAttackDamage = new Damage(damageSource, sweepDamage);
                nearby.attackEntityFrom(sweepAttackDamage);
            }
        }
    }

    @Override
    public void playAttackSound(EntityPlayer player, EntityLivingBase target) {
        float volume = 0.4F;
        float pitch = 1.0F + (player.worldObj.rand.nextFloat() - 0.5F) * 0.4F;
        player.worldObj.playSoundAtEntity(player, UCSounds.weaponSweep.toString(), volume, pitch);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {

        super.addInformation(item_stack, player, info, extended_info, slot);

        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            int sweepLevel = EnchantmentHelper.getEnchantmentLevel(UCEnchantments.sweepingEdge.effectId, item_stack);
            float baseDamage = this.getDamage() + 1.0F;
            float sweepDamage = UCDamageUtils.getSweepDamage(baseDamage, sweepLevel);

            info.add(StatCollector.translateToLocalFormatted("item.utilitycraft.saber.desc", sweepDamage));
        } else {
            info.add(StatCollector.translateToLocal("item.utilitycraft.saber.tip"));
        }
    }

    public static ItemSaber createCopper(int id) {
        return new ItemSaber(id, Material.copper, 5.0F, "copper_saber");
    }

    public static ItemSaber createSilver(int id) {
        return new ItemSaber(id, Material.silver, 5.0F, "silver_saber");
    }

    public static ItemSaber createGolden(int id) {
        return new ItemSaber(id, Material.gold, 4.0F, "golden_saber");
    }

    public static ItemSaber createIron(int id) {
        return new ItemSaber(id, Material.iron, 7.0F, "iron_saber");
    }

    public static ItemSaber createAncientMetal(int id) {
        return new ItemSaber(id, Material.ancient_metal, 7.0F, "ancient_metal_saber");
    }

    public static ItemSaber createMithril(int id) {
        return new ItemSaber(id, Material.mithril, 8.0F, "mithril_saber");
    }

    public static ItemSaber createAdamantium(int id) {
        return new ItemSaber(id, Material.adamantium, 9.0F, "adamantium_saber");
    }
}