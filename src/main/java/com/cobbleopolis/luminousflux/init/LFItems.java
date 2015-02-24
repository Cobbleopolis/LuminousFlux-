package com.cobbleopolis.luminousflux.init;

import com.cobbleopolis.luminousflux.item.ItemBulb;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class LFItems {
	public static Item itemBulb = new ItemBulb();

	public static void registerItems(){
		GameRegistry.registerItem(itemBulb,
				itemBulb.getUnlocalizedName());
	}
}
