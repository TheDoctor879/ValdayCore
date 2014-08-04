package net.valdaycraft.core.commands;

import java.io.File;

import net.valdaycraft.core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class WWST implements CommandExecutor {
	
	File ServerFile = Main.config;
	FileConfiguration ServerConfig = YamlConfiguration.loadConfiguration(ServerFile);
	
	Main plugin;
	
	public WWST(Main iPlugin) {
		this.plugin = iPlugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("portsvale")) {
			Player p = (Player) sender;
			String w = ServerConfig.getString("SpawnWorld");
			World world = Bukkit.getWorld(w);
			double x = ServerConfig.getDouble("SpawnX");
			double y = ServerConfig.getDouble("SpawnY");
			double z = ServerConfig.getDouble("SpawnZ");
			float yaw = ServerConfig.getInt("SpawnYaw");
			float pitch = ServerConfig.getInt("SpawnPitch");
			p.sendMessage(ChatColor.GOLD + "Teleporting...");
			Location spawn = new Location(world, x, y, z, yaw, pitch);
			p.teleport(spawn);
		}
		return true;
	}

}
