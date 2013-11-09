package pl.themolka.pgm.api;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import pl.themolka.pgm.PGM;

public class BungeeConector {
	
	static PGM plugin;
	
	public BungeeConector(PGM plugin) {
		BungeeConector.plugin = plugin;
	}
	
	public static void connect(Player player, String server) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("Connect");
			out.writeUTF(server);
		} catch(IOException ex) {}
		player.sendMessage(ChatColor.GOLD + "You have been moved to Lobby server by reload or restart.");
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
	
	public static boolean isBungeeCordEnabled() {
		if(plugin.getConfig().getBoolean("bungee-cord.enable", true)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void kickAllToHub() {
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(player.isOnline()) {
				BungeeConector.connect(player, plugin.getConfig().getString("bungee-cord.hub-server"));
			}
		}
	}
	
}
