 package net.valdaycraft.core.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.valdaycraft.core.Main;

public class OnlineList implements CommandExecutor {
	
	Main plugin;
	
	public OnlineList(Main iPlugin) {
		this.plugin = iPlugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("list")) {
			if (Bukkit.getOnlinePlayers().length >= 2) {
			    String playerList = null;
			    StringBuilder build = new StringBuilder();
			    for(Player onlinePlayers : Bukkit.getOnlinePlayers()) {
				    build.append(onlinePlayers.getName() + ", ");
				    playerList = build.toString();
				    Pattern pattern = Pattern.compile(", $");
			        Matcher matcher = pattern.matcher(playerList);
				    playerList = matcher.replaceAll("");
			   }
			   sender.sendMessage(ChatColor.YELLOW + "-------" + ChatColor.AQUA + " Online List " + ChatColor.YELLOW + "-------");
			   sender.sendMessage(playerList);
			}
			if (Bukkit.getOnlinePlayers().length < 2) {
				sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "There are too little players ");
			}
		}
		return true;
	}
}
