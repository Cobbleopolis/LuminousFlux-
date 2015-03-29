package com.cobbleopolis.luminousflux.block;

import com.cobbleopolis.luminousflux.LuminousFlux;
import com.cobbleopolis.luminousflux.init.LFItems;
import com.cobbleopolis.luminousflux.reference.Gui;
import com.cobbleopolis.luminousflux.reference.Names;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuxBattery;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLuxBattery extends LFBlock {

    public BlockLuxBattery() {
        super(Material.rock);
        setBlockName(Names.Blocks.LUX_BATTERY);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (player.getHeldItem() != null) {
            if (player.getHeldItem().getItem() == LFItems.itemWiringTool || player.getHeldItem().getItem() == LFItems.itemLuxMeter) {
                return false;
            }
        }

        player.openGui(LuminousFlux.instance, Gui.LUX_BATTERY, world, x, y, z);
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityLuxBattery();
    }
}
