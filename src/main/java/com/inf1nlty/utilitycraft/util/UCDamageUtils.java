package com.inf1nlty.utilitycraft.util;

import net.minecraft.Material;
import net.oilcake.mitelros.material.Materials;
import net.moddedmite.mitemod.bex.register.BEXMaterials;

import java.util.HashMap;
import java.util.Map;

public class UCDamageUtils {

    public static float getSweepDamage(float baseDamage, int sweepLevel) {

        if (sweepLevel <= 0) return 1.0F;

        float multiplier = (float)sweepLevel / (sweepLevel + 1);

        return baseDamage * multiplier + 1.0F;
    }

    // Unknown level sentinel: use NaN for unknown
    private static final float UNKNOWN = Float.NaN;
    // mapping Material -> level (higher = stronger)
    private static final Map<Material, Float> MATERIAL_LEVELS = new HashMap<>();

    static {
        // copper/silver/gold = 0.0
        // iron / (ITF) nickel / ancient_metal = 1.0
        // mithril = 2.0
        // (ITF) tungsten = 2.5
        // adamantium = 3.0
        // (BEX) enchant = 5.0
        // vibranium / uru = 6.0

        MATERIAL_LEVELS.put(Material.copper, 0.0F);
        MATERIAL_LEVELS.put(Material.silver, 0.0F);
        MATERIAL_LEVELS.put(Material.gold, 0.0F);

        MATERIAL_LEVELS.put(Material.rusted_iron, 0.5F);

        MATERIAL_LEVELS.put(Material.iron, 1.0F);
        MATERIAL_LEVELS.put(Material.ancient_metal, 1.0F);

        MATERIAL_LEVELS.put(Material.mithril, 2.0F);
        MATERIAL_LEVELS.put(Material.adamantium, 3.0F);

        // ITF materials: nickel (1.0), tungsten (2.5), uru (6.0)
        MATERIAL_LEVELS.put(Materials.nickel, 1.0F);
        MATERIAL_LEVELS.put(Materials.tungsten, 2.5F);
        MATERIAL_LEVELS.put(Materials.uru, 6.0F);

        // BEX enchant -> 5.0
        MATERIAL_LEVELS.put(BEXMaterials.enchant, 5.0F);

        // MITE-ITE vibranium -> 6.0
        MATERIAL_LEVELS.put(net.xiaoyu233.mitemod.miteite.item.material.Materials.vibranium, 6.0F);
    }

    public static void registerMaterialLevel(Material mat, float level) {
        if (mat == null) return;
        MATERIAL_LEVELS.put(mat, level);
    }

    private static float getMaterialLevel(Material mat) {
        if (mat == null) return UNKNOWN;
        Float lv = MATERIAL_LEVELS.get(mat);
        return lv == null ? UNKNOWN : lv;
    }

    public static float getArmorPenetration(Material rapierMaterial, Material armorMaterial) {
        float rLevel = getMaterialLevel(rapierMaterial);
        float aLevel = getMaterialLevel(armorMaterial);
        if (Float.isNaN(rLevel) || Float.isNaN(aLevel)) {
            return 0.0f;
        }
        float delta = rLevel - aLevel;
        if (delta >= 3.0f) return 1.0f;
        if (delta >= 2.0f) return 0.75f;
        if (delta >= 1.0f) return 0.5f;
        if (delta >= 0.0f) return 0.25f;
        if (delta >= -1.0f) return 0.10f;
        return 0.0f;
    }
}