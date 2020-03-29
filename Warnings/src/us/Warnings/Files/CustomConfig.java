package us.Warnings.Files;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import us.Warnings.Utilities.utils;

public class CustomConfig {

	public static File CustomConfigFile;
	public static FileConfiguration CustomConfig;

	public static void init(File dataFolder) {

		CustomConfigFile = new File(dataFolder, "CustomConfig.yml");

		CustomConfig = YamlConfiguration.loadConfiguration(CustomConfigFile);

		if (!CustomConfigFile.exists()) {

			CustomConfig.set("ClearWarnings",
					"&c%player%, &7You have cleared &c%target%'s&7 &7Warnings!");
			CustomConfig.set("Max-Warnings", 4);
			CustomConfig.set("Max-KickCount", 5);
			CustomConfig.set("Report-MSG",
					"&4&lWarnings &8&l>> &c%player%, &7You have warned &c%target% &7for %reason%");
			CustomConfig.set("Recieve-Report-MSG",
					"&c&lREPORTED &8&l>> &cYou have been warned by &4%target% \n &4&lReason: &f%reason%");
			CustomConfig.set("MaxWarnings-Command", "kick %player% &a&lSTAGE A &8&l>> &4&lMax warnings &7reached.");
			CustomConfig.set("MaxKick-Command", "ban %player% &a&lSTAGE B &8&l>> &4&lMax Kick Count &7reached.");

			Bukkit.getConsoleSender()
					.sendMessage(utils.translate("&4&lWarnings &8&l: &cCreating &fCustomConfig.yml&c."));

			saveCustomConfig();

		}

	}

	public static void saveCustomConfig() {

		try {

			CustomConfig.save(CustomConfigFile);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
