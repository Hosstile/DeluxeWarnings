package us.Warnings.Commands.Warns;

import us.Warnings.Commands.Warns.subcommands.addWarnings;
import us.Warnings.Utilities.Executors.Command;

public class Warns extends Command {

	public Warns(us.Warnings.Warnings Warnings) {
		super(Warnings, "warns");
		
		this.registerSubCommand("add", new addWarnings(this));
		
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
	
		return "warnings.warns";
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
