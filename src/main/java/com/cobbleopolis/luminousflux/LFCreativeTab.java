package com.cobbleopolis.luminousflux;

import com.cobbleopolis.luminousflux.init.LFBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LFCreativeTab extends CreativeTabs {


	public LFCreativeTab(String lable) {
		super(lable);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return new ItemStack(LFBlocks.luminousLamp).getItem();
	}

}
