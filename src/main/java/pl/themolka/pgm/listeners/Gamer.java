package pl.themolka.pgm.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import pl.themolka.pgm.PGM;
import pl.themolka.pgm.api.Game;
import pl.themolka.pgm.api.Teams;
import pl.themolka.pgm.files.MapYAML;

public class Gamer implements Listener {
	
	PGM plugin;
	Teams teams;
	
	public Gamer(PGM plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		//Game.finish("blue");
		// Monument - Blue
		if(Teams.isBlueTeam(e.getPlayer())) {
			// Blue
			if(e.getPlayer().getLocation() == MapYAML.getBlueCoreLocation()) {
				e.getPlayer().sendMessage(ChatColor.RED + "You can not destroy this monument!");
				e.setCancelled(true);
			}
			// Red
			if(e.getPlayer().getLocation() == MapYAML.getRedCoreLocation()) {
				e.getBlock().getLocation().getBlock().setType(Material.AIR);
				Bukkit.broadcastMessage(ChatColor.DARK_BLUE + e.getPlayer().getName() + ChatColor.DARK_PURPLE + " destroyed " + ChatColor.RED + Teams.getTeamName("red") + ChatColor.DARK_PURPLE + "'s monument!");
				e.getPlayer().sendMessage(ChatColor.RED + "You have destroyed the monument!");
				Game.finish("blue");
			}
		}
		// Monument - Red
		if(Teams.isRedTeam(e.getPlayer())) {
			// Blue
			if(e.getPlayer().getLocation() == MapYAML.getBlueCoreLocation()) {
				e.getBlock().getLocation().getBlock().setType(Material.AIR);
				Bukkit.broadcastMessage(ChatColor.RED + e.getPlayer().getName() + ChatColor.DARK_PURPLE + " destroyed " + ChatColor.DARK_BLUE + Teams.getTeamName("blue") + ChatColor.DARK_PURPLE + "'s monument!");
				e.getPlayer().sendMessage(ChatColor.RED + "You have destroyed the monument!");
				Game.finish("red");
			}
			// Red
			if(e.getPlayer().getLocation() == MapYAML.getRedCoreLocation()) {
				e.getPlayer().sendMessage(ChatColor.RED + "You can not destroy this monument!");
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		//Game.finish("red");
		if(Teams.isBlueTeam(e.getPlayer())) {
			// Blue
			if(e.getPlayer().getLocation() == MapYAML.getBlueCoreLocation()) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.RED + "You can not place blocks in the monument!");
			}
			// Red
			if(e.getPlayer().getLocation() == MapYAML.getRedCoreLocation()) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.RED + "You can not place blocks in the monument!");
			}
		}
		// Monument - Red
		if(Teams.isRedTeam(e.getPlayer())) {
			// Blue
			if(e.getPlayer().getLocation() == MapYAML.getBlueCoreLocation()) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.RED + "You can not place blocks in the monument!");
			}
			// Red
			if(e.getPlayer().getLocation() == MapYAML.getRedCoreLocation()) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.RED + "You can not place blocks in the monument!");
			}
		}
	}
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		if(Teams.isBlueTeam(e.getPlayer())) {
			e.setRespawnLocation(MapYAML.getBlueSpawnLocation());
			Teams.join(e.getPlayer(), "blue");
		}
		if(Teams.isRedTeam(e.getPlayer())) {
			e.setRespawnLocation(MapYAML.getRedSpawnLocation());
			Teams.join(e.getPlayer(), "red");
		}
	}
	
}
