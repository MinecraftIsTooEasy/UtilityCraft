package com.inf1nlty.utilitycraft.creativetab;

import com.inf1nlty.utilitycraft.item.UCItems;
import huix.glacier.api.extension.creativetab.GlacierCreativeTabs;

public class UCCreativeTab extends GlacierCreativeTabs {

    public static final UCCreativeTab TAB = new UCCreativeTab();

    public UCCreativeTab() {
        super("UtilityCraft");
    }

    public int getTabIconItemIndex() {
        return UCItems.iron_saber.itemID;
    }
}