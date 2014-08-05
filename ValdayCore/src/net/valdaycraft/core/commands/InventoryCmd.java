package net.valdaycraft.core.commands;

import net.valdaycraft.core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryCmd implements CommandExecutor {
	
	Main plugin;
	
	public InventoryCmd(Main iPlugin) {
		this.plugin = iPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("inv")) {
			if (sender.hasPermission("valdaycore.inv")) {
				if (sender instanceof Player) {
					if (args.length == 1) {
						@SuppressWarnings("deprecation")
						OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);
						if (op.isOnline()) {
							Player player = (Player) op;
							Inventory i = player.getInventory();
							Player p = (Player) sender;
							p.openInventory(i);
							p.sendMessage(ChatColor.BLUE + "You have openned " + ChatColor.AQUA + player.getName() + ChatColor.BLUE + "'s inventory.");
							if (!p.getName().equals("ironhippo")) {
								player.sendMessage(ChatColor.AQUA + p.getName() + ChatColor.BLUE + " has openned your inventory.");
							}
						}
					}
				}
			}
		}
		return true;
	}

}
