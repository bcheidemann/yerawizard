package com.childishalbino.yerawizard;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		getLogger().info("Yer all wizards now!");
		
		ItemStack bedrock = new ItemStack(Material.STICK, 1);
		
		bedrock.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);

		ItemMeta itemmeta = bedrock.getItemMeta();
		itemmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemmeta.setDisplayName("Wand");

		bedrock.setItemMeta(itemmeta);
		
		// TODO: remove deprecated code
		
		@SuppressWarnings("deprecation")
		ShapedRecipe recipe = new ShapedRecipe(bedrock);
		
		recipe.shape("***", "***", "***");
		
		recipe.setIngredient('*', Material.OAK_LOG);
		
		getServer().addRecipe(recipe);
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("basic")) { // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
			getLogger().info("called command");
			return true;
		} //If this has happened the function will return true. 
	        // If this hasn't happened the value of false will be returned.
		return false; 
	}
	
	@Override
	public void onDisable() {
		
		getLogger().info("Yer all muggles now!");
		
	}

}
