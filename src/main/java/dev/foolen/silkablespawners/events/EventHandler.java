package dev.foolen.silkablespawners.events;

import org.bukkit.plugin.PluginManager;

import dev.foolen.silkablespawners.SilkableSpawners;
import dev.foolen.silkablespawners.events.listeners.OnBlockBreakEvent;
import dev.foolen.silkablespawners.events.listeners.OnBlockPlaceEvent;

public class EventHandler {

	public EventHandler(SilkableSpawners plugin) {
		PluginManager pm = plugin.getServer().getPluginManager();
		
		pm.registerEvents(new OnBlockBreakEvent(), plugin);
		pm.registerEvents(new OnBlockPlaceEvent(), plugin);
	}
}
