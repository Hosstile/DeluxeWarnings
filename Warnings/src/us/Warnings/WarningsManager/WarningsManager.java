package us.Warnings.WarningsManager;

import org.bukkit.entity.Player;

import us.Warnings.Files.CustomConfig;
import us.Warnings.Files.WarningsFile;

public class WarningsManager {

	public Player target;
	public Player sender;
	public String reason;
	public Integer warnings;
	

	public WarningsManager(Player target, Player sender, String reason, Integer warnings) {

		this.target = target;
		this.sender = sender;
		this.reason = reason;
		this.warnings = warnings;


		
		WarningsFile.warnings.set("Players." +target.getUniqueId() + "." +WarningsAPI.getWarnings(target),  reason);
		WarningsFile.warnings.set("Warnings." + target.getUniqueId() + "." + warnings, "");
		WarningsFile.warnings.set("Warnings." + target.getUniqueId() + "." + warnings + ".NAME", target.getName());
		WarningsFile.warnings.set("Warnings." + target.getUniqueId() + "." + warnings + ".Reporter", sender.getName());
		WarningsFile.warnings.set("Warnings." + target.getUniqueId() + "." + warnings + ".Reason", reason);
		WarningsFile.saveWarnings();

	}

}
