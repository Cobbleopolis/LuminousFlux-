package com.cobbleopolis.luminousflux.block;


import com.cobbleopolis.luminousflux.LuminousFlux;
import com.cobbleopolis.luminousflux.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class LFBlock extends Block {

	protected LFBlock(Material material) {
		super(material);
		setCreativeTab(LuminousFlux.tabLF);
		setBlockTextureName(LuminousFlux.MODID + ":" + getUnlocalizedName());
	}

	@Override
	public String getUnlocalizedName() {
		return getUnwrappedUnlocalizedName(super.getUnlocalizedName());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(String.format("%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

}
