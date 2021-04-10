package com.geik.repair.exp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

@SuppressWarnings("unused")
public class Listeners implements Listener{
	
	private Main plugin;
	public Listeners(Main plugin) {
		this.plugin = plugin;}
	
	
	
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onInventoryclick(InventoryClickEvent e) {
		if (e.getView().getType() == InventoryType.ANVIL) {
			Player player = (Player) e.getWhoClicked();
				if (e.getCurrentItem().getType() == Material.NAME_TAG && e.getCurrentItem().getType() != null && e.getCurrentItem().getType() != Material.AIR) {
					e.setCancelled(true);
					e.getView().setItem(0, e.getCurrentItem());
					player.getInventory().setItem(e.getSlot(), null);
					player.updateInventory();
				}else e.setCancelled(true);
				if (e.getSlot() == 2 && e.getClickedInventory().getType() == InventoryType.ANVIL) {
					player.closeInventory();
					Main.isimEtiketi(player);
				}
		}
	}
	@EventHandler
	public void onrightclick(PlayerInteractEntityEvent e) {
		if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.NAME_TAG) {
			if (e.getRightClicked().getType() == EntityType.VILLAGER) e.setCancelled(true);
		}
	}
	/*@EventHandler
	public void onsneak(PlayerToggleSneakEvent e) {
	  Player player = e.getPlayer();
	  double launchStrength = (1.0D * 3.0D);
		if (player.isSneaking()) {return;}
		else {
		Location loc = player.getLocation();
		Vector dir = loc.getDirection().add(new Vector(0.0D, launchStrength, 0.0D));
		player.setVelocity(player.getVelocity().add(dir));}
	}*/

}
