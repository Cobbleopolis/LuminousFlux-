package com.cobbleopolis.luminousflux.inventory;

import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxBattery;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerLuxBattery extends Container {

    private TileEntityLuxBattery te;
    private int lastBurnTime;

    public ContainerLuxBattery(InventoryPlayer player, TileEntityLuxBattery te){
        this.te = te;
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

//    public void addCraftingToCrafters(ICrafting craft){
//        super.addCraftingToCrafters(craft);
//        craft.sendProgressBarUpdate(this, 0, this.te.burnTime);
//    }

//    public void detectAndSendChanges(){
//        super.detectAndSendChanges();
//        for(int i = 0; i < this.crafters.size(); ++i){
//            ICrafting craft = (ICrafting) this.crafters.get(i);
//
//            if(this.lastBurnTime != this.te.burnTime){
//                craft.sendProgressBarUpdate(this, 0, this.te.burnTime);
//            }
//        }
//
//        this.lastBurnTime = this.te.burnTime;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public void updateProgressBar(int par1, int par2){
//        if(par1 == 0){
//            this.te.burnTime = par2;
//        }
//    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.te.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slot) {
//
//		Slot slotObject = (Slot) inventorySlots.get(slot);
//		if(slotObject != null && slotObject.getHasStack()) {
//			ItemStack stackInSlot = slotObject.getStack();
//			ItemStack stack = stackInSlot.copy();
//			if(slot <= 1) {
//				if(!mergeItemStack(stackInSlot, 2, inventorySlots.size(), true))
//					return null;
//			} else if(slot != 1 && stack.itemID == ModItems.necronomicon.itemID && !getSlot(0).getHasStack()) {
//				ItemStack copy = slotObject.decrStackSize(1);
//				getSlot(0).putStack(copy);
//				return null;
//
//			} else {
//				return null;
//			}
//
//			if(stackInSlot.stackSize == 0)
//				slotObject.putStack(null);
//			else
//				slotObject.onSlotChanged();
//
//			return stack;
//		}
        return null;
    }
}
