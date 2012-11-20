package net.floodlightcontroller.core;

import java.util.Map;

/**
 * 
 * @author youri
 *
 */
public interface NetworkStatistics {

	/**
	 * Returns the load of all switches in the network
	 * @return a map with the loads of all switches
	 */
	public Map<IOFSwitch, Long> networkLoad();
	
	/**
	 * Returns the load a specific switch in the network
	 * @param sw the switch
	 * @return the load of the given switch
	 */
	public Long switchLoad(IOFSwitch sw);
}
