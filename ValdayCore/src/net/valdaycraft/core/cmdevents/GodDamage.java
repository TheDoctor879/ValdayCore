package net.valdaycraft.core.cmdevents;

import java.util.HashMap;

import net.valdaycraft.core.commands.God;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class GodDamage implements Listener {
	HashMap<String, Object> gods = God.gods;
	
	@EventHandler
	public void onGodlikeDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			if (gods.containsKey(player.getName())) {
				double h = player.getMaxHealth();
				player.setHealth(h);
			}
		}
	}

}
