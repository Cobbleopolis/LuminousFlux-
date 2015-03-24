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
        if (!world.isRemote && te instanceof TileEntityLuxPowered) {
            if(player.isSneaking()){
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setInteger("xFrom", x);
                nbt.setInteger("yFrom", y);
                nbt.setInteger("zFrom", z);
                itemStack.writeToNBT(nbt);
            } else {

            }
        }
        return true;
    }
}
