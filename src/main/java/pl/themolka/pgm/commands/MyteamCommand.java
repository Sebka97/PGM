package pl.themolka.pgm.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.themolka.pgm.PGM;
import pl.themolka.pgm.api.Teams;

public class MyteamCommand implements CommandExecutor {
	
	PGM plugin;
	
	public MyteamCommand(PGM plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("myteam") || command.getName().equalsIgnoreCase("mt")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Bad sender!");
				return true;
			}
			if(Teams.isBlueTeam((Player) sender)) {
				sender.sendMessage(ChatColor.DARK_PURPLE + "You are currently in the " + ChatColor.DARK_BLUE + Teams.getTeamName("blue") + ChatColor.DARK_PURPLE + ".");
				return true;
			}
			if(Teams.isRedTeam((Player) sender)) {
				sender.sendMessage(ChatColor.DARK_PURPLE + "You are currently in the " + ChatColor.RED + Teams.getTeamName("red") + ChatColor.DARK_PURPLE + ".");
				return true;
			}
			if(Teams.isObservator((Player) sender)) {
				sender.sendMessage(ChatColor.DARK_PURPLE + "You are currently in the " + ChatColor.AQUA + "Observators Team" + ChatColor.DARK_PURPLE + ".");
				return true;
			}
		}
		return false;
	}
	
}
