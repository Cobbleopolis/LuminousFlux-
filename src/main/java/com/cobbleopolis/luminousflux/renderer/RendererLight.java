package com.cobbleopolis.luminousflux.renderer;

import com.cobbleopolis.luminousflux.LuminousFlux;
import com.cobbleopolis.luminousflux.model.ModelLight;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLight;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;


public class RendererLight extends TileEntitySpecialRenderer implements
		IItemRenderer {

	private final ModelLight model;

	public RendererLight() {
		this.model = new ModelLight();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
			case ENTITY:
				return true;
			case EQUIPPED:
				return true;
			case EQUIPPED_FIRST_PERSON:
				return true;
			case INVENTORY:
				return true;
			default:
				return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		GL11.glCullFace(GL11.GL_FRONT);
		GL11.glScalef(1F, -1F, 1F);
		GL11.glTranslatef(0F, -1F, 0F);
		ResourceLocation textures = (new ResourceLocation(
				LuminousFlux.MODID + ":textures/blocks/light2.png"));
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glCullFace(GL11.GL_BACK);
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y,
								   double z, float paramFloat) {
		TileEntityLight te = (TileEntityLight) tileEntity;
		int dir = te.direction;
		GL11.glPushMatrix();
		GL11.glCullFace(GL11.GL_FRONT);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        switch (dir) {
            case 1: //WEST
                GL11.glRotatef(-90F, 0F, 0F, 1F);
                GL11.glTranslatef(1F, 1F, 0F);
                break;
            case 2: //EAST
                GL11.glRotatef(90F, 0F, 0F, 1F);
                GL11.glTranslatef(-1F, 1F, 0F);
                break;
            case 3: //NORTH
                GL11.glRotatef(90F, 1F, 0F, 0F);
                GL11.glTranslatef(0F, 1F, 1F);
                break;
            case 4: //SOUTH
                GL11.glRotatef(-90F, 1F, 0F, 0F);
                GL11.glTranslatef(0F, 1F, -1F);
                break;
            case 5: //DOWN

                break;
            case 6: //UP
                GL11.glRotatef(-180F, 1F, 0F, 0F);
                GL11.glTranslatef(0F, 2F, 0F);
                break;
        }
        GL11.glScalef(1F, -1F, 1F);
        ResourceLocation textures = (new ResourceLocation(
				LuminousFlux.MODID + ":textures/blocks/light2.png"));
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
        this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        if (!te.bulbItem.equalsIgnoreCase("none")) {
            this.model.light_bottom.render(0.0625F);
            this.model.light_top.render(0.0625F);
        }
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glCullFace(GL11.GL_BACK);
		GL11.glPopMatrix();
	}
}