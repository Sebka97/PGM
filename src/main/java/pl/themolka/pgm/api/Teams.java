package pl.themolka.pgm.api;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import pl.themolka.pgm.PGM;
import pl.themolka.pgm.files.MapYAML;

public class Teams {

	PGM plugin;
	
	public static List<String> getBluePlayers = new ArrayList<String>();
	public static List<String> getRedPlayers = new ArrayList<String>();
	
	private static boolean joinable;
	
	public Teams(PGM plugin) {
		this.plugin  = plugin;
	}
	
	public static String getTeamCode(Player player) {
		if(Teams.getBluePlayers.contains(player)) {
			return "blue";
		}
		if(Teams.getRedPlayers.contains(player)) {
			return "red";
		} else {
			return "Unknown";
		}
	}
	
	public static String getTeamName(Player player) {
		if(Teams.getBluePlayers.contains(player)) {
			return MapYAML.getBlueName();
		}
		if(Teams.getRedPlayers.contains(player)) {
			return MapYAML.getRedName();
		} else {
			return "Unknown";
		}
	}
	
	public static String getTeamName(String code) {
		if(code.equalsIgnoreCase("blue")) {
			return MapYAML.getBlueName();
		}
		if(code.equalsIgnoreCase("red")) {
			return MapYAML.getRedName();
		}
		if(code.equalsIgnoreCase("observator")) {
			return "Observator";
		} else {
			return null;
		}
	}
	
	public static boolean isBlueTeam(Player player) {
		if(Teams.getBluePlayers.contains(player.getName())) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isObservator(Player player) {
		if(Teams.getBluePlayers.contains(player.getName()) || Teams.getRedPlayers.contains(player.getName())) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isJoinable() {
		if(Teams.joinable = true) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRedTeam(Player player) {
		if(Teams.getRedPlayers.contains(player.getName())) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void setJoinable(boolean joinable) {
		Teams.joinable = joinable;
	}
	
	public static void setTeam(Player player, String team) {
		if(Teams.getBluePlayers.size() >= 0) {
			if(!(player.hasPermission("pgm.vip.joinfull") || team.equalsIgnoreCase("obs"))) {
				player.sendMessage(ChatColor.GOLD + "This match is full! Purcharse VIP to join full matches!");
				return;
			}
		}
		if(joinable = false) {
			player.sendMessage(ChatColor.RED + "You can not join to the team at this time, " + ChatColor.GOLD + "Please wait!");
			return;
		}
		if(team == null) {
			if(!Teams.isObservator(player) && Teams.getBluePlayers.contains(player.getName()) || Teams.getRedPlayers.contains(player.getName())) {
				player.sendMessage(ChatColor.RED + "You are already joined to the team!");
				return;
			}
			if(Teams.getBluePlayers.size() > Teams.getRedPlayers.size()) {
				// Red Team
				Teams.getRedPlayers.add(player.getName());
				join(player, "red");
				player.sendMessage(ChatColor.DARK_PURPLE + "You have joined to the " + ChatColor.RED + MapYAML.getRedName() + ChatColor.DARK_PURPLE + ".");
				return;
			}
			if(Teams.getBluePlayers.size() < Teams.getRedPlayers.size()) {
				// Blue Team
				Teams.getBluePlayers.add(player.getName());
				join(player, "blue");
				player.sendMessage(ChatColor.DARK_PURPLE + "You have joined to the " + ChatColor.DARK_BLUE + MapYAML.getBlueName() + ChatColor.DARK_PURPLE + ".");
				return;
			} else {
				// Hmm... random :)
				// Red Team
				Teams.getRedPlayers.add(player.getName());
				join(player, "red");
				player.sendMessage(ChatColor.DARK_PURPLE + "You have joined to the " + ChatColor.RED + MapYAML.getRedName() + ChatColor.DARK_PURPLE + ".");
;				return;
			}
		}
		if(team.equalsIgnoreCase("obs")) {
			if(Teams.isObservator(player)) {
				player.sendMessage(ChatColor.RED + "You are already in the " + ChatColor.AQUA + "Observators Team" + ChatColor.RED + "!");
				return;
			}
			Teams.getBluePlayers.remove(player.getName());
			Teams.getRedPlayers.remove(player.getName());
			
			player.damage(20.0);
			player.setDisplayName(ChatColor.AQUA + player.getName());
			player.setGameMode(GameMode.CREATIVE);
			player.sendMessage(ChatColor.DARK_PURPLE + "You have joined to the " + ChatColor.AQUA + "Observators Team" + ChatColor.DARK_PURPLE + ".");
			return;
		}
		if(!player.hasPermission("pgm.vip.join")) {
			player.sendMessage(ChatColor.GOLD + "We sorry," + ChatColor.RED + " join to specify team is only for VIP members!");
			return;
		}
		if(!Teams.isObservator(player) && Teams.getBluePlayers.contains(player.getName()) || Teams.getRedPlayers.contains(player.getName())) {
			player.sendMessage(ChatColor.RED + "You are already joined to the team!");
			return;
		}
		if(team.equalsIgnoreCase("blue")) {
			// Blue Team
			Teams.getBluePlayers.add(player.getName());
			join(player, "blue");
			player.sendMessage(ChatColor.DARK_PURPLE + "You have joined to the " + ChatColor.DARK_BLUE + MapYAML.getBlueName() + ChatColor.DARK_PURPLE + ".");
			Game.start();
			return;
		}
		if(team.equalsIgnoreCase("red")) {
			// Red Team
			Teams.getRedPlayers.add(player.getName());
			join(player, "red");
			player.sendMessage(ChatColor.DARK_PURPLE + "You have joined to the " + ChatColor.RED + MapYAML.getRedName() + ChatColor.DARK_PURPLE + ".");
			Game.start();
			return;
		} else {
			player.sendMessage(ChatColor.RED + "Team \"" + team + "\" not found!");
			return;
		}
	}
	
	public static void join(Player player, String team) {
		player.getInventory().clear();
		
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
		
		player.getInventory().addItem(new ItemStack(Material.STONE_SWORD, 1));
		player.getInventory().addItem(new ItemStack(Material.BOW, 1));
		player.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE, 1));
		player.getInventory().addItem(new ItemStack(Material.WOOD, 64));
		player.getInventory().addItem(new ItemStack(Material.WOOD, 64));
		player.getInventory().addItem(new ItemStack(Material.GLASS, 64));
		player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
		player.getInventory().addItem(new ItemStack(Material.BREAD, 16));
		player.getInventory().addItem(new ItemStack(Material.ARROW, 64));
		
		if(isBlueTeam(player)) {
			Wool wool = new Wool(DyeColor.BLUE);
			player.getInventory().setHelmet(wool.toItemStack(1));
			player.getInventory().setChestplate(null);
			player.getInventory().setLeggings(null);
			player.getInventory().setBoots(null);
		}
		if(isRedTeam(player)) {
			Wool wool = new Wool(DyeColor.RED);
			player.getInventory().setHelmet(wool.toItemStack(1));
			player.getInventory().setChestplate(null);
			player.getInventory().setLeggings(null);
			player.getInventory().setBoots(null);
		}
	}
	
}
