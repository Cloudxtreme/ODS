[[ $# == 2 ]] || { echo "Usage: ./files.sh filenameofbytes layernr"; exit 1; }

i=0

while read byte
do dd if=/dev/zero of=video_s${i}_l$2.dat bs=$byte count=1
i=$(( $i+1 )) 
done < $1




