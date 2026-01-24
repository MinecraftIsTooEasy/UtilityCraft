package com.inf1nlty.utilitycraft;

import com.google.common.eventbus.Subscribe;

import com.inf1nlty.utilitycraft.client.UCSounds;
import com.inf1nlty.utilitycraft.entity.EntityObsidianBoat;
import com.inf1nlty.utilitycraft.init.UCRecipes;
import com.inf1nlty.utilitycraft.item.UCItems;

import net.xiaoyu233.fml.reload.event.EntityRegisterEvent;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;
import net.xiaoyu233.fml.reload.event.SoundsRegisterEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class UtilityCraftEventListener {

    @Subscribe
    public void onItemRegister(ItemRegistryEvent event) {
        UCItems.registerItems(event);
    }

    @Subscribe
    public void onRecipeRegister(RecipeRegistryEvent event) {
        UCRecipes.registerRecipes(event);
    }

    @Subscribe
    public void onEntityRegister(EntityRegisterEvent event) {
        event.register(EntityObsidianBoat.class, "utilitycraft", "EntityObsidianBoat", IdUtil.getNextEntityID(), 0, 0);
    }

    @Subscribe
    public void registerSounds(SoundsRegisterEvent event) {
        event.registerSound(UCSounds.weaponSweep, 7);
        event.registerSound(UCSounds.weaponRapier, 4);
    }
}