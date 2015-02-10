package com.cobbleopolis.luminousflux.block;

import com.cobbleopolis.luminousflux.init.LFBlocks;
import com.cobbleopolis.luminousflux.reference.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;

public class BlockGlowingGlass extends LFBlock {
	public BlockGlowingGlass() {
		super(Material.glass);
		setStepSound(this.soundTypeGlass);
		setBlockName(Names.Blocks.GLOWING_GLASS);
		setLightLevel(1F);
		setLightOpacity(0);
	}

	//You don't want the normal render type, or it wont render properly.
	@Override
	public int getRenderBlockPass() {
		return 1;
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



	/**
	 //	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	 //	 * coordinates.  Args: blockAccess, x, y, z, side
	 //	 */
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		Block block = blockAccess.getBlock(x, y, z);

		if (this == LFBlocks.luminousLamp)
		{
			if (blockAccess.getBlockMetadata(x, y, z) != blockAccess.getBlockMetadata(x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side]))
			{
				return true;
			}

			if (block == this)
			{
				return false;
			}
		}

		return block != this && super.shouldSideBeRendered(blockAccess, x, y, z, side);
	}
}
