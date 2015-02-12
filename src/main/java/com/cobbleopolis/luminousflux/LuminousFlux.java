package com.cobbleopolis.luminousflux;

import com.cobbleopolis.luminousflux.init.LFBlocks;
import com.cobbleopolis.luminousflux.init.LFCrafting;
import com.cobbleopolis.luminousflux.proxy.CommonProxy;
import cpw.mods.fml.common.SidedProxy;
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

	@SidedProxy(clientSide = "com.cobbleopolis.luminousflux.proxy.ClientProxy", serverSide = "com.cobbleopolis.luminousflux.proxy.CommonProxy")
	public static CommonProxy proxy;


	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		configPath = event.getModConfigurationDirectory() + "luminousflux.cfg";
//		CofigurationBPP.init(new File(configPath));
		System.out.println("Registering Luminous Flux Blocks...");
		LFBlocks.registerBlocks();
		System.out.println("Finished Registering Luminous Flux Blocks");
		System.out.println("Registering Luminous Flux Tile Entities...");
		LFBlocks.registerTileEntity();
		System.out.println("Finished Registering Luminous Flux Tile Entities");
		System.out.println("Registering Luminous Flux Crafting Recipes...");
		LFCrafting.loadRecipes();
		System.out.println("Finished Registering Luminous Flux Crafting Recipes...");
	}

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		proxy.registerRenderers();
		System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
