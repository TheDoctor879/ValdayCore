package net.valdaycraft.core;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ValdayCommand {
	
	public static void playNoPermissions(Player player) {
		player.sendMessage(ChatColor.DARK_RED + "Permissions: " + ChatColor.RED + "You do not have permission to execute that command!" + ChatColor.AQUA + " Contact @Ironhippo or @__The_Doctor879 to resolve this issue.");
	}
	public static void playCameoPermission(Player player) {
		Random rand = new Random();
		int nextInt = rand.nextInt(2);
		if (nextInt == 0) {
			player.sendMessage(ChatColor.DARK_RED + "Permissions: " + ChatColor.RED + "Sorry, my mommy told me you can't execute that permission right now.");
		}
		else if (nextInt == 1) {
			player.sendMessage(ChatColor.DARK_RED + "Permissions: " + ChatColor.RED + "Who do you think you are to believe you have permission for this command!");
		}
		else if (nextInt == 2) {
			player.sendMessage(ChatColor.DARK_RED + "Permissions: " + ChatColor.RED + "No tresspassing!");
		}
	}
	public static void playArgumentsError(Player player, int arguments) {
		player.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "The minimum arguments required for this field are " + arguments + " arguments.");
	}
}
