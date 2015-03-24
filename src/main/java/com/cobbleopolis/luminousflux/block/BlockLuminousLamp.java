package com.cobbleopolis.luminousflux.block;

import com.cobbleopolis.luminousflux.reference.Names;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuminousLamp;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLuminousLamp extends LFBlock {
	public BlockLuminousLamp() {
		super(Material.glass);
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
}
