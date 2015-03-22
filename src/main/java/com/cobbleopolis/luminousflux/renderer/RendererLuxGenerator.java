package com.cobbleopolis.luminousflux.renderer;

import com.cobbleopolis.luminousflux.LuminousFlux;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RendererLuxGenerator extends TileEntitySpecialRenderer implements
		IItemRenderer {
	
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
		GL11.glTranslatef(0F, -0.5F, 0F);
		if(type == ItemRenderType.INVENTORY || type == ItemRenderType.EQUIPPED_FIRST_PERSON)
			GL11.glTranslatef(0F, -0.5F, 0F);

		ResourceLocation textures = (new ResourceLocation(
				LuminousFlux.MODID + ":textures/blocks/luminousLamp.png"));
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);

		GL11.glCullFace(GL11.GL_BACK);
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y,
								   double z, float paramFloat) {
		GL11.glPushMatrix();


		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		ResourceLocation textures = (new ResourceLocation(
				LuminousFlux.MODID + ":textures/blocks/luminousLamp.png"));
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);



		GL11.glPopMatrix();
	}
}
