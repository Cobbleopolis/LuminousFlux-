package com.cobbleopolis.luminousflux.proxy;

import ibxm.Player;

import java.io.File;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.world.World;

public class CommonProxy implements ILFProxy{
	/**
	 * Registers all the renderers for the proxy, only contains code client side
	 */
	public void registerRenderers() {
	}

	public void registerSound() {

	}

	public boolean isRenderWorld(World world) {
		return world.isRemote;
	}

	/* SIMULATION */
	public boolean isSimulating(World world) {
		return !world.isRemote;
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
	public long getTicks(World worldObj) {
		return worldObj.getTotalWorldTime();
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