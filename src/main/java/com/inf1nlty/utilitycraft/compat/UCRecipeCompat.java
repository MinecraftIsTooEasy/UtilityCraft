package com.inf1nlty.utilitycraft.compat;

import com.inf1nlty.utilitycraft.item.UCItems;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

import java.lang.reflect.Field;
import java.util.Locale;

public final class UCRecipeCompat {

    private UCRecipeCompat() {}

    private static final String ITF_ITEMS_CLASS = "net.oilcake.mitelros.registry.item.Items";
    private static final String BEX_ITEMS_CLASS = "net.moddedmite.mitemod.bex.register.BEXItems";
    private static final String MITEITE_ITEMS_CLASS = "net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit";

    public static void registerCompatRecipes(RecipeRegistryEvent event) {
        registerItfCompat(event);
        registerBexCompat(event);
        registerMiteiteCompat(event);
    }

    // ITF
    private static void registerItfCompat(RecipeRegistryEvent event) {
        Class<?> cls;
        try {
            cls = Class.forName(ITF_ITEMS_CLASS);
        } catch (ClassNotFoundException e) {
            return;
        }

        Item forgingNote = findItemField(cls, "forgingNote");
        Item uruIngot = findItemField(cls, "uruIngot");

        if (forgingNote != null && uruIngot != null) {

            if (UCCompat.uru_paxel != null) {
                try {
                    event.registerShapelessRecipe(new ItemStack(UCCompat.uru_paxel, 1), false,
                            forgingNote,
                            uruIngot,
                            Item.axeMithril, Item.shovelMithril, Item.pickaxeMithril, Item.ingotMithril
                    );
                } catch (Throwable ignored) {}
            }

            if (UCCompat.uru_saber != null && UCItems.mithril_saber != null) {
                try {
                    event.registerShapelessRecipe(new ItemStack(UCCompat.uru_saber, 1), false,
                            forgingNote, uruIngot, UCItems.mithril_saber, Item.ingotMithril);
                } catch (Throwable ignored) {
                }
            }

            if (UCCompat.uru_rapier != null && UCItems.mithril_rapier != null) {
                try {
                    event.registerShapelessRecipe(new ItemStack(UCCompat.uru_rapier, 1), false,
                            forgingNote, uruIngot, UCItems.mithril_rapier, Item.ingotMithril);
                } catch (Throwable ignored) {
                }
            }
        }

        tryRegisterMetalFromProvider(cls, "nickel", UCCompat.nickel_saber, UCCompat.nickel_rapier, UCCompat.nickel_paxel, event);
        tryRegisterMetalFromProvider(cls, "tungsten", UCCompat.tungsten_saber, UCCompat.tungsten_rapier, UCCompat.tungsten_paxel, event);
    }

    private static void registerBexCompat(RecipeRegistryEvent event) {
        Item enchantIngot = findItemFromClassName(BEX_ITEMS_CLASS, "enchantIngot");

        // try to find obsidian stick from MITE-ITE to use as stick replacement if present
        Item obsidianStick = findItemFromClassName(MITEITE_ITEMS_CLASS, "OBSIDIAN_STICK");

        if (enchantIngot != null) {
            // saber
            if (UCCompat.enchant_saber != null) {
                try {
                    event.registerShapedRecipe(new ItemStack(UCCompat.enchant_saber, 1), false,
                            " C ", " C ", "CK ", 'C', enchantIngot, 'K', obsidianStick != null ? obsidianStick : Item.stick);
                } catch (Throwable ignored) {}
            }
            // rapier
            if (UCCompat.enchant_rapier != null) {
                try {
                    event.registerShapedRecipe(new ItemStack(UCCompat.enchant_rapier, 1), false,
                            "  C", "CC ", "KC ", 'C', enchantIngot, 'K', obsidianStick != null ? obsidianStick : Item.stick);
                } catch (Throwable ignored) {}
            }

            if (UCCompat.enchant_paxel != null) {
                try {
                    Class<?> bexCls = Class.forName(BEX_ITEMS_CLASS);
                    Item enchantPickaxe = findItemField(bexCls, "enchantPickaxe");
                    if (enchantPickaxe != null) {
                        try {
                            event.registerShapedRecipe(new ItemStack(UCCompat.enchant_paxel, 1), false,
                                    "ASP",
                                    "AA ",
                                    " K ",
                                    'A', enchantIngot,
                                    'S', enchantIngot,
                                    'P', enchantPickaxe,
                                    'K', obsidianStick != null ? obsidianStick : Item.stick);
                        } catch (Throwable ignored) {}
                    }
                } catch (ClassNotFoundException ignored) {
                }
            }
        }
    }

