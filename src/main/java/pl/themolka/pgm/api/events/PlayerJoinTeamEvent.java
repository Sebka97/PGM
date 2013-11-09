package pl.themolka.pgm.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerJoinTeamEvent extends Event {
	
	private static final HandlerList handlers = new HandlerList();
	private Player player;
	private String team;
	
	public PlayerJoinTeamEvent(Player player, String team) {
		this.player = player;
		this.team = team;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public String getTeam() {
		return team;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
