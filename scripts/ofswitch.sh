#!/bin/bash
(( $# == 1 )) || { echo "usage: ./ofswitch [path to csv of interfaces]"; exit 1; }
sudo ofdatapath --detach punix:/var/run/dp0 -i $(cat $1)

