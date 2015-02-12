package com.cobbleopolis.luminousflux.block;

import com.cobbleopolis.luminousflux.LuminousFlux;
import com.cobbleopolis.luminousflux.init.LFBlocks;
import com.cobbleopolis.luminousflux.reference.Names;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuminousLamp;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLuminousLamp extends BlockContainer {
	public BlockLuminousLamp() {
		super(Material.glass);
		setCreativeTab(LuminousFlux.tabLF);
		setStepSound(this.soundTypeStone);
		setBlockName(Names.Blocks.LUMINOUS_LAMP);
		setLightLevel(1F);
		setLightOpacity(0);
		setBlockBounds(.25F, .0F, .25F, .75F, .875F, .75F);

	}

	//You don't want the normal render type, or it wont render properly.
	@Override
	public int getRenderType() {
		return -1;
	}

	//It's not an opaque cube, so you need this.
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	//It's not a normal block, so you need this too.
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityLuminousLamp();
	}

//	@Override
//	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
//		return null;
//	}


//	/**
//	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
//	 * coordinates.  Args: blockAccess, x, y, z, side
//	 */
//	@SideOnly(Side.CLIENT)
//	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
//	{
//		Block block = blockAccess.getBlock(x, y, z);
//
//		if (this == LFBlocks.luminousLamp)
//		{
//			if (blockAccess.getBlockMetadata(x, y, z) != blockAccess.getBlockMetadata(x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side]))
//			{
//				return true;
//			}
//
//			if (block == this)
//			{
//				return false;
//			}
//		}
//
//		return block != this && super.shouldSideBeRendered(blockAccess, x, y, z, side);
//	}
}
