#!/home/saikumar/bin/py

import subprocess

name='saikumar'
proc = subprocess.Popen(['echo',name],
			    stdin = subprocess.PIPE,
			    stdout = subprocess.PIPE,	
                            stderr = subprocess.PIPE		
			);

(out,err) = proc.communicate()
print("\n")
print(out)

print("\nTrying ls command");

rcode = subprocess.call(["ls","-junk"]);
print(rcode);




