package net.floodlightcontroller.videofilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import net.floodlightcontroller.core.FloodlightContext;
import net.floodlightcontroller.core.IFloodlightProviderService;
import net.floodlightcontroller.core.IOFMessageListener;
import net.floodlightcontroller.core.IOFSwitch;
import net.floodlightcontroller.core.module.FloodlightModuleContext;
import net.floodlightcontroller.core.module.FloodlightModuleException;
import net.floodlightcontroller.core.module.IFloodlightModule;
import net.floodlightcontroller.core.module.IFloodlightService;
import net.floodlightcontroller.core.util.AppCookie;
import net.floodlightcontroller.counter.ICounterStoreService;
import net.floodlightcontroller.devicemanager.IDevice;
import net.floodlightcontroller.devicemanager.IDeviceService;
import net.floodlightcontroller.devicemanager.SwitchPort;
import net.floodlightcontroller.packet.Ethernet;
import net.floodlightcontroller.packet.IPv4;
import net.floodlightcontroller.packet.TCP;
import net.floodlightcontroller.routing.IRoutingDecision;
import net.floodlightcontroller.routing.Route;
import net.floodlightcontroller.topology.ITopologyService;
import net.floodlightcontroller.topology.NodePortTuple;
import net.floodlightcontroller.util.OFMessageDamper;

