package com.cobbleopolis.luminousflux.gui;

import com.cobbleopolis.luminousflux.inventory.ContainerLuxBattery;
import com.cobbleopolis.luminousflux.reference.Textures;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxBattery;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class GuiLuxBattery extends GuiContainer {
    private static final ResourceLocation luxBatteryGuiTexture = new ResourceLocation(Textures.RESOURCE_PREFIX + Textures.GUI_SHEET_LOCATION + "luxBattery.png");
    private TileEntityLuxBattery te;
    private List tooltip = new ArrayList();
    private int mouseX, mouseY;

    public GuiLuxBattery(InventoryPlayer invPlayer, TileEntityLuxBattery tile) {
        super(new ContainerLuxBattery(invPlayer, tile));
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
        mc.renderEngine.bindTexture(luxBatteryGuiTexture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        if (this.te.getScaledEnergy(62) > 0) {
            int l = this.te.getScaledEnergy(62);
            drawTexturedModalRect(guiLeft + 80, (guiTop + 74) - l, 176, 76 - l, 16, l + 2);
        }
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {
        super.drawScreen(par1, par2, par3);
        this.mouseX = par1 - guiLeft;
        this.mouseY = par2 - guiTop;
        if(mouseX >= 80 && mouseX <= 95 && mouseY >= 12 && mouseY <= 70) {
            tooltip.add("Lux");
            tooltip.add(te.storedLux + " lx/" + te.maxLux + " lx");
            this.func_146283_a(tooltip, mouseX + guiLeft, mouseY + guiTop);
            tooltip.clear();
        }

    }
}
