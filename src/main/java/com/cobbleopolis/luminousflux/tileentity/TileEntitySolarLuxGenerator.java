package com.cobbleopolis.luminousflux.tileentity;

public class TileEntitySolarLuxGenerator extends TileEntityLuxPowered {

	public TileEntitySolarLuxGenerator(){
		super();
		this.storedLux = 0;
		this.maxLux = 1000;
		this.outputRate = 1;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();


		if (!worldObj.provider.hasNoSky && worldObj.getWorldTime() > 12000 && worldObj.getWorldTime() % 5 == 0) {
			int lightLevel = worldObj.getBlockLightValue(xCoord, yCoord + 1, zCoord);
			storedLux = Math.min(storedLux + (int)Math.floor((double) lightLevel / 5), this.maxLux);

		}

	}

}
