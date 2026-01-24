package com.inf1nlty.utilitycraft.entity;

import com.inf1nlty.utilitycraft.item.UCItems;
import net.minecraft.*;

public class EntityObsidianBoat extends EntityBoat {

    public EntityObsidianBoat(World par1World) {
        super(par1World);
    }

    public EntityObsidianBoat(World par1World, double par2, double par4, double par6) {
        this(par1World);
        this.setPosition(par2, par4 + (double)this.yOffset, par6);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
    }

    @Override
    public double getMountedYOffset() {
        return 0.0;
    }

    @Override
    public boolean isHarmedByFire() {
        return false;
    }

    @Override
    public boolean isHarmedByLava() {
        return false;
    }

    @Override
    public EntityDamageResult attackEntityFrom(Damage damage) {
        if (this.isEntityInvulnerable()) {
            this.playSound("step.stone", 0.8F, 0.6F + this.rand.nextFloat() * 0.2F);
            return null;
        }

        if (damage.isExplosion()) {
            this.playSound("step.stone", 0.8F, 0.6F + this.rand.nextFloat() * 0.2F);
            return null;
        }

        Entity attacker = damage.getResponsibleEntity();
        if (attacker instanceof EntityPlayer player) {

            if (player.capabilities.isCreativeMode) {
                EntityDamageResult result = new EntityDamageResult(this);
                if (!this.worldObj.isRemote) {
                    this.setDead();
                    result.setEntityWasDestroyed();
                }
                return result;
            }

            ItemStack heldItem = player.getHeldItemStack();
            if (heldItem == null) {
                this.playSound("step.stone", 0.8F, 0.6F + this.rand.nextFloat() * 0.2F);
                return null;
            }

            Item item = heldItem.getItem();
            int toolLevel = -1;
            if (item instanceof ItemPickaxe) {
                toolLevel = ((ItemPickaxe) item).getMaterialHarvestLevel();
            }

            int requiredLevel = 3;
            if (toolLevel < requiredLevel) {
                this.playSound("step.stone", 0.8F, 0.6F + this.rand.nextFloat() * 0.2F);
                return null;
            }

            EntityDamageResult result = new EntityDamageResult(this);
            if (!this.worldObj.isRemote && !this.isDead) {
                this.setDead();
                result.setEntityWasDestroyed();

                ItemStack drop = new ItemStack(UCItems.obsidian_boat);
                double sx = this.posX, sy = this.posY + 0.5, sz = this.posZ;
                EntityItem entityItem = new EntityItem(this.worldObj, sx, sy, sz, drop);

                double dx = player.posX - sx;
                double dy = (player.posY + player.getEyeHeight()/2) - sy;
                double dz = player.posZ - sz;
                double dist = Math.sqrt(dx*dx + dy*dy + dz*dz);
                if (dist > 0.0001) {
                    double speed = 0.6;
                    entityItem.motionX = dx / dist * speed;
                    entityItem.motionY = dy / dist * speed;
                    entityItem.motionZ = dz / dist * speed;
                }

                entityItem.delayBeforeCanPickup = 0;
                this.worldObj.spawnEntityInWorld(entityItem);

                this.playSound("step.stone", 1.0F, 0.7F + this.rand.nextFloat() * 0.2F);
            }
            return result;
        }

        this.playSound("step.stone", 0.8F, 0.6F + this.rand.nextFloat() * 0.2F);
        return null;
    }

    @Override
    protected void fall(float fFallDistance) {
    }
}