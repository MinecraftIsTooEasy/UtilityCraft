package com.inf1nlty.utilitycraft.item;

import com.inf1nlty.utilitycraft.item.rapier.ItemRapier;
import com.inf1nlty.utilitycraft.item.saber.ItemSaber;
import net.minecraft.Item;
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

    public static void registerItems(ItemRegistryEvent event) {

        obsidian_boat = new ItemObsidianBoat(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:obsidian_boat", "obsidian_boat", obsidian_boat);


        copper_saber = ItemSaber.createCopper(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:copper_saber", "copper_saber", copper_saber);

        silver_saber = ItemSaber.createSilver(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:silver_saber", "silver_saber", silver_saber);

        golden_saber = ItemSaber.createGolden(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:golden_saber", "golden_saber", golden_saber);

        iron_saber = ItemSaber.createIron(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:iron_saber", "iron_saber", iron_saber);

        ancient_metal_saber = ItemSaber.createAncientMetal(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:ancient_metal_saber", "ancient_metal_saber", ancient_metal_saber);

        mithril_saber = ItemSaber.createMithril(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:mithril_saber", "mithril_saber", mithril_saber);

        adamantium_saber = ItemSaber.createAdamantium(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:adamantium_saber", "adamantium_saber", adamantium_saber);


        copper_rapier = ItemRapier.createCopper(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:copper_rapier", "copper_rapier", copper_rapier);

        silver_rapier = ItemRapier.createSilver(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:silver_rapier", "silver_rapier", silver_rapier);

        golden_rapier = ItemRapier.createGolden(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:golden_rapier", "golden_rapier", golden_rapier);

        iron_rapier = ItemRapier.createIron(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:iron_rapier", "iron_rapier", iron_rapier);

        ancient_metal_rapier = ItemRapier.createAncientMetal(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:ancient_metal_rapier", "ancient_metal_rapier", ancient_metal_rapier);

        mithril_rapier = ItemRapier.createMithril(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:mithril_rapier", "mithril_rapier", mithril_rapier);

        adamantium_rapier = ItemRapier.createAdamantium(IdUtil.getNextItemID());
        event.register("UtilityCraft", "utilitycraft:adamantium_rapier", "adamantium_rapier", adamantium_rapier);
    }
}
