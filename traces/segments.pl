#!/usr/bin/perl
#use strict;    # turn on compiler restrictions
$|++;    # do not buffer output

$num_args = $#ARGV + 1;
if ($num_args != 2) {
  print "Usage: segments.pl trace.txt segment_size\n";
  exit;
}

open( INFILE, $ARGV[0] )
  or die("Can not open input file: $!");

while ( $file = <INFILE> ) {
    
    @fields = split(";", $file);
    $som+=@fields[3];

    $line =  $fields[0];
    if($line > 0 && $line % $ARGV[1] == 0) {
      #print $line . "\n";
      print $som . "\n";
      $som = 0;
    }

}

close(INFILE);

exit;


