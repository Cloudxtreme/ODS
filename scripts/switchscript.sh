#!/bin/bash                                                                                                                                                      
cd ~/openflow-1.0.0                                                                                                    
sudo make install                                                                                                                                                
sudo apt-get update && sudo apt-get install emacs xauth --yes

sudo apt-get install gawk
sudo update-alternatives --set awk /usr/bin/gawk
alias ll='ls -al'

cd ~

./getEthernetPorts.sh | xargs sudo ofdatapath --detach punix:/var/run/dp0 -i
