package fr.telec.simpleCore;

import java.util.Map;

import org.bukkit.ChatColor;

public class StringHandler {

	/**
	 * Replace all '&lt;key&gt;' by there values binded in the <b>values</b> Map
	 * 
	 * @param string Text containing the keys to replace
	 * @param values Keys/Values Map.
	 * @return The string with the replaced keys.
	 */
	public static String format(String string, Map<String, String> values) {
		for (String key : values.keySet()) {
			string = string.replace("<" + key + ">", values.get(key));
		}

		return string;
	}

	/*
	 * From ChatColor source : 
	 * BLACK('0', 0x00)
	 * DARK_BLUE('1', 0x1)
	 * DARK_GREEN('2', 0x2)
	 * DARK_AQUA('3', 0x3)
	 * DARK_RED('4', 0x4)
	 * DARK_PURPLE('5', 0x5)
	 * GOLD('6', 0x6)
	 * GRAY('7', 0x7)
	 * DARK_GRAY('8', 0x8)
	 * BLUE('9', 0x9)
	 * GREEN('a', 0xA)
	 * AQUA('b', 0xB)
	 * RED('c', 0xC)
	 * LIGHT_PURPLE('d', 0xD)
	 * YELLOW('e', 0xE)
	 * WHITE('f', 0xF)
	 * 
	 * MAGIC('k', 0x10, true)
	 * BOLD('l', 0x11, true)
	 * STRIKETHROUGH('m', 0x12, true)
	 * UNDERLINE('n', 0x13, true)
	 * ITALIC('o', 0x14, true)
	 * RESET('r', 0x15);
	 */

	/**
	 * Translates a string using an alternate color code character into a string
	 * that uses the internal ChatColor.COLOR_CODE color code character. The
	 * alternate color code character will only be replaced if it is immediately
	 * followed by 0-9, A-F, a-f, K-O, k-o, R or r. See
	 * ChatColor.translateAlternateColorCodes()
	 * 
	 * @param string Text containing the alternate color code character.
	 * @return Text containing the ChatColor.COLOR_CODE color code character.
	 */
	public static String colorize(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	/**
	 * Format and colorize.
	 * 
	 * @param string Text containing the alternate color code character and the keys
	 *               to replace.
	 * @param values Keys/Values Map.
	 * @return Text containing the ChatColor.COLOR_CODE color code character and the
	 *         replaced keys.
	 */
	public static String translate(String string, Map<String, String> values) {
		return colorize(format(string, values));
	}

}
