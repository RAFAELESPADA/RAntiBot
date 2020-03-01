package me.rafaelauler.antibot.Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
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
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
					/*     */         {
					public void run()

					/*     */           {
						if (!move.contains(e.getPlayer().getName())) {
					/* 165 */             
					e.getPlayer().sendMessage(Main.plugin.getConfig().getString("MessageRememberToSneak").replace("&", "§"));;
					/*     */           }
					/* 167 */         }}, 60);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
					/*     */         {
					public void run()

					/*     */           {
						if (!move.contains(e.getPlayer().getName())) {
					/* 165 */            
					e.getPlayer().sendMessage(Main.plugin.getConfig().getString("MessageRememberToSneak").replace("&", "§"));;
					/*     */           }
					/* 167 */         }}, 90);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()					
					/*     */         {
				
					public void run()

					/*     */           {
						if (!move.contains(e.getPlayer().getName())) {
					/* 165 */            
					e.getPlayer().sendMessage(Main.plugin.getConfig().getString("MessageRememberToSneak").replace("&", "§"));;
					/*     */           }
					/* 167 */         }}, 120);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
					/*     */         {
					public void run()

					/*     */           {
						if (!move.contains(e.getPlayer().getName())) {
					/* 165 */            
					e.getPlayer().sendMessage(Main.plugin.getConfig().getString("MessageRememberToSneak").replace("&", "§"));;
					/*     */           }
					/* 167 */         }}, 150);
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
							/*     */         {
							public void run()

							/*     */           {
								if (!move.contains(e.getPlayer().getName())) {
							/* 165 */            
							e.getPlayer().sendMessage(Main.plugin.getConfig().getString("MessageRememberToSneak").replace("&", "§"));;
							/*     */           }
							/* 167 */         }}, 180);
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
							/*     */         {
							public void run()

							/*     */           {
								if (!move.contains(e.getPlayer().getName())) {
							/* 165 */            
							e.getPlayer().sendMessage(Main.plugin.getConfig().getString("MessageRememberToSneak").replace("&", "§"));;
							/*     */           }
							/* 167 */         }}, 210);
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
					/*     */         {
					public void run()

					/*     */           {
						if (!move.contains(e.getPlayer().getName())) {
					/* 165 */            
					e.getPlayer().sendMessage(Main.plugin.getConfig().getString("MessageRememberToSneak").replace("&", "§"));;
					/*     */           }
					/* 167 */         }}, 240);
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
							/*     */         {
							public void run()

							/*     */           {
								if (!move.contains(e.getPlayer().getName())) {
							/* 165 */            
							e.getPlayer().sendMessage(Main.plugin.getConfig().getString("MessageRememberToSneak").replace("&", "§"));;
							/*     */           }
							/* 167 */         }}, 270);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
				/*     */         {
					public void run()

					/*     */           {
						if (!move.contains(e.getPlayer().getName())) {
							e.getPlayer().kickPlayer(Main.plugin.getConfig().getString("KickedBecauseNotSneak").replace("&", "§"));
					/*     */           }
					/* 167 */         }}, 300);
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
			e.getPlayer().sendMessage(this.main.getConfig().getString("MustSneakToTalk").replace("&", "§"));
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
