package com.inf1nlty.utilitycraft.init;

import com.inf1nlty.utilitycraft.block.UCBlocks;
import com.inf1nlty.utilitycraft.compat.UCRecipeCompat;
import com.inf1nlty.utilitycraft.item.UCItems;

import net.minecraft.Block;
import net.minecraft.Item;
import net.minecraft.ItemStack;

import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;

import java.util.function.Consumer;

public class UCRecipes implements Consumer<CraftingRecipeRegisterEvent> {

    @Override
    public void accept(CraftingRecipeRegisterEvent event) {
        addCraftingRecipes(event);
        UCRecipeCompat.registerCompatRecipes(event);
    }

    private static void addCraftingRecipes(CraftingRecipeRegisterEvent event) {

        event.registerShapedRecipe(new ItemStack(UCBlocks.chestCopper, 1), true, "AAA", "ACA", "AAA", 'A', Item.ingotCopper, 'C', Block.chest);
        event.registerShapedRecipe(new ItemStack(UCBlocks.chestSilver, 1), true, "AAA", "ACA", "AAA", 'A', Item.ingotSilver, 'C', Block.chest);
        event.registerShapedRecipe(new ItemStack(UCBlocks.chestGold, 1), true, "AAA", "ACA", "AAA", 'A', Item.ingotGold, 'C', Block.chest);
        event.registerShapedRecipe(new ItemStack(UCBlocks.chestIron, 1), true, "AAA", "ACA", "AAA", 'A', Item.ingotIron, 'C', Block.chest);
        event.registerShapedRecipe(new ItemStack(UCBlocks.chestAncientMetal, 1), true, "AAA", "ACA", "AAA", 'A', Item.ingotAncientMetal, 'C', Block.chest);
        event.registerShapedRecipe(new ItemStack(UCBlocks.chestMithril, 1), true, "AAA", "ACA", "AAA", 'A', Item.ingotMithril, 'C', Block.chest);
        event.registerShapedRecipe(new ItemStack(UCBlocks.chestAdamantium, 1), true, "AAA", "ACA", "AAA", 'A', Item.ingotAdamantium, 'C', Block.chest);

        event.registerShapedRecipe(new ItemStack(UCItems.obsidian_boat, 1), true, "   ", "OMO", "OOO", 'O', Block.obsidian, 'M', Item.magmaCream);

        event.registerShapedRecipe(new ItemStack(UCItems.copper_saber, 1), true, " C ", " C ", "CK ", 'C', Item.ingotCopper, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.silver_saber, 1), true, " S ", " S ", "SK ", 'S', Item.ingotSilver, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.golden_saber, 1), true, " G ", " G ", "GK ", 'G', Item.ingotGold, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.iron_saber, 1), true, " I ", " I ", "IK ", 'I', Item.ingotIron, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_saber, 1), true, " A ", " A ", "AK ", 'A', Item.ingotAncientMetal, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_saber, 1), true, " M ", " M ", "MK ", 'M', Item.ingotMithril, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_saber, 1), true, " A ", " A ", "AK ", 'A', Item.ingotAdamantium, 'K', Item.stick);

        event.registerShapedRecipe(new ItemStack(UCItems.copper_rapier, 1), true, "  C", "CC ", "KC ", 'C', Item.ingotCopper, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.silver_rapier, 1), true, "  S", "SS ", "KS ", 'S', Item.ingotSilver, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.golden_rapier, 1), true, "  G", "GG ", "KG ", 'G', Item.ingotGold, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.iron_rapier, 1), true, "  I", "II ", "KI ", 'I', Item.ingotIron, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_rapier, 1), true, "  A", "AA ", "KA ", 'A', Item.ingotAncientMetal, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_rapier, 1), true, "  M", "MM ", "KM ", 'M', Item.ingotMithril, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_rapier, 1), true, "  A", "AA ", "KA ", 'A', Item.ingotAdamantium, 'K', Item.stick);

        event.registerShapedRecipe(new ItemStack(UCItems.copper_mace, 1), true, "CCC", "CBC", " K ", 'C', Item.ingotCopper, 'B', Block.blockCopper, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.silver_mace, 1), true, "SSS", "SBS", " K ", 'S', Item.ingotSilver, 'B', Block.blockSilver, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.golden_mace, 1), true, "GGG", "GBG", " K ", 'G', Item.ingotGold, 'B', Block.blockGold, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.iron_mace, 1), true, "III", "IBI", " K ", 'I', Item.ingotIron, 'B', Block.blockIron, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_mace, 1), true, "AAA", "ABA", " K ", 'A', Item.ingotAncientMetal, 'B', Block.blockAncientMetal, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_mace, 1), true, "MMM", "MBM", " K ", 'M', Item.ingotMithril, 'B', Block.blockMithril, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_mace, 1), true, "AAA", "ABA", " K ", 'A', Item.ingotAdamantium, 'B', Block.blockAdamantium, 'K', Item.stick);

        event.registerShapedRecipe(new ItemStack(UCItems.copper_heavy_helmet, 1), true, "ABA", "A A", 'A', Item.ingotCopper, 'B', Block.blockCopper);
        event.registerShapedRecipe(new ItemStack(UCItems.copper_heavy_chestplate, 1), true, "A A", "ABA", "AAA", 'A', Item.ingotCopper, 'B', Block.blockCopper);
        event.registerShapedRecipe(new ItemStack(UCItems.copper_heavy_leggings, 1), true, "ABA", "A A", "A A", 'A', Item.ingotCopper, 'B', Block.blockCopper);
        event.registerShapedRecipe(new ItemStack(UCItems.copper_heavy_boots, 1), true, "A A", " B ", "A A", 'A', Item.ingotCopper, 'B', Block.blockCopper);

        event.registerShapedRecipe(new ItemStack(UCItems.silver_heavy_helmet, 1), true, "ABA", "A A", 'A', Item.ingotSilver, 'B', Block.blockSilver);
        event.registerShapedRecipe(new ItemStack(UCItems.silver_heavy_chestplate, 1), true, "A A", "ABA", "AAA", 'A', Item.ingotSilver, 'B', Block.blockSilver);
        event.registerShapedRecipe(new ItemStack(UCItems.silver_heavy_leggings, 1), true, "ABA", "A A", "A A", 'A', Item.ingotSilver, 'B', Block.blockSilver);
        event.registerShapedRecipe(new ItemStack(UCItems.silver_heavy_boots, 1), true, "A A", " B ", "A A", 'A', Item.ingotSilver, 'B', Block.blockSilver);

        event.registerShapedRecipe(new ItemStack(UCItems.golden_heavy_helmet, 1), true, "ABA", "A A", 'A', Item.ingotGold, 'B', Block.blockGold);
        event.registerShapedRecipe(new ItemStack(UCItems.golden_heavy_chestplate, 1), true, "A A", "ABA", "AAA", 'A', Item.ingotGold, 'B', Block.blockGold);
        event.registerShapedRecipe(new ItemStack(UCItems.golden_heavy_leggings, 1), true, "ABA", "A A", "A A", 'A', Item.ingotGold, 'B', Block.blockGold);
        event.registerShapedRecipe(new ItemStack(UCItems.golden_heavy_boots, 1), true, "A A", " B ", "A A", 'A', Item.ingotGold, 'B', Block.blockGold);

        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_helmet, 1), true, "ABA", "A A", 'A', Item.ingotIron, 'B', Block.blockIron);
        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_chestplate, 1), true, "A A", "ABA", "AAA", 'A', Item.ingotIron, 'B', Block.blockIron);
        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_leggings, 1), true, "ABA", "A A", "A A", 'A', Item.ingotIron, 'B', Block.blockIron);
        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_boots, 1), true, "A A", " B ", "A A", 'A', Item.ingotIron, 'B', Block.blockIron);

        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_heavy_helmet, 1), true, "ABA", "A A", 'A', Item.ingotAncientMetal, 'B', Block.blockAncientMetal);
        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_heavy_chestplate, 1), true, "A A", "ABA", "AAA", 'A', Item.ingotAncientMetal, 'B', Block.blockAncientMetal);
        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_heavy_leggings, 1), true, "ABA", "A A", "A A", 'A', Item.ingotAncientMetal, 'B', Block.blockAncientMetal);
        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_heavy_boots, 1), true, "A A", " B ", "A A", 'A', Item.ingotAncientMetal, 'B', Block.blockAncientMetal);

        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_helmet, 1), true, "AHA", "A A", 'A', Item.ingotIron, 'H', UCItems.copper_heavy_helmet).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_chestplate, 1), true, "A A", "ACA", "AAA", 'A', Item.ingotIron, 'C', UCItems.copper_heavy_chestplate).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_leggings, 1), true, "ALA", "A A", "A A", 'A', Item.ingotIron, 'L', UCItems.copper_heavy_leggings).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_boots, 1), true, "A A", " B ", "A A", 'A', Item.ingotIron, 'B', UCItems.copper_heavy_boots).extendsNBT().keepQuality();

        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_helmet, 1), true, "AHA", "A A", 'A', Item.ingotIron, 'H', UCItems.silver_heavy_helmet).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_chestplate, 1), true, "A A", "ACA", "AAA", 'A', Item.ingotIron, 'C', UCItems.silver_heavy_chestplate).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_leggings, 1), true, "ALA", "A A", "A A", 'A', Item.ingotIron, 'L', UCItems.silver_heavy_leggings).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_boots, 1), true, "A A", " B ", "A A", 'A', Item.ingotIron, 'B', UCItems.silver_heavy_boots).extendsNBT().keepQuality();

        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_helmet, 1), true, "AHA", "A A", 'A', Item.ingotIron, 'H', UCItems.golden_heavy_helmet).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_chestplate, 1), true, "A A", "ACA", "AAA", 'A', Item.ingotIron, 'C', UCItems.golden_heavy_chestplate).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_leggings, 1), true, "ALA", "A A", "A A", 'A', Item.ingotIron, 'L', UCItems.golden_heavy_leggings).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_heavy_boots, 1), true, "A A", " B ", "A A", 'A', Item.ingotIron, 'B', UCItems.golden_heavy_boots).extendsNBT().keepQuality();

        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_heavy_helmet, 1), true, "AHA", "A A", 'A', Item.ingotAncientMetal, 'H', UCItems.iron_heavy_helmet).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_heavy_chestplate, 1),    true, "A A", "ACA", "AAA", 'A', Item.ingotAncientMetal, 'C', UCItems.iron_heavy_chestplate).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_heavy_leggings, 1), true, "ALA", "A A", "A A", 'A', Item.ingotAncientMetal, 'L', UCItems.iron_heavy_leggings).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_heavy_boots, 1), true, "A A", " B ", "A A", 'A', Item.ingotAncientMetal, 'B', UCItems.iron_heavy_boots).extendsNBT().keepQuality();

        event.registerShapedRecipe(new ItemStack(UCItems.mithril_heavy_helmet, 1), true, "AHA", "A A", 'A', Item.ingotMithril, 'H', UCItems.ancient_metal_heavy_helmet).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_heavy_chestplate, 1), true, "A A", "ACA", "AAA", 'A', Item.ingotMithril, 'C', UCItems.ancient_metal_heavy_chestplate).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_heavy_leggings, 1), true, "ALA", "A A", "A A", 'A', Item.ingotMithril, 'L', UCItems.ancient_metal_heavy_leggings).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_heavy_boots, 1), true, "A A", " B ", "A A", 'A', Item.ingotMithril, 'B', UCItems.ancient_metal_heavy_boots).extendsNBT().keepQuality();

        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_heavy_helmet, 1), true, "AHA", "A A", 'A', Item.ingotAdamantium, 'H', UCItems.mithril_heavy_helmet).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_heavy_chestplate, 1), true, "A A", "ACA", "AAA", 'A', Item.ingotAdamantium, 'C', UCItems.mithril_heavy_chestplate).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_heavy_leggings, 1), true, "ALA", "A A", "A A", 'A', Item.ingotAdamantium, 'L', UCItems.mithril_heavy_leggings).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_heavy_boots, 1), true, "A A", " B ", "A A", 'A', Item.ingotAdamantium, 'B', UCItems.mithril_heavy_boots).extendsNBT().keepQuality();

        event.registerShapedRecipe(new ItemStack(UCItems.copper_paxel, 1), true, "ASP", " K ", " K ", 'A', Item.axeCopper, 'S', Item.shovelCopper, 'P', Item.pickaxeCopper, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.silver_paxel, 1), true, "ASP", " K ", " K ", 'A', Item.axeSilver, 'S', Item.shovelSilver, 'P', Item.pickaxeSilver, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.golden_paxel, 1), true, "ASP", " K ", " K ", 'A', Item.axeGold, 'S', Item.shovelGold, 'P', Item.pickaxeGold, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.iron_paxel, 1), true, "ASP", " K ", " K ", 'A', Item.axeIron, 'S', Item.shovelIron, 'P', Item.pickaxeIron, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_paxel, 1), true, "ASP", " K ", " K ", 'A', Item.axeAncientMetal, 'S', Item.shovelAncientMetal, 'P', Item.pickaxeAncientMetal, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_paxel, 1), true, "ASP", " K ", " K ", 'A', Item.axeMithril, 'S', Item.shovelMithril, 'P', Item.pickaxeMithril, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_paxel, 1), true, "ASP", " K ", " K ", 'A', Item.axeAdamantium, 'S', Item.shovelAdamantium, 'P', Item.pickaxeAdamantium, 'K', Item.stick);

        // Saber upgrade recipes
        event.registerShapedRecipe(new ItemStack(UCItems.iron_saber, 1), true, " I ", " I ", "IK ", 'I', Item.ingotIron, 'K', UCItems.copper_saber).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_saber, 1), true, " I ", " I ", "IK ", 'I', Item.ingotIron, 'K', UCItems.silver_saber).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_saber, 1), true, " I ", " I ", "IK ", 'I', Item.ingotIron, 'K', UCItems.golden_saber).extendsNBT().keepQuality();

        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_saber, 1), true, " A ", " A ", "AK ", 'A', Item.ingotAncientMetal, 'K', UCItems.iron_saber).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_saber, 1), true, " M ", " M ", "MK ", 'M', Item.ingotMithril, 'K', UCItems.ancient_metal_saber).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_saber, 1), true, " A ", " A ", "AK ", 'A', Item.ingotAdamantium, 'K', UCItems.mithril_saber).extendsNBT().keepQuality();

        // Rapier upgrade recipes
        event.registerShapedRecipe(new ItemStack(UCItems.iron_rapier, 1), true, "  I", "II ", "KI ", 'I', Item.ingotIron, 'K', UCItems.copper_rapier).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_rapier, 1), true, "  I", "II ", "KI ", 'I', Item.ingotIron, 'K', UCItems.silver_rapier).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_rapier, 1), true, "  I", "II ", "KI ", 'I', Item.ingotIron, 'K', UCItems.golden_rapier).extendsNBT().keepQuality();

        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_rapier, 1), true, "  A", "AA ", "KA ", 'A', Item.ingotAncientMetal, 'K', UCItems.iron_rapier).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_rapier, 1), true, "  M", "MM ", "KM ", 'M', Item.ingotMithril, 'K', UCItems.ancient_metal_rapier).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_rapier, 1), true, "  A", "AA ", "KA ", 'A', Item.ingotAdamantium, 'K', UCItems.mithril_rapier).extendsNBT().keepQuality();

        // Mace upgrade recipes
        event.registerShapedRecipe(new ItemStack(UCItems.iron_mace, 1), true, "III", "IBI", " K ", 'I', Item.ingotIron, 'B', Block.blockIron, 'K', UCItems.copper_mace).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_mace, 1), true, "III", "IBI", " K ", 'I', Item.ingotIron, 'B', Block.blockIron, 'K', UCItems.silver_mace).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_mace, 1), true, "III", "IBI", " K ", 'I', Item.ingotIron, 'B', Block.blockIron, 'K', UCItems.golden_mace).extendsNBT().keepQuality();

        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_mace, 1), true, "AAA", "ABA", " K ", 'A', Item.ingotAncientMetal, 'B', Block.blockAncientMetal, 'K', UCItems.iron_mace).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_mace, 1), true, "MMM", "MBM", " K ", 'M', Item.ingotMithril, 'B', Block.blockMithril, 'K', UCItems.ancient_metal_mace).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_mace, 1), true, "AAA", "ABA", " K ", 'A', Item.ingotAdamantium, 'B', Block.blockAdamantium, 'K', UCItems.mithril_mace).extendsNBT().keepQuality();

        // Paxel upgrade recipes
        event.registerShapedRecipe(new ItemStack(UCItems.iron_paxel, 1), true, "ASP", " K ", "   ", 'A', Item.axeIron, 'S', Item.shovelIron, 'P', Item.pickaxeIron, 'K', UCItems.copper_paxel).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_paxel, 1), true, "ASP", " K ", "   ", 'A', Item.axeIron, 'S', Item.shovelIron, 'P', Item.pickaxeIron, 'K', UCItems.silver_paxel).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_paxel, 1), true, "ASP", " K ", "   ", 'A', Item.axeIron, 'S', Item.shovelIron, 'P', Item.pickaxeIron, 'K', UCItems.golden_paxel).extendsNBT().keepQuality();

        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_paxel, 1), true, "ASP", " K ", "   ", 'A', Item.axeAncientMetal, 'S', Item.shovelAncientMetal, 'P', Item.pickaxeAncientMetal, 'K', UCItems.iron_paxel).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_paxel, 1), true, "ASP", " K ", "   ", 'A', Item.axeMithril, 'S', Item.shovelMithril, 'P', Item.pickaxeMithril, 'K', UCItems.ancient_metal_paxel).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_paxel, 1), true, "ASP", " K ", "   ", 'A', Item.axeAdamantium, 'S', Item.shovelAdamantium, 'P', Item.pickaxeAdamantium, 'K', UCItems.mithril_paxel).extendsNBT().keepQuality();
    }
}
