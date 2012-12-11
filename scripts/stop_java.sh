#!/bin/sh

node_count=32

for node_id in `jot $node_count 1`; do
	hostname="peer-$node_id"
    ssh $hostname.group16.odspracticum.wall.test "killall java" &
done

wait
