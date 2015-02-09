package com.cobbleopolis.luminousflux.block;

import com.cobbleopolis.luminousflux.init.LFBlocks;
import com.cobbleopolis.luminousflux.reference.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;

public class BlockLuminousLamp extends LFBlock{
	public BlockLuminousLamp() {
		super(Material.glass);
		setStepSound(this.soundTypeGlass);
		setBlockName(Names.Blocks.LUMINOUS_LAMP);
		setLightLevel(1F);
		setLightOpacity(0);

	}

	@Override
	public boolean isOpaqueCube(){
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}


	/**
	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	 * coordinates.  Args: blockAccess, x, y, z, side
	 */
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
