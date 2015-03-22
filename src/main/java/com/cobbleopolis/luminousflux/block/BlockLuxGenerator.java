package com.cobbleopolis.luminousflux.block;

import com.cobbleopolis.luminousflux.LuminousFlux;
import com.cobbleopolis.luminousflux.reference.Names;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockLuxGenerator extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon bottom;

	private final Random random = new Random();

	public BlockLuxGenerator() {
		super(Material.rock);
		setCreativeTab(LuminousFlux.tabLF);
		setBlockName(Names.Blocks.LUX_GENERATOR);
		setStepSound(this.soundTypeStone);
		setHardness(3.5F);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(LuminousFlux.MODID + ":luxGeneratorSide");
//		this.bottom = iconRegister.registerIcon(LuminousFlux.MODID + ":luxGeneratorBottom");
		this.top = iconRegister.registerIcon(LuminousFlux.MODID + ":luxGeneratorTop");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (side == 0 || side == 1)
			return top;
		else
			return blockIcon;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		player.openGui(LuminousFlux.instance, 0, world, x, y, z);
		return true;
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityLuxGenerator();
	}


	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
//		this.direction(world, x, y, z);
	}

//	private void direction(World world, int x, int y, int z) {
//		if (!world.isRemote) {
//			Block direction = world.getBlock(x, y, z - 1);
//			Block direction1 = world.getBlock(x, y, z + 1);
//			Block direction2 = world.getBlock(x - 1, y, z);
//			Block direction3 = world.getBlock(x + 1, y, z);
//			byte byte0 = 3;
//
//			if (direction.func_149730_j() && direction.func_149730_j()) {
//				byte0 = 3;
//			}
//
//			if (direction1.func_149730_j() && direction1.func_149730_j()) {
//				byte0 = 2;
//			}
//
//			if (direction2.func_149730_j() && direction2.func_149730_j()) {
//				byte0 = 5;
//			}
//
//			if (direction3.func_149730_j() && direction3.func_149730_j()) {
//				byte0 = 4;
//			}
//
//			world.setBlockMetadataWithNotify(x, y, z, byte0, 2);
//		}
//	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
//		int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
//
//		if (direction == 0) {
//			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
//		}
//
//		if (direction == 1) {
//			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
//		}
//
//		if (direction == 2) {
//			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
//		}
//
//		if (direction == 3) {
//			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
//		}

		if (itemstack.hasDisplayName()) {
			((TileEntityLuxGenerator) world.getTileEntity(x, y, z)).furnaceName(itemstack.getDisplayName());
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityLuxGenerator tileEntityLuxGenerator = (TileEntityLuxGenerator) world.getTileEntity(x, y, z);

		if (tileEntityLuxGenerator != null) {
			for (int i = 0; i < tileEntityLuxGenerator.getSizeInventory(); ++i) {
				ItemStack itemstack = tileEntityLuxGenerator.getStackInSlot(i);

				if (itemstack != null) {
					float f = this.random.nextFloat() * 0.6F + 0.1F;
					float f1 = this.random.nextFloat() * 0.6F + 0.1F;
					float f2 = this.random.nextFloat() * 0.6F + 0.1F;

					while (itemstack.stackSize > 0) {
						int j = this.random.nextInt(21) + 10;

						if (j > itemstack.stackSize) {
							j = itemstack.stackSize;
						}

						itemstack.stackSize -= j;
						EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
						}

						float f3 = 0.025F;
						entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
						entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
						entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
						world.spawnEntityInWorld(entityitem);
					}
				}
			}
			world.func_147453_f(x, y, z, block);
		}

		super.breakBlock(world, x, y, z, block, meta);
	}

//	@SideOnly(Side.CLIENT)
//	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
//		if (this.isBurning) {
//			int l = world.getBlockMetadata(x, y, z);
//			float f = (float) x + 0.5F;
//			float f1 = (float) y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
//			float f2 = (float) z + 0.5F;
//			float f3 = 0.52F;
//			float f4 = random.nextFloat() * 0.6F - 0.3F;
//
//			if (l == 4) {
//				world.spawnParticle("smoke", (double) (f - f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
//				world.spawnParticle("flame", (double) (f - f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
//			} else if (l == 5) {
//				world.spawnParticle("smoke", (double) (f + f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
//				world.spawnParticle("flame", (double) (f + f3), (double) f1, (double) (f2 + f4), 0.0D, 0.0D, 0.0D);
//			} else if (l == 2) {
//				world.spawnParticle("smoke", (double) (f + f4), (double) f1, (double) (f2 - f3), 0.0D, 0.0D, 0.0D);
//				world.spawnParticle("flame", (double) (f + f4), (double) f1, (double) (f2 - f3), 0.0D, 0.0D, 0.0D);
//			} else if (l == 3) {
//				world.spawnParticle("smoke", (double) (f + f4), (double) f1, (double) (f2 + f3), 0.0D, 0.0D, 0.0D);
//				world.spawnParticle("flame", (double) (f + f4), (double) f1, (double) (f2 + f3), 0.0D, 0.0D, 0.0D);
//			}
//		}
//	}
}
