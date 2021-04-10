package com.geik.repair.exp;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Commands implements CommandExecutor{
	
	@SuppressWarnings("unused")
	private Main plugin;
	  protected Commands(Main plugin) {
	    this.plugin = plugin;}
	  

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("tamir")) {
		  if (args.length == 0) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.getLevel() >= 35 || player.hasPermission("tamir.bypass")) {
					ItemStack playerItems = player.getItemInHand();
					if (playerItems != null) {
						if(playerItems.getDurability() > 0) {
							if (playerItems.getType() != Material.ELYTRA && playerItems.getType() != Material.TRIDENT ) {
								if (playerItems.getType() != Material.WOODEN_HOE
									&& playerItems.getType() != Material.STONE_HOE
									&& playerItems.getType() != Material.IRON_HOE
									&& playerItems.getType() != Material.DIAMOND_HOE) {
									
								
					            	playerItems.setDurability((short)0);
					            	Main.tamirSuccess(player);
					            	int playerlevel = player.getLevel();
					            	if (!player.hasPermission("tamir.bypass")) player.setLevel(playerlevel - 35);
					            	
								} else {
									if (playerItems.hasItemMeta())  Main.tamirunSucess(player);
									else {
										playerItems.setDurability((short)0);
						            	Main.tamirSuccess(player);
						            	int playerlevel = player.getLevel();
						            	if (!player.hasPermission("tamir.bypass")) player.setLevel(playerlevel - 35);
									}
								}
				            	
				            	
							} else Main.tamirunSucess(player);
				        }
					  else Main.tamirunSucess(player);
					}

				} else {
					Main.levelRequire(player, "35");
				}
			}else sender.sendMessage(Main.color("&c&lTAMIR &cBunun için oyuncu olman gerek."));
		  }
		  else if (args.length == 1) {
			  if (sender instanceof Player) {
				  Player player = (Player) sender;
				  if (args[0].equalsIgnoreCase("hepsi") || args[0].equalsIgnoreCase("all")) {
				  if (player.getLevel() >= 80 || player.hasPermission("tamirall.bypass")) {
					  
						  tamirAll(player);
						  int playerlevel = player.getLevel();
						  Main.tamirSuccess(player);
						  if (!player.hasPermission("tamirall.bypass")) player.setLevel(playerlevel - 80);
				  }
				  else Main.levelRequire(player, "80");
			    }
				  else if (args[0].equalsIgnoreCase("yardým") || args[0].equalsIgnoreCase("yardim")) {
					  player.sendMessage(Main.color("&f        &e&lTAMIR YARDIM&r        &7"));
					  player.sendMessage(Main.color("&r"));
					  player.sendMessage(Main.color("&a/tamir &f- &7Eþyayý tamir eder."));
					  player.sendMessage(Main.color("&a/tamir <all/hepsi> &f- &7Bütün eþyalarý tamir eder."));
					  player.sendMessage(Main.color("&7Tamir bedeli: &e35 Seviye"));
					  player.sendMessage(Main.color("&7Tamir hepsi bedeli: &e60 Seviye"));
					  player.sendMessage(Main.color("&r"));
				  }
				  
				  
				  else player.sendMessage(Main.color("&e&lRIGELMC &cYanlýþ kullaným: &a/tamir yardým"));
		    }else sender.sendMessage(Main.color("&c&lTAMIR &cBunun için oyuncu olman gerek."));
		  }
		}
		return false;
	}
	@SuppressWarnings("deprecation")
	public void tamirAll(Player player) {
		for(ItemStack items : player.getInventory().getContents()) {
		  if (items != null) {
			if(items.getDurability() > 0) {
				if (items.getType() != Material.ELYTRA && items.getType() != Material.TRIDENT) {
					if (items.getType() != Material.WOODEN_HOE
							&& items.getType() != Material.STONE_HOE
							&& items.getType() != Material.IRON_HOE
							&& items.getType() != Material.DIAMOND_HOE) {
						items.setDurability((short)0);
					} else {
						if (items.hasItemMeta())  Main.tamirunSucess(player);
						else {
							items.setDurability((short)0);
						}
					}
				}
				
			}
		  }
    	}
		for(ItemStack items : player.getEquipment().getArmorContents()) {
			if (items != null) {
			  if(items.getDurability() > 0) {
				if (items.getType() != Material.ELYTRA && items.getType() != Material.TRIDENT) 
					items.setDurability((short)0);
			  }
            }
        }
	}



}
