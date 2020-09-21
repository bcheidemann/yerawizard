package com.childishalbino.yerawizard;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
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
		Player player = event.getPlayer();
        if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
        	Location playerLocation = player.getLocation();
        	PlayerInventory inventory = player.getInventory();
    		ItemStack offHandItem = inventory.getItemInOffHand();
    		ItemStack wandItem = event.getItem();
    		// ItemStack mainHandItem = inventory.getItemInMainHand();
        	// TODO: add proper check so players can't just rename an item to "Wand"
        	if (wandItem.getItemMeta().getDisplayName().equals("Wand")
        			&& wandItem.getType().equals(Material.STICK))
        	{
        		if (offHandItem.getType().equals(Material.CLOCK)) {
        			player.chat("Abracadabra!");
        			player.getWorld().playSound(playerLocation, Sound.BLOCK_RESPAWN_ANCHOR_DEPLETE, 1, 0);
        			player.getWorld().playEffect(playerLocation, Effect.DRAGON_BREATH, 0);
        			player.getWorld().setTime(0);
            		offHandItem.setAmount(offHandItem.getAmount() - 1);
            		// TODO: do we need to call updateInventory?
            		player.updateInventory();
        		}
        	}
        }
    }
	
}
