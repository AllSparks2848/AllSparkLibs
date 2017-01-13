package com.team2848.hardware.registry.port_types;

/**
 * represents a Digital Output port on the roborio
 * 
 * 
 *
 */
public class DIO extends PortInstance {

	/**
	 * @param port the port number
	 */
	public DIO(int port) {
		super(port);
	}

	@Override
	public PortType getPortType() {
		return PortType.DIO;
	}

}
