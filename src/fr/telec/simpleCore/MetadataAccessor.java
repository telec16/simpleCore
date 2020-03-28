package fr.telec.simpleCore;

import java.util.List;

import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.java.JavaPlugin;

public class MetadataAccessor {

	public static void setMetadata(JavaPlugin plugin, Metadatable object, String key, Object value) {
		object.setMetadata(key, new FixedMetadataValue(plugin, value));
	}

	public static Object getMetadata(JavaPlugin plugin, Metadatable object, String key) {
		return getMetadata(plugin, object, key, null);
	}

	public static Object getMetadata(JavaPlugin plugin, Metadatable object, String key, Object def) {
		List<MetadataValue> values = object.getMetadata(key);
		for (MetadataValue value : values) {
			// Plugins are singleton objects, so using == is safe here
			if (value.getOwningPlugin() == plugin) {
				return value.value();
			}
		}
		return def;
	}
}
