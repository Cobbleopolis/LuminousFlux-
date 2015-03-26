package com.cobbleopolis.luminousflux.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
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

	public boolean isEnergyBufferFull() {
		return storedLux >= maxLux;
	}

	public void sendLuxPacket(TileEntityLuxPowered te, int packetSize) {
		this.storedLux -= packetSize;
		te.storedLux += packetSize;
	}

	public boolean canReceiveEnergyPacket(World world, int x, int y, int z, int packetSize) {
		if (world.getTileEntity(x, y, z) instanceof TileEntityLuxPowered) {
			TileEntityLuxPowered te = (TileEntityLuxPowered) world.getTileEntity(x, y, z);
			return te.storedLux + packetSize <= maxLux;
		} else {
			return false;
		}
	}

	public boolean canReceiveEnergyPacket(int packetSize) {
		return this.storedLux + packetSize <= this.maxLux;
	}

	@Override
	public void updateEntity() {
		ArrayList<int[]> remove = new ArrayList<>();
		if (blocksToPower.size() > 0 && this.storedLux >= this.outputRate * this.blocksToPower.size())
			for (int[] i : blocksToPower) {
				if (worldObj.getTileEntity(i[0], i[1], i[2]) instanceof TileEntityLuxPowered) {
					TileEntityLuxPowered te = (TileEntityLuxPowered) worldObj.getTileEntity(i[0], i[1], i[2]);
					if (te != null) {
						if (te.canReceiveEnergyPacket(outputRate) && this.storedLux >= outputRate) {
							int send = Math.min(this.storedLux, outputRate);
							this.sendLuxPacket(te, send);
							worldObj.markBlockForUpdate(i[0], i[1], i[2]);
							te.markDirty();
							worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
							this.markDirty();
						}
					}
				} else {
//					System.out.println(this.blocksToPower.indexOf(i));
					remove.add(i);
				}

			}
		for(int[] i : remove)
			this.blocksToPower.remove(i);
		remove.clear();
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		this.storedLux = tagCompound.getInteger("storedLux");
		this.maxLux = tagCompound.getInteger("maxLux");

		NBTTagList tagList = tagCompound.getTagList("blocksToPower", 10);
		this.blocksToPower.clear();

		for (int i = 0; i < tagList.tagCount(); ++i) {
			NBTTagCompound tabCompound1 = tagList.getCompoundTagAt(i);
			int x = tabCompound1.getInteger("x");
			int y = tabCompound1.getInteger("y");
			int z = tabCompound1.getInteger("z");

			int[] block = {x, y, z};
			this.blocksToPower.add(block);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setInteger("storedLux", this.storedLux);
		tagCompound.setInteger("maxLux", this.maxLux);

		NBTTagList tagList = new NBTTagList();

		for (int[] i : this.blocksToPower) {
			if (i != null) {
				NBTTagCompound tagCompound1 = new NBTTagCompound();
				tagCompound1.setInteger("x", i[0]);
				tagCompound1.setInteger("y", i[1]);
				tagCompound1.setInteger("z", i[2]);
				tagList.appendTag(tagCompound1);
			}
		}

		tagCompound.setTag("blocksToPower", tagList);
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
