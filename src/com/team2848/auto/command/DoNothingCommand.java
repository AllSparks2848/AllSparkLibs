
package com.team2848.auto.command;

import com.team2848.command_framework.command_base.Command;
/**
 * This command does nothing (what did you expect?)
 * 
 *
 */
public class DoNothingCommand extends Command {

	@Override
	public boolean execute() {
		return true;
	}

}