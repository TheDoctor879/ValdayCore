package net.valdaycraft.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.valdaycraft.core.Main;

public class ValdayMode implements CommandExecutor {
	
	Main plugin;
	
	public ValdayMode(Main iPlugin) {
		this.plugin = iPlugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gm")) {
			if (sender.hasPermission("valdaycore.gm")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					if (args.length == 1) {
						//Creative
						if (args[0].equalsIgnoreCase("c")) {
							player.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.RED + "" + ChatColor.BOLD + "Creative");
							player.setGameMode(GameMode.CREATIVE);
						}
						if (args[0].equalsIgnoreCase("1")) {
							player.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.RED + "" + ChatColor.BOLD + "Creative");
							player.setGameMode(GameMode.CREATIVE);
						}
						if (args[0].equalsIgnoreCase("creative")) {
							player.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.RED + "" + ChatColor.BOLD + "Creative");
							player.setGameMode(GameMode.CREATIVE);
						}
						//Survival
						if (args[0].equalsIgnoreCase("s")) {
							player.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.AQUA + "" + ChatColor.BOLD + "Survival");
							player.setGameMode(GameMode.SURVIVAL);
						}
						if (args[0].equalsIgnoreCase("0")) {
							player.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.AQUA + "" + ChatColor.BOLD + "Survival");
							player.setGameMode(GameMode.SURVIVAL);
						}
						if (args[0].equalsIgnoreCase("survival")) {
							player.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.AQUA + "" + ChatColor.BOLD + "Survival");
							player.setGameMode(GameMode.SURVIVAL);
						}
						//Adventure
						if (args[0].equalsIgnoreCase("a")) {
							player.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Adventure");
							player.setGameMode(GameMode.ADVENTURE);
						}
						if (args[0].equalsIgnoreCase("2")) {
							player.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Adventure");
							player.setGameMode(GameMode.ADVENTURE);
						}
						if (args[0].equalsIgnoreCase("adventure")) {
							player.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Adventure");
							player.setGameMode(GameMode.ADVENTURE);
						}
					}
					if (args.length == 2) {
						@SuppressWarnings("deprecation")
						OfflinePlayer p = (Player) Bukkit.getPlayer(args[1]);
						if (p.isOnline()) {
							Player pl = (Player) p;
							//Creative
							if (args[0].equalsIgnoreCase("c")) {
								pl.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.RED + "" + ChatColor.BOLD + "Creative");
								pl.setGameMode(GameMode.CREATIVE);
							}
							if (args[0].equalsIgnoreCase("1")) {
								pl.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.RED + "" + ChatColor.BOLD + "Creative");
								pl.setGameMode(GameMode.CREATIVE);
							}
							if (args[0].equalsIgnoreCase("creative")) {
								pl.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.RED + "" + ChatColor.BOLD + "Creative");
								pl.setGameMode(GameMode.CREATIVE);
							}
							//Survival
							if (args[0].equalsIgnoreCase("s")) {
								pl.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.AQUA + "" + ChatColor.BOLD + "Survival");
								pl.setGameMode(GameMode.SURVIVAL);
							}
							if (args[0].equalsIgnoreCase("0")) {
								pl.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.AQUA + "" + ChatColor.BOLD + "Survival");
								pl.setGameMode(GameMode.SURVIVAL);
							}
							if (args[0].equalsIgnoreCase("survival")) {
								pl.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.AQUA + "" + ChatColor.BOLD + "Survival");
								pl.setGameMode(GameMode.SURVIVAL);
							}
							//Adventure
							if (args[0].equalsIgnoreCase("a")) {
								pl.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Adventure");
								pl.setGameMode(GameMode.ADVENTURE);
							}
							if (args[0].equalsIgnoreCase("2")) {
								pl.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Adventure");
								pl.setGameMode(GameMode.ADVENTURE);
							}
							if (args[0].equalsIgnoreCase("adventure")) {
								pl.sendMessage(ChatColor.GOLD + "Your game mode has been set to " + ChatColor.YELLOW + "" + ChatColor.BOLD + "Adventure");
								pl.setGameMode(GameMode.ADVENTURE);
							}
						}
					}
				}
			}
		}
		return true;
	}

}
