package com.cobbleopolis.luminousflux.init;


import com.cobbleopolis.luminousflux.block.BlockLight;
import com.cobbleopolis.luminousflux.block.BlockLuminousLamp;
import com.cobbleopolis.luminousflux.block.BlockGlowingGlass;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLight;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuminousLamp;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class LFBlocks {
	public static Block luminousLamp = new BlockLuminousLamp();
	public static Block glowingGlass = new BlockGlowingGlass();
	public static Block light = new BlockLight();

	public static void registerBlocks(){
		GameRegistry.registerBlock(luminousLamp,
				luminousLamp.getUnlocalizedName());
		GameRegistry.registerBlock(glowingGlass,
				glowingGlass.getUnlocalizedName());
		GameRegistry.registerBlock(light,
				light.getUnlocalizedName());
	}

	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityLuminousLamp.class, "tileentity." + luminousLamp.getUnlocalizedName());
		GameRegistry.registerTileEntity(TileEntityLight.class, "tileentity." + light.getUnlocalizedName());

	}
}
