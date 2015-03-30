package com.cobbleopolis.luminousflux.block;


import com.cobbleopolis.luminousflux.LuminousFlux;
import com.cobbleopolis.luminousflux.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class LFBlock extends BlockContainer {

	public LFBlock(Material material) {
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

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return null;
	}
}
