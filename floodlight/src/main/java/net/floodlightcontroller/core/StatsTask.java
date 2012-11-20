package net.floodlightcontroller.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.openflow.protocol.OFPort;
import org.openflow.protocol.OFStatisticsRequest;
import org.openflow.protocol.statistics.OFPortStatisticsReply;
import org.openflow.protocol.statistics.OFPortStatisticsRequest;
import org.openflow.protocol.statistics.OFStatistics;
import org.openflow.protocol.statistics.OFStatisticsType;


/**
 * Class that will periodically retrieve statistics of all switches
 * @author youri
 *
 */
public class StatsTask extends TimerTask {

	//the floodlight provider
	protected IFloodlightProviderService floodlightProvider;
	
	//the rate at which this task will be executed
	protected int period;
	
	//a map with the loads of switches in the network
	protected Map<IOFSwitch, Long> loads;
	
	/**
	 * Creates a new statistics task
	 * @param floodlightProvider the floodlight provider
	 * @param period the rate at which the statistics have to be polled
	 */
	public StatsTask(IFloodlightProviderService floodlightProvider, int period){
		this.floodlightProvider = floodlightProvider;
		this.period = period;
		loads = null;
	}
	
	/**
	 * Called periodically to retrieve all port statistics of all switches
	 */
	@Override
	public synchronized void run() {
		//get a list of all the switches found
		Map<Long,IOFSwitch> switches = floodlightProvider.getSwitches();				
		Collection<IOFSwitch> swList = switches.values();		
		Iterator<IOFSwitch> it = swList.iterator();
		
		//for each switch, retrieve the statistics
		while(it.hasNext()){
			IOFSwitch sw = it.next();
			List<OFStatistics> stats = new ArrayList<OFStatistics>();
			
			//make a statistics request			
		    OFStatisticsRequest req = new OFStatisticsRequest();
		    req.setStatisticType(OFStatisticsType.PORT);
            req.setXid(sw.getNextTransactionId());
		    
            //fill it with a specific request
		    OFPortStatisticsRequest specReq = new OFPortStatisticsRequest();
		    specReq.setPortNumber(OFPort.OFPP_NONE.getValue());
		    stats.add((OFStatistics)specReq);
		    req.setStatistics(stats);
		    req.setLengthU(req.getLengthU() + specReq.getLength());
		    
		    //attempt to retrieve the statistics
		    Future<List<OFStatistics>> future = null;
		    List<OFStatistics> values = null;
		    
		    try {
		    	future = sw.getStatistics(req);
		    	values = future.get();		    	
		    } catch (Exception e){
		    	System.err.println("Exception while retrieving statistics for switch: " + sw + " " + e);
		    } 
		    		    
		    //process the statistics
		    if(!values.isEmpty()){
		    	OFPortStatisticsReply reply = (OFPortStatisticsReply)values.get(0);
		    	System.out.println("Stats: " + reply.getTransmitBytes());
		    }
		}
	}
	
	/**
	 * Determines the load of all the switches in the network
	 * @return a map with loads of all switches or null if the network has no switches
	 */
	public synchronized Map<IOFSwitch, Long> networkLoad(){
		return loads;
	}
	
	/**
	 * Determines the load of a specific switch 
	 * @param sw the switch
	 * @return the load of the given switch or null if the switch is not in the network
	 */
	public synchronized Long switchLoad(IOFSwitch sw){
		long id = sw.getId();
		
		if(loads != null && loads.containsKey(id)){
			return loads.get(id);
		} else {
			return null;
		}
	}	
}
