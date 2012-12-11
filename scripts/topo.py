"""Topology for the ODS project

author: Sander Vrijders

Adding the 'ofsvc' dict with a key/value pair to generate our newly defined topology enables one to pass in '--topo=ofsvc' from the command line. """

from mininet.topo import Topo, Node

class MyTopo( Topo ):

    def __init__( self, enable_all = True ):
        "Create custom topo."

        # Add default members to class.
        super( MyTopo, self ).__init__()

        # Set Node IDs for hosts and switches
        src = 1
        switch0 = 2
        switch1 = 3
        switch2 = 4
        switch3 = 5
        switch4 = 6
        sink = 7

        # Add nodes
        self.add_node( src, Node( is_switch=False ) )
        self.add_node( switch0, Node( is_switch=True ) )
        self.add_node( switch1, Node( is_switch=True ) )
        self.add_node( switch2, Node( is_switch=True ) )
        self.add_node( switch3, Node( is_switch=True ) )
        self.add_node( switch4, Node( is_switch=True ) )
        self.add_node( sink, Node( is_switch=False ) )

        # Add edges
        self.add_edge( src, switch0 )
        self.add_edge( switch0, switch1 )
        self.add_edge( switch0, switch2 )
        self.add_edge( switch1, switch2 )
        self.add_edge( switch1, switch3 )
        self.add_edge( switch2, switch4 )
        self.add_edge( switch3, switch4 )
        self.add_edge( switch4, sink )  

        # Consider all switches and hosts 'on'
        self.enable_all()

topos = { 'ofsvc': ( lambda: MyTopo() ) } 
