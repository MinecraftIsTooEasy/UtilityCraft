package com.inf1nlty.utilitycraft;

import com.google.common.eventbus.Subscribe;

import com.inf1nlty.utilitycraft.block.UCBlocks;
import com.inf1nlty.utilitycraft.client.UCSounds;
import com.inf1nlty.utilitycraft.entity.EntityObsidianBoat;
import com.inf1nlty.utilitycraft.item.UCItems;

import net.xiaoyu233.fml.reload.event.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class UCFMLEvents {

    @Subscribe
    public void onItemRegister(ItemRegistryEvent event) {
        UCItems.registerItems(event);
    }

    @Subscribe
    public void onBlockRegister(BlockRegistryEvent event) {
        UCBlocks.registerBlocks(event);
    }

    @Subscribe
    public void onEnchantmentRegister(EnchantmentRegistryEvent event) {
        UCEnchantments.registerEnchantments(event);
    }

    @Subscribe
    public void onEntityRegister(EntityRegisterEvent event) {
        event.register(EntityObsidianBoat.class, "utilitycraft", "EntityObsidianBoat", IdUtil.getNextEntityID());
    }

    @Subscribe
    public void registerSounds(SoundsRegisterEvent event) {
        event.registerSound(UCSounds.weaponSweep, 7);
        event.registerSound(UCSounds.weaponRapier, 4);
    }
}