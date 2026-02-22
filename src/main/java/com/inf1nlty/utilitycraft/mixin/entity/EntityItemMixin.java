package com.inf1nlty.utilitycraft.mixin.entity;

import com.inf1nlty.utilitycraft.mixin.accessor.EntityAccessor;
import net.minecraft.Block;
import net.minecraft.EntityItem;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.minecraft.NBTTagCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityItem.class)
public abstract class EntityItemMixin {

    @Inject(method = "onUpdate", at = @At("RETURN"))
    private void afterOnUpdate(CallbackInfo ci)

    {
        EntityItem self = (EntityItem) (Object) this;
        EntityAccessor accessor = (EntityAccessor) self;

        boolean nowInWater = accessor.getInWater();

        if (!self.worldObj.isRemote && nowInWater)
        {
            ItemStack stack = self.getEntityItem();

            if (stack != null && stack.isBlock() && stack.getItemAsBlock() != null)
            {
                Block b = stack.getItemAsBlock().getBlock();

                if (b == Block.cloth)
                {
                    int colorMeta = stack.getItemSubtype();

                    if (colorMeta != 0)
                    {
                        Item base = stack.getItem();

                        int count = stack.stackSize;

                        ItemStack newStack = new ItemStack(base, count, 0);

                        NBTTagCompound nbt = stack.getTagCompound();

                        if (nbt != null) newStack.setTagCompound((NBTTagCompound) nbt.copy());

                        self.setEntityItemStack(newStack);
                    }
                }
            }
        }
    }
}