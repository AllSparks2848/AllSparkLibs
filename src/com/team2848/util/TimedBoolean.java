package com.team2848.util;

import com.team2848.hardware.inputs.interfaces.BinaryInput;

/**
 * a boolean stream that becomes true after a fixed wait time
 * 
 *
 */
public class TimedBoolean implements BinaryInput {
	Timer timer;
	double time;
	
	/**
	 * @param time the time to wait
	 */
	public TimedBoolean(double time) {
		timer = new Timer();
		this.time = time;
	}

	/**
	 * starts the timer
	 */
	public void start() {
		timer.zero();
	}
	
	/**
	 * true if the time since {@link TimedBoolean#start() start()} was called is greater than wait time
	 */
	@Override
	public Boolean get() {
		return timer.get() > time;
	}
}
