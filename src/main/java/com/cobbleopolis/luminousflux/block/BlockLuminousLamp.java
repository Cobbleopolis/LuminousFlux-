package com.cobbleopolis.luminousflux.block;

import com.cobbleopolis.luminousflux.reference.Names;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuminousLamp;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
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

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
        return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileEntityLuminousLamp();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if(player.isSneaking())
			world.getBlock(x, y, z).setLightLevel(1F);
		else
			world.getBlock(x, y, z).setLightLevel(0F);
		return false;
	}
}
