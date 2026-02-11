package com.inf1nlty.utilitycraft.block;

import com.inf1nlty.utilitycraft.block.tileentity.TileEntitySteelChest;
import net.minecraft.Item;
import net.minecraft.ItemBlock;
import net.minecraft.TileEntity;
import net.xiaoyu233.fml.reload.event.BlockRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class UCBlocks {
    public static BlockSteelChest steelAncientMetal;

    public static void registerBlocks(BlockRegistryEvent event) {

        int id = IdUtil.getNextBlockID();
        steelAncientMetal = new BlockSteelChest(id, 0);
        ItemBlock amchest = new ItemBlock(steelAncientMetal);
        amchest.setMaxStackSize(4);
        Item.itemsList[id] = amchest;
        event.registerBlock("UtilityCraft", "ancientmetalchest", steelAncientMetal);
        TileEntity.addMapping(TileEntitySteelChest.class, "utilitycraft:TileEntityAncientMetalChest");
    }
}