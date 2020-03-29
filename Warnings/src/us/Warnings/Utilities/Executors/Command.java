package us.Warnings.Utilities.Executors;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.Warnings.Warnings;
import us.Warnings.Interfaces.Messages;
import us.Warnings.Utilities.utils;

public abstract class Command extends SubCommand implements CommandExecutor {

	private HashMap<String, SubCommand> subCommands = new HashMap<>();

	private String name;

	private Warnings Warnings;

	public Command(Warnings Warnings, String name) {
		super(null);
		this.name = name;
		this.Warnings = Warnings;
	}

	public Command registerSubCommand(String name, SubCommand subCommand) {
		this.subCommands.put(name, subCommand);
		return this;
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command Warningsd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			if (!this.anyConsoleUse()) {

				return true;
			}
			if (args.length == 0) {
				execute(sender, args);
				return true;
			}
			if (!subCommands.containsKey(args[0].toLowerCase())) {
				sender.sendMessage(utils.translate(Messages.prefix + "&cInvalid usage, Please use /Warnings help."));
				return true;
			}
			SubCommand sub = this.subCommands.get(args[0].toLowerCase());
			if (!sub.consoleUse()) {
				return true;
			}
			sub.execute(sender, args);
			return true;
		}
		Player player = (Player) sender;
		if (args.length == 0) {
			if (!player.hasPermission(getPermission())) {
				sender.sendMessage(utils.translate(Messages.prefix + "&cYou don't have access to this command!."));
				return true;
			}
			execute(player, args);
			return true;
		}
		if (!subCommands.containsKey(args[0].toLowerCase())) {
			sender.sendMessage(utils.translate(Messages.prefix + "&cInvalid usage, &fPlease use the following: "));
			sender.sendMessage(utils.translate("&f&l&m---&8&l&m-----------&f&l&m---"));
			sender.sendMessage(utils.translate("\n&c/warns add <player> <reason>"));
			sender.sendMessage(utils.translate("&4/warn check <player>"));
			sender.sendMessage(utils.translate("&4/warn clear <player>"));
			sender.sendMessage(utils.translate("&f&l&m---&8&l&m-----------&f&l&m---"));
			return true;
		}
		SubCommand sub = this.subCommands.get(args[0].toLowerCase());
		if (!player.hasPermission(sub.getPermission())) {
			sender.sendMessage(utils.translate(Messages.prefix + "&cYou don't have access to this command!."));
			return true;
		}
		sub.execute(player, args);
		return true;
	}

	public boolean anyConsoleUse() {
		if (subCommands.isEmpty())
			return false;
		if (subCommands.values().stream().anyMatch(SubCommand::consoleUse))
			return true;
		return false;
	}

	public void execute(CommandSender player, String[] args) {
		player.sendMessage(utils.translate("\n    &4&lWarnings&e&l    "));
		subCommands.values().forEach(sub -> {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "\n&e/" + name + " " + sub.getName()
					+ (sub.getUsage().length() == 0 ? "" : " &7" + sub.getUsage())));
		});
	}

	public Warnings getWarnings() {
		return Warnings;
	}

}