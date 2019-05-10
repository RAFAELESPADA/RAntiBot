package me.rafaelauler.antibot.Main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.rafaelauler.antibot.BStats.Metrics;



public class Main extends JavaPlugin {
	private Server server = Bukkit.getServer();
	public static Main instance;
	private PluginManager pm;
	/*     */   public static Main getInstance()
	/*     */   {
	/*  82 */     return instance;
	/*     */   }
	/*     */    public static Plugin plugin;
	/*     */   public static Main getInstace()
	/*     */   {
	/*  87 */     return instance;
	/*     */   }
	/*     */   
	
/*     */   public void onEnable() {
	
/*     */  /* 109 */     Metrics metrics = new Metrics(this);
getLogger().info("RAntiBot plugin is now enabled [By zEnderX5_]");
getLogger().info("Website: http://bit.ly/2kC345B");
Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(this), this);
Bukkit.getServer().getPluginManager().registerEvents(new MoveEvent(this), this);
getCommand("rantibot").setExecutor(new AntiBotCMD());
metrics.addCustomChart(new Metrics.DrilldownPie("serverAddress", () -> {
	Map<String, Map<String, Integer>> map = new HashMap<>();
	Map<String, Integer> entry = new HashMap<>();
	if (getConfig().getBoolean("SendIPAddressData")) entry.put(server.getIp(), 1);
	else entry.put("Hidden", 1);
	
	map.put("Port " + server.getPort(), entry);
	
	return map;
}));
/* 126 */     File cf = new File(getDataFolder(), "config.yml");
/* 127 */     if (!cf.exists()) {
/* 128 */       saveResource("config.yml", false);
/*     */   getConfig().options().copyDefaults(true);
/* 149 */       getConfig().options().copyHeader(true);
/* 150 */       saveConfig();

/*     */     }
plugin = this;
}
}