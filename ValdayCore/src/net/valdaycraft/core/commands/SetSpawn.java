package net.valdaycraft.core.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.valdaycraft.core.Main;

public class SetSpawn implements CommandExecutor {
	
	Main plugin;
	
	File file = new File("ValdayCraft" + File.separator + "config.yml");
	
	public SetSpawn(Main iPlugin) {
		this.plugin = iPlugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("setspawn")) {
			if (sender.hasPermission("valdaycore.setspawn")) {
				Player player = (Player) sender;
				double x = player.getLocation().getBlockX();
				double y = player.getLocation().getBlockY();
				double z = player.getLocation().getBlockZ();
				float yaw = player.getLocation().getYaw();
				float pitch = player.getLocation().getPitch();
				FileConfiguration ServerConfig = YamlConfiguration.loadConfiguration(file);
				ServerConfig.set(player.getWorld().getName() + ".X", x);
				ServerConfig.set(player.getWorld().getName() + ".Y", y);
				ServerConfig.set(player.getWorld().getName() + ".Z", z);
				ServerConfig.set(player.getWorld().getName() + ".Yaw", yaw);
				ServerConfig.set(player.getWorld().getName() + ".Pitch", pitch);
				try {
					ServerConfig.save(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
}
