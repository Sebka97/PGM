package pl.themolka.pgm.commands.pgmcmd;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import pl.themolka.pgm.PGM;

public class About {
	
	public static boolean about(CommandSender sender) {
		sender.sendMessage(ChatColor.GOLD + " ===== PGM inspirated by Overcast Network ===== ");
		sender.sendMessage(ChatColor.GOLD + "Version: " + ChatColor.GRAY + PGM.getInstance().getDescription().getVersion());
		sender.sendMessage(ChatColor.GOLD + "Author: " + ChatColor.GRAY + PGM.getInstance().getDescription().getAuthors().toString());
		sender.sendMessage(ChatColor.GOLD + "Source code: " + ChatColor.GRAY + "https://github.com/TheMolkaPL/PGM");
		return true;
	}
	
}
