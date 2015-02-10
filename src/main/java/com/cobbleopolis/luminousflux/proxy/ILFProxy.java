package com.cobbleopolis.luminousflux.proxy;

import ibxm.Player;
import java.io.File;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public interface ILFProxy {
	public boolean isServerOnly();

	public boolean isServerThread();

	public World getClientWorld();

	public World getServerWorld(int dimension);

	public EntityPlayer getThePlayer();

	public boolean isClientPlayer(Entity player);

	public long getTicks(World worldObj);

	public void sendPacketToPlayer(Player player, Packet packet);

	public void sendPacketToServer(Packet packet);

	public File getMinecraftDir();

	public String getLogFileName();

	public IGuiHandler wrapHandler(IGuiHandler modSpecificHandler);

	public void preInit();

	public void init();

	public void postInit();

	public void setNowPlayingTitle(String nowPlaying);
}