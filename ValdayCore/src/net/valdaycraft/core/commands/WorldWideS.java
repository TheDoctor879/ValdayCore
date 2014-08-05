package net.valdaycraft.core.commands;

import java.io.File;
import java.io.IOException;

import net.valdaycraft.core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class WorldWideS implements CommandExecutor {
	
	File ServerFile = Main.config;
	FileConfiguration ServerConfig = YamlConfiguration.loadConfiguration(ServerFile);
	
	Main plugin;
	
	public WorldWideS(Main iPlugin) {
		this.plugin = iPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sethq")) {
			Player player = (Player) sender;
			if (player.hasPermission("valdaycore.sethq")) {
				double X = player.getLocation().getBlockX() + 0.5;
				double Y = player.getLocation().getBlockY() + 0.5;
				double Z = player.getLocation().getBlockZ() + 0.5;
				float yaw = player.getLocation().getYaw();
				float pitch = player.getLocation().getPitch();
				String s = ChatColor.GOLD + ", " + ChatColor.GREEN;
				player.sendMessage(ChatColor.GOLD + "Spawn: " + ChatColor.GREEN + "Set location to " + X + s + Y + s + Z);
				ServerConfig.set("SpawnWorld", player.getWorld().getName());
				ServerConfig.set("SpawnX", X);
				ServerConfig.set("SpawnY", Y);
				ServerConfig.set("SpawnZ", Z);
				ServerConfig.set("SpawnYaw", yaw);
				ServerConfig.set("SpawnPitch", pitch);
				try {
					ServerConfig.save(ServerFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "A new spawn location has been set at: " + X + s + Y + s + Z);
			}
		}
		return true;
	}

}
