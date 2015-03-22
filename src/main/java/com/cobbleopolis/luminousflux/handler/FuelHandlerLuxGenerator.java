package com.cobbleopolis.luminousflux.handler;

import net.minecraft.item.Item;

import java.util.HashMap;

public class FuelHandlerLuxGenerator {

	private static HashMap<String, Integer> fuelList = new HashMap<String, Integer>();

	public static void registerFuel(Item item, int value){
		fuelList.put(item.getUnlocalizedName(), value);
	}

	public static int getItemFuelValue(Item item){
		return fuelList.get(item.getUnlocalizedName());
	}
}
