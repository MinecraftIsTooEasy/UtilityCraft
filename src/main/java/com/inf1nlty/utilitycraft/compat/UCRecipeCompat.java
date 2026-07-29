package com.inf1nlty.utilitycraft.compat;

import com.inf1nlty.utilitycraft.item.UCItems;

import com.moddedmite.mitemod.MoreMetals.items.MMItems;
import net.minecraft.Item;
import net.minecraft.ItemStack;

import net.moddedmite.mitemod.bex.register.BEXItems;
import net.oilcake.mitelros.registry.item.Items;
import net.xiaoyu233.mitemod.miteite.block.MITEITEBlockRegistryInit;
import net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit;

import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;

public final class UCRecipeCompat {

    private UCRecipeCompat() {}

    public static void registerCompatRecipes(CraftingRecipeRegisterEvent event) {
        registerItfCompat(event);
        registerBexCompat(event);
        registerMiteiteCompat(event);
        registerMMCompat(event);
    }

    private static void registerItfCompat(CraftingRecipeRegisterEvent event) {

        if (!ModChecker.HAS_ITFRB) return;

        if (Items.uruIngot != null) {

            if (UCCompat.uru_paxel != null) {

                event.registerShapelessRecipe(new ItemStack(UCCompat.uru_paxel, 1), true, Items.forgingNote, Items.uruIngot, UCItems.mithril_paxel, Item.ingotMithril).extendsNBT().keepQuality();
            }

            if (UCCompat.uru_saber != null && UCItems.mithril_saber != null) {
                event.registerShapelessRecipe(new ItemStack(UCCompat.uru_saber, 1), true, Items.forgingNote, Items.uruIngot, UCItems.mithril_saber, Item.ingotMithril).extendsNBT().keepQuality();
            }

            if (UCCompat.uru_rapier != null && UCItems.mithril_rapier != null) {
                event.registerShapelessRecipe(new ItemStack(UCCompat.uru_rapier, 1), true, Items.forgingNote, Items.uruIngot, UCItems.mithril_rapier, Item.ingotMithril).extendsNBT().keepQuality();
            }

            if (UCCompat.uru_nunchaku != null && UCItems.mithril_nunchaku != null) {
                event.registerShapelessRecipe(new ItemStack(UCCompat.uru_nunchaku, 1), true, Items.forgingNote, Items.uruIngot, UCItems.mithril_nunchaku, Item.ingotMithril).extendsNBT().keepQuality();
            }
        }

        if (UCCompat.nickel_saber != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_saber, 1), true, " C ", " C ", "CK ", 'C', Items.nickelIngot, 'K', Item.stick);
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_saber, 1), true, " C ", " C ", "CK ", 'C', Items.nickelIngot, 'K', UCItems.copper_saber).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_saber, 1), true, " C ", " C ", "CK ", 'C', Items.nickelIngot, 'K', UCItems.silver_saber).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_saber, 1), true, " C ", " C ", "CK ", 'C', Items.nickelIngot, 'K', UCItems.golden_saber).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_saber, 1), true, " A ", " A ", "AK ", 'A', Item.ingotAncientMetal, 'K', UCCompat.nickel_saber).extendsNBT().keepQuality();
        }

        if (UCCompat.nickel_rapier != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_rapier, 1), true, "  C", "CC ", "KC ", 'C', Items.nickelIngot, 'K', Item.stick);
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_rapier, 1), true, "  C", "CC ", "KC ", 'C', Items.nickelIngot, 'K', UCItems.copper_rapier).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_rapier, 1), true, "  C", "CC ", "KC ", 'C', Items.nickelIngot, 'K', UCItems.silver_rapier).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_rapier, 1), true, "  C", "CC ", "KC ", 'C', Items.nickelIngot, 'K', UCItems.golden_rapier).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_rapier, 1), true, "  A", "AA ", "KA ", 'A', Item.ingotAncientMetal, 'K', UCCompat.nickel_rapier).extendsNBT().keepQuality();
        }

        if (UCCompat.nickel_nunchaku != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_nunchaku, 1), true, " S ", "N N", 'S', Item.silk, 'N', Items.nickelIngot);
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_nunchaku, 1), true, " S ", "NHN", 'S', Item.silk, 'N', Items.nickelIngot, 'H', UCItems.copper_nunchaku).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_nunchaku, 1), true, " S ", "NHN", 'S', Item.silk, 'N', Items.nickelIngot, 'H', UCItems.silver_nunchaku).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_nunchaku, 1), true, " S ", "NHN", 'S', Item.silk, 'N', Items.nickelIngot, 'H', UCItems.golden_nunchaku).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_nunchaku, 1), true, " S ", "AHA", 'S', Item.silk, 'A', Item.ingotAncientMetal, 'H', UCCompat.nickel_nunchaku).extendsNBT().keepQuality();
        }

        if (UCCompat.nickel_paxel != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_paxel, 1), true, "ASP", " K ", " K ", 'A', Items.nickelAxe, 'S', Items.nickelShovel, 'P', Items.nickelPickaxe, 'K', Item.stick);
            event.registerShapedRecipe(new ItemStack(UCItems.ancient_metal_paxel, 1), true, "ASP", " K ", 'A', Item.axeAncientMetal, 'S', Item.shovelAncientMetal, 'P', Item.pickaxeAncientMetal, 'K', UCCompat.nickel_paxel).extendsNBT().keepQuality();

            if (Items.nickelAxe != null && Items.nickelShovel != null && Items.nickelPickaxe != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.nickel_paxel, 1), true, "ASP", " K ", "   ", 'A', Items.nickelAxe, 'S', Items.nickelShovel, 'P', Items.nickelPickaxe, 'K', UCItems.copper_paxel).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.nickel_paxel, 1), true, "ASP", " K ", "   ", 'A', Items.nickelAxe, 'S', Items.nickelShovel, 'P', Items.nickelPickaxe, 'K', UCItems.silver_paxel).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.nickel_paxel, 1), true, "ASP", " K ", "   ", 'A', Items.nickelAxe, 'S', Items.nickelShovel, 'P', Items.nickelPickaxe, 'K', UCItems.golden_paxel).extendsNBT().keepQuality();
            }
        }

        if (UCCompat.tungsten_saber != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_saber, 1), true, " C ", " C ", "CK ", 'C', Items.tungstenIngot, 'K', Item.stick);
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_saber, 1), true, " C ", " C ", "CK ", 'C', Items.tungstenIngot, 'K', UCItems.mithril_saber).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCItems.adamantium_saber, 1), true, " A ", " A ", "AK ", 'A', Item.ingotAdamantium, 'K', UCCompat.tungsten_saber).extendsNBT().keepQuality();
        }

        if (UCCompat.tungsten_rapier != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_rapier, 1), true, "  C", "CC ", "KC ", 'C', Items.tungstenIngot, 'K', Item.stick);
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_rapier, 1), true, "  C", "CC ", "KC ", 'C', Items.tungstenIngot, 'K', UCItems.mithril_rapier).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCItems.adamantium_rapier, 1), true, "  A", "AA ", "KA ", 'A', Item.ingotAdamantium, 'K', UCCompat.tungsten_rapier).extendsNBT().keepQuality();
        }

        if (UCCompat.tungsten_nunchaku != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_nunchaku, 1), true, " S ", "T T", 'S', Item.silk, 'T', Items.tungstenIngot);
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_nunchaku, 1), true, " S ", "THT", 'S', Item.silk, 'T', Items.tungstenIngot, 'H', UCItems.mithril_nunchaku).extendsNBT().keepQuality();
            event.registerShapedRecipe(new ItemStack(UCItems.adamantium_nunchaku, 1), true, " S ", "AHA", 'S', Item.silk, 'A', Item.ingotAdamantium, 'H', UCCompat.tungsten_nunchaku).extendsNBT().keepQuality();
        }

        if (UCCompat.tungsten_paxel != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_paxel, 1), true, "ASP", " K ", " K ", 'A', Items.tungstenAxe, 'S', Items.tungstenShovel, 'P', Items.tungstenPickaxe, 'K', Item.stick);
            event.registerShapedRecipe(new ItemStack(UCItems.adamantium_paxel, 1), true, "ASP", " K ", "   ", 'A', Item.axeAdamantium, 'S', Item.shovelAdamantium, 'P', Item.pickaxeAdamantium, 'K', UCCompat.tungsten_paxel).extendsNBT().keepQuality();

            if (Items.tungstenAxe != null && Items.tungstenShovel != null && Items.tungstenPickaxe != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_paxel, 1), true, "ASP", " K ", "   ", 'A', Items.tungstenAxe, 'S', Items.tungstenShovel, 'P', Items.tungstenPickaxe, 'K', UCItems.mithril_paxel).extendsNBT().keepQuality();
            }
        }
    }

    private static void registerBexCompat(CraftingRecipeRegisterEvent event) {

        if (!ModChecker.HAS_BEX) return;

        if (BEXItems.enchantIngot != null) {

            if (UCCompat.enchant_saber != null) {

                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_saber, 1), true, " C ", " C ", "CK ", 'C', BEXItems.enchantIngot, 'K', MITEITEItemRegistryInit.OBSIDIAN_STICK != null ? MITEITEItemRegistryInit.OBSIDIAN_STICK : Item.stick);
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_saber, 1), true, " C ", " C ", "CK ", 'C', BEXItems.enchantIngot, 'K', UCItems.mithril_saber).extendsNBT().keepQuality();
            }

            if (UCCompat.enchant_rapier != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_rapier, 1), true, "  C", "CC ", "KC ", 'C', BEXItems.enchantIngot, 'K', MITEITEItemRegistryInit.OBSIDIAN_STICK != null ? MITEITEItemRegistryInit.OBSIDIAN_STICK : Item.stick);
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_rapier, 1), true, "  C", "CC ", "KC ", 'C', BEXItems.enchantIngot, 'K', UCItems.mithril_rapier).extendsNBT().keepQuality();
            }

            if (UCCompat.enchant_nunchaku != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_nunchaku, 1), true, " S ", "E E", 'S', Item.silk, 'E', BEXItems.enchantIngot);
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_nunchaku, 1), true, " S ", "EHE", 'S', Item.silk, 'E', BEXItems.enchantIngot, 'H', UCItems.mithril_nunchaku).extendsNBT().keepQuality();
            }

            if (UCCompat.enchant_paxel != null && BEXItems.enchantPickaxe != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_paxel, 1), true, "IIP", "II ", " K ", 'I', BEXItems.enchantIngot, 'P', BEXItems.enchantPickaxe, 'K', MITEITEItemRegistryInit.OBSIDIAN_STICK != null ? MITEITEItemRegistryInit.OBSIDIAN_STICK : Item.stick);
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_paxel, 1), true, "III", "IAP", "   ", 'A', UCItems.mithril_paxel, 'I', BEXItems.enchantIngot, 'P', BEXItems.enchantPickaxe).extendsNBT().keepQuality();
            }
        }
    }

    private static void registerMiteiteCompat(CraftingRecipeRegisterEvent event) {

        if (!ModChecker.HAS_ITE) return;

        if (MITEITEItemRegistryInit.VIBRANIUM_INGOT != null) {

            if (UCCompat.vibranium_saber != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_saber, 1), true, " C ", " C ", "CH ", 'C', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'H', Item.swordAncientMetal).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_saber, 1), true, " C ", " C ", "CH ", 'C', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'H', UCItems.ancient_metal_saber).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_saber, 1), true, " C ", " C ", "CH ", 'C', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'H', UCItems.adamantium_saber).extendsNBT().keepQuality();
            }

            if (UCCompat.vibranium_rapier != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_rapier, 1), true, "  C", "CC ", "HC ", 'C', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'H', Item.swordAncientMetal).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_rapier, 1), true, "  C", "CC ", "HC ", 'C', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'H', UCItems.ancient_metal_rapier).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_rapier, 1), true, "  C", "CC ", "HC ", 'C', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'H', UCItems.adamantium_rapier).extendsNBT().keepQuality();
            }

            if (UCCompat.vibranium_mace != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_mace, 1), true, "III", "IBI", " H ",
                        'I', MITEITEItemRegistryInit.VIBRANIUM_INGOT,
                        'B', MITEITEBlockRegistryInit.blockVibranium,
                        'H', UCItems.ancient_metal_mace).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_mace, 1), true, "III", "IBI", " H ",
                        'I', MITEITEItemRegistryInit.VIBRANIUM_INGOT,
                        'B', MITEITEBlockRegistryInit.blockVibranium,
                        'H', UCItems.adamantium_mace).extendsNBT().keepQuality();
            }

            if (UCCompat.vibranium_nunchaku != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_nunchaku, 1), true, " S ", "VHV",
                        'S', Item.silk,
                        'V', MITEITEItemRegistryInit.VIBRANIUM_INGOT,
                        'H', UCItems.ancient_metal_nunchaku).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_nunchaku, 1), true, " S ", "VHV",
                        'S', Item.silk,
                        'V', MITEITEItemRegistryInit.VIBRANIUM_INGOT,
                        'H', UCItems.adamantium_nunchaku).extendsNBT().keepQuality();
            }

            if (UCCompat.vibranium_paxel != null && MITEITEItemRegistryInit.VIBRANIUM_AXE != null && MITEITEItemRegistryInit.VIBRANIUM_SHOVEL != null && MITEITEItemRegistryInit.VIBRANIUM_PICKAXE != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_paxel, 1), true, "ASP", " K ", " K ", 'A', MITEITEItemRegistryInit.VIBRANIUM_AXE, 'S', MITEITEItemRegistryInit.VIBRANIUM_SHOVEL, 'P', MITEITEItemRegistryInit.VIBRANIUM_PICKAXE, 'K', MITEITEItemRegistryInit.OBSIDIAN_STICK != null ? MITEITEItemRegistryInit.OBSIDIAN_STICK : Item.stick).extendsNBT().keepQuality();

                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_paxel, 1), true, "ASP", " K ", "   ", 'A', MITEITEItemRegistryInit.VIBRANIUM_AXE, 'S', MITEITEItemRegistryInit.VIBRANIUM_SHOVEL, 'P', MITEITEItemRegistryInit.VIBRANIUM_PICKAXE, 'K', UCItems.ancient_metal_paxel).extendsNBT().keepQuality();
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_paxel, 1), true, "ASP", " K ", "   ", 'A', MITEITEItemRegistryInit.VIBRANIUM_AXE, 'S', MITEITEItemRegistryInit.VIBRANIUM_SHOVEL, 'P', MITEITEItemRegistryInit.VIBRANIUM_PICKAXE, 'K', UCItems.adamantium_paxel).extendsNBT().keepQuality();
            }

            if (UCCompat.vibranium_heavy_helmet != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_heavy_helmet, 1), true, "IHI", "I I", 'I', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'H', UCItems.adamantium_heavy_helmet).extendsNBT().keepQuality();
            }

            if (UCCompat.vibranium_heavy_chestplate != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_heavy_chestplate, 1), true, "I I", "ICI", "III", 'I', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'C', UCItems.adamantium_heavy_chestplate).extendsNBT().keepQuality();
            }

            if (UCCompat.vibranium_heavy_leggings != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_heavy_leggings, 1), true, "ILI", "I I", "I I", 'I', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'L', UCItems.adamantium_heavy_leggings).extendsNBT().keepQuality();
            }

            if (UCCompat.vibranium_heavy_boots != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_heavy_boots, 1), true, "I I", " B ", "I I", 'I', MITEITEItemRegistryInit.VIBRANIUM_INGOT, 'B', UCItems.adamantium_heavy_boots).extendsNBT().keepQuality();
            }
        }
    }

    private static void registerMMCompat(CraftingRecipeRegisterEvent event) {

        if (!ModChecker.HAS_MM) return;

        if (UCCompat.bronze_saber != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.bronze_saber, 1), true, " B ", " B ", "BK ", 'B', MMItems.bronze_ingot, 'K', Item.stick);
        }

        if (UCCompat.bronze_rapier != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.bronze_rapier, 1), true, "  B", "BB ", "BK ", 'B', MMItems.bronze_ingot, 'K', Item.stick);
        }

        if (UCCompat.bronze_nunchaku != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.bronze_nunchaku, 1), true, " S ", "B B", 'S', Item.silk, 'B', MMItems.bronze_ingot);
        }

        if (UCCompat.bronze_paxel != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.bronze_paxel, 1), true, "ASP", " K ", " K ", 'A', MMItems.bronze_axe, 'S', MMItems.bronze_shovel, 'P', MMItems.bronze_pickaxe, 'K', Item.stick);
        }



        if (UCCompat.steel_saber != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.steel_saber, 1), true, " S ", " S ", "SK ", 'S', MMItems.steel_ingot, 'K', Item.stick);
        }

        if (UCCompat.steel_rapier != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.steel_rapier, 1), true, "  S", "SS ", "SK ", 'S', MMItems.steel_ingot, 'K', Item.stick);
        }

        if (UCCompat.steel_nunchaku != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.steel_nunchaku, 1), true, " X ", "S S", 'X', Item.silk, 'S', MMItems.steel_ingot);
        }

        if (UCCompat.steel_paxel != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.steel_paxel, 1), true, "ASP", " K ", " K ", 'A', MMItems.steel_axe, 'S', MMItems.steel_shovel, 'P', MMItems.steel_pickaxe, 'K', Item.stick);
        }



        if (UCCompat.titanium_alloy_saber != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.titanium_alloy_saber, 1), true, " T ", " T ", "TK ", 'T', MMItems.titanium_alloy_ingot, 'K', Item.stick);
        }

        if (UCCompat.titanium_alloy_rapier != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.titanium_alloy_rapier, 1), true, "  T", "TT ", "TK ", 'T', MMItems.titanium_alloy_ingot, 'K', Item.stick);
        }

        if (UCCompat.titanium_alloy_nunchaku != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.titanium_alloy_nunchaku, 1), true, " S ", "T T", 'S', Item.silk, 'T', MMItems.titanium_alloy_ingot);
        }

        if (UCCompat.titanium_alloy_paxel != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.titanium_alloy_paxel, 1), true, "ASP", " K ", " K ", 'A', MMItems.titanium_alloy_axe, 'S', MMItems.titanium_alloy_shovel, 'P', MMItems.titanium_alloy_pickaxe, 'K', Item.stick);
        }




        if (UCCompat.rose_gold_saber != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.rose_gold_saber, 1), true, " R ", " R ", "RK ", 'R', MMItems.rose_gold_ingot, 'K', Item.stick);
        }

        if (UCCompat.rose_gold_rapier != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.rose_gold_rapier, 1), true, "  R", "RR ", "RK ", 'R', MMItems.rose_gold_ingot, 'K', Item.stick);
        }

        if (UCCompat.rose_gold_nunchaku != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.rose_gold_nunchaku, 1), true, " S ", "R R", 'S', Item.silk, 'R', MMItems.rose_gold_ingot);
        }

        if (UCCompat.rose_gold_paxel != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.rose_gold_paxel, 1), true, "ASP", " K ", " K ", 'A', MMItems.rose_gold_axe, 'S', MMItems.rose_gold_shovel, 'P', MMItems.rose_gold_pickaxe, 'K', Item.stick);
        }



        if (UCCompat.platinum_saber != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.platinum_saber, 1), true, " P ", " P ", "PK ", 'P', MMItems.platinum_ingot, 'K', Item.stick);
        }

        if (UCCompat.platinum_rapier != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.platinum_rapier, 1), true, "  P", "PP ", "PK ", 'P', MMItems.platinum_ingot, 'K', Item.stick);
        }

        if (UCCompat.platinum_nunchaku != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.platinum_nunchaku, 1), true, " S ", "P P", 'S', Item.silk, 'P', MMItems.platinum_ingot);
        }

        if (UCCompat.platinum_paxel != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.platinum_paxel, 1), true, "ASP", " K ", " K ", 'A', MMItems.platinum_axe, 'S', MMItems.platinum_shovel, 'P', MMItems.platinum_pickaxe, 'K', Item.stick);
        }



        if (UCCompat.midas_gold_saber != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.midas_gold_saber, 1), true, " M ", " M ", "MK ", 'M', MMItems.midas_gold_ingot, 'K', Item.stick);
        }

        if (UCCompat.midas_gold_rapier != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.midas_gold_rapier, 1), true, "  M", "MM ", "MK ", 'M', MMItems.midas_gold_ingot, 'K', Item.stick);
        }

        if (UCCompat.midas_gold_nunchaku != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.midas_gold_nunchaku, 1), true, " S ", "M M", 'S', Item.silk, 'M', MMItems.midas_gold_ingot);
        }

        if (UCCompat.midas_gold_paxel != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.midas_gold_paxel, 1), true, "ASP", " K ", " K ", 'A', MMItems.midas_gold_axe, 'S', MMItems.midas_gold_shovel, 'P', MMItems.midas_gold_pickaxe, 'K', Item.stick);
        }



        if (UCCompat.adamium_mm_saber != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.adamium_mm_saber, 1), true, " M ", " M ", "MK ", 'M', MMItems.adamantium_ingot, 'K', Item.stick);
        }

        if (UCCompat.adamium_mm_rapier != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.adamium_mm_rapier, 1), true, "  M", "MM ", "MK ", 'M', MMItems.adamantium_ingot, 'K', Item.stick);
        }

        if (UCCompat.adamium_mm_nunchaku != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.adamium_mm_nunchaku, 1), true, " S ", "A A", 'S', Item.silk, 'A', MMItems.adamantium_ingot);
        }

        if (UCCompat.adamium_mm_paxel != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.adamium_mm_paxel, 1), true, "ASP", " K ", " K ", 'A', MMItems.adamantium_axe, 'S', MMItems.adamantium_shovel, 'P', MMItems.adamantium_pickaxe, 'K', Item.stick);
        }
    }

}
