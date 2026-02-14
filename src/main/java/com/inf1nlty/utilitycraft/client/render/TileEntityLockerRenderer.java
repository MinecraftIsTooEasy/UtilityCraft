package com.inf1nlty.utilitycraft.client.render;

import com.inf1nlty.utilitycraft.block.tileentity.TileEntitySteelChest;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.*;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@Environment(value= EnvType.CLIENT)
public class TileEntityLockerRenderer extends TileEntitySpecialRenderer {

    private final ModelChest chestModel = new ModelChest();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTicks) {
        if (!(tileEntity instanceof TileEntitySteelChest)) {
            return;
        }
        renderChest((TileEntitySteelChest) tileEntity, x, y, z, partialTicks);
    }

    private ResourceLocation getTextureForType(int type) {
        return switch (type) {
            case 2 -> new ResourceLocation("utilitycraft:textures/blocks/chest/chestSilver.png");
            case 3 -> new ResourceLocation("utilitycraft:textures/blocks/chest/chestGold.png");
            case 4 -> new ResourceLocation("utilitycraft:textures/blocks/chest/chestIron.png");
            case 5 -> new ResourceLocation("utilitycraft:textures/blocks/chest/chestAncientMetal.png");
            case 6 -> new ResourceLocation("utilitycraft:textures/blocks/chest/chestMithril.png");
            case 7 -> new ResourceLocation("utilitycraft:textures/blocks/chest/chestAdamantium.png");
            default ->new ResourceLocation("utilitycraft:textures/blocks/chest/chestCopper.png");
        };
    }

    private void renderChest(TileEntitySteelChest chest, double x, double y, double z, float partialTicks) {

        float lidProgress = chest.prevLidAngle + (chest.lidAngle - chest.prevLidAngle) * partialTicks;
        lidProgress = 1.0f - lidProgress;
        lidProgress = 1.0f - lidProgress * lidProgress * lidProgress;

        ResourceLocation tex = getTextureForType(chest.chestType);
        this.bindTexture(tex);

        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1f, 1f, 1f, 1f);

        GL11.glTranslatef((float) x, (float) y + 1.0f, (float) z + 1.0f);
        GL11.glScalef(1f, -1f, -1f);
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);

        int meta;
        if(!chest.hasWorldObj()){
            meta = 0;
        } else{
            meta = chest.getBlockMetadata();
        }
        int rotation = switch (meta) {
            case 2 -> 180;
            case 4 -> 90;
            case 5 -> -90;
            default -> 0;
        };
        GL11.glRotatef(rotation, 0f, 1f, 0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);

        chestModel.chestLid.rotateAngleX = -(lidProgress * (float) Math.PI / 2f);
        chestModel.renderAll();

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1f, 1f, 1f, 1f);
    }
}