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
		return playFromConfig(player, key, 10);
	}

	public boolean playFromConfig(Player player, String key, float volume) {
		return playFromConfig(player, key, volume, 1);
	}

	public boolean playFromConfig(Player player, String key, float volume, float pitch) {
		String soundName = plugin.getConfig().getString(key);

		if (soundName != null) {
			try {
				Sound sound = Sound.valueOf(soundName);
				player.playSound(player.getLocation(), sound, volume, pitch);

				return true;

			} catch (IllegalArgumentException e) {
			}
		}

		return false;
	}
}
