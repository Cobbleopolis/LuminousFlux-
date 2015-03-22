package com.cobbleopolis.luminousflux.init;


import com.cobbleopolis.luminousflux.block.BlockGlowingGlass;
import com.cobbleopolis.luminousflux.block.BlockLightFixture;
import com.cobbleopolis.luminousflux.block.BlockLuminousLamp;
import com.cobbleopolis.luminousflux.block.BlockLuxGenerator;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLight;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuminousLamp;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class LFBlocks {
	public static Block luminousLamp = new BlockLuminousLamp();
	public static Block glowingGlass = new BlockGlowingGlass();
	public static Block lightFixture = new BlockLightFixture();
	public static Block luxGenerator = new BlockLuxGenerator();
//	public static Block luxGeneratorActive = new BlockLuxGenerator(true);

	public static void registerBlocks(){
		GameRegistry.registerBlock(luminousLamp,
				luminousLamp.getUnlocalizedName());
		GameRegistry.registerBlock(glowingGlass,
				glowingGlass.getUnlocalizedName());
		GameRegistry.registerBlock(lightFixture,
				lightFixture.getUnlocalizedName());
		GameRegistry.registerBlock(luxGenerator,
				luxGenerator.getUnlocalizedName());
//		GameRegistry.registerBlock(luxGeneratorActive,
//				luxGeneratorActive.getUnlocalizedName());
	}

	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityLuminousLamp.class, "tileentity." + luminousLamp.getUnlocalizedName());
		GameRegistry.registerTileEntity(TileEntityLight.class, "tileentity." + lightFixture.getUnlocalizedName());
		GameRegistry.registerTileEntity(TileEntityLuxGenerator.class, "tileentity." + luxGenerator.getUnlocalizedName());
	}
}
