package com.cobbleopolis.luminousflux.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLight extends TileEntityLuxPowered {

	public String bulbItem = "none";
	public int direction = 0;

	public TileEntityLight(){
		super();
	}

	@Override
	public void updateEntity() {
		if (!bulbItem.equalsIgnoreCase("none")) {
			worldObj.getBlock(xCoord, xCoord, xCoord).setBlockBounds(.375f, .0F, .375F, .625f, .3125f, .625F);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setString("bulbItem", bulbItem);
		par1.setInteger("direction", direction);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		this.bulbItem = par1.getString("bulbItem");
		this.direction = par1.getInteger("direction");
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}
