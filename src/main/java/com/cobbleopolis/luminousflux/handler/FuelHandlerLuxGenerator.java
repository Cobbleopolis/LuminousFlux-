package com.cobbleopolis.luminousflux.handler;

import net.minecraft.item.Item;

import java.util.HashMap;

public class FuelHandlerLuxGenerator {

	private static HashMap<String, int[]> fuelList = new HashMap<>();

	/**
	 * Registers a fuel with the Lux Generator fuel handler
	 * @param item The item to register
	 * @param value An array that contains the amount of lux generated per tick and for how many ticks (in that order)
	 */
	public static void registerFuel(Item item, int[] value){
		fuelList.put(item.getUnlocalizedName(), value);
	}

	public static void removeRegisteredFuel(Item item){
		fuelList.remove(item.getUnlocalizedName());
	}

	public static int[] getItemFuelValue(Item item){
		if(fuelList.containsKey(item.getUnlocalizedName())) {
//			((Item) Item.itemRegistry.getObject(item.getUnlocalizedName())).in
			return fuelList.get(item.getUnlocalizedName());
		} else {
			return new int[]{0, 0};
		}
	}
}
