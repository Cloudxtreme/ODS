#!/bin/bash
sudo apt-get update
sudo apt-get install gawk

cd ~/openv/openvswitch-1.1.0pre2
sudo /sbin/insmod ./datapath/linux-2.6/openvswitch_mod.ko
./getEthernetPortsSpace.sh | sudo xargs ./utilities/ovs-dpctl add-dp dp0
sudo ifconfig dp0 up
sudo mkdir /usr/local/var
sudo mkdir /usr/local/var/run
sudo mkdir /usr/local/var/run/openvswitch
sudo ./utilities/ovs-openflowd dp0 tcp:10.1.8.2 --pidfile=$$
