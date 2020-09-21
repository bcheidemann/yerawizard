package com.childishalbino.yerawizard;

import org.bukkit.Effect;
//import org.bukkit.Location;
//import org.bukkit.Material;
import org.bukkit.Sound;
//import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
//import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
//import org.bukkit.inventory.PlayerInventory;

public class SpellEventHandler implements Listener {
	
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
		ItemStack spellItem = SpellCaster.getSpellItem(event);
		boolean wasCast = false;
		
		switch(spellItem.getType()) {
			case CLOCK:
				wasCast = SpellCaster.cast(
						event,
						Sound.BLOCK_RESPAWN_ANCHOR_DEPLETE,
						Effect.DRAGON_BREATH,
						"Lumos!"
				);
				if(wasCast) {
					Spells.castLumos(event);
				}
				break;
			default:
				break;
		}

    }
	
}
