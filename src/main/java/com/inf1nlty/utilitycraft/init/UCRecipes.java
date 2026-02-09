package com.inf1nlty.utilitycraft.init;

import com.inf1nlty.utilitycraft.compat.UCRecipeCompat;
import com.inf1nlty.utilitycraft.item.UCItems;
import net.minecraft.Block;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

public class UCRecipes {

    public static void registerRecipes(RecipeRegistryEvent event) {
        addCraftingRecipes(event);

        UCRecipeCompat.registerCompatRecipes(event);
    }

    private static void addCraftingRecipes(RecipeRegistryEvent event) {
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
    }
}