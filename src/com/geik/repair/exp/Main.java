package com.geik.repair.exp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import io.puharesource.mc.titlemanager.api.v2.TitleManagerAPI;



public class Main extends JavaPlugin{
	
	public static boolean license = false;
	public static String  pluginName = "GeikRepair";
	private Listeners listeners;
	public static Main instance;
	public static String login = "&4&lUnauthorized Login!";
	public static TitleManagerAPI api = (TitleManagerAPI) Bukkit.getServer().getPluginManager().getPlugin("TitleManager");
	
	public void onEnable() {
		instance = this;
		this.listeners = new Listeners(this);;
		Bukkit.getPluginManager().registerEvents(this.listeners, this);
		getCommand("tamir").setExecutor(new Commands(this));
		Bukkit.getConsoleSender().sendMessage(color("&6&lGeikRepair &aLoaded! Version: 2.0"));
		Bukkit.getConsoleSender().sendMessage(color("&6&lGeikRepair &aMade by Geik."));
		
	}
	public static String color(String yazirengi){return ChatColor.translateAlternateColorCodes('&', yazirengi);}
	
	
	public void test() {
		String asd = "asd";
		switch(asd) {
		case "asd": Bukkit.broadcastMessage("asd");
		
		
		}
	}
	
	public static void isimEtiketi(Player player){
		String subti = Main.color("&7Baþarýyla isim deðiþtirildi.");
		String noti = Main.color("&6Ýsim Etiketi");
		api.sendTitle(player, noti, 10, 40, 10);
    	api.sendSubtitle(player, subti);
		}
	public static void tamirSuccess(Player player){
		String subti = Main.color("&7Tamir gerçekleþtirildi.");
		String noti = Main.color("&6&lTAMIR");
		api.sendTitle(player, noti, 10, 40, 10);
    	api.sendSubtitle(player, subti);
		}
	public static void tamirunSucess(Player player){
		String subti = Main.color("&7Bu eþya tamir edilemez!.");
		String noti = Main.color("&4TAMIR HATASI");
		api.sendTitle(player, noti, 10, 40, 10);
    	api.sendSubtitle(player, subti);
		}
	public static void levelRequire(Player player, String xp){
		String subti = Main.color("&7Bunun için &b" + xp + " &7seviye olman gerek!.");
		String noti = Main.color("&4XP Yetersiz");
		api.sendTitle(player, noti, 10, 60, 10);
    	api.sendSubtitle(player, subti);
		}
	

}
