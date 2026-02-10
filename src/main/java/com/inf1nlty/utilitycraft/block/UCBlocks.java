package com.inf1nlty.utilitycraft.block;

import net.xiaoyu233.fml.reload.event.BlockRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class UCBlocks {
    public static BlockSteelChest steelChest;

    public static void registerBlocks(BlockRegistryEvent event) {

        int id = IdUtil.getNextBlockID();
        steelChest = new BlockSteelChest(id, 0);
        event.registerBlock("UtilityCraft", "ancient_metal_chest", steelChest);
    }
}