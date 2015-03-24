package com.cobbleopolis.luminousflux.init;

import com.cobbleopolis.luminousflux.handler.FuelHandlerLuxGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LFCrafting {
	public static void loadRecipes() {
		GameRegistry.addRecipe(new ItemStack(LFBlocks.luminousLamp), "S", "G", "C", 'S', Blocks.stone_slab, 'G', Blocks.glowstone, 'C', Blocks.cobblestone);
		GameRegistry.addRecipe(new ItemStack(LFItems.itemBulb), "GGG", "G-G", "-I-", 'G', Blocks.glass, 'I', Items.iron_ingot);
	}

	public static void loadOreRecipes() {
//		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
//				SteamCraftItem.ingotBrass, 4), true, new Object[] { "CC", "CZ",
//				'C', "ingotCopper", 'Z', "ingotZinc" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(SteamCraftItem.gear, true,
//				new Object[] { "-B-", "BSB", "-B-", 'B', "ingotBrass", 'S',
//						Items.stick }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(SteamCraftBlock.gearBox,
//				true, new Object[] { "PBP", "BGB", "PBP", 'B', "ingotBrass",
//				'P', Blocks.planks, 'G', SteamCraftItem.gear }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
//				SteamCraftItem.brassBallBearing, 16), true, new Object[] {
//				"-B-", "BBB", "-B-", 'B', "ingotBrass" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
//				SteamCraftBlock.boilerBase), true, new Object[] { "ZZZ", "ZBZ",
//				"ZZZ", 'Z', "ingotZinc", 'B', "ingotBrass" }));
//		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
//				SteamCraftBlock.boilerWall), true, new Object[] { "ZZZ", "ZCZ",
//				"ZZZ", 'Z', "ingotZinc", 'C', "ingotCopper" }));
	}

	public static void loadFurnaceRecipes() {
//		FurnaceRecipes.smelting().func_151393_a(
//				SteamCraftBlock.engineeringQuartzOre,
//				new ItemStack(SteamCraftItem.engineeringQuartz), 0.7F);
//		FurnaceRecipes.smelting().func_151393_a(SteamCraftBlock.copperOre,
//				new ItemStack(SteamCraftItem.ingotCopper), 0.7F);
//		FurnaceRecipes.smelting().func_151393_a(SteamCraftBlock.zincOre,
//				new ItemStack(SteamCraftItem.ingotZinc), 0.7F);
//		FurnaceRecipes.smelting().func_151396_a(Items.water_bucket,
//				new ItemStack(SteamCraftItem.steamBucket), 0.7F);
	}

	public static void loadLuxGeneratorFuels() {
		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(Blocks.beacon), 15);
		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(Blocks.glowstone), 15);
		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(Blocks.lit_pumpkin), 15);
		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(Blocks.redstone_lamp), 15);
		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(Blocks.torch), 14);
		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(Blocks.furnace), 13);
		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(Blocks.redstone_ore), 9);
		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(Blocks.ender_chest), 7);
		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(Blocks.redstone_torch), 7);
//		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(Blocks.brewing_stand), 1);
		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(Blocks.brown_mushroom), 1);
		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(Blocks.dragon_egg), 1);
		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(Blocks.end_portal_frame), 1);


		FuelHandlerLuxGenerator.registerFuel(Item.getItemFromBlock(LFBlocks.glowingGlass), 25);
	}

}
