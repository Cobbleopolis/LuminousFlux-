package com.cobbleopolis.luminousflux.handler;

import net.minecraft.item.Item;

import java.util.HashMap;

public class FuelHandlerLuxGenerator {

	private static HashMap<String, Integer> fuelList = new HashMap<String, Integer>();

	public static void registerFuel(Item item, int value){
		fuelList.put(item.getUnlocalizedName(), value);
	}

	public static void removeRegisteredFuel(Item item){
		fuelList.remove(item.getUnlocalizedName());
	}

	public static int getItemFuelValue(Item item){
		if(fuelList.containsKey(item.getUnlocalizedName())) {
//			((Item) Item.itemRegistry.getObject(item.getUnlocalizedName())).in
			return fuelList.get(item.getUnlocalizedName());
		} else {
			return 0;
		}
	}
}
