package com.inf1nlty.utilitycraft.mixin.client;

import com.inf1nlty.utilitycraft.item.nunchaku.ItemNunchaku;
import net.minecraft.EnumFace;
import net.minecraft.EnumGameType;
import net.minecraft.ItemStack;
import net.minecraft.Minecraft;
import net.minecraft.PlayerControllerMP;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerControllerMP.class)
public class PlayerControllerMPNunchakuMixin {

    @Shadow @Final private Minecraft mc;

    @Shadow private EnumGameType currentGameType;

    @Inject(method = "onPlayerDestroyBlock", at = @At("HEAD"), cancellable = true)
    private void utilitycraft$preventCreativeNunchakuBlockBreaking(int x, int y, int z, EnumFace face, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = this.mc.thePlayer.getHeldItemStack();
        if (this.currentGameType.isCreative() && stack != null && stack.getItem() instanceof ItemNunchaku) {
            cir.setReturnValue(false);
        }
    }
}
