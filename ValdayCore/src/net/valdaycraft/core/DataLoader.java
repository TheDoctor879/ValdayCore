package net.valdaycraft.core;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class DataLoader implements Listener {
	
	@EventHandler
	public void onPlayerFileLoad(PlayerQuitEvent ev) {
		Player player = ev.getPlayer();
		String playerName = player.getName();
		String ipAddress = player.getAddress().getAddress().getHostAddress();
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();
		boolean offline = false;
		String rpName = ChatColor.RED + "" + ChatColor.BOLD + "Unused";
		UUID playerId = null;
		try {
			playerId = UUIDFetcher.getUUIDOf(playerName);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File playerFile = new File("ValdayCraft" + File.separator + "Users" + File.separator + playerId.toString() + ".yml");
		FileConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerFile);
		if (playerFile.exists()) {
		    playerConfig.set("Player Name", playerName);
		    playerConfig.set("Ip", ipAddress);
		    playerConfig.set("X", x);
		    playerConfig.set("Y", y);
		    playerConfig.set("Z", z);
		    playerConfig.set("Active", offline);
		    try {
			playerConfig.save(playerFile);
		    } catch (IOException e1) {
			    e1.printStackTrace();
		    }
		}
		if (!playerFile.exists()) {
			playerConfig.set("Player Name", playerName);
		    playerConfig.set("Ip", ipAddress);
		    playerConfig.set("World", player.getWorld().getName());
		    playerConfig.set("X", x);
		    playerConfig.set("Y", y);
		    playerConfig.set("Z", z);
		    playerConfig.set("Active", offline);
		    playerConfig.set("Race", "Human");
		    playerConfig.set("Latest Offense: ", ChatColor.RED + "None");
		    playerConfig.set("Race", "Human");
		    playerConfig.set("Roleplay Name", rpName);
		    playerConfig.set("Staff", "Non");
		    try {
			playerConfig.save(playerFile);
		    } catch (IOException e1) {
			    e1.printStackTrace();
		    }
		    Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Creating .dat file for " + playerId.toString() + "."); 
		}
	}
}
