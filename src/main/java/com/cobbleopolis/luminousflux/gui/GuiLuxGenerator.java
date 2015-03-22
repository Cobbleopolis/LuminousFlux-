package com.cobbleopolis.luminousflux.gui;

import com.cobbleopolis.luminousflux.LuminousFlux;
import com.cobbleopolis.luminousflux.inventory.ContainerLuxGenerator;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiLuxGenerator extends GuiContainer{

	private static final ResourceLocation luxGeneratorGuiTexture = new ResourceLocation(LuminousFlux.MODID + ":textures/guis/luxGenerator.png");
	private TileEntityLuxGenerator te;

	public GuiLuxGenerator(InventoryPlayer invPlayer, TileEntityLuxGenerator tile) {
		super(new ContainerLuxGenerator(invPlayer, tile));
		this.te = tile;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		String string = this.te.hasCustomInventoryName() ? this.te.getInventoryName() : I18n.format(this.te.getInventoryName(), new Object[0]);
		String energy = "Lux: " + this.te.storedLux + " lx / " + this.te.maxLux + " lx";
		this.fontRendererObj.drawString(string, this.xSize / 2 - this.fontRendererObj.getStringWidth(string), 6, 4210752);
		this.fontRendererObj.drawString(energy, 88 - (this.fontRendererObj.getStringWidth(string) / 2), 63, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(luxGeneratorGuiTexture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		if (this.te.getScaledBurnTime(12) > 0) {
			int l = this.te.getScaledBurnTime(12);
			drawTexturedModalRect(guiLeft + 80, (guiTop + 24 + 12) - l, 176, 12 - l, 14, l + 2);
		}
	}

}