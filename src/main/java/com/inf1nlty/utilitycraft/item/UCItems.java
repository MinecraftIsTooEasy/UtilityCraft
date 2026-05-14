package com.inf1nlty.utilitycraft.item;

import com.inf1nlty.utilitycraft.compat.UCCompat;
import com.inf1nlty.utilitycraft.item.armor.ItemHeavyBoots;
import com.inf1nlty.utilitycraft.item.armor.ItemHeavyCuirass;
import com.inf1nlty.utilitycraft.item.armor.ItemHeavyHelmet;
import com.inf1nlty.utilitycraft.item.armor.ItemHeavyLeggings;
import com.inf1nlty.utilitycraft.item.mace.ItemMace;
import com.inf1nlty.utilitycraft.item.paxel.ItemPaxel;
import com.inf1nlty.utilitycraft.item.rapier.ItemRapier;
import com.inf1nlty.utilitycraft.item.saber.ItemSaber;

import net.minecraft.Item;
import net.minecraft.Material;

import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class UCItems {

    public static Item obsidian_boat;

    public static ItemSaber copper_saber;
    public static ItemSaber silver_saber;
    public static ItemSaber golden_saber;
    public static ItemSaber iron_saber;
    public static ItemSaber ancient_metal_saber;
    public static ItemSaber mithril_saber;
    public static ItemSaber adamantium_saber;

    public static ItemRapier copper_rapier;
    public static ItemRapier silver_rapier;
    public static ItemRapier golden_rapier;
    public static ItemRapier iron_rapier;
    public static ItemRapier ancient_metal_rapier;
    public static ItemRapier mithril_rapier;
    public static ItemRapier adamantium_rapier;

    public static ItemMace copper_mace;
    public static ItemMace silver_mace;
    public static ItemMace golden_mace;
    public static ItemMace iron_mace;
    public static ItemMace ancient_metal_mace;
    public static ItemMace mithril_mace;
    public static ItemMace adamantium_mace;

    public static ItemHeavyHelmet copper_heavy_helmet;
    public static ItemHeavyCuirass copper_heavy_chestplate;
    public static ItemHeavyLeggings copper_heavy_leggings;
    public static ItemHeavyBoots copper_heavy_boots;
    public static ItemHeavyHelmet silver_heavy_helmet;
    public static ItemHeavyCuirass silver_heavy_chestplate;
    public static ItemHeavyLeggings silver_heavy_leggings;
    public static ItemHeavyBoots silver_heavy_boots;
    public static ItemHeavyHelmet golden_heavy_helmet;
    public static ItemHeavyCuirass golden_heavy_chestplate;
    public static ItemHeavyLeggings golden_heavy_leggings;
    public static ItemHeavyBoots golden_heavy_boots;
    public static ItemHeavyHelmet iron_heavy_helmet;
    public static ItemHeavyCuirass iron_heavy_chestplate;
    public static ItemHeavyLeggings iron_heavy_leggings;
    public static ItemHeavyBoots iron_heavy_boots;
    public static ItemHeavyHelmet ancient_metal_heavy_helmet;
    public static ItemHeavyCuirass ancient_metal_heavy_chestplate;
    public static ItemHeavyLeggings ancient_metal_heavy_leggings;
    public static ItemHeavyBoots ancient_metal_heavy_boots;
    public static ItemHeavyHelmet mithril_heavy_helmet;
    public static ItemHeavyCuirass mithril_heavy_chestplate;
    public static ItemHeavyLeggings mithril_heavy_leggings;
    public static ItemHeavyBoots mithril_heavy_boots;
    public static ItemHeavyHelmet adamantium_heavy_helmet;
    public static ItemHeavyCuirass adamantium_heavy_chestplate;
    public static ItemHeavyLeggings adamantium_heavy_leggings;
    public static ItemHeavyBoots adamantium_heavy_boots;

    public static ItemPaxel copper_paxel;
    public static ItemPaxel silver_paxel;
    public static ItemPaxel golden_paxel;
    public static ItemPaxel iron_paxel;
    public static ItemPaxel ancient_metal_paxel;
    public static ItemPaxel mithril_paxel;
    public static ItemPaxel adamantium_paxel;

    private static final String MOD_DISPLAY_NAME = "UtilityCraft";
    private static final String MOD_NAMESPACE = "utilitycraft";
    private static final String RES_PREFIX = MOD_NAMESPACE + ":";

    public static void registerItems(ItemRegistryEvent event) {

        UCCompat.registerCompatItems(event);

        obsidian_boat = new ItemObsidianBoat(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "obsidian_boat", "obsidian_boat", obsidian_boat);


        copper_saber = ItemSaber.createCopper(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "saber/copper_saber", "copper_saber", copper_saber);

        silver_saber = ItemSaber.createSilver(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "saber/silver_saber", "silver_saber", silver_saber);

        golden_saber = ItemSaber.createGolden(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "saber/golden_saber", "golden_saber", golden_saber);

        iron_saber = ItemSaber.createIron(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "saber/iron_saber", "iron_saber", iron_saber);

        ancient_metal_saber = ItemSaber.createAncientMetal(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "saber/ancient_metal_saber", "ancient_metal_saber", ancient_metal_saber);

        mithril_saber = ItemSaber.createMithril(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "saber/mithril_saber", "mithril_saber", mithril_saber);

        adamantium_saber = ItemSaber.createAdamantium(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "saber/adamantium_saber", "adamantium_saber", adamantium_saber);


        copper_rapier = ItemRapier.createCopper(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "rapier/copper_rapier", "copper_rapier", copper_rapier);

        silver_rapier = ItemRapier.createSilver(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "rapier/silver_rapier", "silver_rapier", silver_rapier);

        golden_rapier = ItemRapier.createGolden(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "rapier/golden_rapier", "golden_rapier", golden_rapier);

        iron_rapier = ItemRapier.createIron(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "rapier/iron_rapier", "iron_rapier", iron_rapier);

        ancient_metal_rapier = ItemRapier.createAncientMetal(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "rapier/ancient_metal_rapier", "ancient_metal_rapier", ancient_metal_rapier);

        mithril_rapier = ItemRapier.createMithril(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "rapier/mithril_rapier", "mithril_rapier", mithril_rapier);

        adamantium_rapier = ItemRapier.createAdamantium(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "rapier/adamantium_rapier", "adamantium_rapier", adamantium_rapier);


        copper_mace = ItemMace.createCopper(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "mace/copper_mace", "copper_mace", copper_mace);

        silver_mace = ItemMace.createSilver(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "mace/silver_mace", "silver_mace", silver_mace);

        golden_mace = ItemMace.createGolden(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "mace/golden_mace", "golden_mace", golden_mace);

        iron_mace = ItemMace.createIron(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "mace/iron_mace", "iron_mace", iron_mace);

        ancient_metal_mace = ItemMace.createAncientMetal(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "mace/ancient_metal_mace", "ancient_metal_mace", ancient_metal_mace);

        mithril_mace = ItemMace.createMithril(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "mace/mithril_mace", "mithril_mace", mithril_mace);

        adamantium_mace = ItemMace.createAdamantium(IdUtil.getNextItemID());
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "mace/adamantium_mace", "adamantium_mace", adamantium_mace);

        registerHeavyArmor(event);

        Object[][] paxelSpecs = new Object[][] {
                {"copper_paxel",Material.copper},
                {"silver_paxel",Material.silver},
                {"golden_paxel",Material.gold},
                {"iron_paxel",Material.iron},
                {"ancient_metal_paxel",Material.ancient_metal},
                {"mithril_paxel",Material.mithril},
                {"adamantium_paxel",Material.adamantium}
        };

        for (Object[] spec : paxelSpecs) {
            String name = (String) spec[0];
            Material mat = (Material) spec[1];

            ItemPaxel paxel = new ItemPaxel(IdUtil.getNextItemID(), mat, name);

            event.register(MOD_DISPLAY_NAME, RES_PREFIX + "paxel/" + name, name, paxel);

            switch (name) {
                case "copper_paxel":        copper_paxel = paxel; break;
                case "silver_paxel":        silver_paxel = paxel; break;
                case "golden_paxel":        golden_paxel = paxel; break;
                case "iron_paxel":          iron_paxel = paxel; break;
                case "ancient_metal_paxel": ancient_metal_paxel = paxel; break;
                case "mithril_paxel":       mithril_paxel = paxel; break;
                case "adamantium_paxel":    adamantium_paxel = paxel; break;
            }
        }
    }

    private static void registerHeavyArmor(ItemRegistryEvent event) {
        copper_heavy_helmet = registerHeavyHelmet(event, Material.copper, "copper");
        copper_heavy_chestplate = registerHeavyCuirass(event, Material.copper, "copper");
        copper_heavy_leggings = registerHeavyLeggings(event, Material.copper, "copper");
        copper_heavy_boots = registerHeavyBoots(event, Material.copper, "copper");

        silver_heavy_helmet = registerHeavyHelmet(event, Material.silver, "silver");
        silver_heavy_chestplate = registerHeavyCuirass(event, Material.silver, "silver");
        silver_heavy_leggings = registerHeavyLeggings(event, Material.silver, "silver");
        silver_heavy_boots = registerHeavyBoots(event, Material.silver, "silver");

        golden_heavy_helmet = registerHeavyHelmet(event, Material.gold, "golden");
        golden_heavy_chestplate = registerHeavyCuirass(event, Material.gold, "golden");
        golden_heavy_leggings = registerHeavyLeggings(event, Material.gold, "golden");
        golden_heavy_boots = registerHeavyBoots(event, Material.gold, "golden");

        iron_heavy_helmet = registerHeavyHelmet(event, Material.iron, "iron");
        iron_heavy_chestplate = registerHeavyCuirass(event, Material.iron, "iron");
        iron_heavy_leggings = registerHeavyLeggings(event, Material.iron, "iron");
        iron_heavy_boots = registerHeavyBoots(event, Material.iron, "iron");

        ancient_metal_heavy_helmet = registerHeavyHelmet(event, Material.ancient_metal, "ancient_metal");
        ancient_metal_heavy_chestplate = registerHeavyCuirass(event, Material.ancient_metal, "ancient_metal");
        ancient_metal_heavy_leggings = registerHeavyLeggings(event, Material.ancient_metal, "ancient_metal");
        ancient_metal_heavy_boots = registerHeavyBoots(event, Material.ancient_metal, "ancient_metal");

        mithril_heavy_helmet = registerHeavyHelmet(event, Material.mithril, "mithril");
        mithril_heavy_chestplate = registerHeavyCuirass(event, Material.mithril, "mithril");
        mithril_heavy_leggings = registerHeavyLeggings(event, Material.mithril, "mithril");
        mithril_heavy_boots = registerHeavyBoots(event, Material.mithril, "mithril");

        adamantium_heavy_helmet = registerHeavyHelmet(event, Material.adamantium, "adamantium");
        adamantium_heavy_chestplate = registerHeavyCuirass(event, Material.adamantium, "adamantium");
        adamantium_heavy_leggings = registerHeavyLeggings(event, Material.adamantium, "adamantium");
        adamantium_heavy_boots = registerHeavyBoots(event, Material.adamantium, "adamantium");
    }

    private static ItemHeavyHelmet registerHeavyHelmet(ItemRegistryEvent event, Material material, String materialName) {
        String name = materialName + "_heavy_helmet";
        ItemHeavyHelmet item = new ItemHeavyHelmet(IdUtil.getNextItemID(), material, name, "heavy_armor/" + materialName + "_heavy");
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "heavy_armor/" + name, name, item);
        return item;
    }

    private static ItemHeavyCuirass registerHeavyCuirass(ItemRegistryEvent event, Material material, String materialName) {
        String name = materialName + "_heavy_chestplate";
        ItemHeavyCuirass item = new ItemHeavyCuirass(IdUtil.getNextItemID(), material, name, "heavy_armor/" + materialName + "_heavy");
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "heavy_armor/" + name, name, item);
        return item;
    }

    private static ItemHeavyLeggings registerHeavyLeggings(ItemRegistryEvent event, Material material, String materialName) {
        String name = materialName + "_heavy_leggings";
        ItemHeavyLeggings item = new ItemHeavyLeggings(IdUtil.getNextItemID(), material, name, "heavy_armor/" + materialName + "_heavy");
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "heavy_armor/" + name, name, item);
        return item;
    }

    private static ItemHeavyBoots registerHeavyBoots(ItemRegistryEvent event, Material material, String materialName) {
        String name = materialName + "_heavy_boots";
        ItemHeavyBoots item = new ItemHeavyBoots(IdUtil.getNextItemID(), material, name, "heavy_armor/" + materialName + "_heavy");
        event.register(MOD_DISPLAY_NAME, RES_PREFIX + "heavy_armor/" + name, name, item);
        return item;
    }
}
