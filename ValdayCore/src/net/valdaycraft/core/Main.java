package net.valdaycraft.core;

import java.io.File;
import java.io.IOException;

import net.valdaycraft.core.commands.AddSchematic;
import net.valdaycraft.core.commands.ArmorCmd;
import net.valdaycraft.core.commands.Author;
import net.valdaycraft.core.commands.BroadcastCmd;
import net.valdaycraft.core.commands.God;
import net.valdaycraft.core.commands.InventoryCmd;
import net.valdaycraft.core.commands.OnlineList;
import net.valdaycraft.core.commands.Seen;
import net.valdaycraft.core.commands.SetSpawn;
import net.valdaycraft.core.commands.Summon;
import net.valdaycraft.core.commands.Teleport;
import net.valdaycraft.core.commands.TimeSet;
import net.valdaycraft.core.commands.ValdayMode;
import net.valdaycraft.core.commands.Version;
import net.valdaycraft.core.commands.WWST;
import net.valdaycraft.core.commands.WeatherSet;
import net.valdaycraft.core.commands.WorldWideS;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static File mySQLFile = new File("ValdayCraft" + File.separator + "SQL.yml");
	
	public static File config = new File("ValdayCraft" + File.separator + "config.yml");
	
	public static FileConfiguration serverConfig = YamlConfiguration.loadConfiguration(config);
	
	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Valday" + ChatColor.GREEN + "Core" + ChatColor.GRAY + ": " + ChatColor.YELLOW + "Checking for any external API jars...");
		getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Valday" + ChatColor.GREEN + "Core" + ChatColor.GRAY + ": " + ChatColor.YELLOW + "No external API's found. Loading normally...");
		
		// TODO - Command Register
		getCommand("author").setExecutor(new Author(this));
		getCommand("summon").setExecutor(new Summon(this));
		getCommand("bc").setExecutor(new BroadcastCmd(this));
		getCommand("version").setExecutor(new Version(this));
		getCommand("sw").setExecutor(new AddSchematic(this));
		getCommand("god").setExecutor(new God(this));
		getCommand("tpto").setExecutor(new Teleport(this));
		getCommand("sethq").setExecutor(new WorldWideS(this));
		getCommand("portsvale").setExecutor(new WWST(this));
		getCommand("gm").setExecutor(new ValdayMode(this));
		getCommand("seen").setExecutor(new Seen(this));
		getCommand("time").setExecutor(new TimeSet(this));
		getCommand("weather").setExecutor(new WeatherSet(this));
		getCommand("list").setExecutor(new OnlineList(this));
		getCommand("setspawn").setExecutor(new SetSpawn(this));
		getCommand("inv").setExecutor(new InventoryCmd(this));
		getCommand("armor").setExecutor(new ArmorCmd(this));
		// TODO - Event Registers
		getServer().getPluginManager().registerEvents(new DataLoader(), this);
		// TODO - Configuration
		if (!mySQLFile.exists()) {
		    FileConfiguration fc = YamlConfiguration.loadConfiguration(mySQLFile);
		    fc.set("Ip", "66.85.144.162");
		    fc.set("User", "mcph30392");
		    fc.set("Name", "mcph30392");
		    fc.set("Password", "a63c6c0382");
		    try {
				fc.save(mySQLFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Valday" + ChatColor.GREEN + "Core" + ChatColor.AQUA + ": MySQL statement is standing by.");
		}
		serverConfig.set("Schematic", "SchematicWorld");
		serverConfig.set("Proxy", false);
		serverConfig.set("PvP", true);
		serverConfig.set("KeepInventory", false);
		serverConfig.set("Server MOTD", ChatColor.GREEN + "Valday" + ChatColor.LIGHT_PURPLE + "Craft" + ChatColor.AQUA + " - " + ChatColor.GOLD + "A PvP & Roleplay Server");
		try {
			serverConfig.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Valday" + ChatColor.GREEN + "Core" + ChatColor.GRAY + ": " + ChatColor.YELLOW + "Waiting for external API's to unload...");
		getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "Valday" + ChatColor.GREEN + "Core" + ChatColor.GRAY + ": " + ChatColor.YELLOW + "External API's have finished. ValdayCore has unloaded all properties.");
	}
}
