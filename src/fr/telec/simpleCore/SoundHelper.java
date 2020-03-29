package fr.telec.simpleCore;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SoundHelper {
	private JavaPlugin plugin;

	public SoundHelper(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	public boolean playFromConfig(Player player, String key) {
		return playFromConfig(plugin, player, key);
	}

	public boolean playFromConfig(Player player, String key, float volume) {
		return playFromConfig(plugin, player, key, volume);
	}

	public boolean playFromConfig(Player player, String key, float volume, float pitch) {
		return playFromConfig(plugin, player, key, volume, pitch);
	}

	public static boolean playFromConfig(JavaPlugin plugin, Player player, String key) {
		return playFromConfig(plugin, player, key, 10);
	}

	public static boolean playFromConfig(JavaPlugin plugin, Player player, String key, float volume) {
		return playFromConfig(plugin, player, key, volume, 1);
	}

	public static boolean playFromConfig(JavaPlugin plugin, Player player, String key, float volume, float pitch) {
		String soundName = plugin.getConfig().getString(key);

		if (soundName != null) {
			return play(player, soundName, volume, pitch);
		}

		return false;
	}

	public static boolean play(Player player, String soundName, float volume, float pitch) {
		try {
			Sound sound = Sound.valueOf(soundName);
			player.playSound(player.getLocation(), sound, volume, pitch);

			return true;

		} catch (IllegalArgumentException e) {
		}

		return false;
	}
}
