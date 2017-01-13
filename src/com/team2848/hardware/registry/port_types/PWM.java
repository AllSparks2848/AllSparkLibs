package com.team2848.hardware.registry.port_types;

/**
 * represents a PWM port on the roborio
 * 
 * 
 *
 */
public class PWM extends PortInstance {
	/**
	 * 
	 * @param port the port number
	 */
	public PWM(int port) {
		super(port);
	}

	@Override
	public PortType getPortType() {
		return PortType.PWM;
	}

}
