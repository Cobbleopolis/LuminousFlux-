package com.cobbleopolis.luminousflux.block;

import com.cobbleopolis.luminousflux.LuminousFlux;
import com.cobbleopolis.luminousflux.init.LFItems;
import com.cobbleopolis.luminousflux.reference.Gui;
import com.cobbleopolis.luminousflux.reference.Names;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
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

public class BlockLuxGenerator extends LFBlock {

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon bottom;

	private final Random random = new Random();

	public BlockLuxGenerator() {
		super(Material.rock);
		setBlockName(Names.Blocks.LUX_GENERATOR);
		setStepSound(soundTypeStone);
		setHardness(3.5F);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(LuminousFlux.MODID + ":luxGeneratorSide");
		this.top = iconRegister.registerIcon(LuminousFlux.MODID + ":luxGeneratorTop");
		this.bottom = iconRegister.registerIcon(LuminousFlux.MODID + ":luxGeneratorBottom");

	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (side == 0)
			return bottom;
		else if(side == 1)
			return top;
		else
			return blockIcon;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (player.getHeldItem() != null) {
			if (player.getHeldItem().getItem().equals(LFItems.itemWiringTool)) {
				return false;
			}
		}

		player.openGui(LuminousFlux.instance, Gui.LUX_GENERATOR, world, x, y, z);
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
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
		if (itemstack.hasDisplayName()) {
			((TileEntityLuxGenerator) world.getTileEntity(x, y, z)).furnaceName(itemstack.getDisplayName());
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (world.getTileEntity(x, y, z) != null) {
			if (world.getTileEntity(x, y, z) instanceof TileEntityLuxGenerator) {

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
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}
}
