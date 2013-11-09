package pl.themolka.pgm.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import pl.themolka.pgm.PGM;
import pl.themolka.pgm.api.HelpCenter;
import pl.themolka.pgm.commands.pgmcmd.About;

public class PgmCommand implements CommandExecutor {
	
	PGM plugin;
	
	public PgmCommand(PGM plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("pgm")) {
			if(args.length == 0) {
				return true;
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("about") || args[0].equalsIgnoreCase("version")) {
					return About.about(sender);
				}
				if(args[0].equalsIgnoreCase("commands") || args[0].equalsIgnoreCase("cmds")) {
					
				}
				if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")) {
					return HelpCenter.help(sender, null);
				}
				if(args[0].equalsIgnoreCase("info")) {
					
				}
				if(args[0].equalsIgnoreCase("map")) {
					
				}
				if(args[0].equalsIgnoreCase("maplist")) {
					
				}
				if(args[0].equalsIgnoreCase("match")) {
					
				}
				if(args[0].equalsIgnoreCase("reload")) {
					
				}
				if(args[0].equalsIgnoreCase("set")) {
					
				} else {
					return true;
				}
			}
			if(args.length == 2) {
				if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")) {
					HelpCenter.help(sender, args[1]);
				} else {
					return true;
				}
			} else {
				return true;
			}
		}
		return false;
	}
	
}
