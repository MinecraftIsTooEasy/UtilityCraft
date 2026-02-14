package com.inf1nlty.utilitycraft.mixin.client.render;

import com.inf1nlty.utilitycraft.block.BlockLocker;
import com.inf1nlty.utilitycraft.block.tileentity.TileEntityLocker;
import net.minecraft.Block;
import net.minecraft.ChestItemRenderHelper;
import net.minecraft.TileEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChestItemRenderHelper.class)
public abstract class ChestItemRenderHelperMixin {

    @Unique private final TileEntityLocker steelChest = new TileEntityLocker();

    @Inject(method = "renderChest", at = @At("HEAD"),cancellable = true)
    private void renderSteelChestItem(Block block, int f, float par3, CallbackInfo ci){
        if (block instanceof BlockLocker bsc) {
            this.steelChest.chestType = bsc.chestType;
            TileEntityRenderer.instance.renderTileEntityAt(this.steelChest, 0.0, 0.0, 0.0, 0.0f);
            ci.cancel();
        }
    }
}