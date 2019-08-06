package dev.foolen.silkablespawners.events.listeners;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dev.foolen.silkablespawners.SilkableSpawners;

public class OnBlockBreakEvent implements Listener {

	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent e) {
		Player player = e.getPlayer();
		
		// Check if player has permission
		if (player.hasPermission("silkablespawners.break")) {
			// Check if broken block is a spawner
			if (e.getBlock().getType() == Material.SPAWNER) {
				// Check if block is broken by a diamond pickaxe with silktouch
				if (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_PICKAXE && player
						.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)) {
					
					// get spawner meta data
					CreatureSpawner creatureSpawner = (CreatureSpawner) e.getBlock().getState();
					ItemStack spawnerItem = new ItemStack(e.getBlock().getType(), 1);
					ItemMeta spawnerMeta = spawnerItem.getItemMeta();

					// Set item meta
					spawnerMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + ""
							+ creatureSpawner.getSpawnedType().toString() + " Spawner");
					spawnerMeta.setLore(Arrays.asList(ChatColor.GRAY + "Obtained by " + player.getName() + "."));
					spawnerItem.setItemMeta(spawnerMeta);

					e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), spawnerItem);
					player.sendMessage(SilkableSpawners.PREFIX + "You've mined a spawner with silk touch.");
				}
			}
		}
	}
}
