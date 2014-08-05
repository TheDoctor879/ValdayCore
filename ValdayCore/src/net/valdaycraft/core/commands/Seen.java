package net.valdaycraft.core.commands;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import net.valdaycraft.core.Main;
import net.valdaycraft.core.UUIDFetcher;
import net.valdaycraft.core.api.ValdayCraft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Seen implements CommandExecutor {
	
	Main plugin;
	
	public Seen(Main iPlugin) {
		this.plugin = iPlugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("seen")) {
			if (args.length > 1) {
				sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "Please define only one player.");
			}
			if (args.length == 1) {
				@SuppressWarnings("deprecation")
				OfflinePlayer p = Bukkit.getOfflinePlayer(args[0]);
				UUID playerId = null;
				try {
					playerId = UUIDFetcher.getUUIDOf(p.getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (playerId != null) {
					File file = new File("ValdayCraft" + File.separator + "Users" + File.separator + playerId.toString() + ".yml");
					if (p.isOnline()) {
						Player pl = (Player) p;
					    FileConfiguration config = YamlConfiguration.loadConfiguration(file);
					    sender.sendMessage(ChatColor.AQUA + "-------" + ChatColor.GREEN + "{" + config.getString("Player Name") + ChatColor.GREEN + "}" + ChatColor.AQUA + "-------");
					    sender.sendMessage(ChatColor.GREEN + "Online: " + ChatColor.BLUE + "Yes");
					    sender.sendMessage(ChatColor.GREEN + "Character: " + ChatColor.GOLD + config.getString("Roleplay Name"));
					    sender.sendMessage(ChatColor.GREEN + "Race:" + ChatColor.GOLD + config.getString("Race"));
					    sender.sendMessage(ChatColor.GREEN + "Banned: " + config.getString("Banned"));
					    sender.sendMessage(ChatColor.GREEN + "World: " + pl.getLocation().getWorld().getName());
						if (sender.hasPermission("valdaycore.seeall")) {
							sender.sendMessage(ChatColor.GREEN + "Block X: " + ChatColor.RED + pl.getLocation().getBlockX());
							sender.sendMessage(ChatColor.GREEN + "Block Y: " + ChatColor.YELLOW + pl.getLocation().getBlockY());
							sender.sendMessage(ChatColor.GREEN + "Block Z: " + ChatColor.AQUA + pl.getLocation().getBlockZ());
						}
						if (config.getString("Staff").equalsIgnoreCase("Org")) {
					        sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.YELLOW + " [° Organization °]");
						}
						if (config.getString("Staff").equalsIgnoreCase("World")) {
						    sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.GOLD + "World");
						}
						if (config.getString("Staff").equalsIgnoreCase("Creative")) {
						    sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.DARK_AQUA + "Creative");
						}
						if (config.getString("Staff").equalsIgnoreCase("RP")) {
						    sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.DARK_GREEN + "Roleplay");
						}
						if (config.getString("Staff").equalsIgnoreCase("Tech")) {
							sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.BLUE + "Tech");
						}
						if (config.getString("Staff").equalsIgnoreCase("PremiumS")) {
						    sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.AQUA + "[± Dedicator ±]");
						}
						if (config.getString("Staff").equalsIgnoreCase("Non") || config.getString("Staff").isEmpty()) {
						    sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.GRAY + "Player");
						}
						try {
							config.save(file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						FileConfiguration config = YamlConfiguration.loadConfiguration(file);
						sender.sendMessage(ChatColor.RED + "-------" + ChatColor.GREEN + "{" + config.getString("Player Name") + ChatColor.GREEN + "}" + ChatColor.RED + "-------");
					    sender.sendMessage(ChatColor.GREEN + "Online: " + ChatColor.DARK_RED + "No");
					    sender.sendMessage(ChatColor.GREEN + "Unique Id: " + playerId.toString());
					    sender.sendMessage(ChatColor.GREEN + "Character: " + ChatColor.GOLD + config.getString("Roleplay Name"));
					    sender.sendMessage(ChatColor.GREEN + "Race: " + ChatColor.GOLD + config.getString("Race"));
					    sender.sendMessage(ChatColor.GREEN + "Banned: " + config.getString("Banned"));
					    sender.sendMessage(ChatColor.GREEN + "World: " + config.getString("World"));
						if (sender.hasPermission("valdaycore.seeall")) {
							sender.sendMessage(ChatColor.GREEN + "Block X: " + ChatColor.RED + config.getDouble("X"));
							sender.sendMessage(ChatColor.GREEN + "Block X: " + ChatColor.YELLOW + config.getDouble("Y"));
							sender.sendMessage(ChatColor.GREEN + "Block X: " + ChatColor.AQUA + config.getDouble("Z"));
						}
						if (ValdayCraft.getRank(p).equalsIgnoreCase("Organization")) {
							sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.YELLOW + "Organization");
						}
						if (ValdayCraft.getRank(p).equalsIgnoreCase("World")) {
							sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.DARK_AQUA + "World");
						}
						if (ValdayCraft.getRank(p).equalsIgnoreCase("Creative")) {
							sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.BLUE + "Creative");
						}
						if (ValdayCraft.getRank(p).equalsIgnoreCase("Kingdom")) {
							sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.GREEN + "Kingdom");
						}
						if (ValdayCraft.getRank(p).equalsIgnoreCase("RP")) {
							sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.GOLD + "Roleplay");
						}
						if (ValdayCraft.getRank(p).equalsIgnoreCase("PR")) {
							sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.DARK_GRAY + "Public " + ChatColor.DARK_RED + "Relations");
						}
						if (ValdayCraft.getRank(p).equalsIgnoreCase("Star")) {
							sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.LIGHT_PURPLE + "☼ Star");
						}
						if (ValdayCraft.getRank(p).equalsIgnoreCase("Player")) {
							sender.sendMessage(ChatColor.GREEN + "Rank: " + ChatColor.WHITE + "Player");
						}
						try {
							config.save(file);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "This player seems to not exist.");
				}
			}
		}
		return true;
	}
	
}
