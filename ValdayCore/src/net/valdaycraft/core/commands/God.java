package net.valdaycraft.core.commands;

import java.util.HashMap;

import net.valdaycraft.core.Main;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class God implements CommandExecutor {
	
	public static HashMap<String, Object> gods = new HashMap<String, Object>();
	
	Main plugin;
	
	public God(Main iPlugin) {
		this.plugin = iPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("god")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("valdaycore.god")) {
					Player player = (Player) sender;
					if (gods.containsKey(player.getName())) {
						player.sendMessage(ChatColor.YELLOW + "" + ChatColor.ITALIC + "You have lost your godlike powers.");
						gods.remove(player.getName());
					}
					else if (!gods.containsKey(player.getName())) {
						player.sendMessage(ChatColor.YELLOW + "" + ChatColor.ITALIC + "\"I am become death, destroyer of worlds.\"");
						player.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 2, 3);
						gods.put(player.getName(), true);
					}
				}
			}
			else if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "You cannot be godlike if you already have godlike powers :P.");
			}
		}
		return true;
	}

}
