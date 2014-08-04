package net.valdaycraft.core.commands;

import java.io.File;
import java.io.IOException;

import net.valdaycraft.core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class AddSchematic implements CommandExecutor { 
	
	File file = Main.config;
	FileConfiguration config = Main.serverConfig;
	
	Main plugin;
	
	public AddSchematic(Main iPlugin) {
		this.plugin = iPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sw")) {
			if (sender.hasPermission("valdaycore.sw")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					if (args.length > 1 || args.length == 0) {
						sender.sendMessage(ChatColor.DARK_RED + "Error in Syntax: " + ChatColor.RED + "Use the arguments: 'set', 'remove', or 'tp'.");
					}
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("set")) {
							String worldName = player.getWorld().getName();
							config.set("Schematic", worldName);
							try {
								config.save(file);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							sender.sendMessage(ChatColor.GREEN + "Set the schematic world to: " + ChatColor.GOLD + worldName + ChatColor.GREEN + ".");
						}
						else if (args[0].equalsIgnoreCase("remove")) {
							config.set("Schematic", "world");
							try {
								config.save(file);
							} catch (Exception e) {
								e.printStackTrace();
							}
							sender.sendMessage(ChatColor.GREEN + "Set the schematic world to: " + ChatColor.GOLD + "Unknown" + ChatColor.GREEN + ".");
						}
						else if (args[0].equalsIgnoreCase("tp")) {
							String worldName = config.getString("Schematic");
							World world = Bukkit.getWorld(worldName);
							Location schematicSpawn = world.getSpawnLocation();
							player.teleport(schematicSpawn);
							player.sendMessage(ChatColor.GREEN + "Welcome to the Schematic World!");
						}
					}
				}
			}
		}
		return true;
	}

}
