package me.rafaelauler.antibot.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;





public class AntiBotCMD implements CommandExecutor {

	static Main plugin;
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
/*  91 */     if (commandLabel.equalsIgnoreCase("rantibot"))
/*     */     {
	/*  93 */       if (args.length == 0)
	/*     */       {

	/* 106 */         sender.sendMessage(ChatColor.DARK_AQUA + "§m-----------" + ChatColor.AQUA + " RAntiBot COMMANDS " + ChatColor.DARK_AQUA + ChatColor.STRIKETHROUGH + "-------------");
	/* 107 */         sender.sendMessage(ChatColor.DARK_AQUA + "§eCreated by zEnderX5_");
	/* 108 */         sender.sendMessage("");
	/* 109 */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/rantibot" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Display this help page");
	/* 110 */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/rantibot " + ChatColor.GREEN + "info" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Display plugin info!");
	/* 111 */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/rantibot " + ChatColor.GREEN + "reload" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Reload config file!");
	                  sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/rantibot " + ChatColor.GREEN + "reset" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Reset the AntiBot player data!");
	/* 112 */         
	

	/* 102 */         return true;
	/*     */       }
/*  93 */       if (args[0].equalsIgnoreCase("info"))
{
	/* 27 */       sender.sendMessage("§2§lCREDITS §f§lAND §e§lINFORMATION");
	/* 28 */       sender.sendMessage("§6\u279C §cPlugin Name: §eRAntiBot");
	/* 29 */       sender.sendMessage("§6\u279C §cPlugin Version: §eBUILD-5");
	/* 30 */       sender.sendMessage("§6\u279C §cAuthor: §ezEnderX5_ , Rafael Auler");
	/* 31 */       sender.sendMessage("§6\u279C §cAuthor Channel: http://bit.ly/2kC345B");
	/* 32 */       sender.sendMessage("§6\u279C §cSpigot Profile: http://bit.ly/2j5qvnM");
	/* 34 */       sender.sendMessage("§cThanks for use this plugin i really appreaciate IT");
	/* 35 */       sender.sendMessage("§cIf you like it consider giving a §e§l\u2605\u2605\u2605\u2605\u2605 §cReview");
	/* 36 */       sender.sendMessage("§cPS: §eSubscribe to my channel and follow me on Spigot Thanks! §9§l=)");
	 return true;
		/*     */       }
/*  93 */       if (args[0].equalsIgnoreCase("reload"))
/*     */       {

	if (!sender.hasPermission("rantibot.reload")) {
		Player p = (Player)sender;
		/* 31 */         p.sendMessage("§b[RAntiBot] §cYou dont have permission!");
		/* 32 */         
		/* 33 */         return true;
		/*    */       }
		/*    */       Player p = (Player)sender;
		/* 36 */       Plugin plugin = p.getServer().getPluginManager().getPlugin("RAntiBot");
		/* 37 */       plugin.reloadConfig();
		/* 38 */       p.getServer().getPluginManager().disablePlugin(plugin);
		/* 39 */       p.getServer().getPluginManager().enablePlugin(plugin);
		/* 40 */        p.sendMessage("§b[RAntiBot] §eThe config has been sucefully reloaded!");

/* 102 */         return true;
/*     */       }
/*  93 */       if (args[0].equalsIgnoreCase("reset"))
/*     */       {

	if (!sender.hasPermission("rantibot.reset")) {
		Player p = (Player)sender;
		/* 31 */         p.sendMessage("§b[RAntiBot] §cYou dont have permission!");
		/* 32 */         
		/* 33 */         return true;
		/*    */       }
	if (!JoinListener.canplay.isEmpty()) {
		JoinListener.canplay.remove(String.valueOf(JoinListener.canplay.size()));
		sender.sendMessage("§b[RAntiBot] §eYou reset all antibot data!");
		sender.sendMessage("§b[RAntiBot] §eNow all players that dont have the");
		sender.sendMessage("§b[RAntiBot] §ePermission antibot.bypass");
		sender.sendMessage("§b[RAntiBot] §eMust be verified by the antibot again");
		Bukkit.getConsoleSender().sendMessage("§b[RAntiBot] §eThe player data has been reseted by " + sender.getName() + "!");
	} else {
		sender.sendMessage("§b[RAntiBot] §cDont exists any data to remove!");
	}
/* 102 */         return true;
/*     */       }

		

/* 102 */         return true;
/*     */       }
return false;



}
}
