package com.cobbleopolis.luminousflux.item;

import com.cobbleopolis.luminousflux.reference.Names;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxPowered;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemWiringTool extends LFItem {

    public ItemWiringTool() {
        super();
        setUnlocalizedName(Names.Items.WIRING_TOOL);
        setMaxStackSize(1);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world,
                             // which block was in the target when clicked
                             int x, int y, int z,
                             // where on the target block was clicked (0.0-1.0)
                             int side, float blockx, float blocky, float blockz) {
        TileEntityLuxPowered te = (TileEntityLuxPowered) world.getTileEntity(x, y, z);
        if (!world.isRemote && te != null) {
            if(player.isSneaking()){
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setInteger("xFrom", x);
                nbt.setInteger("yFrom", y);
                nbt.setInteger("zFrom", z);
                itemStack.setTagCompound(nbt);
            } else {
                NBTTagCompound nbt = itemStack.getTagCompound();
                if(nbt != null) {
                    TileEntityLuxPowered teSender = (TileEntityLuxPowered) world.getTileEntity(nbt.getInteger("xFrom"), nbt.getInteger("yFrom"), nbt.getInteger("zFrom"));
                    if(teSender != null) {
//                        System.out.println(te.xCoord + " " + teSender.xCoord);
//                        System.out.println(te.yCoord + " " + teSender.yCoord);
//                        System.out.println(te.zCoord + " " + teSender.zCoord);
                        if(te.xCoord != teSender.xCoord || te.yCoord != teSender.yCoord || te.zCoord != teSender.zCoord) {
                            int[] block = {x, y, z};
                            teSender.blocksToPower.add(block);
                            itemStack.setTagCompound(null);
                        }
                    } else {
                        System.out.println("Whoops.. " + nbt.getInteger("xFrom") + " " + nbt.getInteger("yFrom") + " " + nbt.getInteger("zFrom"));
                    }
                } else {
                    System.out.println("Whoops.");
                }
            }
        }
        return true;
    }
}
