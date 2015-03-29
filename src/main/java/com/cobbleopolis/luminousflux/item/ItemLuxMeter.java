package com.cobbleopolis.luminousflux.item;

import com.cobbleopolis.luminousflux.reference.Names;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxPowered;
import com.cobbleopolis.luminousflux.util.UtilString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemLuxMeter extends LFItem {

	public ItemLuxMeter() {
		super();
		setUnlocalizedName(Names.Items.LUX_METER);
		setMaxStackSize(1);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world,
							 // which block was in the target when clicked
							 int x, int y, int z,
							 // where on the target block was clicked (0.0-1.0)
							 int side, float blockx, float blocky, float blockz) {
		if(world.getTileEntity(x, y, z) instanceof  TileEntityLuxPowered) {
			TileEntityLuxPowered te = (TileEntityLuxPowered) world.getTileEntity(x, y, z);
			if (!world.isRemote && te != null) {
				if (!player.isSneaking())
						player.addChatMessage(new ChatComponentText("Stored Lux: " + UtilString.formatIntWithCommas(te.storedLux) + " lx / " + UtilString.formatIntWithCommas(te.maxLux) + " lx"));
//				else
					//TODO if player is sneaking (make sure to uncomment the else statement above)
			}
		}
		return true;
	}
}
