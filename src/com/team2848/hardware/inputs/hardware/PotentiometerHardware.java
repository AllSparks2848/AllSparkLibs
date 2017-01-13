package com.team2848.hardware.inputs.hardware;

import java.util.Optional;

import com.team2848.hardware.Hardware;
import com.team2848.hardware.inputs.software.RangeIn;
import com.team2848.hardware.registry.Registry;
import com.team2848.hardware.registry.port_types.Analog;
import com.team2848.hardware.value_types.Position;
import com.team2848.util.AddList;
import com.team2848.watch.Watchable;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

/**
 * represents an analog potentiometer
 * 
 * 
 *
 */
public class PotentiometerHardware extends Hardware<Analog> {
	/**
	 * @param requestedPort the port to attempt to initialize this hardware
	 * @param registry the registry associated with the robot
	 */
	public PotentiometerHardware(Analog requestedPort, Registry registry) {
		super(requestedPort, registry);
	}

	private Optional<AnalogPotentiometer> wpiPot;
	
	/**
	 * 
	 * @return an input stream of potentiometer values on the range [0,1]
	 */
	public RangeIn<Position> getAnalogInput() {
		return new RangeIn<>(Position.class, () -> wpiPot.map(pot -> pot.get()).orElse(0.0), 0, 1);
	}

	@Override
	public AddList<Watchable> getSubWatchables(AddList<Watchable> stem) {
		return stem.put(getAnalogInput().getWatchable("val"));
	}

	@Override
	protected String getHardwareIdentifier() {
		return "Potentiometer";
	}

	@Override
	public void init(Analog port) {
		wpiPot = Optional.of(new AnalogPotentiometer(port.index()));
	}

	@Override
	public void failInit() {
		wpiPot = Optional.empty();
	}
}
