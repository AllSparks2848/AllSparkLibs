package com.team2848.hardware.registry.port_types;

/**
 * represents a PCM port
 * 
 * 
 *
 */
public class PCM extends PortInstance {
	/**
	 * 
	 * @param port the PCM port number
	 */
	public PCM(int port) {
		super(port);
	}

	@Override
	public PortType getPortType() {
		return PortType.PCM;
	}

}
