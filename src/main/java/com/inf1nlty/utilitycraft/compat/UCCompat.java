package com.inf1nlty.utilitycraft.compat;

import com.inf1nlty.utilitycraft.item.rapier.ItemRapier;
import com.inf1nlty.utilitycraft.item.saber.ItemSaber;
import com.inf1nlty.utilitycraft.item.paxel.ItemPaxel;
import com.inf1nlty.utilitycraft.util.UCDamageUtils;
import net.minecraft.Item;
import net.minecraft.Material;
import net.moddedmite.mitemod.bex.register.BEXMaterials;
import net.oilcake.mitelros.material.Materials;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public final class UCCompat {

    private UCCompat() {}

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

    // Paxels
    public static Item nickel_paxel;
    public static Item tungsten_paxel;
    public static Item uru_paxel;
    public static Item enchant_paxel;
    public static Item vibranium_paxel;

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

                ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), nickelMat);
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

                ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), tungstenMat);
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

            ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), uruMat);
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

            ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), enchantMat);
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

            ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), vibMat);
            event.register(MOD_NAMESPACE, RES_PREFIX + "paxel/vibranium_paxel", "vibranium_paxel", paxel);
            vibranium_paxel = paxel;
        }
    }
}