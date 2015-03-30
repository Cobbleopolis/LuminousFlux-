package com.cobbleopolis.luminousflux.block;

import com.cobbleopolis.luminousflux.reference.Names;
import net.minecraft.block.material.Material;

public class BlockSolarLuxGenerator extends LFBlock {

    public BlockSolarLuxGenerator() {
        super(Material.rock);
        setBlockName(Names.Blocks.LUX_SOLAR_GENERATOR);
        setStepSound(soundTypeStone);
        setHardness(3.5F);
    }
}
