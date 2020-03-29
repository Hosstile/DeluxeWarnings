package us.Warnings.Commands.Warn.subcommand;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import us.Warnings.Files.CustomConfig;
import us.Warnings.Files.WarningsFile;
import us.Warnings.Interfaces.Messages;
import us.Warnings.Utilities.utils;
import us.Warnings.Utilities.Executors.SubCommand;
import us.Warnings.WarningsManager.WarningsAPI;

public class check extends SubCommand {

	public check(SubCommand parent) {
		super(parent);
	}

	@Override
	public void execute(CommandSender player, String[] args) {

		Player p = (Player) player;

		if (args.length == 1) {

			p.sendMessage(utils.translate(Messages.prefix + "&c/warn check <player>"));
			return;

		} else {

			Player target = Bukkit.getPlayer(args[1]);

			if (target == null) {

				p.sendMessage(utils.translate("&8&l&m-----------------------------------"));
				p.sendMessage("");
				p.sendMessage(utils.translate(Messages.prefix + "/warn check <player>"));
				p.sendMessage("");
				p.sendMessage(utils.translate("&8> &f&lINVALID TARGET &8<"));
				p.sendMessage("");
				p.sendMessage(utils.translate("&8&l&m-----------------------------------"));
				return;

			} else {
				if (target != null) {

					p.sendMessage("");
					p.sendMessage(utils.translate("&b&lLIST &8&l:: &a&l " + target.getName()));
					p.sendMessage("");
					p.sendMessage(utils.translate("&7Current KickCount&8: &b"
							+ WarningsFile.warnings.getInt("Warnings." + target.getUniqueId() + ".KickCount")));
					p.sendMessage("");
					p.sendMessage(utils.translate("&7Checks &8/ &7Warnings &8: &b"
							+ WarningsFile.warnings.getInt("Warnings." + target.getUniqueId() + ".Warnings") + " &8&l/&b " + CustomConfig.CustomConfig.getInt("Max-Warnings")));
					p.sendMessage("");
					p.sendMessage(utils.translate("&a&lReached-MaxWarnings: &f&l " + WarningsFile.warnings
							.getBoolean(("Warnings." + target.getUniqueId() + ".Max-Warnings-Reached"))));

					return;
				}
			}
		}

	}

	@Override
	public String getDescription() {

		return "";
	}

	@Override
	public String getUsage() {

		return "";
	}

	@Override
	public String getPermission() {

		return "warnings.check";
	}

	@Override
	public String getName() {

		return "check";
	}

	@Override
	public boolean consoleUse() {

		return false;
	}

}
