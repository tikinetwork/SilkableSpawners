package dev.foolen.silkablespawners.events.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import dev.foolen.silkablespawners.SilkableSpawners;

public class OnBlockPlaceEvent implements Listener {

	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent e) {
		Player player = e.getPlayer();

		// Check if player has permission
		if (player.hasPermission("silkablespawners.place")) {
			// Check if placed block is spawner
			if (e.getBlock().getType() == Material.SPAWNER) {
				// Check if spawner has custom name
				if (e.getItemInHand().getItemMeta().getLore() != null) {

					String entityName = ChatColor.stripColor(e.getItemInHand().getItemMeta().getDisplayName())
							.split(" ")[0];
					EntityType entity = EntityType.valueOf(entityName);

					CreatureSpawner spawner = (CreatureSpawner) e.getBlockPlaced().getState();
					spawner.setSpawnedType(entity);
					spawner.update();
					e.getPlayer().sendMessage(
							SilkableSpawners.PREFIX + "Your " + entityName.toLowerCase() + " spawner has been placed!");
				}
			}
		}
	}
}
