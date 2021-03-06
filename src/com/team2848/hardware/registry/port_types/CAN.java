package com.team2848.hardware.registry.port_types;

/**
 * represents a port on the CAN bus
 * 
 * 
 *
 */
public class CAN extends PortInstance {
	/**
	 * 
	 * @param port the CAN port number
	 */
	public CAN(int port) {
		super(port);
	}

	@Override
	public PortType getPortType() {
		return PortType.CAN;
	}

}
