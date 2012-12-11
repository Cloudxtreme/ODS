#!/bin/bash

ifconfig | gawk -f ./getEthernetPorts.gawk

