package com.cobbleopolis.luminousflux.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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

}
