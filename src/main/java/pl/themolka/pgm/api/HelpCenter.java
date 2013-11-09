package pl.themolka.pgm.api;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class HelpCenter {
	
	public static boolean help(CommandSender sender, String command) {
		if(command == null) {
			sender.sendMessage(ChatColor.GOLD + " ===== PGM's Help Center ===== ");
			sender.sendMessage(ChatColor.GRAY + "Welcome to PGM's help center. Here you can get a help for specifited command!");
			sender.sendMessage(ChatColor.GOLD + "Let's started by using /pgm help <command>!");
			sender.sendMessage(ChatColor.GOLD + "Get all PGM's commands by typing /pgm commands");
			return true;
		}
		
		if(command.equalsIgnoreCase("about") || command.equalsIgnoreCase("version")) {
			sendHelp(sender, "/pgm about", "version", "Show all informations about this plugin", "/pgm about", null, true);
			return true;
		}
		if(command.equalsIgnoreCase("commands") || command.equalsIgnoreCase("cmds")) {
			sendHelp(sender, "/pgm commands", "cmds", "Get all PGM's commands", "/pgm commands", null, true);
			return true;
		}
		if(command.equalsIgnoreCase("help") || command.equalsIgnoreCase("?")) {
			sendHelp(sender, "/pgm help", "?", "Show PGM's help center", "/pgm help\n/pgm help <command>", null, true);
			return true;
		}
		if(command.equalsIgnoreCase("info")) {
			sendHelp(sender, "/pgm info", null, "Show all information about currently settings", "/pgm info map <author>\n/pgm info map <version>\n/pgm info map <desc>", "pgm.op.info", true);
			return true;
		}
		if(command.equalsIgnoreCase("join")) {
			sendHelp(sender, "/join", "play", "Join to the team and start the game", "/join\n/join blue\n/join obs\n/join red", null, false);
			return true;
		}
		if(command.equalsIgnoreCase("map")) {
			sendHelp(sender, "/pgm map", null, "Show all informations about maps", "/pgm map new <name>\n/pgm map del <name>", "pgm.op.map", true);
			return true;
		}
		if(command.equalsIgnoreCase("maplist")) {
			sendHelp(sender, "/pgm maplist", null, "Show all loades maps on this server", "/maplist", null, true);
			return true;
		}
		if(command.equalsIgnoreCase("match")) {
			sendHelp(sender, "/pgm match", null, "Show all informations about current match", "/pgm match\n/pgm match start\n/pgm match end", "pgm.op.match", false);
			return true;
		}
		if(command.equalsIgnoreCase("myteam")) {
			sendHelp(sender, "/myteam", "mt", "Get information about team you are on", "/myteam", null, false);
			return true;
		}
		if(command.equalsIgnoreCase("pgm")) {
			sendHelp(sender, "/pgm", null, "Set/get informations about this plugin and more", "/pgm commands", null, true);
			return true;
		}
		if(command.equalsIgnoreCase("reload")) {
			sendHelp(sender, "/pgm reload", null, "Reload all plugin settings and maps files", "/pgm reload", "pgm.op.reload", true);
			return true;
		}
		if(command.equalsIgnoreCase("set")) {
			sendHelp(sender, "/pgm set", null, "Set a setting", "/pgm set <setting> <value>", "pgm.op.set", true);
			return true;
		} else {
			sender.sendMessage(ChatColor.RED + "Help for \"" + command + "\" was not found! Please try again and typing other command");
			return true;
		}
	}
	
	public static void sendHelp(CommandSender sender, String command, String alias, String description, String usage, String permission, boolean canConsole) {
		sender.sendMessage(ChatColor.GOLD + " ===== PGM's help center ===== ");
		sender.sendMessage(ChatColor.GOLD + "Help for: " + ChatColor.GRAY + command);
		sender.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.GRAY + description);
		if(!(alias == null)) {
			sender.sendMessage(ChatColor.GOLD + "Aliases: " + ChatColor.GRAY + alias);
		}
		if(!(permission == null)) {
			sender.sendMessage(ChatColor.GOLD + "Permission: " + ChatColor.GRAY + permission);
		}
		if(canConsole == true) {
			sender.sendMessage(ChatColor.DARK_GREEN + "This command can be use by console!");
		}
		if(canConsole == false) {
			sender.sendMessage(ChatColor.RED + "This command can not be use by console!");
		}
		sender.sendMessage(ChatColor.GOLD + "Usage: " + ChatColor.GRAY + usage);
	}
	
}
