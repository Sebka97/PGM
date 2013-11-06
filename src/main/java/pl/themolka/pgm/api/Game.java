package pl.themolka.pgm.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import pl.themolka.pgm.files.MapYAML;

public class Game {
	
	public static void finish(String won) {
		Teams.setJoinable(false);
		if(won.equalsIgnoreCase("red")) {
			for(String playerStr : Teams.getBluePlayers) {
				Player player = Bukkit.getPlayer(playerStr);
				if(player.isOnline()) {
					Teams.getBluePlayers.remove(player.getName()); // TODO
					player.setGameMode(GameMode.CREATIVE);
					player.getInventory().setItem(0, new ItemStack(Material.COMPASS, 1));
					
					player.sendMessage(ChatColor.DARK_PURPLE + "########################");
					player.sendMessage(ChatColor.DARK_PURPLE + "#       " + ChatColor.RED + "Your team lost!" + ChatColor.DARK_PURPLE + "       #");
					player.sendMessage(ChatColor.DARK_PURPLE + "########################");
				}
			}
			for(String playerStr : Teams.getRedPlayers) {
				Player player = Bukkit.getPlayer(playerStr);
				if(player.isOnline()) {
					Teams.getRedPlayers.remove(player.getName()); // TODO
					player.setGameMode(GameMode.CREATIVE);
					player.getInventory().setItem(0, new ItemStack(Material.COMPASS, 1));
					
					player.sendMessage(ChatColor.DARK_PURPLE + "########################");
					player.sendMessage(ChatColor.DARK_PURPLE + "#       " + ChatColor.DARK_GREEN + "Your team won!" + ChatColor.DARK_PURPLE + "       #");
					player.sendMessage(ChatColor.DARK_PURPLE + "########################");
				}
			}
		}
		if(won.equalsIgnoreCase("blue")) {
			for(String playerStr : Teams.getBluePlayers) {
				Player player = Bukkit.getPlayer(playerStr);
				if(player.isOnline()) {
					Teams.getBluePlayers.remove(player.getName()); // TODO
					player.setGameMode(GameMode.CREATIVE);
					player.getInventory().setItem(0, new ItemStack(Material.COMPASS, 1));
					
					player.sendMessage(ChatColor.DARK_PURPLE + "########################");
					player.sendMessage(ChatColor.DARK_PURPLE + "#       " + ChatColor.DARK_GREEN + "Your team won!" + ChatColor.DARK_PURPLE + "       #");
					player.sendMessage(ChatColor.DARK_PURPLE + "########################");
				}
			}
			for(String playerStr : Teams.getRedPlayers) {
				Player player = Bukkit.getPlayer(playerStr);
				if(player.isOnline()) {
					Teams.getRedPlayers.remove(player.getName()); // TODO
					player.setGameMode(GameMode.CREATIVE);
					player.getInventory().setItem(0, new ItemStack(Material.COMPASS, 1));
					
					player.sendMessage(ChatColor.DARK_PURPLE + "########################");
					player.sendMessage(ChatColor.DARK_PURPLE + "#      " + ChatColor.RED + "Your team lost!" + ChatColor.DARK_PURPLE + "      #");
					player.sendMessage(ChatColor.DARK_PURPLE + "########################");
				}
			}
		}
	}
	
	public static void start() {
		for(String playerStr : Teams.getBluePlayers) {
			Player player = Bukkit.getPlayer(playerStr);
			if(player.isOnline()) {
				player.setGameMode(GameMode.SURVIVAL);
				player.teleport(MapYAML.getBlueSpawnLocation());
				
				Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "########################");
				Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "#  " + ChatColor.DARK_GREEN + "The match has started!" + ChatColor.DARK_PURPLE + "  #");
				Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "########################");
			}
		}
		for(String playerStr : Teams.getRedPlayers) {
			Player player = Bukkit.getPlayer(playerStr);
			if(player.isOnline()) {
				player.setGameMode(GameMode.SURVIVAL);
				player.teleport(MapYAML.getRedSpawnLocation());
				
				Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "########################");
				Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "#  " + ChatColor.DARK_GREEN + "The match has started!" + ChatColor.DARK_PURPLE + "  #");
				Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "########################");
			}
		}
	}
	
}
