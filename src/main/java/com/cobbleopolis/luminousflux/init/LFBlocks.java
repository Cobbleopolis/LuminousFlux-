package com.cobbleopolis.luminousflux.init;


import com.cobbleopolis.luminousflux.block.BlockLuminousLamp;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class LFBlocks {
	public static Block luminousLamp = new BlockLuminousLamp();

	public static void registerBlocks(){
		GameRegistry.registerBlock(luminousLamp,
				luminousLamp.getUnlocalizedName());
	}

	public static void registerTileEntity() {

	}
}
