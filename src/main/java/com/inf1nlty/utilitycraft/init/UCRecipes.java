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

        event.registerShapedRecipe(new ItemStack(UCBlocks.chestCopper, 1), false, "AAA", "ACA", "AAA", 'A', Item.ingotCopper, 'C', Block.chest);
        event.registerShapedRecipe(new ItemStack(UCBlocks.chestSilver, 1), false, "AAA", "ACA", "AAA", 'A', Item.ingotSilver, 'C', Block.chest);
        event.registerShapedRecipe(new ItemStack(UCBlocks.chestGold, 1), false, "AAA", "ACA", "AAA", 'A', Item.ingotGold, 'C', Block.chest);
        event.registerShapedRecipe(new ItemStack(UCBlocks.chestIron, 1), false, "AAA", "ACA", "AAA", 'A', Item.ingotIron, 'C', Block.chest);
        event.registerShapedRecipe(new ItemStack(UCBlocks.chestAncientMetal, 1), false, "AAA", "ACA", "AAA", 'A', Item.ingotAncientMetal, 'C', Block.chest);
        event.registerShapedRecipe(new ItemStack(UCBlocks.chestMithril, 1), false, "AAA", "ACA", "AAA", 'A', Item.ingotMithril, 'C', Block.chest);
        event.registerShapedRecipe(new ItemStack(UCBlocks.chestAdamantium, 1), false, "AAA", "ACA", "AAA", 'A', Item.ingotAdamantium, 'C', Block.chest);

        event.registerShapedRecipe(new ItemStack(UCItems.obsidian_boat, 1), false, "   ", "OMO", "OOO", 'O', Block.obsidian, 'M', Item.magmaCream);

        event.registerShapedRecipe(new ItemStack(UCItems.copper_saber, 1), false, " C ", " C ", "CK ", 'C', Item.ingotCopper, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.silver_saber, 1), false, " S ", " S ", "SK ", 'S', Item.ingotSilver, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.golden_saber, 1), false, " G ", " G ", "GK ", 'G', Item.ingotGold, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.iron_saber, 1), false, " I ", " I ", "IK ", 'I', Item.ingotIron, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_saber, 1), false, " A ", " A ", "AK ", 'A', Item.ingotAncientMetal, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_saber, 1), false, " M ", " M ", "MK ", 'M', Item.ingotMithril, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_saber, 1), false, " A ", " A ", "AK ", 'A', Item.ingotAdamantium, 'K', Item.stick);

        event.registerShapedRecipe(new ItemStack(UCItems.copper_rapier, 1), false, "  C", "CC ", "KC ", 'C', Item.ingotCopper, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.silver_rapier, 1), false, "  S", "SS ", "KS ", 'S', Item.ingotSilver, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.golden_rapier, 1), false, "  G", "GG ", "KG ", 'G', Item.ingotGold, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.iron_rapier, 1), false, "  I", "II ", "KI ", 'I', Item.ingotIron, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_rapier, 1), false, "  A", "AA ", "KA ", 'A', Item.ingotAncientMetal, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_rapier, 1), false, "  M", "MM ", "KM ", 'M', Item.ingotMithril, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_rapier, 1), false, "  A", "AA ", "KA ", 'A', Item.ingotAdamantium, 'K', Item.stick);

        event.registerShapedRecipe(new ItemStack(UCItems.copper_paxel, 1), false, "ASP", " K ", " K ", 'A', Item.axeCopper, 'S', Item.shovelCopper, 'P', Item.pickaxeCopper, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.silver_paxel, 1), false, "ASP", " K ", " K ", 'A', Item.axeSilver, 'S', Item.shovelSilver, 'P', Item.pickaxeSilver, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.golden_paxel, 1), false, "ASP", " K ", " K ", 'A', Item.axeGold, 'S', Item.shovelGold, 'P', Item.pickaxeGold, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.iron_paxel, 1), false, "ASP", " K ", " K ", 'A', Item.axeIron, 'S', Item.shovelIron, 'P', Item.pickaxeIron, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_paxel, 1), false, "ASP", " K ", " K ", 'A', Item.axeAncientMetal, 'S', Item.shovelAncientMetal, 'P', Item.pickaxeAncientMetal, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_paxel, 1), false, "ASP", " K ", " K ", 'A', Item.axeMithril, 'S', Item.shovelMithril, 'P', Item.pickaxeMithril, 'K', Item.stick);
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_paxel, 1), false, "ASP", " K ", " K ", 'A', Item.axeAdamantium, 'S', Item.shovelAdamantium, 'P', Item.pickaxeAdamantium, 'K', Item.stick);

        // Saber upgrade recipes
        event.registerShapedRecipe(new ItemStack(UCItems.iron_saber, 1), false, " I ", " I ", "IK ", 'I', Item.ingotIron, 'K', UCItems.copper_saber).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_saber, 1), false, " I ", " I ", "IK ", 'I', Item.ingotIron, 'K', UCItems.silver_saber).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_saber, 1), false, " I ", " I ", "IK ", 'I', Item.ingotIron, 'K', UCItems.golden_saber).extendsNBT().keepQuality();

        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_saber, 1), false, " A ", " A ", "AK ", 'A', Item.ingotAncientMetal, 'K', UCItems.iron_saber).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_saber, 1), false, " M ", " M ", "MK ", 'M', Item.ingotMithril, 'K', UCItems.ancient_metal_saber).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_saber, 1), false, " A ", " A ", "AK ", 'A', Item.ingotAdamantium, 'K', UCItems.mithril_saber).extendsNBT().keepQuality();

        // Rapier upgrade recipes
        event.registerShapedRecipe(new ItemStack(UCItems.iron_rapier, 1), false, "  I", "II ", "KI ", 'I', Item.ingotIron, 'K', UCItems.copper_rapier).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_rapier, 1), false, "  I", "II ", "KI ", 'I', Item.ingotIron, 'K', UCItems.silver_rapier).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_rapier, 1), false, "  I", "II ", "KI ", 'I', Item.ingotIron, 'K', UCItems.golden_rapier).extendsNBT().keepQuality();

        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_rapier, 1), false, "  A", "AA ", "KA ", 'A', Item.ingotAncientMetal, 'K', UCItems.iron_rapier).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_rapier, 1), false, "  M", "MM ", "KM ", 'M', Item.ingotMithril, 'K', UCItems.ancient_metal_rapier).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_rapier, 1), false, "  A", "AA ", "KA ", 'A', Item.ingotAdamantium, 'K', UCItems.mithril_rapier).extendsNBT().keepQuality();

        // Paxel upgrade recipes
        event.registerShapedRecipe(new ItemStack(UCItems.iron_paxel, 1), false, "ASP", " K ", "   ", 'A', Item.axeIron, 'S', Item.shovelIron, 'P', Item.pickaxeIron, 'K', UCItems.copper_paxel).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_paxel, 1), false, "ASP", " K ", "   ", 'A', Item.axeIron, 'S', Item.shovelIron, 'P', Item.pickaxeIron, 'K', UCItems.silver_paxel).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.iron_paxel, 1), false, "ASP", " K ", "   ", 'A', Item.axeIron, 'S', Item.shovelIron, 'P', Item.pickaxeIron, 'K', UCItems.golden_paxel).extendsNBT().keepQuality();

        event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_paxel, 1), false, "ASP", " K ", "   ", 'A', Item.axeAncientMetal, 'S', Item.shovelAncientMetal, 'P', Item.pickaxeAncientMetal, 'K', UCItems.iron_paxel).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.mithril_paxel, 1), false, "ASP", " K ", "   ", 'A', Item.axeMithril, 'S', Item.shovelMithril, 'P', Item.pickaxeMithril, 'K', UCItems.ancient_metal_paxel).extendsNBT().keepQuality();
        event.registerShapedRecipe(new ItemStack(UCItems.adamantium_paxel, 1), false, "ASP", " K ", "   ", 'A', Item.axeAdamantium, 'S', Item.shovelAdamantium, 'P', Item.pickaxeAdamantium, 'K', UCItems.mithril_paxel).extendsNBT().keepQuality();
    }
}