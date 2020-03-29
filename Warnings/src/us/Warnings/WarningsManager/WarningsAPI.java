package us.Warnings.WarningsManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import us.Warnings.Warnings;
import us.Warnings.Files.CustomConfig;
import us.Warnings.Files.WarningsFile;
import us.Warnings.Utilities.utils;

public class WarningsAPI {

	public static Warnings plugin;

	public WarningsAPI(Warnings plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("unused")
	public static Integer getWarnings(Player p) {

		Integer current = WarningsFile.warnings.getInt("Warnings." + p.getUniqueId() + ".Warnings");

		return current;

	}

	public static Integer getMaxWarnings(Player p) {

		return CustomConfig.CustomConfig.getInt("Max-Warnings");

	}

	public static void addWarnings(Player p, Integer size) {

		int maxKickCount;
		int currentkickCount = CustomConfig.CustomConfig.getInt("MaxKickCount");

		maxKickCount = WarningsFile.warnings.getInt("Warnings." + p.getUniqueId() + ".KickCount");

		Integer current = getWarnings(p);

		current = current + 1;

		WarningsFile.warnings.set("Warnings." + p.getUniqueId() + ".Warnings", current);
		WarningsFile.saveWarnings();

		if (current >= getMaxWarnings(p)) {

			WarningsFile.warnings.set("Warnings." + p.getUniqueId() + ".KickCount", currentkickCount = currentkickCount +1);

			if (currentkickCount == maxKickCount) {

				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), utils.translate(
						CustomConfig.CustomConfig.getString("MaxKick-Command").replaceAll("%player%", p.getName())));

				return;
			}
			
			WarningsFile.warnings.set("Warnings." + p.getUniqueId() + ".Max-Warnings-Reached", true);
			WarningsFile.saveWarnings();

			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), utils.translate(
					CustomConfig.CustomConfig.getString("MaxWarnings-Command").replaceAll("%player%", p.getName())));
			return;
		} else {

			return;
		}

	}

	public static void clearWarnings(Player p) {
		
		WarningsFile.warnings.set("Warnings." + p.getUniqueId(), null);
		WarningsFile.warnings.set("Players." + p.getUniqueId(), null);
		WarningsFile.saveWarnings();

	}

}
