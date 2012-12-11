BEGIN{
count = 0
processLine=1;
OFS=" "
}

{ 
	if (processLine == 1){
		count++
		ports[count]=$1
		processLine=0
	}
}

/$^/{
processLine=1
}

#The line contains the ip address
/inet addr/ {
ip[count]=substr($2,6,length($2)-5)
}

END{
	#print "ports:"
	#printArray(ports)
	for( number in ports){
		location = match(ip[number],/10\.1\.[0-9]+\.[0-9]+/)
		if(location > 0)
		{
			goodports[number] = ports[number]
		}
	}
	#print "goodports:"
	printArray(goodports)
}

function printArray(arr){
	amt=0
	cnt=0
	for (var in arr){cnt++}
	for (var in arr){
		amt++
		if( amt < cnt){
			printf "%s%s",arr[var],OFS
		}else{
			printf "%s",arr[var]
		}
	}
	print""
}
