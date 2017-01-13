package com.team2848.auto.command;

import com.team2848.command_framework.command_base.Command;
import com.team2848.hardware.inputs.interfaces.BinaryInput;

/**
 * This command waits until the given {@link BinaryInput} returns true
 * 
 * 
 *
 */
public class WaitForBooleanCommand extends Command {
	BinaryInput untilTrue;

	/**
	 * 
	 * @param untilTrue the {@link BinaryInput} to wait for
	 */
	public WaitForBooleanCommand(BinaryInput untilTrue) {
		this.untilTrue = untilTrue;
	}

	@Override
	protected boolean execute() {
		return untilTrue.get();
	}

}
