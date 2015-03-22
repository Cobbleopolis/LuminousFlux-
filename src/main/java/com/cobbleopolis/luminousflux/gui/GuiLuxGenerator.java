package com.cobbleopolis.luminousflux.gui;

import com.cobbleopolis.luminousflux.inventory.ContainerLuxGenerator;
import com.cobbleopolis.luminousflux.reference.Textures;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class GuiLuxGenerator extends GuiContainer {

	private static final ResourceLocation luxGeneratorGuiTexture = new ResourceLocation(Textures.RESOURCE_PREFIX + Textures.GUI_SHEET_LOCATION + "luxGenerator.png");
	private TileEntityLuxGenerator te;
	private List tooltip = new ArrayList();
	private int mouseX, mouseY;

	public GuiLuxGenerator(InventoryPlayer invPlayer, TileEntityLuxGenerator tile) {
		super(new ContainerLuxGenerator(invPlayer, tile));
		this.te = tile;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		String string = this.te.hasCustomInventoryName() ? this.te.getInventoryName() : I18n.format(this.te.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(string, 8, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(luxGeneratorGuiTexture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		if (this.te.getScaledBurnTime(12) > 0) {
			int l = this.te.getScaledBurnTime(12);
			drawTexturedModalRect(guiLeft + 80, (guiTop + 36) - l, 176, 12 - l, 14, l + 2);
		}

		if (this.te.getScaledEnergy(62) > 0) {
			int l = this.te.getScaledEnergy(62);
			drawTexturedModalRect(guiLeft + 134, (guiTop + 74) - l, 176, 76 - l, 16, l + 2);
		}
	}

	// 286 302
	// 61 123
	@Override
	public void drawScreen(int par1, int par2, float par3) {
		super.drawScreen(par1, par2, par3);
		this.mouseX = par1 - guiLeft;
		this.mouseY = par2 - guiTop;
//		System.out.println("(" + par1 + " , " + par2 + ") | (" + guiLeft + " , " + guiTop + ")");
		if(mouseX > 134 && mouseX < 150 && mouseY > 11 && mouseY < 73) {
			tooltip.add("Lux");
			tooltip.add(te.storedLux + " lx/" + te.maxLux + " lx");
			this.func_146283_a(tooltip, mouseX + guiLeft, mouseY + guiTop);
			tooltip.clear();
		}

	}

//	protected void drawToolTip(List par1List, int par2, int par3) {
//		if (!par1List.isEmpty()) {
//			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
//			RenderHelper.disableStandardItemLighting();
//			GL11.glDisable(GL11.GL_LIGHTING);
//			GL11.glDisable(GL11.GL_DEPTH_TEST);
//			int k = 0;
//			Iterator iterator = par1List.iterator();
//
//			while (iterator.hasNext()) {
//				String s = (String) iterator.next();
//				int l = this.fontRendererObj.getStringWidth(s);
//
//				if (l > k) {
//					k = l;
//				}
//			}
//
//			int i1 = par2 + 12;
//			int j1 = par3 - 12;
//			int k1 = 8;
//
//			if (par1List.size() > 1) {
//				k1 += 2 + (par1List.size() - 1) * 10;
//			}
//
//			if (i1 + k > this.width) {
//				i1 -= 28 + k;
//			}
//
//			if (j1 + k1 + 6 > this.height) {
//				j1 = this.height - k1 - 6;
//			}
//
//			this.zLevel = 300.0F;
//			itemRender.zLevel = 300.0F;
//			int l1 = -267386864;
//			this.drawGradientRect(i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
//			this.drawGradientRect(i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
//			this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
//			this.drawGradientRect(i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
//			this.drawGradientRect(i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
//			int i2 = 1347420415;
//			int j2 = (i2 & 16711422) >> 1 | i2 & -16777216;
//			this.drawGradientRect(i1 - 3, j1 - 3 + 1, i1 - 3 + 1, j1 + k1 + 3 - 1, i2, j2);
//			this.drawGradientRect(i1 + k + 2, j1 - 3 + 1, i1 + k + 3, j1 + k1 + 3 - 1, i2, j2);
//			this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 - 3 + 1, i2, i2);
//			this.drawGradientRect(i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);
//
//			for (int k2 = 0; k2 < par1List.size(); ++k2) {
//				String s1 = (String) par1List.get(k2);
//				this.fontRendererObj.drawStringWithShadow(s1, i1, j1, -1);
//
//				if (k2 == 0) {
//					j1 += 2;
//				}
//
//				j1 += 10;
//			}
//
//			this.zLevel = 0.0F;
//			itemRender.zLevel = 0.0F;
//		}
//	}

}