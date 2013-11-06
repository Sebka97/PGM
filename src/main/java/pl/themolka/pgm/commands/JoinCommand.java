package pl.themolka.pgm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.themolka.pgm.PGM;
import pl.themolka.pgm.api.Teams;

public class JoinCommand implements CommandExecutor {

	PGM plugin;
	
	public JoinCommand(PGM plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("join") || command.getName().equalsIgnoreCase("play")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Bad sender!");
				return true;
			}
			if(args.length == 0) {
				Teams.setTeam((Player) sender, null);
				return true;
			}
			if(args.length == 1) {
				Teams.setTeam((Player) sender, args[0]);
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "Too many arguments!");
				return true;
			}
		}
		return false;
	}
	
}
