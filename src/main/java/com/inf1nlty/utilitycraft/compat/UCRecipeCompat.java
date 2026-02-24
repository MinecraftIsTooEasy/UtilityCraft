package com.inf1nlty.utilitycraft.compat;

import com.inf1nlty.utilitycraft.item.UCItems;

import net.minecraft.Item;
import net.minecraft.ItemStack;

import net.moddedmite.mitemod.bex.register.BEXItems;
import net.oilcake.mitelros.registry.item.Items;
import net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit;

import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;

public final class UCRecipeCompat {

    private UCRecipeCompat() {}

    public static void registerCompatRecipes(CraftingRecipeRegisterEvent event) {
        registerItfCompat(event);
        registerBexCompat(event);
        registerMiteiteCompat(event);
    }

    private static void registerItfCompat(CraftingRecipeRegisterEvent event) {

        if (!ModChecker.HAS_ITFRB) return;

        if (Items.uruIngot != null) {

            if (UCCompat.uru_paxel != null) {

                event.registerShapelessRecipe(new ItemStack(UCCompat.uru_paxel, 1), false, Items.forgingNote, Items.uruIngot, UCItems.mithril_paxel, Item.ingotMithril).extendsNBT().keepQuality();
            }

            if (UCCompat.uru_saber != null && UCItems.mithril_saber != null) {
                event.registerShapelessRecipe(new ItemStack(UCCompat.uru_saber, 1), false, Items.forgingNote, Items.uruIngot, UCItems.mithril_saber, Item.ingotMithril).extendsNBT().keepQuality();
            }

            if (UCCompat.uru_rapier != null && UCItems.mithril_rapier != null) {
                event.registerShapelessRecipe(new ItemStack(UCCompat.uru_rapier, 1), false, Items.forgingNote, Items.uruIngot, UCItems.mithril_rapier, Item.ingotMithril).extendsNBT().keepQuality();
            }
        }

        if (UCCompat.nickel_saber != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_saber, 1), false, " C ", " C ", "CK ", 'C', Items.nickelIngot, 'K', Item.stick);
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_saber, 1), false, " C ", " C ", "CK ", 'C', Items.nickelIngot, 'K', UCItems.copper_saber).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_saber, 1), false, " C ", " C ", "CK ", 'C', Items.nickelIngot, 'K', UCItems.silver_saber).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_saber, 1), false, " C ", " C ", "CK ", 'C', Items.nickelIngot, 'K', UCItems.golden_saber).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_saber, 1), false, " A ", " A ", "AK ", 'A', Item.ingotAncientMetal, 'K', UCCompat.nickel_saber).extendsNBT().keepQuality();
        }

        if (UCCompat.nickel_rapier != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_rapier, 1), false, "  C", "CC ", "KC ", 'C', Items.nickelIngot, 'K', Item.stick);
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_rapier, 1), false, "  C", "CC ", "KC ", 'C', Items.nickelIngot, 'K', UCItems.copper_rapier).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_rapier, 1), false, "  C", "CC ", "KC ", 'C', Items.nickelIngot, 'K', UCItems.silver_rapier).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_rapier, 1), false, "  C", "CC ", "KC ", 'C', Items.nickelIngot, 'K', UCItems.golden_rapier).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_rapier, 1), false, "  A", "AA ", "KA ", 'A', Item.ingotAncientMetal, 'K', UCCompat.nickel_rapier).extendsNBT().keepQuality();
        }

        if (UCCompat.nickel_paxel != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_paxel, 1), false, "ASP", " K ", " K ", 'A', Items.nickelAxe, 'S', Items.nickelShovel, 'P', Items.nickelPickaxe, 'K', Item.stick);
            event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_paxel, 1), false, "ASP", " K ", 'A', Item.axeAncientMetal, 'S', Item.shovelAncientMetal, 'P', Item.pickaxeAncientMetal, 'K', UCCompat.nickel_paxel).extendsNBT().keepQuality();

            if (Items.nickelAxe != null && Items.nickelShovel != null && Items.nickelPickaxe != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.nickel_paxel, 1), false, "ASP", " K ", "   ", 'A', Items.nickelAxe, 'S', Items.nickelShovel, 'P', Items.nickelPickaxe, 'K', UCItems.copper_paxel).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.nickel_paxel, 1), false, "ASP", " K ", "   ", 'A', Items.nickelAxe, 'S', Items.nickelShovel, 'P', Items.nickelPickaxe, 'K', UCItems.silver_paxel).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.nickel_paxel, 1), false, "ASP", " K ", "   ", 'A', Items.nickelAxe, 'S', Items.nickelShovel, 'P', Items.nickelPickaxe, 'K', UCItems.golden_paxel).extendsNBT().keepQuality();
            }
        }

        if (UCCompat.tungsten_saber != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_saber, 1), false, " C ", " C ", "CK ", 'C', Items.tungstenIngot, 'K', Item.stick);
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_saber, 1), false, " C ", " C ", "CK ", 'C', Items.tungstenIngot, 'K', UCItems.mithril_saber).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCItems.adamantium_saber, 1), false, " A ", " A ", "AK ", 'A', Item.ingotAdamantium, 'K', UCCompat.tungsten_saber).extendsNBT().keepQuality();
        }

        if (UCCompat.tungsten_rapier != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_rapier, 1), false, "  C", "CC ", "KC ", 'C', Items.tungstenIngot, 'K', Item.stick);
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_rapier, 1), false, "  C", "CC ", "KC ", 'C', Items.tungstenIngot, 'K', UCItems.mithril_rapier).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCItems.adamantium_rapier, 1), false, "  A", "AA ", "KA ", 'A', Item.ingotAdamantium, 'K', UCCompat.tungsten_rapier).extendsNBT().keepQuality();
        }

        if (UCCompat.tungsten_paxel != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_paxel, 1), false, "ASP", " K ", " K ", 'A', Items.tungstenAxe, 'S', Items.tungstenShovel, 'P', Items.tungstenPickaxe, 'K', Item.stick);
            event.registerShapedRecipe(new ItemStack(UCItems.adamantium_paxel, 1), false, "ASP", " K ", "   ", 'A', Item.axeAdamantium, 'S', Item.shovelAdamantium, 'P', Item.pickaxeAdamantium, 'K', UCCompat.tungsten_paxel).extendsNBT().keepQuality();

            if (Items.tungstenAxe != null && Items.tungstenShovel != null && Items.tungstenPickaxe != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_paxel, 1), false, "ASP", " K ", "   ", 'A', Items.tungstenAxe, 'S', Items.tungstenShovel, 'P', Items.tungstenPickaxe, 'K', UCItems.mithril_paxel).extendsNBT().keepQuality();
            }
        }
    }

    private static void registerBexCompat(CraftingRecipeRegisterEvent event) {

        if (!ModChecker.HAS_BEX) return;

        if (BEXItems.enchantIngot != null) {

            if (UCCompat.enchant_saber != null) {

                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_saber, 1), false, " C ", " C ", "CK ", 'C', BEXItems.enchantIngot, 'K', MITEITEItemRegistryInit.OBSIDIAN_STICK != null ? MITEITEItemRegistryInit.OBSIDIAN_STICK : Item.stick);
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_saber, 1), false, " C ", " C ", "CK ", 'C', BEXItems.enchantIngot, 'K', UCItems.mithril_saber).extendsNBT().keepQuality();
            }

            if (UCCompat.enchant_rapier != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_rapier, 1), false, "  C", "CC ", "KC ", 'C', BEXItems.enchantIngot, 'K', MITEITEItemRegistryInit.OBSIDIAN_STICK != null ? MITEITEItemRegistryInit.OBSIDIAN_STICK : Item.stick);
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_rapier, 1), false, "  C", "CC ", "KC ", 'C', BEXItems.enchantIngot, 'K', UCItems.mithril_rapier).extendsNBT().keepQuality();
            }

            if (UCCompat.enchant_paxel != null && BEXItems.enchantPickaxe != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_paxel, 1), false, "IIP", "II ", " K ", 'I', BEXItems.enchantIngot, 'P', BEXItems.enchantPickaxe, 'K', MITEITEItemRegistryInit.OBSIDIAN_STICK != null ? MITEITEItemRegistryInit.OBSIDIAN_STICK : Item.stick);
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_paxel, 1), false, "III", "IAP", "   ", 'A', UCItems.mithril_paxel, 'I', BEXItems.enchantIngot, 'P', BEXItems.enchantPickaxe).extendsNBT().keepQuality();
            }
        }
    }

    private static void registerMiteiteCompat(CraftingRecipeRegisterEvent event) {

        if (!ModChecker.HAS_ITE) return;

        if (MITEITEItemRegistryInit.VIBRANIUM_INGOT != null) {

            if (UCCompat.vibranium_saber != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_saber, 1), false, " C ", " C ", "CH ", 'C', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'H', Item.swordAncientMetal).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_saber, 1), false, " C ", " C ", "CH ", 'C', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'H', UCItems.ancient_metal_saber).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_saber, 1), false, " C ", " C ", "CH ", 'C', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'H', UCItems.adamantium_saber).extendsNBT().keepQuality();
            }

            if (UCCompat.vibranium_rapier != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_rapier, 1), false, "  C", "CC ", "HC ", 'C', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'H', Item.swordAncientMetal).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_rapier, 1), false, "  C", "CC ", "HC ", 'C', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'H', UCItems.ancient_metal_rapier).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_rapier, 1), false, "  C", "CC ", "HC ", 'C', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'H', UCItems.adamantium_rapier).extendsNBT().keepQuality();
            }

            if (UCCompat.vibranium_paxel != null && MITEITEItemRegistryInit.VIBRANIUM_AXE != null && MITEITEItemRegistryInit.VIBRANIUM_SHOVEL != null && MITEITEItemRegistryInit.VIBRANIUM_PICKAXE != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_paxel, 1), false, "ASP", " K ", " K ", 'A', MITEITEItemRegistryInit.VIBRANIUM_AXE, 'S', MITEITEItemRegistryInit.VIBRANIUM_SHOVEL, 'P', MITEITEItemRegistryInit.VIBRANIUM_PICKAXE, 'K', MITEITEItemRegistryInit.OBSIDIAN_STICK != null ? MITEITEItemRegistryInit.OBSIDIAN_STICK : Item.stick).extendsNBT().keepQuality();

                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_paxel, 1), false, "ASP", " K ", "   ", 'A', MITEITEItemRegistryInit.VIBRANIUM_AXE, 'S', MITEITEItemRegistryInit.VIBRANIUM_SHOVEL, 'P', MITEITEItemRegistryInit.VIBRANIUM_PICKAXE, 'K', UCItems.ancient_metal_paxel).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_paxel, 1), false, "ASP", " K ", "   ", 'A', MITEITEItemRegistryInit.VIBRANIUM_AXE, 'S', MITEITEItemRegistryInit.VIBRANIUM_SHOVEL, 'P', MITEITEItemRegistryInit.VIBRANIUM_PICKAXE, 'K', UCItems.adamantium_paxel).extendsNBT().keepQuality();
            }
        }
    }
}