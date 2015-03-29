package com.cobbleopolis.luminousflux.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

public class TileEntityLight extends TileEntityLuxPowered {

	public String bulbItem = "none";
	public int direction = 0;
	public int lightLevel = 15;

	public TileEntityLight(){
		super();
		this.storedLux = 0;
		this.maxLux = 100;
		this.outputRate = 25;
	}

	@Override
	public void updateEntity() {
		doesBlockNeedRenderUpdate();
		if(canEmitLight())
			this.storedLux = Math.max(0, this.storedLux - (this.lightLevel / 10));
	}

	public boolean canEmitLight(){
		return worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && !bulbItem.equalsIgnoreCase("none") && this.storedLux >= (this.lightLevel / 10);
	}

	private void doesBlockNeedRenderUpdate(){
		if(canEmitLight()) {
			if(worldObj.getBlock(xCoord, yCoord, zCoord).getLightValue() != lightLevel) {
				worldObj.markBlockRangeForRenderUpdate(this.xCoord, this.yCoord, this.zCoord, this.xCoord, this.yCoord, this.zCoord);
				this.markDirty();
			}
		} else {
			if(worldObj.getBlock(xCoord, yCoord, zCoord).getLightValue() != 0) {
				worldObj.markBlockRangeForRenderUpdate(this.xCoord, this.yCoord, this.zCoord, this.xCoord, this.yCoord, this.zCoord);
				this.markDirty();
			}
		}
	}

	//Tile Entity

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setString("bulbItem", bulbItem);
		par1.setInteger("direction", direction);
		par1.setInteger("lightLevel", lightLevel);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		this.bulbItem = par1.getString("bulbItem");
		this.direction = par1.getInteger("direction");
		this.lightLevel = par1.getInteger("lightLevel");
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
