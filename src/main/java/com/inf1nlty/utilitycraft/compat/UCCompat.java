// 修改/替换为此 UCCompat（仅展示关键部分）
package com.inf1nlty.utilitycraft.compat;

import com.inf1nlty.utilitycraft.item.UCItems;
import com.inf1nlty.utilitycraft.item.rapier.ItemRapier;
import com.inf1nlty.utilitycraft.item.saber.ItemSaber;
import net.minecraft.Item;
import net.minecraft.Material;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

import java.lang.reflect.Field;

public final class UCCompat {

    private UCCompat() {}

    private static final String MOD_NAMESPACE = "utilitycraft";
    private static final String RES_PREFIX = MOD_NAMESPACE + ":";

    private static final String ITF_MATERIALS_CLASS = "net.oilcake.mitelros.material.Materials";
    private static final String MITEITE_MATERIALS_CLASS = "net.xiaoyu233.mitemod.miteite.item.material.Materials";
    private static final String BEX_MATERIALS_CLASS = "net.moddedmite.mitemod.bex.register.BEXMaterials";

    // Add static references here so other code (recipes) can see items even if UCItems lacks fields
    public static Item nickel_saber;
    public static Item nickel_rapier;
    public static Item tungsten_saber;
    public static Item tungsten_rapier;
    public static Item uru_saber;
    public static Item uru_rapier;
    public static Item enchant_saber;
    public static Item enchant_rapier;
    public static Item vibranium_saber;
    public static Item vibranium_rapier;

    public static void registerCompatItems(ItemRegistryEvent event) {
        tryRegisterFromProvider(ITF_MATERIALS_CLASS,
                "nickel", "saber/nickel_saber", "nickel_saber", 7.0F, "rapier/nickel_rapier", "nickel_rapier", 7.0F,
                event);

        tryRegisterFromProvider(ITF_MATERIALS_CLASS,
                "tungsten", "saber/tungsten_saber", "tungsten_saber", 8.0F, "rapier/tungsten_rapier", "tungsten_rapier", 8.0F,
                event);

        tryRegisterFromProvider(ITF_MATERIALS_CLASS,
                "uru", "saber/uru_saber", "uru_saber", 9.0F, "rapier/uru_rapier", "uru_rapier", 9.0F,
                event);

        tryRegisterFromProvider(BEX_MATERIALS_CLASS,
                "enchant", "saber/enchant_saber", "enchant_saber", 11.0F, "rapier/enchant_rapier", "enchant_rapier", 11.0F,
                event);

        tryRegisterFromProvider(MITEITE_MATERIALS_CLASS,
                "vibranium", "saber/vibranium_saber", "vibranium_saber", 12.0F, "rapier/vibranium_rapier", "vibranium_rapier", 12.0F,
                event);
    }

    private static void tryRegisterFromProvider(String providerClass,
                                                String fieldName,
                                                String saberResPath, String saberFieldName, float saberDamage,
                                                String rapierResPath, String rapierFieldName, float rapierDamage,
                                                ItemRegistryEvent event) {
        Class<?> cls;
        try {
            cls = Class.forName(providerClass);
        } catch (ClassNotFoundException e) {
            return;
        }

        try {
            Field f = cls.getField(fieldName);
            Object value = f.get(null);
            if (!(value instanceof Material mat)) return;

            // Saber
            ItemSaber saber = new ItemSaber(IdUtil.getNextItemID(), mat, saberDamage, saberFieldName);
            event.register(MOD_NAMESPACE, RES_PREFIX + saberResPath, saberFieldName, saber);
            // assign to UCItems if possible (existing code)
            assignToUCItemsFieldIfExists(saberFieldName, saber);
            // also store in UCCompat static field so recipes can reference it
            storeCompatField(saberFieldName, saber);

            // Rapier
            ItemRapier rapier = new ItemRapier(IdUtil.getNextItemID(), mat, rapierDamage, rapierFieldName);
            event.register(MOD_NAMESPACE, RES_PREFIX + rapierResPath, rapierFieldName, rapier);
            assignToUCItemsFieldIfExists(rapierFieldName, rapier);
            storeCompatField(rapierFieldName, rapier);

        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            // missing field or inaccessible -> skip this material
        } catch (Throwable t) {
            // catch any other reflection/runtime issues to avoid crashing registration
        }
    }

    private static void storeCompatField(String fieldName, Item value) {
        try {
            switch (fieldName) {
                case "nickel_saber": nickel_saber = value; break;
                case "nickel_rapier": nickel_rapier = value; break;
                case "tungsten_saber": tungsten_saber = value; break;
                case "tungsten_rapier": tungsten_rapier = value; break;
                case "uru_saber": uru_saber = value; break;
                case "uru_rapier": uru_rapier = value; break;
                case "enchant_saber": enchant_saber = value; break;
                case "enchant_rapier": enchant_rapier = value; break;
                case "vibranium_saber": vibranium_saber = value; break;
                case "vibranium_rapier": vibranium_rapier = value; break;
                default: break;
            }
        } catch (Throwable ignored) {}
    }

    private static void assignToUCItemsFieldIfExists(String fieldName, Object value) {
        try {
            Field target = UCItems.class.getDeclaredField(fieldName);
            target.setAccessible(true);
            target.set(null, value);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
    }
}