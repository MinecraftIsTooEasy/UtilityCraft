package com.inf1nlty.utilitycraft;

import com.inf1nlty.utilitycraft.item.ISweepAttack;
import net.minecraft.*;

import net.xiaoyu233.fml.reload.utils.IdUtil;
import net.xiaoyu233.fml.reload.event.EnchantmentRegistryEvent;

public class UCEnchantments extends Enchantment {

    public static UCEnchantments sweepingEdge;

    public UCEnchantments(int id, EnumRarity rarity, int difficulty) {
        super(id, rarity, difficulty);
    }

    public static void registerEnchantments(EnchantmentRegistryEvent event) {
        int id = IdUtil.getNextEnchantmentID();
        sweepingEdge = new UCEnchantments(id, EnumRarity.rare, 10);
        event.registerEnchantment(sweepingEdge);
    }

    @Override
    public String getNameSuffix() {
        return "sweeping_edge";
    }

    @Override
    public boolean canEnchantItem(Item item) {
        return item instanceof ISweepAttack;
    }

    @Override
    public boolean isOnCreativeTab(CreativeTabs creativeTabs) {
        return creativeTabs == CreativeTabs.tabCombat;
    }

    @Override
    public int getNumLevels() {
        return 3;
    }
}