package com.cobbleopolis.luminousflux.inventory; //ContainerLuxGenerator

import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;

public class ContainerLuxGenerator extends Container {

	private TileEntityLuxGenerator te;
	private int lastBurnTime;

	public ContainerLuxGenerator(InventoryPlayer player, TileEntityLuxGenerator te){
		this.te = te;
		this.addSlotToContainer(new Slot(te, 0, 80, 41));
		int i;

		for(i = 0; i < 3; ++i){
			for(int j = 0; j < 9; ++j){
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(i = 0; i < 9; ++i){
			this.addSlotToContainer(new Slot(player, i , 8 + i * 18 , 142));
		}
	}

	public void addCraftingToCrafters(ICrafting craft){
		super.addCraftingToCrafters(craft);
		craft.sendProgressBarUpdate(this, 0, this.te.burnTime);
	}

	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); ++i){
			ICrafting craft = (ICrafting) this.crafters.get(i);

			if(this.lastBurnTime != this.te.burnTime){
				craft.sendProgressBarUpdate(this, 0, this.te.burnTime);
			}
		}

		this.lastBurnTime = this.te.burnTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2){
		if(par1 == 0){
			this.te.burnTime = par2;
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.te.isUseableByPlayer(player);
	}

//	@Override
//	public ItemStack transferStackInSlot(EntityPlayer player, int par2){
//		ItemStack itemstack = null;
//		Slot slot = (Slot) this.inventorySlots.get(par2);
//
//		if(slot != null && slot.getHasStack()){
//			ItemStack itemstack1 = slot.getStack();
//			itemstack = itemstack1.copy();
//
//			if(par2 == 2){
//				if(!this.mergeItemStack(itemstack1, 3, 39, true)){
//					return null;
//				}
//				slot.onSlotChange(itemstack1, itemstack);
//			}else if(par2 != 1 && par2 != 0){
//				if(CraftingLuxGenerator.smelting().getSmeltingResult(itemstack1) != null){
//					if(!this.mergeItemStack(itemstack1, 0, 1, false)){
//						return null;
//					}
//				}else if(TileEntityLuxGenerator.isItemFuel(itemstack1)){
//					if(!this.mergeItemStack(itemstack1, 1, 2, false)){
//						return null;
//					}
//				}else if(par2 >=3 && par2 < 30){
//					if(!this.mergeItemStack(itemstack1, 30, 39, false)){
//						return null;
//					}
//				}else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
//					return null;
//				}
//			}else if(!this.mergeItemStack(itemstack1, 3, 39, false)){
//				return null;
//			}
//			if(itemstack1.stackSize == 0){
//				slot.putStack((ItemStack)null);
//			}else{
//				slot.onSlotChanged();
//			}
//			if(itemstack1.stackSize == itemstack.stackSize){
//				return null;
//			}
//			slot.onPickupFromSlot(player, itemstack1);
//		}
//		return itemstack;
//	}

}