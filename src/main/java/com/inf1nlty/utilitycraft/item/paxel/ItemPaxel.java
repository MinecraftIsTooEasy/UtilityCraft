package com.inf1nlty.utilitycraft.item.paxel;

import com.inf1nlty.utilitycraft.creativetab.UCCreativeTab;
import com.inf1nlty.utilitycraft.compat.ModChecker;
import net.minecraft.*;
import net.oilcake.mitelros.material.Materials;

public class ItemPaxel extends ItemTool implements IPaxel {

    public ItemPaxel(int id, Material material) {
        super(id, material);

        this.addMaterialsEffectiveAgainst(new Material[] {
                // pickaxe materials
                Material.adamantium, Material.ancient_metal, Material.circuits, Material.clay, Material.coal,
                Material.copper, Material.coral, Material.diamond, Material.emerald, Material.glass, Material.gold,
                Material.hardened_clay, Material.ice, Material.iron, Material.mithril, Material.netherrack,
                Material.obsidian, Material.quartz, Material.redstone, Material.stone, Material.rusted_iron, Material.silver,
                // axe materials
                Material.cactus, Material.pumpkin, Material.wood,
                // shovel materials
                Material.cake, Material.clay, Material.craftedSnow, Material.grass, Material.dirt, Material.sand, Material.snow
        });

        if (ModChecker.HAS_ITFRB) {
            this.addMaterialsEffectiveAgainst(new Material[] { Materials.crystal });
        }

        // common + axe special blocks
        this.addBlocksEffectiveAgainst(new Block[] {
                Block.ladder, Block.reed, Block.sandStone,
        });

        // shovel-specific effective blocks
        this.addBlocksEffectiveAgainst(new Block[] {
                Block.carrot, Block.onions, Block.potato, Block.thinGlass
        });

        // shovel: if tool material is metal in original shovel ctor they add Block.glass
        // here the constructor parameter `material` corresponds to shovel's material check
        if (material.isMetal()) {
            this.addBlocksEffectiveAgainst(new Block[] { Block.glass });
        }

        this.setMaxDamage(this.getMultipliedDurability());
        this.setCreativeTab(UCCreativeTab.TAB);
    }

    @Override
    public String getToolType() {
        return "paxel";
    }

    @Override
    public float getBaseHarvestEfficiency(Block block) {
        if (block == Block.sandStone) {
            return super.getBaseHarvestEfficiency(block) * 0.5F;
        }
        return super.getBaseHarvestEfficiency(block);
    }

    @Override
    public float getBaseDamageVsEntity() {
        return 3.0F;
    }

    @Override
    public int getNumComponentsForDurability() {
        return 7;
    }

    /**
     * Combine axe/pick/shovel decay behaviour:
     * - shovel special: certain crop/soft blocks -> 0.5F
     * - default -> 1.0F
     */
    @Override
    public float getBaseDecayRateForBreakingBlock(Block block) {

        if (block == Block.dirt || block == Block.sand || block == Block.grass || block == Block.gravel || block == Block.carrot || block == Block.onions || block == Block.potato || block == Block.thinGlass || block == Block.glass) {
            return 0.5F;
        }

        return 1.0F;
    }

    @Override
    public float getBaseDecayRateForAttackingEntity(ItemStack item_stack) {
        return 1.0F;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Class[] getSimilarClasses() {
        return this.spliceClassArrays(new Class[] { ItemBattleAxe.class, ItemHatchet.class, ItemWarHammer.class, ItemMattock.class, ItemHoe.class }, ItemTool.weapon_classes);
    }
}