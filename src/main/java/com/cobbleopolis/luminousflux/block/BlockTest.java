package com.cobbleopolis.luminousflux.block;

import com.cobbleopolis.luminousflux.reference.Names;
import net.minecraft.block.material.Material;

public class BlockTest extends LFBlock {
	public BlockTest() {
		super(Material.glass);
		setStepSound(this.soundTypeGlass);
		setBlockName(Names.Blocks.TEST);
		setLightLevel(1F);
		setLightOpacity(0);

	}
}
