package net.valdaycraft.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.valdaycraft.core.Main;
import net.valdaycraft.core.ValdayCeptions;

public class TimeSet implements CommandExecutor {
	
	Main plugin;
	
	public TimeSet(Main iPlugin) {
		this.plugin = iPlugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("time")) {
			if (sender.hasPermission("valdaycore.time")) {
				if (args.length == 1) {
					if (ValdayCeptions.checkInteger(args[0])) {
						int i = Integer.parseInt(args[0]);
						Player player = (Player) sender;
						World w = player.getWorld();
						w.setTime(i);
						player.sendMessage(ChatColor.GOLD + "Time: " + ChatColor.GREEN + "Set to " + args[1] + " ticks.");
					} else {
						String s = args[0];
						boolean sr = s.equalsIgnoreCase("day");
						boolean ss = s.equalsIgnoreCase("night");
						boolean n = s.equalsIgnoreCase("noon");
						if (sr) {
							Player player = (Player) sender;
							World w = player.getWorld();
							w.setTime(50);
							player.sendMessage(ChatColor.GOLD + "Time: " + ChatColor.GREEN + "Set to sunrise.");
						}
						if (ss) {
							Player player = (Player) sender;
							World w = player.getWorld();
							w.setTime(14002);
							player.sendMessage(ChatColor.GOLD + "Time: " + ChatColor.GREEN + "Set to sunset.");
						}
						if (n) {
							Player player = (Player) sender;
							World w = player.getWorld();
							w.setTime(5064);
							player.sendMessage(ChatColor.GOLD + "Time: " + ChatColor.GREEN + "Set to sunset.");
						}
						if (sr == false && ss == false && n == false) {
							Player player = (Player) sender;
							player.sendMessage(ChatColor.GOLD + "Time: " + ChatColor.GREEN + "You must use [day, night, and noon]");
						}
					}
				}
			}
		}
		return true;
	}

}
