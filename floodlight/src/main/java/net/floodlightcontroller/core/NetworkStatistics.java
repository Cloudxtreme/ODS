package net.floodlightcontroller.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.Future;
import java.io.*;

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
public class NetworkStatistics extends TimerTask {

	//the floodlight provider
	protected IFloodlightProviderService floodlightProvider;
	
	//the rate at which this task will be executed
	protected int period;
	
	//a map with the previous loads of switches in the network
	protected static Map<Long, Long> loadHistory;
	
	//a map that keeps record of the current load
	protected static Map<Long, Long> currentLoad;

	private FileWriter fw;
	private BufferedWriter bw;
	private static int statsCounter = 0;
	
	/**
	 * Creates a new statistics task
	 * @param floodlightProvider the floodlight provider
	 * @param period the rate at which the statistics have to be polled
	 */
	public NetworkStatistics(IFloodlightProviderService floodlightProvider, int period){
		this.floodlightProvider = floodlightProvider;
		this.period = period;
		loadHistory = new HashMap<Long, Long>();
		currentLoad = new HashMap<Long, Long>();
		statsCounter++;
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
		try{
			fw = new FileWriter("netstatslog.txt",true);
			bw = new BufferedWriter(fw);
			
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
			    	 
			    	//determine the new load
			    	long newload = 0;		    	
			    	if(currentLoad.containsKey(sw.getId())){
			    		//we've seen the switch before
			    		newload = reply.getTransmitBytes();
				    	loadHistory.put(sw.getId(), reply.getTransmitBytes());  		
			    	} else {
			    		//this is the first time we see the switch
			    		newload = reply.getTransmitBytes();		
			    		loadHistory.put(sw.getId(),newload);
			    	}				    	
			    	//System.out.println("Capa: " + sw.getCapabilities() * 1024);
			    	//System.out.println("Load: " + newload);
			    	currentLoad.put(sw.getId(), (sw.getCapabilities() * 1024) - newload);
			    	bw.write("\n id: "+sw.getId()+" ;load: "+((sw.getCapabilities() * 1024) - newload));
			    	
			    	//System.out.println("Load for switch: " + currentLoad.get(sw.getId()));
			    }
			}
			bw.write("\n******************");
			
			bw.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * Determines the load of all the switches in the network
	 * @return a map with loads of all switches or null if the network has no switches
	 */
	public static synchronized Map<Long, Long> networkLoad(){
		//return the whole map with loads
		if(!currentLoad.isEmpty()){
			//System.out.println("Loads in map:" + currentLoad.size());
			return currentLoad;
		} else {
			//niet goed, moet null terug geven, eerst aanpassen in topo instance
			return null;
		}		
	}
	
	/**
	 * Determines the load of a specific switch 
	 * @param sw the switch
	 * @return the load of the given switch or null if the switch is not in the network
	 */
	public static synchronized Long switchLoad(long switchId){	
		//lookup the load in the map
		if(currentLoad != null && currentLoad.containsKey(switchId)){
			//System.out.println("Load for: " + sw + " is: " + loadHistory.get(sw));
			return currentLoad.get(switchId);
		} else {
			return null;
		}
	}	
}
