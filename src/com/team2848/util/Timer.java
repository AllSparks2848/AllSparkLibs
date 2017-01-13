package com.team2848.util;

import com.team2848.hardware.inputs.interfaces.ScalarInput;
import com.team2848.hardware.inputs.software.RangeIn;
import com.team2848.hardware.value_types.Value;

/**
 * wraps the WPILib timer class
 * 
 * 
 *
 */
public class Timer implements ScalarInput<Value> {
	edu.wpi.first.wpilibj.Timer timer;
	private double lastMark = 0;

	/**
	 * initializes the WPILib timer
	 */
	public Timer() {
		timer = new edu.wpi.first.wpilibj.Timer();
		timer.start();
	}

	/**
	 * sets the time elapsed to 0 (resets the timer)
	 */
	public void zero() {
		timer.reset();
		lastMark = 0;
	}

	public void mark() {
		lastMark = get();
	}

	public double getSinceMark() {
		return get() - lastMark;
	}

	@Override
	public Double get() {
		return timer.get();
	}

	/**
	 * 
	 * @return an input stream that tracks the time as stored by this timer (units seconds)
	 */
	public RangeIn<Value> getTimeInput() {
		return new RangeIn<Value>(Value.class, this::get, 0, 60);
	}

}
