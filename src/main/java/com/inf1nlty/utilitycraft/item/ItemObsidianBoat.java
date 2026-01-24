package com.inf1nlty.utilitycraft.item;

import com.inf1nlty.utilitycraft.entity.EntityObsidianBoat;
import net.minecraft.*;

import java.util.List;

public class ItemObsidianBoat extends Item {
    public ItemObsidianBoat(int id) {
        super(id, Material.obsidian, "obsidian_boat");
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabTransport);
    }

    @Override
    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        World world = player.worldObj;
        float var4 = 1.0F;
        float var5 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * var4;
        float var6 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * var4;
        double var7 = player.prevPosX + (player.posX - player.prevPosX) * (double)var4;
        double var9 = player.prevPosY + (player.posY - player.prevPosY) * (double)var4 + 1.62 - (double)player.yOffset;
        double var11 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)var4;
        Vec3 var13 = world.getWorldVec3Pool().getVecFromPool(var7, var9, var11);
        float var14 = MathHelper.cos(-var6 * ((float)Math.PI / 180F) - (float)Math.PI);
        float var15 = MathHelper.sin(-var6 * ((float)Math.PI / 180F) - (float)Math.PI);
        float var16 = -MathHelper.cos(-var5 * ((float)Math.PI / 180F));
        float var17 = MathHelper.sin(-var5 * ((float)Math.PI / 180F));
        float var18 = var15 * var16;
        float var20 = var14 * var16;
        double var21 = (double)5.0F;
        Vec3 var23 = var13.addVector((double)var18 * var21, (double)var17 * var21, (double)var20 * var21);
        RaycastCollision var24 = world.getBlockCollisionForSelection(var13, var23, true);

        if (var24 == null) {
            return false;
        } else {
            Vec3 var25 = player.getLook(var4);
            boolean var26 = false;
            float var27 = 1.0F;
            List var28 = world.getEntitiesWithinAABBExcludingEntity(player, player.boundingBox.addCoord(var25.xCoord * var21, var25.yCoord * var21, var25.zCoord * var21).expand((double)var27, (double)var27, (double)var27));

            for(int var29 = 0; var29 < var28.size(); ++var29) {
                Entity var30 = (Entity)var28.get(var29);
                if (var30.canBeCollidedWith()) {
                    float var31 = var30.getCollisionBorderSize(player);
                    AxisAlignedBB var32 = var30.boundingBox.expand((double)var31, (double)var31, (double)var31);
                    if (var32.isVecInside(var13)) {
                        var26 = true;
                    }
                }
            }

            if (var26) {
                return false;
            } else if (var24.isBlock()) {
                int var33 = var24.block_hit_x;
                int var34 = var24.block_hit_y;
                int var35 = var24.block_hit_z;
                if (world.getBlockId(var33, var34, var35) == Block.snow.blockID) {
                    --var34;
                }

                EntityObsidianBoat boat = new EntityObsidianBoat(world, (double)((float)var33 + 0.5F), (double)((float)var34 + 1.0F), (double)((float)var35 + 0.5F));
                boat.rotationYaw = (float)(((MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + (double)0.5F) & 3) - 1) * 90);
                if (!world.getCollidingBoundingBoxes(boat, boat.boundingBox.expand(-0.1, -0.1, -0.1)).isEmpty()) {
                    return false;
                } else {
                    if (player.onServer()) {
                        world.spawnEntityInWorld(boat);
                        if (!player.inCreativeMode()) {
                            player.convertOneOfHeldItem((ItemStack)null);
                        }
                    }
                    return true;
                }
            } else {
                return false;
            }
        }
    }
}
