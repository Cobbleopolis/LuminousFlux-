package com.cobbleopolis.luminousflux;

import com.cobbleopolis.luminousflux.init.LFBlocks;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import java.io.File;

@Mod(modid = LuminousFlux.MODID, version = LuminousFlux.VERSION)
public class LuminousFlux
{
    public static final String MODID = "luminousflux";
    public static final String VERSION = "1.0";

	@Mod.Instance(MODID)
	public static LuminousFlux instance;

	public static CreativeTabs tabLF = new LFCreativeTab("lf");

	public static String configPath;


	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		configPath = event.getModConfigurationDirectory() + "luminousflux.cfg";
//		CofigurationBPP.init(new File(configPath));
		LFBlocks.registerBlocks();
	}

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
		System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
