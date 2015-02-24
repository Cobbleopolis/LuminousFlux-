package com.cobbleopolis.luminousflux.block;

import com.cobbleopolis.luminousflux.init.LFItems;
import com.cobbleopolis.luminousflux.item.ItemBulb;
import com.cobbleopolis.luminousflux.reference.Names;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLight;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLight extends LFBlock {

	public BlockLight() {
		super(Material.iron);
		setStepSound(this.soundTypeStone);
		setBlockName(Names.Blocks.LIGHT);
		setBlockBounds(.375f, .0F, .375F, .625f, .3125f, .625F);
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
		return new TileEntityLight();
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
						world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(LFItems.itemBulb)));
					}
					te.bulbItem = "none";
					te.markDirty();
				}
			}
		}
		return false;
	}
}
