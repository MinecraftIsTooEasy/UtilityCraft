package com.inf1nlty.utilitycraft.compat;

import com.inf1nlty.utilitycraft.item.mace.ItemMace;
import net.xiaoyu233.mitemod.miteite.api.ITEPlugin;
import net.xiaoyu233.mitemod.miteite.api.ITERegistry;

public class UCITEPlugin implements ITEPlugin {
    @Override
    public void register(ITERegistry registry) {
        registry.registerWeaponCriteria(item -> item instanceof ItemMace);
    }
}
