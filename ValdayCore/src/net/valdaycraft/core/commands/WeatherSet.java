package net.valdaycraft.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.valdaycraft.core.Main;

public class WeatherSet implements CommandExecutor {
	
	Main plugin;
	
	public WeatherSet(Main iPlugin) {
		this.plugin = iPlugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("weather")) {
			if (sender.hasPermission("valdaycore.weather")) {
				Player player = (Player) sender;
				World playerWorld = player.getWorld();
				playerWorld.setStorm(false);
				if (args.length != 1) {
					player.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "You ust specify one weather command.");
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("clear") || args[0].equalsIgnoreCase("sun") || args[0].equalsIgnoreCase("bright")) {
						playerWorld.setStorm(false);
						playerWorld.setThundering(false);
					} 
					if (args[0].equalsIgnoreCase("storm") || args[0].equalsIgnoreCase("rain")) {
						playerWorld.setStorm(true);
						playerWorld.setThundering(false);
					}
					if (args[0].equalsIgnoreCase("thunderstorm")) {
						playerWorld.setStorm(true);
						playerWorld.setThundering(true);
					}
				    player.sendMessage(ChatColor.AQUA + "Weather: " + ChatColor.YELLOW + "Changed weather.");
				}
			}
		}
		return true;
	}

}
