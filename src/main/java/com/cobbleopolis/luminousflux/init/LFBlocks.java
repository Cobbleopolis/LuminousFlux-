package com.cobbleopolis.luminousflux.init;


import com.cobbleopolis.luminousflux.block.BlockLuminousLamp;
import com.cobbleopolis.luminousflux.block.BlockTest;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuminousLamp;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class LFBlocks {
	public static Block luminousLamp = new BlockLuminousLamp();
	public static Block test = new BlockTest();

	public static void registerBlocks(){
		GameRegistry.registerBlock(luminousLamp,
				luminousLamp.getUnlocalizedName());
		GameRegistry.registerBlock(test,
				test.getUnlocalizedName());
	}

	public static void registerTileEntity() {

		GameRegistry.registerTileEntity(TileEntityLuminousLamp.class, "tileentity." + luminousLamp.getUnlocalizedName());

	}
}
