package net.floodlightcontroller.videofilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import net.floodlightcontroller.core.FloodlightContext;
import net.floodlightcontroller.core.IFloodlightProviderService;
import net.floodlightcontroller.core.IOFMessageListener;
import net.floodlightcontroller.core.IOFSwitch;
import net.floodlightcontroller.core.NetworkStatistics;
import net.floodlightcontroller.core.module.FloodlightModuleContext;
import net.floodlightcontroller.core.module.FloodlightModuleException;
import net.floodlightcontroller.core.module.IFloodlightModule;
import net.floodlightcontroller.core.module.IFloodlightService;
import net.floodlightcontroller.core.types.SwitchMessagePair;
import net.floodlightcontroller.packet.Ethernet;
import net.floodlightcontroller.packet.IPv4;
import net.floodlightcontroller.packet.TCP;
import net.floodlightcontroller.topology.ITopologyService;

import org.apache.thrift.protocol.TCompactProtocol;
import org.openflow.protocol.OFMessage;
import org.openflow.protocol.OFType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VideoFilter implements IOFMessageListener, IFloodlightModule {

	protected IFloodlightProviderService floodlightProvider;
	protected ITopologyService topologyservice;
	protected static Logger logger;
	
	@Override
	public String getName() {
		return VideoFilter.class.getSimpleName();    
	}

	@Override
	public boolean isCallbackOrderingPrereq(OFType type, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCallbackOrderingPostreq(OFType type, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Class<? extends IFloodlightService>> getModuleServices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Class<? extends IFloodlightService>, IFloodlightService> getServiceImpls() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Class<? extends IFloodlightService>> getModuleDependencies() {
		Collection<Class<? extends IFloodlightService>> l = new ArrayList<Class<? extends IFloodlightService>>();
		l.add(IFloodlightProviderService.class);
		return l;
	}

	@Override
	public void init(FloodlightModuleContext context)
			throws FloodlightModuleException {
	    floodlightProvider = context.getServiceImpl(IFloodlightProviderService.class);
	    topologyservice = context.getServiceImpl(ITopologyService.class);

	    logger = LoggerFactory.getLogger(VideoFilter.class);

	}

	@Override
	public void startUp(FloodlightModuleContext context) {
		floodlightProvider.addOFMessageListener(OFType.PACKET_IN, this);
		floodlightProvider.addOFMessageListener(OFType.STATS_REPLY, this);

	}

	@Override
	public net.floodlightcontroller.core.IListener.Command receive(
			IOFSwitch sw, OFMessage msg, FloodlightContext cntx) {
		Ethernet eth = IFloodlightProviderService.bcStore.get(cntx,
                                            IFloodlightProviderService.CONTEXT_PI_PAYLOAD);
        Short type = eth.getEtherType();
        
        if (type == Ethernet.TYPE_IPv4) {
            IPv4 ippacket = (IPv4)eth.getPayload();
        	logger.info("New IPv4 message found. \n  {} \n",
                    eth.toString());

        	//For debugging purposes in mininet only
            if (ippacket.getProtocol() == IPv4.PROTOCOL_ICMP) {           	            	
				
            	//ICMP icmp = (ICMP)ippacket.getPayload();
            	logger.info("New ICMP message found. \n  {} \n",
                        ippacket.toString());
            	
            	
            	
            }
            
            
        	//Get the TCP port of the packet
        	TCP tcppacket =  (TCP) ippacket.getPayload();
        	int port = tcppacket.getSourcePort();
        	
        	if(port == Constants.BASE){
        		
        	}else if (port == Constants.ENHANCE1){
        		
        	} else if (port == Constants.ENHANCE2){
        		
        	} else if (port == Constants.ENHANCE3){
        		
        	}
        	
        }
        return Command.CONTINUE;
	}

}
