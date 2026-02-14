package com.inf1nlty.utilitycraft.mixin.client.render;

import com.inf1nlty.utilitycraft.block.tileentity.TileEntityLocker;
import com.inf1nlty.utilitycraft.client.render.TileEntityLockerRenderer;
import net.minecraft.TileEntityRenderer;
import net.minecraft.TileEntitySpecialRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(TileEntityRenderer.class)
public abstract class TileEntityRendererMixin {

    @Shadow
    public Map<Class<?>, TileEntitySpecialRenderer> specialRendererMap;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void customChestRendering(CallbackInfo ci) {
        specialRendererMap.put(TileEntityLocker.class, new TileEntityLockerRenderer());
        TileEntityRenderer thisObj = (TileEntityRenderer) (Object) this;

        for (TileEntitySpecialRenderer renderer : specialRendererMap.values()) {
            renderer.setTileEntityRenderer(thisObj);
        }
        specialRendererMap.get(TileEntityLocker.class).setTileEntityRenderer(thisObj);
    }
}