package pl.themolka.pgm.files;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import pl.themolka.pgm.PGM;

public class MapYAML {
	
	PGM plugin;
	
	public MapYAML(PGM plugin) {
		this.plugin = plugin;
	}
	
	public static String getWorldName() {
		// TODO File
		return "world";
	}
	
	public static String getBlueName() {
		// TODO File
		return "Blue Team";
	}
	
	public static Location getBlueSpawnLocation() {
		// TODO File
		Location spawn = new Location(Bukkit.getWorld(getWorldName()), -0, 64, -0);
		return spawn;
	}
	
	public static Location getBlueCoreLocation() {
		// TODO File
		Location core = new Location(Bukkit.getWorld(getWorldName()), -0.0, 64.0, -0.0);
		return core;
	}
	
	public static int getMaxPlayers() {
		// TODO File
		return 25;
	}
	
	public static String getRedName() {
		// TODO File
		return "Red Team";
	}
	
	public static Location getRedSpawnLocation() {
		// TODO File
		Location spawn = new Location(Bukkit.getWorld(getWorldName()), 0, 64, 0);
		return spawn;
	}
	
	public static Location getRedCoreLocation() {
		// TODO File
		Location core = new Location(Bukkit.getWorld(getWorldName()), 0.0, 64.0, 0.0);
		return core;
	}
	
	
	public static void setWorldName(String name) {
		// TODO File
	}
	
	public static void setBlueName(String name) {
		// TODO File
	}
	
	public static void setBlueSpawnLocation(Location location) {
		// TODO File
	}
	
	public static void setBlueCoreLocation(Location location) {
		// TODO File
	}
	
	public static void setMaxPlayers(int amount) {
		// TODO File
	}
	
	public static void setRedName(String name) {
		// TODO File
	}
	
	public static void setRedSpawnLocation(Location location) {
		// TODO File
	}
	
	public static void setRedCoreLocation() {
		// TODO File
	}
	
}
