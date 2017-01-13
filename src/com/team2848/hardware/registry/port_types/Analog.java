package com.team2848.hardware.registry.port_types;

/**
 * represents an analog port on the roborio
 * 
 * 
 *
 */
public class Analog extends PortInstance {
	/**
	 * 
	 * @param port the analog port number
	 */
	public Analog(int port) {
		super(port);
	}

	@Override
	public PortType getPortType() {
		return PortType.ANALOG;
	}
}
