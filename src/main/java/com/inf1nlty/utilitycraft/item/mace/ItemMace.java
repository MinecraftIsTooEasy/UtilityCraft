package com.inf1nlty.utilitycraft.item.mace;

import com.inf1nlty.utilitycraft.creativetab.UCCreativeTab;
import com.inf1nlty.utilitycraft.util.UCItemNameUtils;
import net.minecraft.EntityPlayer;
import net.minecraft.Item;
import net.minecraft.ItemClub;
import net.minecraft.ItemStack;
import net.minecraft.Material;
import net.minecraft.Slot;
import net.minecraft.StatCollector;

import java.util.List;

public class ItemMace extends ItemClub {
    private final String materialKey;

    public ItemMace(int id, Material material, String name) {
        super(id, material);
        this.materialKey = UCItemNameUtils.materialKeyFromItemName(name, "_mace");
        this.setUnlocalizedName(name);
        this.setCreativeTab(UCCreativeTab.TAB);
        this.setReachBonus(1.5F);
    }

    @Override
    public String getItemStackDisplayName(ItemStack itemStack) {
        return this.getItemDisplayName(itemStack);
    }

    @Override
    public String getItemDisplayName(ItemStack itemStack) {
        return this.getStatName();
    }

    @Override
    public String getStatName() {
        return UCItemNameUtils.composeName(this.materialKey, "mace");
    }

    @Override
    public String getToolType() {
        return "mace";
    }

    @Override
    public Material getHardestMetalMaterial() {
        Material material = this.getToolMaterial();
        if (isVibraniumMaterial(material)) {
            return material;
        }

        return super.getHardestMetalMaterial();
    }

    public static boolean isVibraniumMace(Item item) {
        return item instanceof ItemMace && ((ItemMace) item).isVibranium();
    }

    public boolean isVibranium() {
        return isVibraniumMaterial(this.getToolMaterial());
    }

    private static boolean isVibraniumMaterial(Material material) {
        return material != null && "vibranium".equals(material.toString());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean extendedInfo, Slot slot) {
        super.addInformation(itemStack, player, info, extendedInfo, slot);
        info.add(StatCollector.translateToLocal("item.utilitycraft.mace.desc"));
    }

    public static ItemMace createCopper(int id) {
        return new ItemMace(id, Material.copper, "copper_mace");
    }

    public static ItemMace createSilver(int id) {
        return new ItemMace(id, Material.silver, "silver_mace");
    }

    public static ItemMace createGolden(int id) {
        return new ItemMace(id, Material.gold, "golden_mace");
    }

    public static ItemMace createIron(int id) {
        return new ItemMace(id, Material.iron, "iron_mace");
    }

    public static ItemMace createAncientMetal(int id) {
        return new ItemMace(id, Material.ancient_metal, "ancient_metal_mace");
    }

    public static ItemMace createMithril(int id) {
        return new ItemMace(id, Material.mithril, "mithril_mace");
    }

    public static ItemMace createAdamantium(int id) {
        return new ItemMace(id, Material.adamantium, "adamantium_mace");
    }
}
