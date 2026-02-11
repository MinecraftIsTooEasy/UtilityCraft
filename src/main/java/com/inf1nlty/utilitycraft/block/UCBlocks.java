package com.inf1nlty.utilitycraft.block;

import com.inf1nlty.utilitycraft.block.tileentity.TileEntitySteelChest;
import net.minecraft.Item;
import net.minecraft.ItemBlock;
import net.minecraft.TileEntity;
import net.xiaoyu233.fml.reload.event.BlockRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class UCBlocks {

    public static BlockSteelChest chestCopper;
    public static BlockSteelChest chestSilver;
    public static BlockSteelChest chestGold;
    public static BlockSteelChest chestIron;
    public static BlockSteelChest chestAncientMetal;
    public static BlockSteelChest chestMithril;
    public static BlockSteelChest chestAdamantium;

    public static void registerBlocks(BlockRegistryEvent event) {

        int id;

        id = IdUtil.getNextBlockID();
        chestCopper = new BlockSteelChest(id, 1);
        ItemBlock copperItem = new ItemBlock(chestCopper);
        copperItem.setMaxStackSize(4);
        Item.itemsList[id] = copperItem;
        event.registerBlock("UtilityCraft", "copperchest", chestCopper);
        TileEntity.addMapping(TileEntitySteelChest.class, "utilitycraft:TileEntityCopperChest");

        id = IdUtil.getNextBlockID();
        chestSilver = new BlockSteelChest(id, 2);
        ItemBlock silverItem = new ItemBlock(chestSilver);
        silverItem.setMaxStackSize(4);
        Item.itemsList[id] = silverItem;
        event.registerBlock("UtilityCraft", "silverchest", chestSilver);
        TileEntity.addMapping(TileEntitySteelChest.class, "utilitycraft:TileEntitySilverChest");

        id = IdUtil.getNextBlockID();
        chestGold = new BlockSteelChest(id, 3);
        ItemBlock goldItem = new ItemBlock(chestGold);
        goldItem.setMaxStackSize(4);
        Item.itemsList[id] = goldItem;
        event.registerBlock("UtilityCraft", "goldchest", chestGold);
        TileEntity.addMapping(TileEntitySteelChest.class, "utilitycraft:TileEntityGoldChest");

        id = IdUtil.getNextBlockID();
        chestIron = new BlockSteelChest(id, 4);
        ItemBlock ironItem = new ItemBlock(chestIron);
        ironItem.setMaxStackSize(4);
        Item.itemsList[id] = ironItem;
        event.registerBlock("UtilityCraft", "ironchest", chestIron);
        TileEntity.addMapping(TileEntitySteelChest.class, "utilitycraft:TileEntityIronChest");

        id = IdUtil.getNextBlockID();
        chestAncientMetal = new BlockSteelChest(id, 5);
        ItemBlock ancientItem = new ItemBlock(chestAncientMetal);
        ancientItem.setMaxStackSize(4);
        Item.itemsList[id] = ancientItem;
        event.registerBlock("UtilityCraft", "ancientmetalchest", chestAncientMetal);
        TileEntity.addMapping(TileEntitySteelChest.class, "utilitycraft:TileEntityAncientMetalChest");

        id = IdUtil.getNextBlockID();
        chestMithril = new BlockSteelChest(id, 6);
        ItemBlock mithrilItem = new ItemBlock(chestMithril);
        mithrilItem.setMaxStackSize(4);
        Item.itemsList[id] = mithrilItem;
        event.registerBlock("UtilityCraft", "mithrilchest", chestMithril);
        TileEntity.addMapping(TileEntitySteelChest.class, "utilitycraft:TileEntityMithrilChest");

        id = IdUtil.getNextBlockID();
        chestAdamantium = new BlockSteelChest(id, 7);
        ItemBlock adamItem = new ItemBlock(chestAdamantium);
        adamItem.setMaxStackSize(4);
        Item.itemsList[id] = adamItem;
        event.registerBlock("UtilityCraft", "adamantiumchest", chestAdamantium);
        TileEntity.addMapping(TileEntitySteelChest.class, "utilitycraft:TileEntityAdamantiumChest");

    }
}