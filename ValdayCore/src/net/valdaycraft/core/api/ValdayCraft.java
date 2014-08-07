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
	public static File getFileOf(OfflinePlayer player) {
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
    public static String getRank(OfflinePlayer player) {
    	String rank = null;
    	UUID id = null;
    	try {
			id = UUIDFetcher.getUUIDOf(player.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	if (id != null) {
    		File f = ValdayCraft.getFileOf(player);
    		FileConfiguration fc = YamlConfiguration.loadConfiguration(f);
    		if (fc != null) {
    			String staff = fc.getString("Staff");
    			if (staff.equalsIgnoreCase("Org")) {
    				rank = "Organization";
    			}
    			else if (staff.equalsIgnoreCase("World")) {
    				rank = "World";
    			}
    			else if (staff.equalsIgnoreCase("Creative")) {
    				rank = "Creative";
    			}
    			else if (staff.equalsIgnoreCase("RP")) {
    				rank = "Roleplay";
    			}
    			else if (staff.equalsIgnoreCase("Tech")) {
    				rank = "Tech";
    			}
    			else if (staff.equalsIgnoreCase("Kingdom")) {
    				rank = "Kingdom";
    			}
    			else if (staff.equalsIgnoreCase("PR")) {
    				rank = "Public " + "Relations";
    			}
    			else if (staff.equalsIgnoreCase("PremiumS")) {
    				rank = "Star";
    			}
    			else if (staff.equalsIgnoreCase("Non") || staff == null) {
    				rank = "Player";
    			}
    		}
    	} else {
    		System.out.println("Rank is not excepted for " + player.getName());
    	}
    	return rank;
    }
}
