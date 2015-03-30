package com.cobbleopolis.luminousflux.tileentity;

import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;

public class TileEntitySolarLuxGenerator extends TileEntityLuxPowered {

	@Override
	public void updateEntity() {
		super.updateEntity();
//		int lightLevel = worldObj.getFullBlockLightValue(xCoord, yCoord + 1, zCoord);
//		System.out.println(worldObj.getCelestialAngle(1.0F));
//		if(worldObj.canBlockSeeTheSky(xCoord, yCoord, zCoord) && worldObj.getCelestialAngle(1.0F) < (float) Math.PI) {
//			if (this.storedLux < this.maxLux)
//				this.storedLux = Math.min((int)(this.storedLux + Math.ceil((double) lightLevel / 10)), this.maxLux);
//		}
		if (!worldObj.provider.hasNoSky) {
			int lightLevel = worldObj.getSavedLightValue(EnumSkyBlock.Sky, xCoord, yCoord, zCoord) - worldObj.skylightSubtracted;
			float skyRotation = worldObj.getCelestialAngleRadians(1.0F);

			if (skyRotation < (float)Math.PI) {
				skyRotation += (0.0F - skyRotation) * 0.2F;
			} else {
				skyRotation += (((float)Math.PI * 2F) - skyRotation) * 0.2F;
			}

			lightLevel = Math.round((float)lightLevel * MathHelper.cos(skyRotation));

			lightLevel = Math.max(lightLevel, 0);
			lightLevel = Math.min(lightLevel, 15);

//			if (this.storedLux < this.maxLux)
				this.storedLux = Math.min((int)(this.storedLux + Math.ceil((double) lightLevel / 10)), this.maxLux);

		}

	}

}
