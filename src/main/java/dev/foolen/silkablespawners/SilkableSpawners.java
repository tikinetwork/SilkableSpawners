package dev.foolen.silkablespawners;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import dev.foolen.silkablespawners.events.EventHandler;

public class SilkableSpawners extends JavaPlugin {
	
	public static final String PREFIX = ChatColor.BLUE + "[SilkableSpawners] " + ChatColor.GRAY;
	
	@Override
	public void onEnable() {
		// Events
		new EventHandler(this);
	}
}
