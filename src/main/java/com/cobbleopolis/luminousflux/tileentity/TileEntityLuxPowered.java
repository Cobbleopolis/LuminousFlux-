package com.cobbleopolis.luminousflux.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

public class TileEntityLuxPowered extends TileEntity {

	public int storedLux;
	public int maxLux;

	public int outputRate;

	public ArrayList<int[]> blocksToPower = new ArrayList<>();

	public boolean isEnergyBufferFull(){
		return storedLux >= maxLux;
	}

	public void sendLuxPacket(TileEntityLuxPowered te, int packetSize){
		this.storedLux -= packetSize;
		te.storedLux += packetSize;
	}

	public boolean canReceiveEnergyPacket(World world, int x, int y, int z, int packetSize) {
		if(world.getTileEntity(x, y, z) instanceof TileEntityLuxPowered) {
			TileEntityLuxPowered te = (TileEntityLuxPowered) world.getTileEntity(x, y, z);
			return te.storedLux + packetSize <= maxLux;
		} else {
			return false;
		}
	}

	public boolean canReceiveEnergyPacket(TileEntityLuxPowered te, int packetSize) {
		if(te instanceof TileEntityLuxPowered) {
			return te.storedLux + packetSize <= maxLux;
		} else {
			return false;
		}
	}

	@Override
	public void updateEntity(){
		for(int[] i : blocksToPower){
			TileEntityLuxPowered te = (TileEntityLuxPowered) worldObj.getTileEntity(i[0], i[1], i[2]);
			if(this.canReceiveEnergyPacket(te, outputRate) && this.storedLux >= outputRate) {
				int send = Math.min(this.storedLux, outputRate);
				this.sendLuxPacket(te, send);
			}
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		this.storedLux = tagCompound.getInteger("storedLux");
		this.maxLux = tagCompound.getInteger("maxLux");
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setInteger("storedLux", this.storedLux);
		tagCompound.setInteger("maxLux", this.maxLux);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}
