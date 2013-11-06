package pl.themolka.pgm.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import pl.themolka.pgm.PGM;

public class MaplistCommand implements CommandExecutor {
	
	PGM plugin;
	
	public MaplistCommand(PGM plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return false;
	}
	
}
