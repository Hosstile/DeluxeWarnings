package us.Warnings.Commands.Warns.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.Warnings.Files.CustomConfig;
import us.Warnings.Interfaces.Messages;
import us.Warnings.Utilities.utils;
import us.Warnings.Utilities.Executors.SubCommand;
import us.Warnings.WarningsManager.WarningsAPI;
import us.Warnings.WarningsManager.WarningsManager;

public class addWarnings extends SubCommand {

	public addWarnings(SubCommand parent) {
		super(parent);
	}

	@Override
	public void execute(CommandSender player, String[] args) {

		Player p = (Player) player;

		if (args.length == 1) {

			p.sendMessage(utils.translate(Messages.prefix + "/warns add <player> <reason>"));
			return;

		} else {

			Player target = Bukkit.getPlayer(args[1]);

			if (target == null) {

				p.sendMessage(utils.translate("&8&l&m-----------------------------------"));
				p.sendMessage("");
				p.sendMessage(utils.translate(Messages.prefix + "/warns add <player> <reason>"));
				p.sendMessage("");
				p.sendMessage(utils.translate("&8> &f&lINVALID TARGET &8<"));
				p.sendMessage("");
				p.sendMessage(utils.translate("&8&l&m-----------------------------------"));
				return;

			} else {

				if (target != null) {

					if (args.length == 2) {

						p.sendMessage(utils.translate("&8&l&m-----------------------------------"));
						p.sendMessage("");
						p.sendMessage(utils.translate(Messages.prefix + "/warns add <player> <reason>"));
						p.sendMessage("");
						p.sendMessage(utils.translate("&8> &f&lINVALID REASON &8<"));
						p.sendMessage("");
						p.sendMessage(utils.translate("&8&l&m-----------------------------------"));
						return;

					} else {

						StringBuilder sb = new StringBuilder();
						for (int i = 2; i < args.length; i++)
							sb.append(args[i] + " ");

						p.sendMessage(utils.translate(CustomConfig.CustomConfig.getString("Report-MSG"))
								.replace("%target%", target.getName()).replace("%player%", p.getName()).replace("%reason%", sb.toString().trim()));

						target.sendMessage(utils.translate(CustomConfig.CustomConfig.getString("Recieve-Report-MSG")).replace("%target%", target.getName() +" ").replace("%player%", p.getName()).replace("%reason%", sb.toString().trim()));;
						
						WarningsAPI.addWarnings(target, 1);

						WarningsManager wm = new WarningsManager(target, p, sb.toString().trim(),
								WarningsAPI.getWarnings(p));

					}

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

		return "warnings.add";
	}

	@Override
	public String getName() {

		return "add";
	}

	@Override
	public boolean consoleUse() {

		return false;
	}

}
