package pl.themolka.pgm.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import pl.themolka.pgm.PGM;
import pl.themolka.pgm.api.Teams;

public class Player {
	
	PGM plugin;
	
	public Player(PGM plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerKick(PlayerKickEvent e) {
		e.setLeaveMessage(null);
		
		Teams.getBluePlayers.remove(e.getPlayer().getName());
		Teams.getRedPlayers.remove(e.getPlayer().getName());
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerJoinEvent e) {
		e.setJoinMessage(null);
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
		
		Teams.getBluePlayers.remove(e.getPlayer().getName());
		Teams.getRedPlayers.remove(e.getPlayer().getName());
	}
	
}
