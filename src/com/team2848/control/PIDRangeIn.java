package com.team2848.control;

import com.team2848.hardware.inputs.software.RangeIn;
import com.team2848.hardware.value_types.PIDTunableValue;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

/**
 * an adapter class from a PID tunable Ohm input stream to a WPILib PIDSource
 * 
 * 
 *
 * @param <T> the type of the input stream (must be PIDTunable)
 * @see com.team2848.hardware.value_types.PIDTunableValue PIDTunableValue
 * @see PIDController
 * @see PIDRangeOut
 */
public class PIDRangeIn<T extends PIDTunableValue> implements PIDSource {
	RangeIn<T> input;

	/**
	 * @param input the input stream to use
	 */
	public PIDRangeIn(RangeIn<T> input) {
		this.input = input;
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {

	}

	@Override
	public PIDSourceType getPIDSourceType() {
		try {
			return input.getType().newInstance().getValueType();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		return input.get();
	}
	
	protected static <T extends PIDTunableValue> PIDRangeIn<T> get(RangeIn<T> in) {
		return new PIDRangeIn<>(in);
	}

}