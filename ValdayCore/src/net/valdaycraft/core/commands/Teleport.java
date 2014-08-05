package net.valdaycraft.core.commands;

import net.valdaycraft.core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {
	
	Main plugin;
	public Teleport(Main iPlugin) {
		this.plugin = iPlugin;
	}
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tpto")) {
			if (sender.hasPermission("valdaycore.tp")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					if (args.length < 1 && args.length > 2) {
						sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "You cannot have " + args.length + " amounts of arguments.");
					}
					if (args.length == 1) {
						Player target = Bukkit.getPlayer(args[0]);
						if (target != null && player.canSee(target)) {
							player.teleport(target);
							player.sendMessage(ChatColor.GREEN + "You have teleported to " + ChatColor.WHITE + target.getName());
						} 
						if (target == null || !player.canSee(target)) {
							player.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "It seems like this player is not online right now.");
						}
					}
					if (args.length == 2) {
						Player t1 = Bukkit.getPlayer(args[0]);
						Player t2 = Bukkit.getPlayer(args[1]);
						if (t1 != null && t2 != null && t1.canSee(t2)) {
							t1.teleport(t2);
							player.sendMessage(ChatColor.GREEN + "Successfully teleported " + ChatColor.WHITE + t1.getName() + ChatColor.GREEN + " to " + ChatColor.WHITE + t2.getName() + ChatColor.GREEN + ".");
						} 
						if (t1 == null || t2 == null || !t1.canSee(t2)) {
							player.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "It seems like this player is not online right now.");
						}
					}
				} else {
					sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "You are not a player.");
				}
			} else {
				sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "You do not have permission to execute that command.");
			}
		}
		return true;
	}

}