    private static void registerMiteiteCompat(RecipeRegistryEvent event) {
        Item vibraniumIngot = findItemFromClassName(MITEITE_ITEMS_CLASS, "VIBRANIUM_INGOT");
        if (vibraniumIngot == null) return;

        Item obsidianStick = findItemFromClassName(MITEITE_ITEMS_CLASS, "OBSIDIAN_STICK");

        Item handle = Item.swordAncientMetal;

        // saber
        if (UCCompat.vibranium_saber != null) {
            try {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_saber, 1), false,
                        " C ", " C ", "CH ", 'C', vibraniumIngot, 'H', handle);
            } catch (Throwable ignored) {}
        }
        // rapier
        if (UCCompat.vibranium_rapier != null) {
            try {
                event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_rapier, 1), false,
                        "  C", "CC ", "HC ", 'C', vibraniumIngot, 'H', handle);
            } catch (Throwable ignored) {}
        }

        try {
            Class<?> miteiteCls = Class.forName(MITEITE_ITEMS_CLASS);
            // exact names from MITEITE registry
            Item vibPick = findItemField(miteiteCls, "VIBRANIUM_PICKAXE");
            Item vibShovel = findItemField(miteiteCls, "VIBRANIUM_SHOVEL");
            Item vibAxe = findItemField(miteiteCls, "VIBRANIUM_AXE");

            // also check lowercase underscore variants exactly if constants not present
            if (vibPick == null) vibPick = findItemField(miteiteCls, "vibranium_pickaxe");
            if (vibShovel == null) vibShovel = findItemField(miteiteCls, "vibranium_shovel");
            if (vibAxe == null) vibAxe = findItemField(miteiteCls, "vibranium_axe");

            if (UCCompat.vibranium_paxel != null && vibAxe != null && vibShovel != null && vibPick != null) {
                try {
                    event.registerShapedRecipe(new ItemStack(UCCompat.vibranium_paxel, 1), false,
                            "ASP", " K ", " K ", 'A', vibAxe, 'S', vibShovel, 'P', vibPick, 'K', obsidianStick != null ? obsidianStick : Item.stick);
                } catch (Throwable ignored) {}
            }
        } catch (ClassNotFoundException ignored) {}
    }

    // Helper: try to get an ingot for a named metal from provider class and register standard shaped recipes
    private static void tryRegisterMetalFromProvider(Class<?> providerClass, String metalName, Item saberItem, Item rapierItem, Item paxelItem, RecipeRegistryEvent event) {
        if (saberItem == null && rapierItem == null && paxelItem == null) return;

        String[] candidates = new String[] {
                metalName,
                metalName + "Ingot",
                "ingot" + capitalize(metalName),
                "ingot_" + metalName,
                "ingot" + metalName.toUpperCase(Locale.ROOT)
        };

        Item ingot = null;
        for (String cand : candidates) {
            ingot = findItemField(providerClass, cand);
            if (ingot != null) break;
        }

        if (ingot == null && (saberItem != null || rapierItem != null)) return;

        if (saberItem != null) {
            try {
                event.registerShapedRecipe(new ItemStack(saberItem, 1), false, " C ", " C ", "CK ", 'C', ingot, 'K', Item.stick);
            } catch (Throwable ignored) {}
        }

        if (rapierItem != null) {
            try {
                event.registerShapedRecipe(new ItemStack(rapierItem, 1), false, "  C", "CC ", "KC ", 'C', ingot, 'K', Item.stick);
            } catch (Throwable ignored) {}
        }

        // Paxel
        if (paxelItem != null) {
            Item axe = findToolExactField(providerClass, metalName, "axe");
            Item shovel = findToolExactField(providerClass, metalName, "shovel");
            Item pick = findToolExactField(providerClass, metalName, "pickaxe");

            if (axe != null && shovel != null && pick != null) {
                try {
                    event.registerShapedRecipe(new ItemStack(paxelItem, 1), false, "ASP", " K ", " K ", 'A', axe, 'S', shovel, 'P', pick, 'K', Item.stick);
                } catch (Throwable ignored) {}
            }
        }
    }

    // Reflection helpers
    private static Item findItemField(Class<?> cls, String fieldName) {
        try {
            Field f = cls.getField(fieldName);
            Object v = f.get(null);
            if (v instanceof Item) return (Item) v;
        } catch (NoSuchFieldException | IllegalAccessException ignored) {}
        return null;
    }

    private static Item findItemFromClassName(String className, String fieldName) {
        try {
            Class<?> cls = Class.forName(className);
            return findItemField(cls, fieldName);
        } catch (ClassNotFoundException ignored) {}
        return null;
    }

    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    // Try exact/common variants for provider tool fields (used by generic provider branch)
    private static Item findToolExactField(Class<?> cls, String metalName, String toolType) {
        // Try common exact names first
        String[] exact = new String[] {
                metalName + "_" + toolType,
                metalName.toUpperCase(Locale.ROOT) + "_" + toolType.toUpperCase(Locale.ROOT),
                metalName + toolType,
                metalName + capitalize(toolType),
                toolType + capitalize(metalName)
        };
        for (String s : exact) {
            Item it = findItemField(cls, s);
            if (it != null) return it;
        }
        return null;
    }
}