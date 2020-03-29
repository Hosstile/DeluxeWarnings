package us.Warnings.Commands.Warn;

import us.Warnings.Commands.Warn.subcommand.check;
import us.Warnings.Commands.Warn.subcommand.clear;
import us.Warnings.Utilities.Executors.Command;

public class Warn extends Command {

	public Warn(us.Warnings.Warnings Warnings) {
		super(Warnings, "warn");
		this.registerSubCommand("check", new check(this));
		this.registerSubCommand("clear", new clear(this));

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

		return "warnings.admin";
	}

	@Override
	public String getName() {

		return "Warn";
	}

	@Override
	public boolean consoleUse() {

		return false;
	}

}
