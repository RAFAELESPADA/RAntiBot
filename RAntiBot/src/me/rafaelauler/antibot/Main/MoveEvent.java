package me.rafaelauler.antibot.Main;

import java.util.ArrayList;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;


public class MoveEvent implements Listener{
	/*    */   private Main main;
	/*    */   static Main plugin;
	/*    */   
	/*    */   public MoveEvent(Main main)
	/*    */   {
	/* 24 */     this.main = main;
	/* 25 */     plugin = main;
	/*    */   }
	public static ArrayList<String> move = new ArrayList();

	@EventHandler
	public void Player(PlayerJoinEvent e) {
		if (!move.contains(e.getPlayer().getName()) && !e.getPlayer().hasPermission("antibot.bypass")) {
			move.add(e.getPlayer().getName());
		}
	}
@EventHandler
public void onPlayerMove(PlayerToggleSneakEvent e) {
	if (move.contains(e.getPlayer().getName()) && !e.getPlayer().hasPermission("antibot.bypass")) {
		move.remove(e.getPlayer().getName());
	}
}
	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		if (move.contains(e.getPlayer().getName()) && !e.getPlayer().hasPermission("antibot.bypass")) {
			e.getPlayer().sendMessage(this.main.getConfig().getString("MustSneakToTalk").replace("&", "§"));
			e.setCancelled(true);
}
	}
		@EventHandler
		public void leave(PlayerQuitEvent e) {
			if (move.contains(e.getPlayer().getName()) && !e.getPlayer().hasPermission("antibot.bypass")) {
				move.remove(e.getPlayer());
				JoinListener.canplay.remove(e.getPlayer().getName());
				
	}
}
}
