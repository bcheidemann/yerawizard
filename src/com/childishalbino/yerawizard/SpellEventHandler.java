package com.childishalbino.yerawizard;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class SpellEventHandler implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
        	PlayerInventory inventory = event.getPlayer().getInventory();
    		ItemStack offHandItem = inventory.getItemInOffHand();
    		ItemStack wandItem = event.getItem();
    		// ItemStack mainHandItem = inventory.getItemInMainHand();
        	// TODO: add proper check so players can't just rename an item to "Wand"
        	if (wandItem.getItemMeta().getDisplayName().equals("Wand")
        			&& wandItem.getType().equals(Material.STICK))
        	{
        		if (offHandItem.getType().equals(Material.CLOCK)) {
        			event.getPlayer().chat("Abracadabra!");
            		event.getPlayer().getWorld().setTime(0);
            		offHandItem.setAmount(offHandItem.getAmount() - 1);
            		// TODO: do we need to call updateInventory?
            		event.getPlayer().updateInventory();
        		}
        	}
        }
    }
	
}
