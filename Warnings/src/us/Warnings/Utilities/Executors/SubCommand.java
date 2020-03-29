package us.Warnings.Utilities.Executors;

import org.bukkit.command.CommandSender;

import us.Warnings.Warnings;


public abstract class SubCommand {
	
	private SubCommand parent;

	public SubCommand(SubCommand parent) {
		this.parent = parent;
	}

	public SubCommand getParent() {
		return this.parent;
	}

	public Warnings getWarnings() {
		if (this instanceof Command) {
			return ((Command) this).getWarnings();
		}
		return null;
	}

	public abstract void execute(CommandSender player, String args[]);

	public abstract String getDescription();

	public abstract String getUsage();

	public abstract String getPermission();

	public abstract String getName();

	public abstract boolean consoleUse();

}