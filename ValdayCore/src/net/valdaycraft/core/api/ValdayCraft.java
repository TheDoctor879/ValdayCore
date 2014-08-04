package net.valdaycraft.core.api;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import net.valdaycraft.core.UUIDFetcher;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class ValdayCraft {
	
	public static UUID getUUID(Player player) {
		UUID id = null;
		try {
			id = UUIDFetcher.getUUIDOf(player.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (id == null) {
			System.out.println("This player does not exist.");
		}
		return id;
	}
	public static File getFileOf(Player player) {
		UUID id = null;
		try {
			id = UUIDFetcher.getUUIDOf(player.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File f = new File("ValdayCraft" + File.separator + "Users" + File.separator + id.toString() + ".yml");
		return f;
	}
	@Deprecated
	public static Player getOnlinePlayer(String player) {
		Player p = Bukkit.getPlayerExact(player);
		return p;
	}
	public static OfflinePlayer getOfflinePlayer(String player) {
		@SuppressWarnings("deprecation")
		OfflinePlayer p = Bukkit.getOfflinePlayer(player);
		return p;
	}
    public static void setPlayerName(Player player, String prefix) {
    	UUID id = null;
    	try {
			id = UUIDFetcher.getUUIDOf(player.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ScoreboardManager manager = Bukkit.getScoreboardManager();
    	Scoreboard s = manager.getMainScoreboard();
    	Team team = s.registerNewTeam(id.toString());
    	team.addPlayer(player);
    	if (prefix.length() > 14) {
    		String p = prefix.substring(0, 13);
    		team.setPrefix(p);
    	}
    	else {
    		team.setPrefix(prefix);
			}
    	FileConfiguration fc = YamlConfiguration.loadConfiguration(ValdayCraft.getFileOf(player));
		fc.set("NickName", prefix);
		try {
			fc.save(getFileOf(player));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void resetPlayerName(Player player) {
    	if (ValdayCraft.getFileOf(player) != null) {
    	    FileConfiguration fc = YamlConfiguration.loadConfiguration(ValdayCraft.getFileOf(player));
    	    fc.set("NickName", null);
    	    try {
			    fc.save(ValdayCraft.getFileOf(player));
		    } catch (IOException e) {
			    e.printStackTrace();
		    }
		}
    }
}
