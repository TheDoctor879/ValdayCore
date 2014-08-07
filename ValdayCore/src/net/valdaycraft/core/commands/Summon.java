package net.valdaycraft.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import net.valdaycraft.core.Main;

public class Summon implements CommandExecutor {
	
	Main plugin;
	
	public Summon(Main iPlugin) {
		this.plugin = iPlugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("summon")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("valdaycore.summon")) {
				    if (args.length == 1) {
					Player player = (Player) sender;
					if (args[0].equalsIgnoreCase("pig")) {
						EntityType mob = EntityType.PIG;
						Location l = player.getEyeLocation();
						World w = player.getWorld();
						w.spawnEntity(l, mob);
						w.playEffect(l, Effect.MOBSPAWNER_FLAMES, 2);
						player.sendMessage(ChatColor.GOLD + "Spawned a " + ChatColor.GREEN + args[0].toUpperCase() + ChatColor.GOLD + ".");
					}
					if (args[0].equalsIgnoreCase("cow")) {
						EntityType mob = EntityType.COW;
						Location l = player.getEyeLocation();
						World w = player.getWorld();
						w.spawnEntity(l, mob);
						w.playEffect(l, Effect.MOBSPAWNER_FLAMES, 2);
						player.sendMessage(ChatColor.GOLD + "Spawned a " + ChatColor.GREEN + args[0].toUpperCase() + ChatColor.GOLD + ".");
					}
					if (args[0].equalsIgnoreCase("chicken")) {
						EntityType mob = EntityType.CHICKEN;
						Location l = player.getEyeLocation();
						World w = player.getWorld();
						w.spawnEntity(l, mob);
						w.playEffect(l, Effect.MOBSPAWNER_FLAMES, 2);
						player.sendMessage(ChatColor.GOLD + "Spawned a " + ChatColor.GREEN + args[0].toUpperCase() + ChatColor.GOLD + ".");
					}
					if (args[0].equalsIgnoreCase("sheep")) {
						EntityType mob = EntityType.SHEEP;
						Location l = player.getEyeLocation();
						World w = player.getWorld();
						w.spawnEntity(l, mob);
						w.playEffect(l, Effect.MOBSPAWNER_FLAMES, 2);
						player.sendMessage(ChatColor.GOLD + "Spawned a " + ChatColor.GREEN + args[0].toUpperCase() + ChatColor.GOLD + ".");
					}
					if (args[0].equalsIgnoreCase("bat")) {
						EntityType pig = EntityType.BAT;
						Location l = player.getEyeLocation();
						World w = player.getWorld();
						w.spawnEntity(l, pig);
						w.playEffect(l, Effect.MOBSPAWNER_FLAMES, 2);
						w.playSound(l, Sound.COW_WALK, 10, 10);
						player.sendMessage(ChatColor.GOLD + "Spawned a " + ChatColor.GREEN + args[0].toUpperCase() + ChatColor.GOLD + ".");
					}
					if (args[0].equalsIgnoreCase("villager") || args[0].equalsIgnoreCase("testificate")) {
						EntityType mob = EntityType.VILLAGER;
						Location l = player.getEyeLocation();
						World w = player.getWorld();
						w.spawnEntity(l, mob);
						w.playEffect(l, Effect.MOBSPAWNER_FLAMES, 2);
						player.sendMessage(ChatColor.GOLD + "Spawned a " + ChatColor.GREEN + args[0].toUpperCase() + ChatColor.GOLD + ".");
					}
					if (args[0].equalsIgnoreCase("wolf") || args[0].equalsIgnoreCase("dog")) {
						EntityType mob = EntityType.WOLF;
						Location l = player.getEyeLocation();
						World w = player.getWorld();
						w.spawnEntity(l, mob);
						w.playEffect(l, Effect.MOBSPAWNER_FLAMES, 2);
						player.sendMessage(ChatColor.GOLD + "Spawned a " + ChatColor.GREEN + args[0].toUpperCase() + ChatColor.GOLD + ".");
					}
					if (args[0].equalsIgnoreCase("horse")) {
						EntityType mob = EntityType.HORSE;
						Location l = player.getEyeLocation();
						World w = player.getWorld();
						w.spawnEntity(l, mob);
						w.playEffect(l, Effect.MOBSPAWNER_FLAMES, 2);
						player.sendMessage(ChatColor.GOLD + "Spawned a " + ChatColor.GREEN + args[0].toUpperCase() + ChatColor.GOLD + ".");
					}
					if (args[0].equalsIgnoreCase("cat") || args[0].equalsIgnoreCase("ocelot")) {
						EntityType mob = EntityType.OCELOT;
						Location l = player.getEyeLocation();
						World w = player.getWorld();
						w.spawnEntity(l, mob);
						w.playEffect(l, Effect.MOBSPAWNER_FLAMES, 2);
						player.sendMessage(ChatColor.GOLD + "Spawned a " + ChatColor.GREEN + args[0].toUpperCase() + ChatColor.GOLD + ".");
					}
					if (args[0].equalsIgnoreCase("squid")) {
						EntityType mob = EntityType.SQUID;
						Location l = player.getEyeLocation();
						World w = player.getWorld();
						w.spawnEntity(l, mob);
						w.playEffect(l, Effect.MOBSPAWNER_FLAMES, 2);
						player.sendMessage(ChatColor.GOLD + "Spawned a " + ChatColor.GREEN + args[0].toUpperCase() + ChatColor.GOLD + ".");
					}
					if (args[0].equalsIgnoreCase("mooshroom")) {
						EntityType mob = EntityType.MUSHROOM_COW;
						Location l = player.getEyeLocation();
						World w = player.getWorld();
						w.spawnEntity(l, mob);
						w.playEffect(l, Effect.MOBSPAWNER_FLAMES, 2);
						player.sendMessage(ChatColor.GOLD + "Spawned a " + ChatColor.GREEN + args[0].toUpperCase() + ChatColor.GOLD + ".");
					    }
				    }
				}
			} else {
				sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "You do not have permission to execute that command.");
			}
		}
		return true;
	}
}
