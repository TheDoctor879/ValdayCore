package net.valdaycraft.core.commands;

import net.valdaycraft.core.Main;
import net.valdaycraft.core.api.ValdayCraft;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ArmorCmd implements CommandExecutor {
	
	Main plugin;
	
	public ArmorCmd(Main iPlugin) {
		this.plugin = iPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("armor")) {
			if (sender.hasPermission("valdaycore.armor")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
			    	ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
			    	ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
			    	ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
			    	LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
			    	LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
			    	LeatherArmorMeta legMeta = (LeatherArmorMeta) legs.getItemMeta();
			    	LeatherArmorMeta bootMeta = (LeatherArmorMeta) boots.getItemMeta();
				    if (ValdayCraft.getRank(player).equalsIgnoreCase("Organization")) {
				    	helmetMeta.setColor(Color.YELLOW);
				    	bootMeta.setColor(Color.YELLOW);
				    	if (player.getName().equalsIgnoreCase("ironhippo")) {
				    		chestMeta.setColor(Color.AQUA);
				    		legMeta.setColor(Color.AQUA);
				    	}
				    	if (player.getName().equalsIgnoreCase("colbyc123") || player.getName().equalsIgnoreCase("FGCsparta")) {
				    		chestMeta.setColor(Color.NAVY);
				    		legMeta.setColor(Color.NAVY);
				    	}
				    	helmet.setItemMeta(helmetMeta);
				    	chest.setItemMeta(chestMeta);
				    	legs.setItemMeta(legMeta);
				    	boots.setItemMeta(bootMeta);
				    	player.getInventory().setHelmet(helmet);
				    	player.getInventory().setChestplate(chest);
				    	player.getInventory().setLeggings(legs);
				    	player.getInventory().setBoots(boots);
				    }
				}
			}
		}
		return true;
	}
}
