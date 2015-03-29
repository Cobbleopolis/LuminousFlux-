package com.cobbleopolis.luminousflux.gui;

import com.cobbleopolis.luminousflux.inventory.ContainerLuxGenerator;
import com.cobbleopolis.luminousflux.reference.Textures;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxGenerator;
import com.cobbleopolis.luminousflux.util.UtilString;
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
	private List<String> tooltip = new ArrayList<>();

	public GuiLuxGenerator(InventoryPlayer invPlayer, TileEntityLuxGenerator tile) {
		super(new ContainerLuxGenerator(invPlayer, tile));
		this.te = tile;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		String string = this.te.hasCustomInventoryName() ? this.te.getInventoryName() : I18n.format(this.te.getInventoryName());
		this.fontRendererObj.drawString(string, 8, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 94, 4210752);

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

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		super.drawScreen(par1, par2, par3);
		int mouseX = par1 - guiLeft;
		int mouseY = par2 - guiTop;
//		System.out.println("(" + par1 + " , " + par2 + ") | (" + guiLeft + " , " + guiTop + ")");
		if(mouseX >= 134 && mouseX <= 151 && mouseY >= 12 && mouseY <= 70) {
			tooltip.add("Lux");
			tooltip.add(UtilString.formatIntWithCommas(te.storedLux) + " lx / " + UtilString.formatIntWithCommas(te.maxLux) + " lx");
			this.func_146283_a(tooltip, mouseX + guiLeft, mouseY + guiTop);
			tooltip.clear();
		}

	}

}