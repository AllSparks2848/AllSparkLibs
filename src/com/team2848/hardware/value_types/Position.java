package com.team2848.hardware.value_types;

import edu.wpi.first.wpilibj.PIDSourceType;

/**
 * represents the position type, considered a displacement function
 * 
 *
 */
public class Position extends PIDTunableValue {

	@Override
	public PIDSourceType getValueType() {
		return PIDSourceType.kDisplacement;
	}

}
