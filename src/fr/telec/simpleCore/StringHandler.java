package fr.telec.simpleCore;

import java.util.Map;

import org.bukkit.ChatColor;

public class StringHandler {

	public static String format(String string, Map<String, String> values) {
		for (String key : values.keySet()) {
			string = string.replace("<" + key + ">", values.get(key));
		}

		return string;
	}

	public static String colorize(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public static String translate(String string, Map<String, String> values) {
		return colorize(format(string, values));
	}

}
