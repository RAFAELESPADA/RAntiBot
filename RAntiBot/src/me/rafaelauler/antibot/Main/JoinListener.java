package me.rafaelauler.antibot.Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;







public class JoinListener implements Listener {
	/*    */   private Main main;
	/*    */   static Main plugin;
	/*    */   
	/*    */   public JoinListener(Main main)
	/*    */   {
	/* 24 */     this.main = main;
	/* 25 */     plugin = main;
	/*    */   }
	/*    */   
	public static ArrayList<String> canplay = new ArrayList();

/*     */   @EventHandler
/*     */   public void onFirstLogin(PlayerLoginEvent e) {
/*     */   Player p = e.getPlayer();
if (!canplay.contains(p.getName()) && !p.hasPermission("antibot.bypass"))
{
	e.setKickMessage(this.main.getConfig().getString("MessageKick").replace("&", "§"));
	e.disallow(PlayerLoginEvent.Result.KICK_OTHER, (this.main.getConfig().getString("MessageKick").replace("&", "§")));
canplay.add(p.getName());
Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
/*     */         {
public void run()

/*     */           {
	if (!JoinListener.canplay.isEmpty()) {
/* 165 */             JoinListener.canplay.remove(String.valueOf(JoinListener.canplay.size()));
Bukkit.getConsoleSender().sendMessage("§b[RAntiBot] §eThe player data has been reseted!");
/*     */           }
/* 167 */         }}, 20 * 60 * this.main.getConfig().getInt(("Interval")));
/*     */       }
}
}


