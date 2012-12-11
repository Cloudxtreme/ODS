#!/bin/bash

#see http://networkstatic.net/openvswitch-configure-from-packages-and-attaching-to-a-floodlight-openflow-controller/
sudo apt-get update
sudo apt-get purge network-manager
sudo apt-get install debhelper
sudo apt-get install module-assistant
sudo apt-get install uuid-runtime
sudo apt-get install bridge-utils
sudo apt-get install python-argparse
sudo dpkg -i openvswitch-common_1.9.90-1_i386.deb
sudo dpkg -i openvswitch-switch_1.9.90-1_i386.deb
sudo dpkg -i openvswitch-brcompat_1.9.90-1_i386.deb
sudo dpkg -i openvswitch-pki_1.9.90-1_all.deb
sudo dpkg -i openvswitch-controller_1.9.90-1_i386.deb
sudo dpkg -i openvswitch-switch_1.9.90-1_i386.deb
sudo dpkg -i openvswitch-datapath-source_1.9.90-1_all.deb

sudo module-assistant auto-install openvswitch-datapath


