package com.team2848.auto.command;

import com.team2848.command_framework.command_base.Command;
import com.team2848.configuration.PIDConstants;
import com.team2848.control.SynchronousPIDController;
import com.team2848.hardware.inputs.software.RangeIn;
import com.team2848.hardware.outputs.software.RangeOut;
import com.team2848.hardware.value_types.Position;
import com.team2848.hardware.value_types.Value;

/**
 * this commmand turns an actuator a given angle
 * 
 * 
 *
 * @param <O> the ouput type
 */
public class TurnAngleCommand<O extends Value> extends Command {
	SynchronousPIDController<O, Position> pid;
	double angle;
	double tolerance;
	boolean isAbsolute;

	/**
	 * 
	 * @param angle the angle to turn
	 * @param isAbsoluteAngle whether the given angle is an absolute angle, or relative to the acuator's starting angle
	 * @param tolerance the tolerance around the target angle in degrees
	 * @param angleVal an angle input that represents the actuator's angle
	 * @param output an output that control's the actuator's movement
	 * @param turnPID the pid constants for the angle turning controller
	 */
	public TurnAngleCommand(double angle, boolean isAbsoluteAngle, double tolerance, RangeIn<Position> angleVal,
			RangeOut<O> output, PIDConstants turnPID) {
		pid = new SynchronousPIDController<O, Position>(turnPID, angleVal, output);
		this.angle = angle;
		this.tolerance = tolerance;
		this.isAbsolute = isAbsoluteAngle;
	}

	/**
	 * assumes angle is relative to actuator's starting angle
	 * 
	 * @param angle the angle to turn
	 * @param tolerance the tolerance around the target angle in degrees
	 * @param angleVal an angle input that represents the actuator's angle
	 * @param output an output that control's the actuator's movement
	 * @param turnPID the pid constants for the angle turning controller
	 */
	public TurnAngleCommand(double angle, double tolerance, RangeIn<Position> angleVal, RangeOut<O> output,
			PIDConstants turnPID) {
		this(angle, false, tolerance, angleVal, output, turnPID);

	}

	@Override
	public void initialize() {
		if (!isAbsolute) {
			angle += pid.getSource().get();
		}
		pid.setSetpoint(angle);
	}

	@Override
	public boolean execute() {
		pid.update();
		return pid.onTarget(tolerance);
	}
}
