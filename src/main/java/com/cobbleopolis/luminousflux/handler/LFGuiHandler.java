package com.cobbleopolis.luminousflux.handler;

import com.cobbleopolis.luminousflux.gui.GuiLuxGenerator;
import com.cobbleopolis.luminousflux.inventory.ContainerLuxGenerator;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxGenerator;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class LFGuiHandler implements IGuiHandler {

	public LFGuiHandler (){

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			TileEntityLuxGenerator tileEntityFurnace = (TileEntityLuxGenerator) world.getTileEntity(x, y, z);
			return new ContainerLuxGenerator(player.inventory, tileEntityFurnace);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			TileEntityLuxGenerator tileEntityTestContainer = (TileEntityLuxGenerator) world.getTileEntity(x, y, z);
			return new GuiLuxGenerator(player.inventory, tileEntityTestContainer);
		}
		return null;
	}

}
