#!/bin/bash
./getEthernetPorts.sh | xargs sudo ofdatapath --detach punix:/var/run/dp0 -i


