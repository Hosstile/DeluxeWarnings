package us.Warnings;

import org.bukkit.plugin.java.JavaPlugin;

import us.Warnings.Commands.Warn.Warn;
import us.Warnings.Commands.Warns.Warns;
import us.Warnings.Files.CustomConfig;
import us.Warnings.Files.WarningsFile;
import us.Warnings.WarningsManager.WarningsManager;

public class Warnings extends JavaPlugin {

	public static Warnings instance;

	public void onEnable() {
		handler();

	}

	public void onDisable() {

	}

	private void handler() {

		registerCFG();
		registerCommands();
		registerEvents();

	}

	protected void registerCFG() {

		getConfig().options().copyDefaults(true);
		saveConfig();

		WarningsFile.init(getDataFolder());
		CustomConfig.init(getDataFolder());

	}

	protected void registerCommands() {

		getCommand("warns").setExecutor(new Warns(this));
		getCommand("warn").setExecutor(new Warn(this));

	}

	protected void registerEvents() {
	}

}
