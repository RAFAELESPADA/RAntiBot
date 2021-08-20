package me.rafaelauler.antibot.Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import me.rafaelauler.antibot.Main.Main;

public class MoveEvent implements Listener {

	public static ArrayList<String> move = new ArrayList();
	
	@EventHandler
	public void Player(PlayerJoinEvent e) {
		if (!move.contains(e.getPlayer().getName()) && !e.getPlayer().hasPermission("antibot.bypass")) {
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				public void run() {
					if (!move.contains(e.getPlayer().getName())) {           
						e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageRememberToSneak")));
					}
				}
			}, 60);

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				public void run() {
					if (!move.contains(e.getPlayer().getName())) {
						e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageRememberToSneak")));
					}
				}
			}, 90);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				
				public void run() {
					if (!move.contains(e.getPlayer().getName())) {            
						e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageRememberToSneak")));
					}
				}
			}, 120);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				public void run() {
					if (!move.contains(e.getPlayer().getName())) {           
						e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageRememberToSneak")));
					}
				
			}, 150);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				public void run() {
					if (!move.contains(e.getPlayer().getName())) {       
						e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageRememberToSneak")));
					}
				}
			}, 180);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				public void run() {
					if (!move.contains(e.getPlayer().getName())) {         
						e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageRememberToSneak")));
					}
				}
			}, 210);

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				public void run() {
					if (!move.contains(e.getPlayer().getName())) {      
						e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageRememberToSneak")));
					}
				}
			}, 240);

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				public void run() {
					if (!move.contains(e.getPlayer().getName())) {            
						e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageRememberToSneak")));
					}
				}
			}, 270);

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				public void run() {
					if (!move.contains(e.getPlayer().getName())) {
						e.getPlayer().kickPlayer(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("KickedBecauseNotSneak")));
					}
				}
			}, 300);
		}
	}

	@EventHandler
	public void onPlayerMove(PlayerToggleSneakEvent e) {
		if (!move.contains(e.getPlayer().getName()) && !e.getPlayer().hasPermission("antibot.bypass") ) {
			move.add(e.getPlayer().getName());
		}
	}

	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		if (!move.contains(e.getPlayer().getName())  && !e.getPlayer().hasPermission("antibot.bypass")) {
			e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MustSneakToTalk")));
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void leave(PlayerQuitEvent e) {
		if (!move.contains(e.getPlayer().getName()) && !e.getPlayer().hasPermission("antibot.bypass")) {
			JoinListener.canplay.remove(e.getPlayer().getName());
		}
	}
	
	@EventHandler
	public void leave(PlayerKickEvent e) {
		if (!move.contains(e.getPlayer().getName()) && !e.getPlayer().hasPermission("antibot.bypass")) {
			JoinListener.canplay.remove(e.getPlayer().getName());
		}
	}
}