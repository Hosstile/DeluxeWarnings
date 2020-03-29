package us.Warnings.Files;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import us.Warnings.Utilities.utils;

public class WarningsFile {
	
	public static File warningsFile;
	public static FileConfiguration warnings;
	
	public static void init(File dataFolder) {
		
		warningsFile = new File(dataFolder, "warnings.yml");
		
		warnings = YamlConfiguration.loadConfiguration(warningsFile);
		
		if(!warningsFile.exists()) {
			
			Bukkit.getConsoleSender().sendMessage(utils.translate("&4&lWarnings &8&l: &cCreating &fwarnings.yml&c."));
			
			saveWarnings();
			
		}
		
		
	}
	
	public static void saveWarnings() {
		
		try {
			
			warnings.save(warningsFile);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
