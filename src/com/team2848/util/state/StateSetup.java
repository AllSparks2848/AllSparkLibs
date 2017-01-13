package com.team2848.util.state;

/**
 * a state that can recieve notification when it is exited
 * 
 * 
 *
 */
@FunctionalInterface

public interface StateSetup {
	/**
	 * initializes this state
	 */
	void setup();

	/**
	 * can be called on state end
	 */
	default void end() {
	}
}
