Layer-based routing to obtain quality optimization of scalable video streaming in the Future Internet.

===

In current IP networks, routes are usually based on the hop count from sender to receiver without keeping in mind the throughput and loss of packets. IP is a best-effort protocol and doesn't guarantee zero packet loss. This is unsatisfactory if we want to deliver qualitative, scalable video streams. It is essential that the base layer doesn't have any lost packets since it is used to decode the other layers. We will apply traffic engineering using Openflow by dynamically configuring switches to choose optimal paths for the different layers of the video streams. This is based on monitoring data that represents the state of the network. A 1st problem is to determine most efficient paths for the different layers of video streams. A 2nd problem we have to account for is failures in the network. 

We want to provide certain quality measurements for the delivered video streams. We will do this by delivering the base layer of the video stream with a high priority on links with low congestion and enhancement layers with lower priority and on links with (possibly) more congestion. We will primarily focus on calculating efficient paths and handling failures in the network. 
