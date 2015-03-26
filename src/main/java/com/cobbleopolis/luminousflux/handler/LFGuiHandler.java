package com.cobbleopolis.luminousflux.handler;

import com.cobbleopolis.luminousflux.gui.GuiLuxBattery;
import com.cobbleopolis.luminousflux.gui.GuiLuxGenerator;
import com.cobbleopolis.luminousflux.inventory.ContainerLuxBattery;
import com.cobbleopolis.luminousflux.inventory.ContainerLuxGenerator;
import com.cobbleopolis.luminousflux.reference.Gui;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxBattery;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxGenerator;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class LFGuiHandler implements IGuiHandler {

	public LFGuiHandler (){

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Gui.LUX_GENERATOR){
			TileEntityLuxGenerator tileEntity = (TileEntityLuxGenerator) world.getTileEntity(x, y, z);
			return new ContainerLuxGenerator(player.inventory, tileEntity);
		} else if(ID == Gui.LUX_BATTERY){
			TileEntityLuxBattery tileEntity = (TileEntityLuxBattery) world.getTileEntity(x, y, z);
			return new ContainerLuxBattery(player.inventory, tileEntity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Gui.LUX_GENERATOR){
			TileEntityLuxGenerator tileEntity = (TileEntityLuxGenerator) world.getTileEntity(x, y, z);
			return new GuiLuxGenerator(player.inventory, tileEntity);
		} else if(ID == Gui.LUX_BATTERY) {
			TileEntityLuxBattery tileEntity = (TileEntityLuxBattery) world.getTileEntity(x, y, z);
			return new GuiLuxBattery(player.inventory, tileEntity);
		}

		return null;
	}

}
