package com.inf1nlty.utilitycraft.mixin;

import com.inf1nlty.utilitycraft.item.nunchaku.ItemNunchaku;
import net.minecraft.EnumGameType;
import net.minecraft.ItemInWorldManager;
import net.minecraft.ItemStack;
import net.minecraft.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemInWorldManager.class)
public class ItemInWorldManagerNunchakuMixin {

    @Shadow public ServerPlayer thisPlayerMP;
    @Shadow private EnumGameType gameType;

    @Inject(method = "tryHarvestBlock", at = @At("HEAD"), cancellable = true)
    private void utilitycraft$preventCreativeNunchakuBlockBreaking(int x, int y, int z,
                                                                   CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = this.thisPlayerMP.getHeldItemStack();
        if (this.gameType.isCreative() && stack != null && stack.getItem() instanceof ItemNunchaku) {
            cir.setReturnValue(false);
        }
    }
}
