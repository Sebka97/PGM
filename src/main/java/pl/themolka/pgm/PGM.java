package pl.themolka.pgm;

import java.io.File;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import pl.themolka.pgm.api.BungeeConector;
import pl.themolka.pgm.api.Game;
import pl.themolka.pgm.api.Teams;
import pl.themolka.pgm.commands.JoinCommand;
import pl.themolka.pgm.commands.MaplistCommand;
import pl.themolka.pgm.commands.MyteamCommand;
import pl.themolka.pgm.commands.PgmCommand;
import pl.themolka.pgm.listeners.Gamer;
import pl.themolka.pgm.listeners.Observator;

public class PGM extends JavaPlugin {
	
	public final File dir = new File("plugins/PGM");
	public final File configFile = new File(dir + "config.yml");
	public final File defaultFile = new File(dir + "default.yml");
	private static PGM instance;
	
	@Override
	public void onEnable() {
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		getCommand("join").setExecutor(new JoinCommand(this));
		getCommand("maplist").setExecutor(new MaplistCommand(this));
		getCommand("myteam").setExecutor(new MyteamCommand(this));
		getCommand("pgm").setExecutor(new PgmCommand(this));
		
		try {
			if(!dir.exists()) {
				getLogger().log(Level.INFO, "Saving default PGM's folder...");
				dir.mkdir();
				getLogger().log(Level.INFO, "PGM's folder saved!");
			}
			if(!configFile.exists()) {
				getLogger().log(Level.INFO, "Saving default config.yml file...");
				saveResource("config.yml", false);
				getLogger().log(Level.INFO, "config.yml filer saved!");
			}
			if(!defaultFile.exists()) {
				getLogger().log(Level.INFO, "Saving default default.yml...");
				saveResource("default.yml", false);
				getLogger().log(Level.INFO, "default.yml file saved!");
			}
		} catch(Exception ex) {
			getLogger().log(Level.SEVERE, "Failed to create default files!");
		}
		
		getServer().getPluginManager().registerEvents(new Gamer(this), this);
		getServer().getPluginManager().registerEvents(new Observator(this), this);
		
		Teams.setJoinable(true);
	}
	
	@Override
	public void onDisable() {
		Game.finish(null);
		
		if(BungeeConector.isBungeeCordEnabled()) {
			BungeeConector.kickAllToHub();
		}
	}
	
	public static PGM getInstance() {
		return instance;
	}
	
	public static void setInstance(PGM instance) {
		PGM.instance = instance;
	}

}
