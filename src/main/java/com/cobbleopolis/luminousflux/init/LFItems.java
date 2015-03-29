package com.cobbleopolis.luminousflux.init;

import com.cobbleopolis.luminousflux.item.ItemBulb;
import com.cobbleopolis.luminousflux.item.ItemLuxMeter;
import com.cobbleopolis.luminousflux.item.ItemWiringTool;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class LFItems {
	public static Item itemBulb = new ItemBulb();
	public static Item itemWiringTool = new ItemWiringTool();
	public static Item itemLuxMeter = new ItemLuxMeter();

	public static void registerItems(){
		GameRegistry.registerItem(itemBulb,
				itemBulb.getUnlocalizedName());
        GameRegistry.registerItem(itemWiringTool,
				itemWiringTool.getUnlocalizedName());
		GameRegistry.registerItem(itemLuxMeter,
				itemLuxMeter.getUnlocalizedName());
	}
}
