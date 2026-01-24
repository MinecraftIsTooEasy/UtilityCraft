package com.inf1nlty.utilitycraft;

import com.inf1nlty.utilitycraft.item.ISweepAttack;
import net.minecraft.*;

public class UCEnchantments extends Enchantment {

    public static UCEnchantments sweepingEdge;
    public static final int SWEEPING_EDGE_ID = 101;

    public UCEnchantments(int id, EnumRarity rarity, int difficulty) {
        super(id, rarity, difficulty);
    }

    public static void registerEnchantments() {
        sweepingEdge = new UCEnchantments(SWEEPING_EDGE_ID, EnumRarity.rare, 10);
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