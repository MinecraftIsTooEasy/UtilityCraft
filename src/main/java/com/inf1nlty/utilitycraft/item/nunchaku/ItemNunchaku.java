package com.inf1nlty.utilitycraft.item.nunchaku;

import com.inf1nlty.utilitycraft.UCConfigs;
import com.inf1nlty.utilitycraft.client.UCSounds;
import com.inf1nlty.utilitycraft.creativetab.UCCreativeTab;
import com.inf1nlty.utilitycraft.util.UCItemNameUtils;
import net.minecraft.*;

import java.util.List;

public class ItemNunchaku extends ItemCudgel {

    public static final int AUTO_ATTACK_INTERVAL_TICKS = 6;

    private static final String TAG_COMBO_POWER = "utilitycraftNunchakuComboPower";
    private static final String TAG_COMBO_TIME = "utilitycraftNunchakuComboTime";

    private final String materialKey;
    private final String name;
    private Icon spinningIcon;

    public ItemNunchaku(int id, Material material, String name) {
        super(id, material);
        this.setReachBonus(0.5F);
        this.name = name;
        this.materialKey = UCItemNameUtils.materialKeyFromItemName(name, "_nunchaku");
        this.addMaterialsEffectiveAgainst(new Material[]{Material.web, Material.plants});
        this.setTextureName("utilitycraft:nunchaku/" + name);
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
        return UCItemNameUtils.composeName(this.materialKey, "nunchaku");
    }

    @Override
    public float getBaseDamageVsEntity() {
        return 1.5F;
    }

    @Override
    public float getMaterialDamageVsEntity() {
        return super.getMaterialDamageVsEntity() * 0.5F;
    }

    @Override
    public int getNumComponentsForDurability() {
        return 2;
    }

    @Override
    public String getToolType() {
        return "nunchaku";
    }

    @Override
    public boolean canBlock() {
        return false;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        super.registerIcons(iconRegister);

        if (hasSpinningTextureResource()) {
            this.spinningIcon = iconRegister.registerIcon("utilitycraft:nunchaku/" + this.name + "_spinning");
        }
    }

    public Icon getSpinningIcon() {
        return this.spinningIcon;
    }

    public void playAttackSound(EntityPlayer player) {
        if (!UCConfigs.nunchakuAttackSound.getBooleanValue()) {
            return;
        }

        player.worldObj.playSoundAtEntity(player, UCSounds.weaponNunchaku.toString(), 1.0F, 1.0F);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (attacker instanceof EntityPlayer && !attacker.worldObj.isRemote) {
            addComboPower(stack);
        }

        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isHeld) {
        super.onUpdate(stack, world, entity, slot, isHeld);

        if (world.isRemote || !stack.hasTagCompound()) {
            return;
        }

        NBTTagCompound tag = stack.getTagCompound();

        if (!isHeld) {
            resetCombo(tag);
            return;
        }

        int comboTime = tag.getInteger(TAG_COMBO_TIME);
        if (comboTime > 0) {
            tag.setInteger(TAG_COMBO_TIME, comboTime - 1);
        } else if (tag.getFloat(TAG_COMBO_POWER) > 0.0F) {
            resetCombo(tag);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean extendedInfo, Slot slot) {
        super.addInformation(itemStack, player, info, extendedInfo, slot);
        info.add(StatCollector.translateToLocal("item.utilitycraft.nunchaku.desc"));
    }

    public static float getComboDamageMultiplier(ItemStack stack) {
        if (stack == null || !stack.hasTagCompound()) {
            return 1.0F;
        }

        return 1.0F + Math.min(1.0F, Math.max(0.0F, stack.getTagCompound().getFloat(TAG_COMBO_POWER)));
    }

    private static void addComboPower(ItemStack stack) {
        NBTTagCompound tag = getOrCreateTag(stack);
        float comboPower = Math.min(1.0F, tag.getFloat(TAG_COMBO_POWER) + 0.1F);
        tag.setFloat(TAG_COMBO_POWER, comboPower);
        tag.setInteger(TAG_COMBO_TIME, 30);
    }

    private static NBTTagCompound getOrCreateTag(ItemStack stack) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        return stack.getTagCompound();
    }

    private static void resetCombo(NBTTagCompound tag) {
        tag.setFloat(TAG_COMBO_POWER, 0.0F);
        tag.setInteger(TAG_COMBO_TIME, 0);
    }

    private boolean hasSpinningTextureResource() {
        String path = "assets/utilitycraft/textures/items/nunchaku/" + this.name + "_spinning.png";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader != null && loader.getResource(path) != null) {
            return true;
        }
        return ItemNunchaku.class.getClassLoader().getResource(path) != null;
    }

    public static ItemNunchaku createCopper(int id) {
        return new ItemNunchaku(id, Material.copper, "copper_nunchaku");
    }

    public static ItemNunchaku createSilver(int id) {
        return new ItemNunchaku(id, Material.silver, "silver_nunchaku");
    }

    public static ItemNunchaku createGolden(int id) {
        return new ItemNunchaku(id, Material.gold, "golden_nunchaku");
    }

    public static ItemNunchaku createIron(int id) {
        return new ItemNunchaku(id, Material.iron, "iron_nunchaku");
    }

    public static ItemNunchaku createAncientMetal(int id) {
        return new ItemNunchaku(id, Material.ancient_metal, "ancient_metal_nunchaku");
    }

    public static ItemNunchaku createMithril(int id) {
        return new ItemNunchaku(id, Material.mithril, "mithril_nunchaku");
    }

    public static ItemNunchaku createAdamantium(int id) {
        return new ItemNunchaku(id, Material.adamantium, "adamantium_nunchaku");
    }
}
