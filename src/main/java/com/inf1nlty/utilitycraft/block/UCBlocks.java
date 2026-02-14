package com.inf1nlty.utilitycraft.block;

import com.inf1nlty.utilitycraft.block.tileentity.TileEntityLocker;
import net.minecraft.Item;
import net.minecraft.ItemBlock;
import net.minecraft.TileEntity;
import net.xiaoyu233.fml.reload.event.BlockRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class UCBlocks {

    public static BlockLocker chestCopper;
    public static BlockLocker chestSilver;
    public static BlockLocker chestGold;
    public static BlockLocker chestIron;
    public static BlockLocker chestAncientMetal;
    public static BlockLocker chestMithril;
    public static BlockLocker chestAdamantium;

    public static void registerBlocks(BlockRegistryEvent event) {

        int id;

        id = IdUtil.getNextBlockID();
        chestCopper = new BlockLocker(id, 1);
        ItemBlock copperItem = new ItemBlock(chestCopper);
        copperItem.setMaxStackSize(4);
        Item.itemsList[id] = copperItem;
        event.registerBlock("UtilityCraft", "copperchest", chestCopper);
        TileEntity.addMapping(TileEntityLocker.class, "utilitycraft:TileEntityCopperChest");

        id = IdUtil.getNextBlockID();
        chestSilver = new BlockLocker(id, 2);
        ItemBlock silverItem = new ItemBlock(chestSilver);
        silverItem.setMaxStackSize(4);
        Item.itemsList[id] = silverItem;
        event.registerBlock("UtilityCraft", "silverchest", chestSilver);
        TileEntity.addMapping(TileEntityLocker.class, "utilitycraft:TileEntitySilverChest");

        id = IdUtil.getNextBlockID();
        chestGold = new BlockLocker(id, 3);
        ItemBlock goldItem = new ItemBlock(chestGold);
        goldItem.setMaxStackSize(4);
        Item.itemsList[id] = goldItem;
        event.registerBlock("UtilityCraft", "goldchest", chestGold);
        TileEntity.addMapping(TileEntityLocker.class, "utilitycraft:TileEntityGoldChest");

        id = IdUtil.getNextBlockID();
        chestIron = new BlockLocker(id, 4);
        ItemBlock ironItem = new ItemBlock(chestIron);
        ironItem.setMaxStackSize(4);
        Item.itemsList[id] = ironItem;
        event.registerBlock("UtilityCraft", "ironchest", chestIron);
        TileEntity.addMapping(TileEntityLocker.class, "utilitycraft:TileEntityIronChest");

        id = IdUtil.getNextBlockID();
        chestAncientMetal = new BlockLocker(id, 5);
        ItemBlock ancientItem = new ItemBlock(chestAncientMetal);
        ancientItem.setMaxStackSize(4);
        Item.itemsList[id] = ancientItem;
        event.registerBlock("UtilityCraft", "ancientmetalchest", chestAncientMetal);
        TileEntity.addMapping(TileEntityLocker.class, "utilitycraft:TileEntityAncientMetalChest");

        id = IdUtil.getNextBlockID();
        chestMithril = new BlockLocker(id, 6);
        ItemBlock mithrilItem = new ItemBlock(chestMithril);
        mithrilItem.setMaxStackSize(4);
        Item.itemsList[id] = mithrilItem;
        event.registerBlock("UtilityCraft", "mithrilchest", chestMithril);
        TileEntity.addMapping(TileEntityLocker.class, "utilitycraft:TileEntityMithrilChest");

        id = IdUtil.getNextBlockID();
        chestAdamantium = new BlockLocker(id, 7);
        ItemBlock adamItem = new ItemBlock(chestAdamantium);
        adamItem.setMaxStackSize(4);
        Item.itemsList[id] = adamItem;
        event.registerBlock("UtilityCraft", "adamantiumchest", chestAdamantium);
        TileEntity.addMapping(TileEntityLocker.class, "utilitycraft:TileEntityAdamantiumChest");

    }
}