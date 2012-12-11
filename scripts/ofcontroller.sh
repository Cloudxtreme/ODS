#!/bin/bash
(( $# == 0 )) || { echo "usage: ./ofcontroller.sh"; exit 1; }
sudo ofprotocol unix:/var/run/dp0 tcp:10.1.8.2:6633
