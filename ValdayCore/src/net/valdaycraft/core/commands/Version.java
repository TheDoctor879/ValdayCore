package net.valdaycraft.core.commands;

import java.util.List;

import net.valdaycraft.core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R3.CraftServer;

public class Version implements CommandExecutor {
	
	String Version = Bukkit.getServer().getPluginManager().getPlugin("ValdayCore").getDescription().getVersion();
	String Description = Bukkit.getServer().getPluginManager().getPlugin("ValdayCore").getDescription().getDescription();
	List<String> Author = Bukkit.getServer().getPluginManager().getPlugin("ValdayCore").getDescription().getAuthors();
	CraftServer serv = (CraftServer) Bukkit.getServer();
	String n = serv.getVersion();
	
	Main plugin;
	public Version(Main iPlugin) {
		this.plugin = iPlugin;
	}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("version")) {
			sender.sendMessage(ChatColor.GOLD + "-------- " + ChatColor.LIGHT_PURPLE + "Valday" + ChatColor.GREEN + "Craft" + ChatColor.GOLD + " --------");
			sender.sendMessage(ChatColor.YELLOW + "Server Name: " + ChatColor.LIGHT_PURPLE + "Valday" + ChatColor.GREEN + "Craft");
			sender.sendMessage(ChatColor.YELLOW + "Java Author: " + ChatColor.GREEN + "[" + ChatColor.RED + "" + ChatColor.MAGIC + "666" + ChatColor.RESET + ChatColor.GREEN + "] " + ChatColor.AQUA + Author.toString() + ChatColor.GREEN + " [" + ChatColor.RED + "" + ChatColor.MAGIC + "666" + ChatColor.RESET + "" + ChatColor.GREEN + "]" );
			sender.sendMessage(ChatColor.YELLOW + "Version: " + ChatColor.GREEN + Version);
			sender.sendMessage(ChatColor.YELLOW + "Minecraft Version: " + n);
			sender.sendMessage(ChatColor.YELLOW + "Description: " + ChatColor.GREEN + Description);
		}
		return true;
	}
}