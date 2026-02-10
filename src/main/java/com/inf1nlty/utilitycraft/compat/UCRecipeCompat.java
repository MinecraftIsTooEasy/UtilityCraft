package com.inf1nlty.utilitycraft.compat;

import com.inf1nlty.utilitycraft.item.UCItems;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.moddedmite.mitemod.bex.register.BEXItems;
import net.oilcake.mitelros.registry.item.Items;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;
import net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit;

public final class UCRecipeCompat {

    private UCRecipeCompat() {}

    public static void registerCompatRecipes(RecipeRegistryEvent event) {
        registerItfCompat(event);
        registerBexCompat(event);
        registerMiteiteCompat(event);
    }

    private static void registerItfCompat(RecipeRegistryEvent event) {

        if (!ModChecker.HAS_ITFRB) return;

        // ITF items class: Items
        Item forgingNote = Items.forgingNote;
        Item uruIngot = Items.uruIngot;

        if (uruIngot != null) {

            if (UCCompat.uru_paxel != null) {

                event.registerShapelessRecipe(new ItemStack(UCCompat.uru_paxel, 1), false,
                        forgingNote,
                        uruIngot,
                        Item.pickaxeMithril,
                        Item.shovelMithril,
                        Item.axeMithril,
                        Item.ingotMithril
                );
            }

            if (UCCompat.uru_saber != null && UCItems.mithril_saber != null) {
                event.registerShapelessRecipe(new ItemStack(UCCompat.uru_saber, 1), false,
                        forgingNote, uruIngot, UCItems.mithril_saber, Item.ingotMithril);
            }

            if (UCCompat.uru_rapier != null && UCItems.mithril_rapier != null) {
                event.registerShapelessRecipe(new ItemStack(UCCompat.uru_rapier, 1), false,
                        forgingNote, uruIngot, UCItems.mithril_rapier, Item.ingotMithril);
            }
        }

        if (UCCompat.nickel_saber != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_saber, 1), false, " C ", " C ", "CK ", 'C', Items.nickelIngot, 'K', Item.stick);
        }

        if (UCCompat.nickel_rapier != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_rapier, 1), false, "  C", "CC ", "KC ", 'C', Items.nickelIngot, 'K', Item.stick);
        }

        if (UCCompat.nickel_paxel != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.nickel_paxel, 1), false, "ASP", " K ", " K ", 'A', Items.nickelAxe, 'S', Items.nickelShovel, 'P', Items.nickelPickaxe, 'K', Item.stick);
        }

        if (UCCompat.tungsten_saber != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_saber, 1), false, " C ", " C ", "CK ", 'C', Items.tungstenIngot, 'K', Item.stick);
        }

        if (UCCompat.tungsten_rapier != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_rapier, 1), false, "  C", "CC ", "KC ", 'C', Items.tungstenIngot, 'K', Item.stick);
        }

        if (UCCompat.tungsten_paxel != null) {
            event.registerShapedRecipe(new ItemStack(UCCompat.tungsten_paxel, 1), false, "ASP", " K ", " K ", 'A', Items.tungstenAxe, 'S', Items.tungstenShovel, 'P', Items.tungstenPickaxe, 'K', Item.stick);
        }
    }

    private static void registerBexCompat(RecipeRegistryEvent event) {

        if (!ModChecker.HAS_BEX) return;

        Item enchantIngot = BEXItems.enchantIngot;
        Item enchantPickaxe = BEXItems.enchantPickaxe;
        Item obsidianStick = null;

        if (ModChecker.HAS_ITE) {
            obsidianStick = MITEITEItemRegistryInit.OBSIDIAN_STICK;
        }

        if (enchantIngot != null) {

            if (UCCompat.enchant_saber != null) {

                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_saber, 1), false,
                        " C ", " C ", "CK ", 'C', enchantIngot, 'K', obsidianStick != null ? obsidianStick : Item.stick);
            }

            if (UCCompat.enchant_rapier != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_rapier, 1), false,
                        "  C", "CC ", "KC ", 'C', enchantIngot, 'K', obsidianStick != null ? obsidianStick : Item.stick);
            }

            if (UCCompat.enchant_paxel != null && enchantPickaxe != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.enchant_paxel, 1), false,
                        "IIP",
                        "II ",
                        " K ",
                        'I', enchantIngot,
                        'P', enchantPickaxe,
                        'K', obsidianStick != null ? obsidianStick : Item.stick);
            }
        }
    }

    private static void registerMiteiteCompat(RecipeRegistryEvent event) {

        if (!ModChecker.HAS_ITE) return;

        Item vibraniumIngot = MITEITEItemRegistryInit.VIBRANIUM_INGOT;
        Item vibPick = MITEITEItemRegistryInit.VIBRANIUM_PICKAXE;
        Item vibShovel = MITEITEItemRegistryInit.VIBRANIUM_SHOVEL;
        Item vibAxe = MITEITEItemRegistryInit.VIBRANIUM_AXE;
        Item obsidianStick = MITEITEItemRegistryInit.OBSIDIAN_STICK;
        Item handle = Item.swordAncientMetal;

        if (vibraniumIngot != null) {

            if (UCCompat.vibranium_saber != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_saber, 1), false,
                        " C ", " C ", "CH ", 'C', vibraniumIngot, 'H', handle);
            }

            if (UCCompat.vibranium_rapier != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_rapier, 1), false,
                        "  C", "CC ", "HC ", 'C', vibraniumIngot, 'H', handle);
            }

            if (UCCompat.vibranium_paxel != null && vibAxe != null && vibShovel != null && vibPick != null) {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_paxel, 1), false,
                        "ASP", " K ", " K ", 'A', vibAxe, 'S', vibShovel, 'P', vibPick, 'K', obsidianStick != null ? obsidianStick : Item.stick);
            }
        }
    }
}