package com.cobbleopolis.luminousflux.item;

import com.cobbleopolis.luminousflux.LuminousFlux;
import com.cobbleopolis.luminousflux.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LFItem extends Item {
	protected LFItem(){
		super();
		setCreativeTab(LuminousFlux.tabLF);
		setTextureName(LuminousFlux.MODID + ":" + getUnlocalizedName());
	}

	@Override
	public String getUnlocalizedName() {
		return getUnwrappedUnlocalizedName(super.getUnlocalizedName());
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}
