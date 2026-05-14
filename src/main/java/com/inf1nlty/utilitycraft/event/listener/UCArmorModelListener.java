package com.inf1nlty.utilitycraft.event.listener;

import com.inf1nlty.utilitycraft.UtilityCraftMod;
import com.inf1nlty.utilitycraft.item.armor.IHeavyArmor;
import moddedmite.rustedironcore.api.event.listener.IArmorModelListener;
import net.minecraft.ItemArmor;
import net.minecraft.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class UCArmorModelListener implements IArmorModelListener {
    private final Map<String, ResourceLocation> textureCache = new HashMap<>();

    @Override
    public ResourceLocation getArmorTexture(ItemArmor itemArmor, int slotIndex) {
        if (!(itemArmor instanceof IHeavyArmor)) {
            return null;
        }

        String path = String.format("textures/models/armor/%s_layer_%d.png", itemArmor.getTextureFilenamePrefix(), slotIndex == 2 ? 2 : 1);
        return this.textureCache.computeIfAbsent(path, key -> new ResourceLocation(UtilityCraftMod.NAMESPACE, key));
    }
}
