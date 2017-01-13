package com.team2848.auto.command;

import com.team2848.util.TimedBoolean;
/**
 * This command waits a given time
 * 
 *
 */
public class WaitTimeCommand extends WaitForBooleanCommand{
	TimedBoolean timer;
	/**
	 * @param time amount of time to wait
	 */
	public WaitTimeCommand(double time){
		super(null);
		timer=new TimedBoolean(time);
		untilTrue=timer;
	}
	/**
	 * initializes WaitForBooleanCommand
	 */
	@Override
	public void initialize(){
		super.initialize();
		
	}


}
