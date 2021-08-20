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

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("rantibot"))
		{
			if (args.length == 0 || args[0].equalsIgnoreCase("help"))
			{
				sender.sendMessage(
						ChatColor.DARK_AQUA + "§m-----------" + ChatColor.AQUA + " RAntiBot COMMANDS " + ChatColor.DARK_AQUA + ChatColor.STRIKETHROUGH + "-------------", 
						ChatColor.DARK_AQUA + "§eCreated by zEnderX5_",
						"",
						ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/rantibot " + ChatColor.GREEN + "help" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Display this help page",
						ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/rantibot " + ChatColor.GREEN + "info" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Display plugin info!",
						ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/rantibot " + ChatColor.GREEN + "reload" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Reload config file!",
						ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/rantibot " + ChatColor.GREEN + "reset" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Reset the AntiBot player data!");
				return true;
			}

			if (args[0].equalsIgnoreCase("info"))
			{
				sender.sendMessage(
						"§2§lCREDITS §f§lAND §e§lINFORMATION",
						"§6\u279C §cPlugin Name: §eRAntiBot",
						"§6\u279C §cPlugin Version: §eBUILD-5",
						"§6\u279C §cAuthor: §ezEnderX5_ , Rafael Auler",
						"§6\u279C §cAuthor Channel: http://bit.ly/2kC345B",
						"§6\u279C §cSpigot Profile: http://bit.ly/2j5qvnM",
						"§cThanks for use this plugin i really appreaciate IT",
						"§cIf you like it consider giving a §e§l\u2605\u2605\u2605\u2605\u2605 §cReview",
						"§cPS: §eSubscribe to my channel and follow me on Spigot Thanks! §9§l=)");
				
				return true;
			}

			if (args[0].equalsIgnoreCase("reload"))
			{

				if (!sender.hasPermission("rantibot.reload")) 
				{
					Player p = (Player)sender;
					p.sendMessage("§b[RAntiBot] §cYou dont have permission!");
					return true;
				}
				Player p = (Player)sender;
				Plugin plugin = p.getServer().getPluginManager().getPlugin("RAntiBot");
				plugin.reloadConfig();
				p.getServer().getPluginManager().disablePlugin(plugin);
				p.getServer().getPluginManager().enablePlugin(plugin);
				p.sendMessage("§b[RAntiBot] §eThe config has been sucefully reloaded!");

				return true;
			}

			if (args[0].equalsIgnoreCase("reset"))
			{

				if (!sender.hasPermission("rantibot.reset")) 
				{
					Player p = (Player)sender;
					p.sendMessage("§b[RAntiBot] §cYou dont have permission!");
					return true;
				}

				if (!JoinListener.canplay.isEmpty()) {
					JoinListener.canplay.clear();
					sender.sendMessage(
							"§b[RAntiBot] §eYou reset all antibot data!",
							"§b[RAntiBot] §eNow all players that dont have the",
							"§b[RAntiBot] §ePermission antibot.bypass",
							"§b[RAntiBot] §eMust be verified by the antibot again");
					Bukkit.getConsoleSender().sendMessage("§b[RAntiBot] §eThe player data has been reseted by " + sender.getName() + "!");
				} else {
					sender.sendMessage("§b[RAntiBot] §cDont exists any data to remove!");
				}
				return true;
			}
			return true;
		}
		return false;
	}
}