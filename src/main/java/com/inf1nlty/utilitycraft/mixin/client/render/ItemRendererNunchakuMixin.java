package com.inf1nlty.utilitycraft.mixin.client.render;

import com.inf1nlty.utilitycraft.item.nunchaku.INunchakuSpinState;
import com.inf1nlty.utilitycraft.item.nunchaku.ItemNunchaku;
import net.minecraft.EntityLivingBase;
import net.minecraft.ItemRenderer;
import net.minecraft.ItemStack;
import net.minecraft.Minecraft;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public class ItemRendererNunchakuMixin {

    @Shadow
    private Minecraft mc;

    @Inject(method = "renderItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/ItemRenderer;renderItemIn2D(Lnet/minecraft/Tessellator;FFFFIIF)V", ordinal = 0))
    private void utilitycraft$transformNunchaku(EntityLivingBase entity, ItemStack stack, int renderPass, CallbackInfo ci) {
        if (stack == null || !(stack.getItem() instanceof ItemNunchaku)) {
            return;
        }

        boolean spinning = isSpinning(entity);
        boolean firstPerson = entity == this.mc.thePlayer && this.mc.gameSettings.thirdPersonView == 0;
        if (firstPerson) {
            applyFirstPersonTransform(spinning);
        } else {
            applyThirdPersonTransform(spinning);
        }
    }

    @Unique
    private static boolean isSpinning(EntityLivingBase entity) {
        INunchakuSpinState spinState = INunchakuSpinState.as(entity);
        return spinState != null && spinState.utilitycraft$isNunchakuSpinning();
    }

    @Unique
    private static void applyFirstPersonTransform(boolean spinning) {
        undoItemRendererTransform();
        GL11.glScalef(2.5F, 2.5F, 2.5F);

        // Better Survival's first-person right-hand transform.
        GL11.glRotatef(-45.0F, 0.0F, 1.0F, 0.0F);

        if (spinning) {
            GL11.glTranslatef(0.0F, 9.35F / 16.0F, -2.2F / 16.0F);
        } else {
            GL11.glTranslatef(-0.5F / 16.0F, 2.85F / 16.0F, 0.8F / 16.0F);
        }

        GL11.glRotatef(15.0F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);

        if (spinning) {
            GL11.glScalef(1.36F, 1.36F, 0.68F);
        } else {
            GL11.glScalef(0.68F, 0.68F, 0.68F);
        }

        centerGeneratedItemModel();
    }

    @Unique
    private static void applyThirdPersonTransform(boolean spinning) {
        // Undo MITE's full-3D tool and ItemRenderer transforms.
        undoItemRendererTransform();
        GL11.glRotatef(-45.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(100.0F, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(1.6F, -1.6F, 1.6F);
        GL11.glTranslatef(0.0F, -0.1875F, 0.0F);
        GL11.glTranslatef(0.0625F, -0.4375F, -0.0625F);

        // Better Survival's third-person right-hand transform.
        GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0625F, 0.125F, -0.625F);

        if (spinning) {
            GL11.glTranslatef(0.0F, 9.75F / 16.0F, 0.5F);
        } else {
            GL11.glTranslatef(0.0F, 0.25F, 2.5F / 16.0F);
        }

        GL11.glRotatef(75.0F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);

        if (spinning) {
            GL11.glScalef(1.7F, 1.7F, 0.85F);
        } else {
            GL11.glScalef(0.85F, 0.85F, 0.85F);
        }

        centerGeneratedItemModel();
    }

    @Unique
    private static void undoItemRendererTransform() {
        GL11.glTranslatef(0.9375F, 0.0625F, 0.0F);
        GL11.glRotatef(25.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(2.0F / 3.0F, 2.0F / 3.0F, 2.0F / 3.0F);
        GL11.glTranslatef(0.0F, 0.3F, 0.0F);
    }

    @Unique
    private static void centerGeneratedItemModel() {
        GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, 0.03125F);
    }
}
