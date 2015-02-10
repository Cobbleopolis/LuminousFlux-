package com.cobbleopolis.luminousflux.proxy;

import com.cobbleopolis.luminousflux.init.LFBlocks;
import com.cobbleopolis.luminousflux.renderer.RendererLuminousLamp;
import com.cobbleopolis.luminousflux.tileentity.TileEntityLuminousLamp;
import cpw.mods.fml.client.registry.ClientRegistry;
import ibxm.Player;

import java.io.File;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy implements ILFProxy{

	@Override
	public void registerRenderers() {
		//Steam Pipe
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLuminousLamp.class,
				new RendererLuminousLamp());
		MinecraftForgeClient.registerItemRenderer(
				Item.getItemFromBlock(LFBlocks.luminousLamp),
				new RendererLuminousLamp());
//		//Boiler Hood
//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoilerHood.class,
//				new RendererBoilerHood());
//		MinecraftForgeClient.registerItemRenderer(
//				Item.getItemFromBlock(SteamCraftBlock.boilerHood),
//				new RendererBoilerHood());
//		//Blunderbuss Shot
//		RenderingRegistry.registerEntityRenderingHandler(
//				EntityBlunderbussShot.class, new RenderSnowball(SteamCraftItem.brassBallBearing));
	}

	@Override
	public void registerSound() {
	}

	@Override
	public long getTicks(World worldObj) {
		if (worldObj != null) { return worldObj.getTotalWorldTime(); }
		World cWorld = getClientWorld();
		if (cWorld != null) return cWorld.getTotalWorldTime();
		return 0;
	}

	@Override
	public boolean isServerOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isServerThread() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public World getClientWorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public World getServerWorld(int dimension) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityPlayer getThePlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClientPlayer(Entity player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendPacketToPlayer(Player player, Packet packet) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendPacketToServer(Packet packet) {
		// TODO Auto-generated method stub

	}

	@Override
	public File getMinecraftDir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLogFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGuiHandler wrapHandler(IGuiHandler modSpecificHandler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void preInit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postInit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNowPlayingTitle(String nowPlaying) {
		// TODO Auto-generated method stub

	}
}