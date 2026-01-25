package com.inf1nlty.utilitycraft.item.rapier;

import com.inf1nlty.utilitycraft.client.UCSounds;
import net.minecraft.*;
import net.xiaoyu233.fml.api.item.SwordItem;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;

import java.util.List;
import java.util.regex.Matcher;

public class ItemRapier extends SwordItem implements IRapier {

    private final float damage;

    public ItemRapier(int id, Material material, float damage, String name) {
        super(id, material);
        this.damage = damage;
        this.setUnlocalizedName(name);
        this.setTextureName("utilitycraft:rapier/" + name);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    public float getDamage() {
        return this.damage;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public void playAttackSound(EntityPlayer player, EntityLivingBase target) {
        boolean hasArmor = false;

        for (int i = 1; i <= 4; i++) {
            ItemStack armor = target.getCurrentItemOrArmor(i);
            if (armor != null) {
                hasArmor = true;
                break;
            }
        }

        if (hasArmor) {
            float volume = 0.4F;
            float pitch = 1.0F + (player.worldObj.rand.nextFloat() - 0.5F) * 0.4F;
            player.worldObj.playSoundAtEntity(player, UCSounds.weaponRapier.toString(), volume, pitch);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {

        super.addInformation(item_stack, player, info, extended_info, slot);

        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            String desc = StatCollector.translateToLocal("item.utilitycraft.rapier.desc");
            if (desc == null || desc.isEmpty()) {
                return;
            }

            String[] lines = desc.split("\\\\n|\\n");
            for (int i = 0; i < lines.length; ++i) {
                String line = lines[i];
                if (line == null) continue;
                line = line.trim();
                if (line.isEmpty()) continue;

                if (i == 0) {

                    info.add(line);
                } else {

                    String preserved = line;

                    java.util.regex.Pattern p = java.util.regex.Pattern.compile("(?i)(?:§[0-9A-FK-OR])*?(\\d+%)");
                    java.util.regex.Matcher m = p.matcher(preserved);
                    if (m.find()) {
                        String colorCode = getColorCode(m);

                        preserved = m.replaceFirst(colorCode + "$1");
                    }
                    info.add(preserved);
                }
            }
        } else {
            info.add(StatCollector.translateToLocal("item.utilitycraft.rapier.tip"));
        }
    }

    private static @NotNull String getColorCode(Matcher m) {
        String numPct = m.group(1);
        String numStr = numPct.replace("%", "");
        int val = 0;
        try {
            val = Integer.parseInt(numStr);
        } catch (NumberFormatException ignored) {}
        String colorCode;
        if (val >= 90) {
            colorCode = "§a";
        } else if (val >= 50) {
            colorCode = "§e";
        } else if (val >= 25) {
            colorCode = "§6";
        } else {
            colorCode = "§c";
        }
        return colorCode;
    }

    public static ItemRapier createCopper(int id) {
        return new ItemRapier(id, Material.copper, 5.0F, "copper_rapier");
    }

    public static ItemRapier createSilver(int id) {
        return new ItemRapier(id, Material.silver, 5.0F, "silver_rapier");
    }

    public static ItemRapier createGolden(int id) {
        return new ItemRapier(id, Material.gold, 4.0F, "golden_rapier");
    }

    public static ItemRapier createIron(int id) {
        return new ItemRapier(id, Material.iron, 7.0F, "iron_rapier");
    }

    public static ItemRapier createAncientMetal(int id) {
        return new ItemRapier(id, Material.ancient_metal, 7.0F, "ancient_metal_rapier");
    }

    public static ItemRapier createMithril(int id) {
        return new ItemRapier(id, Material.mithril, 8.0F, "mithril_rapier");
    }

    public static ItemRapier createAdamantium(int id) {
        return new ItemRapier(id, Material.adamantium, 9.0F, "adamantium_rapier");
    }
}