package com.inf1nlty.utilitycraft.util;

import net.minecraft.StatCollector;

public final class UCItemNameUtils {
    private UCItemNameUtils() {
    }

    public static String composeName(String materialKey, String itemTypeKey) {
        String materialName = StatCollector.translateToLocal("utilitycraft.material." + materialKey);
        String itemTypeName = StatCollector.translateToLocal("utilitycraft.item_type." + itemTypeKey);
        return StatCollector.translateToLocalFormatted("utilitycraft.item_name.format", materialName, itemTypeName).trim();
    }

    public static String materialKeyFromItemName(String itemName, String suffix) {
        if (itemName.endsWith(suffix)) {
            return itemName.substring(0, itemName.length() - suffix.length());
        }
        return itemName;
    }
}
