package com.inf1nlty.utilitycraft.item.armor;

import com.inf1nlty.utilitycraft.creativetab.UCCreativeTab;
import com.inf1nlty.utilitycraft.util.UCItemNameUtils;
import net.minecraft.ItemCuirass;
import net.minecraft.ItemStack;
import net.minecraft.Material;

public class ItemHeavyCuirass extends ItemCuirass implements IHeavyArmor {
    private final String texturePrefix;
    private final String materialKey;

    public ItemHeavyCuirass(int id, Material material, String name, String texturePrefix) {
        super(id, material, false);
        this.texturePrefix = texturePrefix;
        this.materialKey = UCItemNameUtils.materialKeyFromItemName(name, "_heavy_chestplate");
        this.setUnlocalizedName(name);
        this.setCreativeTab(UCCreativeTab.TAB);
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
        return UCItemNameUtils.composeName(this.materialKey, "heavy_chestplate");
    }

    @Override
    public int getMaterialProtection() {
        return this.getHeavyArmorMaterialProtection(super.getMaterialProtection());
    }

    @Override
    public String getTextureFilenamePrefix() {
        return this.texturePrefix;
    }
}
