package com.childishalbino.yerawizard;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class SpellCaster {
	
	private static boolean isWand(ItemStack item) {
		if (item.getType().equals(Material.STICK)
				&& item.getItemMeta().getDisplayName().equals("Wand")
				&& item.containsEnchantment(Enchantment.KNOCKBACK)) {
			return true;
		}
		return false;
	}
	
	public static ItemStack getSpellItem(PlayerInteractEvent event) {
		return event.getPlayer().getInventory().getItemInOffHand();
	}
	
	@SuppressWarnings("deprecation")
	public static boolean cast(PlayerInteractEvent event, Sound sound, Effect particles, String exclamation) {
		Player player = event.getPlayer();
    	Location playerLocation = player.getLocation();
    	PlayerInventory inventory = player.getInventory();
		ItemStack offHandItem = inventory.getItemInOffHand();
		ItemStack wandItem = event.getItem();

    	// TODO: add proper check so players can't just rename an item to "Wand"
    	if (SpellCaster.isWand(wandItem)) {
			player.chat(exclamation);
			player.getWorld().playSound(playerLocation, sound, 1, 0);
			player.getWorld().playEffect(playerLocation, particles, 0);
    		offHandItem.setAmount(offHandItem.getAmount() - 1);
    		// TODO: do we need to call updateInventory?
    		player.updateInventory();
    		return true;
    	}
    	return false;
	}
}
