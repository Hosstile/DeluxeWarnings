package us.Warnings.Commands.Warn.subcommand;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.Warnings.Files.CustomConfig;
import us.Warnings.Files.WarningsFile;
import us.Warnings.Interfaces.Messages;
import us.Warnings.Utilities.utils;
import us.Warnings.Utilities.Executors.SubCommand;
import us.Warnings.WarningsManager.WarningsAPI;

public class clear extends SubCommand {

	public clear(SubCommand parent) {
		super(parent);
	}

	@Override
	public void execute(CommandSender player, String[] args) {

		Player p = (Player) player;

		if (args.length == 1) {

			p.sendMessage(utils.translate(Messages.prefix + "&c/warn clear <player>"));
			return;

		} else {

			Player target = Bukkit.getPlayer(args[1]);

			if (target == null) {

				p.sendMessage(utils.translate("&8&l&m-----------------------------------"));
				p.sendMessage("");
				p.sendMessage(utils.translate(Messages.prefix + "/warn clear <player>"));
				p.sendMessage("");
				p.sendMessage(utils.translate("&8> &f&lINVALID TARGET &8<"));
				p.sendMessage("");
				p.sendMessage(utils.translate("&8&l&m-----------------------------------"));
				return;

			} else {
				if (target != null) {

					WarningsAPI.clearWarnings(p);
					p.sendMessage(utils.translate(Messages.prefix + CustomConfig.CustomConfig.getString("ClearWarnings")
							.replaceAll("%player%", p.getName()).replaceAll("%target%", target.getName())));
					return;
				}
			}
		}

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getUsage() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getPermission() {
		// TODO Auto-generated method stub
		return "warnings.clear";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "clear";
	}

	@Override
	public boolean consoleUse() {
		// TODO Auto-generated method stub
		return false;
	}

}
