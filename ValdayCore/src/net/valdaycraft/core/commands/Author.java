package net.valdaycraft.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import net.valdaycraft.core.Main;

public class Author implements CommandExecutor {
	
	Main plugin;
	
	public Author(Main iPlugin) {
		this.plugin = iPlugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("author")) {
			if (sender instanceof Player) {
				if (sender.hasPermission("valdaycore.author")) {
					if (args.length > 0) {
					    Player player = (Player) sender;
					    ItemStack i = player.getItemInHand();
					    int in = args.length;
					    StringBuilder sb = new StringBuilder();
					    for (String s : args) {
					        if (in != 0)
					            sb.append(" ");
					        sb.append(s);
					    }
					    String author = sb.toString();
					    if (i.getType() == Material.WRITTEN_BOOK) {
						    BookMeta bm = (BookMeta) i.getItemMeta();
						    bm.setAuthor("§b" + author);
						    player.sendMessage(ChatColor.GREEN + "Set " + ChatColor.GOLD + "" + ChatColor.ITALIC + bm.getTitle() + ChatColor.RESET + "" + ChatColor.GREEN + " to " + ChatColor.AQUA + author + ChatColor.GREEN + ".");
						    i.setItemMeta(bm);
					    } else {
					    	sender.sendMessage(ChatColor.RED + "You must be holding the book you wish to edit.");
					    }
					} else {
						sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "Where's the author?");
					}
				}
			}
		}
		return true;
	}
}
