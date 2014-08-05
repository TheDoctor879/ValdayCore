package net.valdaycraft.core.chat;

import java.io.File;
import java.io.IOException;

import net.valdaycraft.core.api.ValdayCraft;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ValdayChat {
	
	
	public void setChat(Player player, String channel) {
		File pFile = ValdayCraft.getFileOf(player);
		boolean isLocal = channel.equalsIgnoreCase("local");
		if (isLocal) {
			if (!isLocal) {
				FileConfiguration fc = YamlConfiguration.loadConfiguration(pFile);
				fc.set("Channel", "Local");
				try {
					fc.save(pFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				} else {
					
			}
		}
	}

}
