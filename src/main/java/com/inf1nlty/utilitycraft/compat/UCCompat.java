package com.inf1nlty.utilitycraft.compat;

import com.inf1nlty.utilitycraft.item.rapier.ItemRapier;
import com.inf1nlty.utilitycraft.item.saber.ItemSaber;
import com.inf1nlty.utilitycraft.item.armor.ItemHeavyBoots;
import com.inf1nlty.utilitycraft.item.armor.ItemHeavyCuirass;
import com.inf1nlty.utilitycraft.item.armor.ItemHeavyHelmet;
import com.inf1nlty.utilitycraft.item.armor.ItemHeavyLeggings;
import com.inf1nlty.utilitycraft.item.mace.ItemMace;
import com.inf1nlty.utilitycraft.item.paxel.ItemPaxel;
import com.inf1nlty.utilitycraft.util.UCDamageUtils;
import net.minecraft.Item;
import net.minecraft.Material;
import net.moddedmite.mitemod.bex.register.BEXMaterials;
import net.oilcake.mitelros.material.Materials;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public final class UCCompat {

    private UCCompat() {
    }

    private static final String MOD_NAMESPACE = "UtilityCraft";
    private static final String RES_PREFIX = MOD_NAMESPACE + ":";

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
    public static Item vibranium_mace;
    public static Item vibranium_heavy_helmet;
    public static Item vibranium_heavy_chestplate;
    public static Item vibranium_heavy_leggings;
    public static Item vibranium_heavy_boots;
    public static Item bronze_saber;
    public static Item bronze_rapier;
    public static Item steel_saber;
    public static Item steel_rapier;
    public static Item titanium_alloy_saber;
    public static Item titanium_alloy_rapier;
    public static Item rose_gold_saber;
    public static Item rose_gold_rapier;
    public static Item platinum_saber;
    public static Item platinum_rapier;
    public static Item midas_gold_saber;
    public static Item midas_gold_rapier;
    public static Item adamium_mm_saber;
    public static Item adamium_mm_rapier;

    // Paxels
    public static Item nickel_paxel;
    public static Item tungsten_paxel;
    public static Item uru_paxel;
    public static Item enchant_paxel;
    public static Item vibranium_paxel;
    public static Item bronze_paxel;
    public static Item steel_paxel;
    public static Item titanium_alloy_paxel;
    public static Item rose_gold_paxel;
    public static Item platinum_paxel;
    public static Item midas_gold_paxel;
    public static Item adamium_mm_paxel;

    public static void registerCompatItems(ItemRegistryEvent event) {

        if (ModChecker.HAS_ITFRB) {

            Material nickelMat = Materials.nickel;

            {
                UCDamageUtils.registerMaterialLevel(nickelMat, 1.0F);

                ItemSaber saber = new ItemSaber(IdUtil.getNextItemID(), nickelMat, 7.0F, "nickel_saber");
                event.register(MOD_NAMESPACE, RES_PREFIX + "saber/nickel_saber", "nickel_saber", saber);
                nickel_saber = saber;

                ItemRapier rapier = new ItemRapier(IdUtil.getNextItemID(), nickelMat, 7.0F, "nickel_rapier");
                event.register(MOD_NAMESPACE, RES_PREFIX + "rapier/nickel_rapier", "nickel_rapier", rapier);
                nickel_rapier = rapier;

                ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), nickelMat, "nickel_paxel");
                event.register(MOD_NAMESPACE, RES_PREFIX + "paxel/nickel_paxel", "nickel_paxel", paxel);
                nickel_paxel = paxel;
            }

            Material tungstenMat = Materials.tungsten;

            {
                UCDamageUtils.registerMaterialLevel(tungstenMat, 2.5F);

                ItemSaber saber = new ItemSaber(IdUtil.getNextItemID(), tungstenMat, 8.0F, "tungsten_saber");
                event.register(MOD_NAMESPACE, RES_PREFIX + "saber/tungsten_saber", "tungsten_saber", saber);
                tungsten_saber = saber;

                ItemRapier rapier = new ItemRapier(IdUtil.getNextItemID(), tungstenMat, 8.0F, "tungsten_rapier");
                event.register(MOD_NAMESPACE, RES_PREFIX + "rapier/tungsten_rapier", "tungsten_rapier", rapier);
                tungsten_rapier = rapier;

                ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), tungstenMat, "tungsten_paxel");
                event.register(MOD_NAMESPACE, RES_PREFIX + "paxel/tungsten_paxel", "tungsten_paxel", paxel);
                tungsten_paxel = paxel;
            }

            Material uruMat = Materials.uru;

            UCDamageUtils.registerMaterialLevel(uruMat, 6.0F);
            ItemSaber saber = new ItemSaber(IdUtil.getNextItemID(), uruMat, 9.0F, "uru_saber");
            event.register(MOD_NAMESPACE, RES_PREFIX + "saber/uru_saber", "uru_saber", saber);
            uru_saber = saber;

            ItemRapier rapier = new ItemRapier(IdUtil.getNextItemID(), uruMat, 9.0F, "uru_rapier");
            event.register(MOD_NAMESPACE, RES_PREFIX + "rapier/uru_rapier", "uru_rapier", rapier);
            uru_rapier = rapier;

            ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), uruMat, "uru_paxel");
            event.register(MOD_NAMESPACE, RES_PREFIX + "paxel/uru_paxel", "uru_paxel", paxel);
            uru_paxel = paxel;
        }

        if (ModChecker.HAS_BEX) {

            Material enchantMat = BEXMaterials.enchant;

            UCDamageUtils.registerMaterialLevel(enchantMat, 5.0F);

            ItemSaber saber = new ItemSaber(IdUtil.getNextItemID(), enchantMat, 11.0F, "enchant_saber");
            event.register(MOD_NAMESPACE, RES_PREFIX + "saber/enchant_saber", "enchant_saber", saber);
            enchant_saber = saber;

            ItemRapier rapier = new ItemRapier(IdUtil.getNextItemID(), enchantMat, 11.0F, "enchant_rapier");
            event.register(MOD_NAMESPACE, RES_PREFIX + "rapier/enchant_rapier", "enchant_rapier", rapier);
            enchant_rapier = rapier;

            ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), enchantMat, "enchant_paxel");
            event.register(MOD_NAMESPACE, RES_PREFIX + "paxel/enchant_paxel", "enchant_paxel", paxel);
            enchant_paxel = paxel;
        }

        if (ModChecker.HAS_ITE) {

            Material vibMat = net.xiaoyu233.mitemod.miteite.item.material.Materials.vibranium;

            UCDamageUtils.registerMaterialLevel(vibMat, 6.0F);

            ItemSaber saber = new ItemSaber(IdUtil.getNextItemID(), vibMat, 12.0F, "vibranium_saber");
            event.register(MOD_NAMESPACE, RES_PREFIX + "saber/vibranium_saber", "vibranium_saber", saber);
            vibranium_saber = saber;

            ItemRapier rapier = new ItemRapier(IdUtil.getNextItemID(), vibMat, 12.0F, "vibranium_rapier");
            event.register(MOD_NAMESPACE, RES_PREFIX + "rapier/vibranium_rapier", "vibranium_rapier", rapier);
            vibranium_rapier = rapier;

            ItemMace mace = new ItemMace(IdUtil.getNextItemID(), vibMat, "vibranium_mace");
            event.register(MOD_NAMESPACE, RES_PREFIX + "mace/vibranium_mace", "vibranium_mace", mace);
            vibranium_mace = mace;

            ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), vibMat, "vibranium_paxel");
            event.register(MOD_NAMESPACE, RES_PREFIX + "paxel/vibranium_paxel", "vibranium_paxel", paxel);
            vibranium_paxel = paxel;

            ItemHeavyHelmet heavyHelmet = new ItemHeavyHelmet(IdUtil.getNextItemID(), vibMat, "vibranium_heavy_helmet", "heavy_armor/vibranium_heavy");
            event.register(MOD_NAMESPACE, RES_PREFIX + "heavy_armor/vibranium_heavy_helmet", "vibranium_heavy_helmet", heavyHelmet);
            vibranium_heavy_helmet = heavyHelmet;

            ItemHeavyCuirass heavyChestplate = new ItemHeavyCuirass(IdUtil.getNextItemID(), vibMat, "vibranium_heavy_chestplate", "heavy_armor/vibranium_heavy");
            event.register(MOD_NAMESPACE, RES_PREFIX + "heavy_armor/vibranium_heavy_chestplate", "vibranium_heavy_chestplate", heavyChestplate);
            vibranium_heavy_chestplate = heavyChestplate;

            ItemHeavyLeggings heavyLeggings = new ItemHeavyLeggings(IdUtil.getNextItemID(), vibMat, "vibranium_heavy_leggings", "heavy_armor/vibranium_heavy");
            event.register(MOD_NAMESPACE, RES_PREFIX + "heavy_armor/vibranium_heavy_leggings", "vibranium_heavy_leggings", heavyLeggings);
            vibranium_heavy_leggings = heavyLeggings;

            ItemHeavyBoots heavyBoots = new ItemHeavyBoots(IdUtil.getNextItemID(), vibMat, "vibranium_heavy_boots", "heavy_armor/vibranium_heavy");
            event.register(MOD_NAMESPACE, RES_PREFIX + "heavy_armor/vibranium_heavy_boots", "vibranium_heavy_boots", heavyBoots);
            vibranium_heavy_boots = heavyBoots;
        }

        if (ModChecker.HAS_MM) {

            Material bronzeMat = com.moddedmite.mitemod.MoreMetals.material.Materials.bronze;

            {
                UCDamageUtils.registerMaterialLevel(bronzeMat, 1.0F);

                ItemSaber saber = new ItemSaber(IdUtil.getNextItemID(), bronzeMat, 7.0F, "bronze_saber");
                event.register(MOD_NAMESPACE, RES_PREFIX + "saber/bronze_saber", "bronze_saber", saber);
                bronze_saber = saber;

                ItemRapier rapier = new ItemRapier(IdUtil.getNextItemID(), bronzeMat, 7.0F, "bronze_rapier");
                event.register(MOD_NAMESPACE, RES_PREFIX + "rapier/bronze_rapier", "bronze_rapier", rapier);
                bronze_rapier = rapier;

                ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), bronzeMat, "bronze_paxel");
                event.register(MOD_NAMESPACE, RES_PREFIX + "paxel/bronze_paxel", "bronze_paxel", paxel);
                bronze_paxel = paxel;
            }

            Material steelMat = com.moddedmite.mitemod.MoreMetals.material.Materials.steel;

            {
                UCDamageUtils.registerMaterialLevel(steelMat, 3.0F);

                ItemSaber saber = new ItemSaber(IdUtil.getNextItemID(), steelMat, 9.0F, "steel_saber");
                event.register(MOD_NAMESPACE, RES_PREFIX + "saber/steel_saber", "steel_saber", saber);
                steel_saber = saber;

                ItemRapier rapier = new ItemRapier(IdUtil.getNextItemID(), steelMat, 9.0F, "steel_rapier");
                event.register(MOD_NAMESPACE, RES_PREFIX + "rapier/steel_rapier", "steel_rapier", rapier);
                steel_rapier = rapier;

                ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), steelMat, "steel_paxel");
                event.register(MOD_NAMESPACE, RES_PREFIX + "paxel/steel_paxel", "steel_paxel", paxel);
                steel_paxel = paxel;
            }

            Material titanium_alloyMat = com.moddedmite.mitemod.MoreMetals.material.Materials.titanium_alloy;

            {
                UCDamageUtils.registerMaterialLevel(titanium_alloyMat, 4.0F);

                ItemSaber saber = new ItemSaber(IdUtil.getNextItemID(), titanium_alloyMat, 10F, "titanium_alloy_saber");
                event.register(MOD_NAMESPACE, RES_PREFIX + "saber/titanium_alloy_saber", "titanium_alloy_saber", saber);
                titanium_alloy_saber = saber;

                ItemRapier rapier = new ItemRapier(IdUtil.getNextItemID(), titanium_alloyMat, 10F, "titanium_alloy_rapier");
                event.register(MOD_NAMESPACE, RES_PREFIX + "rapier/titanium_alloy_rapier", "titanium_alloy_rapier", rapier);
                titanium_alloy_rapier = rapier;

                ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), titanium_alloyMat, "titanium_alloy_paxel");
                event.register(MOD_NAMESPACE, RES_PREFIX + "paxel/titanium_alloy_paxel", "titanium_alloy_paxel", paxel);
                titanium_alloy_paxel = paxel;
            }

            Material rose_goldMat = com.moddedmite.mitemod.MoreMetals.material.Materials.rose_gold;

            {
                UCDamageUtils.registerMaterialLevel(rose_goldMat, 0.5F);

                ItemSaber saber = new ItemSaber(IdUtil.getNextItemID(), rose_goldMat, 6.5F, "rose_gold_saber");
                event.register(MOD_NAMESPACE, RES_PREFIX + "saber/rose_gold_saber", "rose_gold_saber", saber);
                rose_gold_saber = saber;

                ItemRapier rapier = new ItemRapier(IdUtil.getNextItemID(), rose_goldMat, 6.5F, "rose_gold_rapier");
                event.register(MOD_NAMESPACE, RES_PREFIX + "rapier/rose_gold_rapier", "rose_gold_rapier", rapier);
                rose_gold_rapier = rapier;

                ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), rose_goldMat, "rose_gold_paxel");
                event.register(MOD_NAMESPACE, RES_PREFIX + "paxel/rose_gold_paxel", "rose_gold_paxel", paxel);
                rose_gold_paxel = paxel;
            }

            Material platinumMat = com.moddedmite.mitemod.MoreMetals.material.Materials.platinum;

            {
                UCDamageUtils.registerMaterialLevel(platinumMat, 1.5F);

                ItemSaber saber = new ItemSaber(IdUtil.getNextItemID(), platinumMat, 7.5F, "platinum_saber");
                event.register(MOD_NAMESPACE, RES_PREFIX + "saber/platinum_saber", "platinum_saber", saber);
                platinum_saber = saber;

                ItemRapier rapier = new ItemRapier(IdUtil.getNextItemID(), platinumMat, 7.5F, "platinum_rapier");
                event.register(MOD_NAMESPACE, RES_PREFIX + "rapier/platinum_rapier", "platinum_rapier", rapier);
                platinum_rapier = rapier;

                ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), platinumMat, "platinum_paxel");
                event.register(MOD_NAMESPACE, RES_PREFIX + "paxel/platinum_paxel", "platinum_paxel", paxel);
                platinum_paxel = paxel;

            }

            Material midas_goldMat = com.moddedmite.mitemod.MoreMetals.material.Materials.midas_gold;

            {
                UCDamageUtils.registerMaterialLevel(midas_goldMat, 2.5F);

                ItemSaber saber = new ItemSaber(IdUtil.getNextItemID(), midas_goldMat, 8.5F, "midas_gold_saber");
                event.register(MOD_NAMESPACE, RES_PREFIX + "saber/midas_gold_saber", "midas_gold_saber", saber);
                midas_gold_saber = saber;

                ItemRapier rapier = new ItemRapier(IdUtil.getNextItemID(), midas_goldMat, 8.5F, "midas_gold_rapier");
                event.register(MOD_NAMESPACE, RES_PREFIX + "rapier/midas_gold_rapier", "midas_gold_rapier", rapier);
                midas_gold_rapier = rapier;

                ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), midas_goldMat, "midas_gold_paxel");
                event.register(MOD_NAMESPACE, RES_PREFIX + "paxel/midas_gold_paxel", "midas_gold_paxel", paxel);
                midas_gold_paxel = paxel;

            }

            Material adamantium_mmMat = com.moddedmite.mitemod.MoreMetals.material.Materials.adamantium_mm;

            {
                UCDamageUtils.registerMaterialLevel(adamantium_mmMat, 3F);

                ItemSaber saber = new ItemSaber(IdUtil.getNextItemID(), adamantium_mmMat, 9F, "adamantium_mm_saber");
                event.register(MOD_NAMESPACE, RES_PREFIX + "saber/adamantium_mm_saber", "adamantium_mm_saber", saber);
                adamium_mm_saber = saber;

                ItemRapier rapier = new ItemRapier(IdUtil.getNextItemID(), adamantium_mmMat, 9F, "adamantium_mm_rapier");
                event.register(MOD_NAMESPACE, RES_PREFIX + "rapier/adamantium_mm_rapier", "adamantium_mm_rapier", rapier);
                adamium_mm_rapier = rapier;

                ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), adamantium_mmMat, "adamantium_mm_paxel");
                event.register(MOD_NAMESPACE, RES_PREFIX + "paxel/adamantium_mm_paxel", "adamantium_mm_paxel", paxel);
                adamium_mm_paxel = paxel;

            }
        }
    }
}