import org.openflow.protocol.OFFlowMod;
import org.openflow.protocol.OFMatch;
import org.openflow.protocol.OFMessage;
import org.openflow.protocol.OFPacketIn;
import org.openflow.protocol.OFPacketOut;
import org.openflow.protocol.OFPort;
import org.openflow.protocol.OFType;
import org.openflow.protocol.action.OFAction;
import org.openflow.protocol.action.OFActionOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VideoFilter implements IOFMessageListener, IFloodlightModule {

	protected IFloodlightProviderService floodlightProvider;
	protected ITopologyService topologyservice;
	protected static Logger log;
	protected ICounterStoreService counterStore;
	protected OFMessageDamper messageDamper;
	protected ITopologyService topology;

	public static short FLOWMOD_DEFAULT_IDLE_TIMEOUT = 5; // in seconds
	public static short FLOWMOD_DEFAULT_HARD_TIMEOUT = 0; // infinite
	protected static int OFMESSAGE_DAMPER_CAPACITY = 10000; // TODO: find sweet
	public static final int FORWARDING_APP_ID = 2; // TODO: This must be managed
	// by a global APP_ID class // spot
	protected static int OFMESSAGE_DAMPER_TIMEOUT = 250; // ms

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
		l.add(ITopologyService.class);
		l.add(ICounterStoreService.class);
		return l;
	}

	@Override
	public void init(FloodlightModuleContext context)
			throws FloodlightModuleException {
		floodlightProvider = context
				.getServiceImpl(IFloodlightProviderService.class);
		topologyservice = context.getServiceImpl(ITopologyService.class);

		log = LoggerFactory.getLogger(VideoFilter.class);
		messageDamper = new OFMessageDamper(OFMESSAGE_DAMPER_CAPACITY,
				EnumSet.of(OFType.FLOW_MOD), OFMESSAGE_DAMPER_TIMEOUT);
		topology = context.getServiceImpl(ITopologyService.class);
		counterStore = context.getServiceImpl(ICounterStoreService.class);
	}

	@Override
	public void startUp(FloodlightModuleContext context) {
		floodlightProvider.addOFMessageListener(OFType.PACKET_IN, this);
		floodlightProvider.addOFMessageListener(OFType.STATS_REPLY, this);

	}

	@Override
	public net.floodlightcontroller.core.IListener.Command receive(
			IOFSwitch sw, OFMessage msg, FloodlightContext cntx) {

		if (msg.getType() == OFType.PACKET_IN) {
			OFPacketIn pi = (OFPacketIn) msg;
			Ethernet eth = IFloodlightProviderService.bcStore.get(cntx,
					IFloodlightProviderService.CONTEXT_PI_PAYLOAD);
			Short type = eth.getEtherType();

			if (type == Ethernet.TYPE_IPv4) {
				IPv4 ippacket = (IPv4) eth.getPayload();
				log.info("New IPv4 message found. \n  {} \n", eth.toString());

				// For debugging purposes in mininet only
				if (ippacket.getProtocol() == IPv4.PROTOCOL_ICMP) {

					// ICMP icmp = (ICMP)ippacket.getPayload();
					log.info("New ICMP message found. \n  {} \n",
							ippacket.toString());

					// TODO: Call doForwardFlow with the calculated weights
					// change doForwardFlow args...
				}

				// Get the TCP port of the packet
				TCP tcppacket = (TCP) ippacket.getPayload();
				int port = tcppacket.getSourcePort();

				if (port == Constants.BASE) {

				} else if (port == Constants.ENHANCE1) {

				} else if (port == Constants.ENHANCE2) {

				} else if (port == Constants.ENHANCE3) {

				}

			}
		}
		return Command.CONTINUE;
	}

	protected void doForwardFlow(IOFSwitch sw, OFPacketIn pi,
			FloodlightContext cntx) {

		// Setup fields for our packets
		OFMatch match = new OFMatch();
		match.loadFromPacket(pi.getPacketData(), pi.getInPort());

		// Check if we have the location of the destination
		IDevice dstDevice = IDeviceService.fcStore.get(cntx,
				IDeviceService.CONTEXT_DST_DEVICE);

		if (dstDevice != null) {
			IDevice srcDevice = IDeviceService.fcStore.get(cntx,
					IDeviceService.CONTEXT_SRC_DEVICE);
			Long srcIsland = topology.getL2DomainId(sw.getId());

			if (srcDevice == null) {
				log.debug("No device entry found for source device");
				return;
			}
			if (srcIsland == null) {
				log.debug("No openflow island found for source {}/{}",
						sw.getStringId(), pi.getInPort());
				return;
			}

			// Validate that we have a destination known on the same
			// island
			// Validate that the source and destination are not on
			// the same switchport
			boolean on_same_island = false;
			boolean on_same_if = false;
			for (SwitchPort dstDap : dstDevice.getAttachmentPoints()) {
				long dstSwDpid = dstDap.getSwitchDPID();
				Long dstIsland = topology.getL2DomainId(dstSwDpid);
				if ((dstIsland != null) && dstIsland.equals(srcIsland)) {
					on_same_island = true;
					if ((sw.getId() == dstSwDpid)
							&& (pi.getInPort() == dstDap.getPort())) {
						on_same_if = true;
					}
					break;
				}
			}

			if (!on_same_island) {
				// Flood since we don't know the dst device
				if (log.isTraceEnabled()) {
					log.trace("No first hop island found for destination "
							+ "device {}, Action = flooding", dstDevice);
				}
				doFlood(sw, pi, cntx);
				return;
			}

			if (on_same_if) {
				if (log.isTraceEnabled()) {
					log.trace("Both source and destination are on the same "
							+ "switch/port {}/{}, Action = NOP", sw.toString(),
							pi.getInPort());
				}
				return;
			}

			// Install all the routes where both src and dst have
			// attachment
			// points. Since the lists are stored in sorted order we
			// can
			// traverse the attachment points in O(m+n) time
			SwitchPort[] srcDaps = srcDevice.getAttachmentPoints();
			Arrays.sort(srcDaps, clusterIdComparator);
			SwitchPort[] dstDaps = dstDevice.getAttachmentPoints();
			Arrays.sort(dstDaps, clusterIdComparator);

			int iSrcDaps = 0, iDstDaps = 0;

			while ((iSrcDaps < srcDaps.length) && (iDstDaps < dstDaps.length)) {
				SwitchPort srcDap = srcDaps[iSrcDaps];
				SwitchPort dstDap = dstDaps[iDstDaps];
				Long srcCluster = topology
						.getL2DomainId(srcDap.getSwitchDPID());
				Long dstCluster = topology
						.getL2DomainId(dstDap.getSwitchDPID());

				int srcVsDest = srcCluster.compareTo(dstCluster);
				if (srcVsDest == 0) {
					if (!srcDap.equals(dstDap) && (srcCluster != null)
							&& (dstCluster != null)) {

						// INSERT DIJKSTRA HERE FOR OUR VIDEO FLOWS
						// AND CALCULATE FLOWS
						Route route;

						if (route != null) {
							if (log.isTraceEnabled()) {
								log.trace("pushRoute match={} route={} "
										+ "destination={}:{}", new Object[] {
										match, route, dstDap.getSwitchDPID(),
										dstDap.getPort() });
							}
							long cookie = AppCookie.makeCookie(
									FORWARDING_APP_ID, 0);

							// if there is prior routing decision
							// use wildcard
							Integer wildcard_hints = null;
							IRoutingDecision decision = null;
							if (cntx != null) {
								decision = IRoutingDecision.rtStore.get(cntx,
										IRoutingDecision.CONTEXT_DECISION);
							}
							if (decision != null) {
								wildcard_hints = decision.getWildcards();
							} else {
								// L2 only wildcard if there is no
								// prior route decision
								wildcard_hints = ((Integer) sw
										.getAttribute(IOFSwitch.PROP_FASTWILDCARDS))
										.intValue()
										& ~OFMatch.OFPFW_IN_PORT
										& ~OFMatch.OFPFW_DL_VLAN
										& ~OFMatch.OFPFW_DL_SRC
										& ~OFMatch.OFPFW_DL_DST
										& ~OFMatch.OFPFW_NW_SRC_MASK
										& ~OFMatch.OFPFW_NW_DST_MASK;
							}

							pushRoute(route, match, wildcard_hints, pi,
									sw.getId(), cookie, cntx, false, false,
									OFFlowMod.OFPFC_ADD);
						}
					}
					iSrcDaps++;
					iDstDaps++;
				} else if (srcVsDest < 0) {
					iSrcDaps++;
				} else {
					iDstDaps++;
				}
			}
		} else {
			// Flood since we don't know the dst device
			doFlood(sw, pi, cntx);
		}
	}

	public boolean pushRoute(Route route, OFMatch match,
			Integer wildcard_hints, OFPacketIn pi, long pinSwitch, long cookie,
			FloodlightContext cntx, boolean requestFlowRemovedNotifn,
			boolean doFlush, short flowModCommand) {

		boolean srcSwitchIncluded = false;
		OFFlowMod fm = (OFFlowMod) floodlightProvider.getOFMessageFactory()
				.getMessage(OFType.FLOW_MOD);
		OFActionOutput action = new OFActionOutput();
		action.setMaxLength((short) 0xffff);
		List<OFAction> actions = new ArrayList<OFAction>();
		actions.add(action);

		fm.setIdleTimeout(FLOWMOD_DEFAULT_IDLE_TIMEOUT)
				.setHardTimeout(FLOWMOD_DEFAULT_HARD_TIMEOUT)
				.setBufferId(OFPacketOut.BUFFER_ID_NONE)
				.setCookie(cookie)
				.setCommand(flowModCommand)
				.setMatch(match)
				.setActions(actions)
				.setLengthU(
						OFFlowMod.MINIMUM_LENGTH
								+ OFActionOutput.MINIMUM_LENGTH);

		List<NodePortTuple> switchPortList = route.getPath();

		for (int indx = switchPortList.size() - 1; indx > 0; indx -= 2) {
			// indx and indx-1 will always have the same switch DPID.
			long switchDPID = switchPortList.get(indx).getNodeId();
			IOFSwitch sw = floodlightProvider.getSwitches().get(switchDPID);
			if (sw == null) {
				if (log.isWarnEnabled()) {
					log.warn("Unable to push route, switch at DPID {} "
							+ "not available", switchDPID);
				}
				return srcSwitchIncluded;
			}

			// set the match.
			fm.setMatch(wildcard(match, sw, wildcard_hints));

			// set buffer id if it is the source switch
			if (1 == indx) {
				// Set the flag to request flow-mod removal notifications only
				// for the
				// source switch. The removal message is used to maintain the
				// flow
				// cache. Don't set the flag for ARP messages - TODO generalize
				// check
				if ((requestFlowRemovedNotifn)
						&& (match.getDataLayerType() != Ethernet.TYPE_ARP)) {
					fm.setFlags(OFFlowMod.OFPFF_SEND_FLOW_REM);
					match.setWildcards(fm.getMatch().getWildcards());
				}
			}

			short outPort = switchPortList.get(indx).getPortId();
			short inPort = switchPortList.get(indx - 1).getPortId();
			// set input and output ports on the switch
			fm.getMatch().setInputPort(inPort);
			((OFActionOutput) fm.getActions().get(0)).setPort(outPort);

			try {
				counterStore.updatePktOutFMCounterStoreLocal(sw, fm);
				if (log.isTraceEnabled()) {
					log.trace("Pushing Route flowmod routeIndx={} "
							+ "sw={} inPort={} outPort={}", new Object[] {
							indx, sw, fm.getMatch().getInputPort(), outPort });
				}
				messageDamper.write(sw, fm, cntx);
				if (doFlush) {
					sw.flush();
					counterStore.updateFlush();
				}

				// Push the packet out the source switch
				if (sw.getId() == pinSwitch) {
					// TODO: Instead of doing a packetOut here we could also
					// send a flowMod with bufferId set....
					pushPacket(sw, match, pi, outPort, cntx);
					srcSwitchIncluded = true;
				}
			} catch (IOException e) {
				log.error("Failure writing flow mod", e);
			}

			try {
				fm = fm.clone();
			} catch (CloneNotSupportedException e) {
				log.error("Failure cloning flow mod", e);
			}
		}

		return srcSwitchIncluded;
	}

	protected OFMatch wildcard(OFMatch match, IOFSwitch sw,
			Integer wildcard_hints) {
		if (wildcard_hints != null) {
			return match.clone().setWildcards(wildcard_hints.intValue());
		}
		return match.clone();
	}

	protected void pushPacket(IOFSwitch sw, OFMatch match, OFPacketIn pi,
			short outport, FloodlightContext cntx) {

		if (pi == null) {
			return;
		} else if (pi.getInPort() == outport) {
			log.warn("Packet out not sent as the outport matches inport. {}",
					pi);
			return;
		}

		// The assumption here is (sw) is the switch that generated the
		// packet-in. If the input port is the same as output port, then
		// the packet-out should be ignored.
		if (pi.getInPort() == outport) {
			if (log.isDebugEnabled()) {
				log.debug("Attempting to do packet-out to the same "
						+ "interface as packet-in. Dropping packet. "
						+ " SrcSwitch={}, match = {}, pi={}", new Object[] {
						sw, match, pi });
				return;
			}
		}

		if (log.isTraceEnabled()) {
			log.trace("PacketOut srcSwitch={} match={} pi={}", new Object[] {
					sw, match, pi });
		}

		OFPacketOut po = (OFPacketOut) floodlightProvider.getOFMessageFactory()
				.getMessage(OFType.PACKET_OUT);

		// set actions
		List<OFAction> actions = new ArrayList<OFAction>();
		actions.add(new OFActionOutput(outport, (short) 0xffff));

		po.setActions(actions).setActionsLength(
				(short) OFActionOutput.MINIMUM_LENGTH);
		short poLength = (short) (po.getActionsLength() + OFPacketOut.MINIMUM_LENGTH);

		// If the switch doens't support buffering set the buffer id to be none
		// otherwise it'll be the the buffer id of the PacketIn
		if (sw.getBuffers() == 0) {
			// We set the PI buffer id here so we don't have to check again
			// below
			pi.setBufferId(OFPacketOut.BUFFER_ID_NONE);
			po.setBufferId(OFPacketOut.BUFFER_ID_NONE);
		} else {
			po.setBufferId(pi.getBufferId());
		}

		po.setInPort(pi.getInPort());

		// If the buffer id is none or the switch doesn's support buffering
		// we send the data with the packet out
		if (pi.getBufferId() == OFPacketOut.BUFFER_ID_NONE) {
			byte[] packetData = pi.getPacketData();
			poLength += packetData.length;
			po.setPacketData(packetData);
		}

		po.setLength(poLength);

		try {
			counterStore.updatePktOutFMCounterStoreLocal(sw, po);
			messageDamper.write(sw, po, cntx);
		} catch (IOException e) {
			log.error("Failure writing packet out", e);
		}
	}

	protected void doFlood(IOFSwitch sw, OFPacketIn pi, FloodlightContext cntx) {
		if (topology.isIncomingBroadcastAllowed(sw.getId(), pi.getInPort()) == false) {
			if (log.isTraceEnabled()) {
				log.trace(
						"doFlood, drop broadcast packet, pi={}, "
								+ "from a blocked port, srcSwitch=[{},{}], linkInfo={}",
						new Object[] { pi, sw.getId(), pi.getInPort() });
			}
			return;
		}

		// Set Action to flood
		OFPacketOut po = (OFPacketOut) floodlightProvider.getOFMessageFactory()
				.getMessage(OFType.PACKET_OUT);
		List<OFAction> actions = new ArrayList<OFAction>();
		if (sw.hasAttribute(IOFSwitch.PROP_SUPPORTS_OFPP_FLOOD)) {
			actions.add(new OFActionOutput(OFPort.OFPP_FLOOD.getValue(),
					(short) 0xFFFF));
		} else {
			actions.add(new OFActionOutput(OFPort.OFPP_ALL.getValue(),
					(short) 0xFFFF));
		}
		po.setActions(actions);
		po.setActionsLength((short) OFActionOutput.MINIMUM_LENGTH);

		// set buffer-id, in-port and packet-data based on packet-in
		short poLength = (short) (po.getActionsLength() + OFPacketOut.MINIMUM_LENGTH);
		po.setBufferId(pi.getBufferId());
		po.setInPort(pi.getInPort());
		if (pi.getBufferId() == OFPacketOut.BUFFER_ID_NONE) {
			byte[] packetData = pi.getPacketData();
			poLength += packetData.length;
			po.setPacketData(packetData);
		}
		po.setLength(poLength);

		try {
			if (log.isTraceEnabled()) {
				log.trace(
						"Writing flood PacketOut switch={} packet-in={} packet-out={}",
						new Object[] { sw, pi, po });
			}
			messageDamper.write(sw, po, cntx);
		} catch (IOException e) {
			log.error(
					"Failure writing PacketOut switch={} packet-in={} packet-out={}",
					new Object[] { sw, pi, po }, e);
		}

		return;
	}

	// Comparator for sorting by SwitchCluster
	public Comparator<SwitchPort> clusterIdComparator = new Comparator<SwitchPort>() {
		@Override
		public int compare(SwitchPort d1, SwitchPort d2) {
			Long d1ClusterId = topology.getL2DomainId(d1.getSwitchDPID());
			Long d2ClusterId = topology.getL2DomainId(d2.getSwitchDPID());
			return d1ClusterId.compareTo(d2ClusterId);
		}
	};
}
