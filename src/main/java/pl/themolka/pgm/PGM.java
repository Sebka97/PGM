package pl.themolka.pgm;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import pl.themolka.pgm.api.Teams;
import pl.themolka.pgm.commands.JoinCommand;
import pl.themolka.pgm.commands.MaplistCommand;
import pl.themolka.pgm.commands.MyteamCommand;
import pl.themolka.pgm.commands.PgmCommand;
import pl.themolka.pgm.listeners.Gamer;
import pl.themolka.pgm.listeners.Observator;

public class PGM extends JavaPlugin {
	
	@Override
	public void onEnable() {
		File filedir = new File(getDataFolder() + "maps/");
		
		getCommand("join").setExecutor(new JoinCommand(this));
		getCommand("maplist").setExecutor(new MaplistCommand(this));
		getCommand("myteam").setExecutor(new MyteamCommand(this));
		getCommand("pgm").setExecutor(new PgmCommand(this));
		
		getServer().getPluginManager().registerEvents(new Gamer(this), this);
		getServer().getPluginManager().registerEvents(new Observator(this), this);
		
		Teams.setJoinable(true);
	}
	
	@Override
	public void onDisable() {
		
	}

}
