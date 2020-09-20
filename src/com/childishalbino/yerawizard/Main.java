package com.childishalbino.yerawizard;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		getLogger().info("Yer all wizards now!");
		
	}
	
	@Override
	public void onDisable() {
		
		getLogger().info("Yer all muggles now!");
		
	}

}
