package me.rafaelauler.antibot.Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import me.rafaelauler.antibot.Main.Main;

public class JoinListener implements Listener {
  
	public static ArrayList<String> canplay = new ArrayList();

	@EventHandler
	public void onFirstLogin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if (!canplay.contains(p.getName()) && !p.hasPermission("antibot.bypass")) {
			e.setKickMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageKick")));
			e.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("MessageKick")));
			canplay.add(p.getName());
			MoveEvent.move.remove(p.getName());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				public void run() {
					if (!JoinListener.canplay.isEmpty()) {
						JoinListener.canplay.clear()
						Bukkit.getConsoleSender().sendMessage("§b[RAntiBot] §eThe player data has been reseted!");
					}
				}
			}, 20 * 60 * Main.getInstance().getConfig().getInt(("Interval")));
		}
	}
}





