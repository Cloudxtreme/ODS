#!/bin/bash

ifconfig | gawk -f ~/openv/openvswitch-1.1.0pre2/getEthernetPortsSpace.gawk
