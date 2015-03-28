package com.cobbleopolis.luminousflux.block;

import com.cobbleopolis.luminousflux.init.LFItems;
import com.cobbleopolis.luminousflux.item.ItemBulb;
import com.cobbleopolis.luminousflux.reference.Names;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLight;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLightFixture extends LFBlock {

	int d = 0;

	public BlockLightFixture() {
		super(Material.iron);
		setStepSound(soundTypeStone);
		setBlockName(Names.Blocks.LIGHT);
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
		TileEntityLight te = new TileEntityLight();
		te.direction = d;
		return te;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (world.getTileEntity(x, y, z) instanceof TileEntityLight) {
			TileEntityLight te = (TileEntityLight) world.getTileEntity(x, y, z);
			if (!player.isSneaking()) {
				if (player.getHeldItem() != null) {
					if (player.getHeldItem().getItem() instanceof ItemBulb && te.bulbItem.equalsIgnoreCase("none")) {
						te.bulbItem = player.getHeldItem().getItem().getUnlocalizedName();

						if (!player.capabilities.isCreativeMode)
							player.getHeldItem().stackSize = player.getHeldItem().stackSize - 1;
					}
				}
			} else {
				if (!te.bulbItem.equalsIgnoreCase("none")) {
					if (!world.isRemote) {
//						if(player.getHeldItem() != null)
							if(player.getHeldItem().getItem() != LFItems.itemWiringTool)
								world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(LFItems.itemBulb)));
					}
					te.bulbItem = "none";
					te.markDirty();
				}
			}
		}
		return false;
	}

	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
	 */
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
		int j1 = metadata;

		if (side == 0) {
			j1 = 6;
		}
		if (side == 1) {
			j1 = 5;
		}

		if (side == 2) {
			j1 = 4;
		}

		if (side == 3) {
			j1 = 3;
		}

		if (side == 4) {
			j1 = 2;
		}

		if (side == 5) {
			j1 = 1;
		}

		d = j1;
		return j1;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess iba, int x, int y, int z) {
		TileEntityLight te = (TileEntityLight) iba.getTileEntity(x, y, z);
		switch (te.direction) {
			case 1: //WEST
				if (!te.bulbItem.equalsIgnoreCase("none"))
					this.setBlockBounds(0f, .375f, .375f, .3125f, .625f, .625f);
				else
					this.setBlockBounds(0f, .375f, .375f, .0625f, .625f, .625f);
				break;
			case 2: //EAST
				if (!te.bulbItem.equalsIgnoreCase("none"))
					this.setBlockBounds(.6875f, .375f, .375f, 1f, .625f, .625f);
				else
					this.setBlockBounds(.9375f, .375f, .375f, 1f, .625f, .625f);
				break;
			case 3: //NORTH
				if (!te.bulbItem.equalsIgnoreCase("none"))
					this.setBlockBounds(.375f, .375f, 0f, .625f, .625f, .3125f);
				else
					this.setBlockBounds(.375f, .375f, 0f, .625f, .625f, .0625f);
				break;
			case 4: //SOUTH
				if (!te.bulbItem.equalsIgnoreCase("none"))
					this.setBlockBounds(.375f, .375f, .6875f, .625f, .625f, 1f);
				else
					this.setBlockBounds(.375f, .375f, .9375f, .625f, .625f, 1f);
				break;
			case 5: //DOWN
				if (!te.bulbItem.equalsIgnoreCase("none"))
					this.setBlockBounds(.375f, 0f, .375f, .625f, .3125f, .625f);
				else
					this.setBlockBounds(.375f, 0f, .375f, .625f, .0625f, .625f);
				break;
			case 6: //UP
				if (!te.bulbItem.equalsIgnoreCase("none"))
					this.setBlockBounds(.375f, .6875f, .375f, .625f, 1f, .625f);
				else
					this.setBlockBounds(.375f, .9375f, .375f, .625f, 1f, .625f);
				break;
		}
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		world.markBlockForUpdate(x, y, z);
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		TileEntityLight te = (TileEntityLight) world.getTileEntity(x, y, z);
		if(te.getWorldObj().isBlockIndirectlyGettingPowered(x, y, z))
			return 15;
		return 0;
	}
}
