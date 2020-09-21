package com.childishalbino.yerawizard;

import org.bukkit.event.player.PlayerInteractEvent;

public class Spells {
	public static void castLumos(PlayerInteractEvent event) {
		event.getPlayer().getWorld().setTime(0);
	}
}
