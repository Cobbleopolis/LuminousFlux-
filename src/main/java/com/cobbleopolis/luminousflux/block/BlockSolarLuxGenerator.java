package com.cobbleopolis.luminousflux.block;

import com.cobbleopolis.luminousflux.LuminousFlux;
import com.cobbleopolis.luminousflux.init.LFItems;
import com.cobbleopolis.luminousflux.reference.Gui;
import com.cobbleopolis.luminousflux.reference.Names;
import com.cobbleopolis.luminousflux.tileentity.TileEntitySolarLuxGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockSolarLuxGenerator extends LFBlock {

    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon bottom;

    public BlockSolarLuxGenerator() {
        super(Material.rock);
        setBlockName(Names.Blocks.LUX_SOLAR_GENERATOR);
        setStepSound(soundTypeStone);
        setHardness(3.5F);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(LuminousFlux.MODID + ":luxSolarGeneratorSide");
        this.top = iconRegister.registerIcon(LuminousFlux.MODID + ":luxSolarGeneratorTop");
        this.bottom = iconRegister.registerIcon(LuminousFlux.MODID + ":luxSolarGeneratorBottom");

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
            if (player.getHeldItem().getItem() == LFItems.itemWiringTool || player.getHeldItem().getItem() == LFItems.itemLuxMeter) {
                return false;
            }
        }

        player.openGui(LuminousFlux.instance, Gui.LUX_SOLAR_GENERATOR, world, x, y, z);
        return true;
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntitySolarLuxGenerator();
    }

}
