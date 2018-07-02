#!/home/saikumar/bin/py

import subprocess
import pdb


#pdb.set_trace()

name='saikumar'
proc = subprocess.Popen(['echo',name],
			    stdin = subprocess.PIPE,
			    stdout = subprocess.PIPE,	
                            stderr = subprocess.PIPE		
			);
(out,err) = proc.communicate()
print(out)
cmd="ls"
cmd_options="-laht"
print("Trying command: %s %s"%(cmd,cmd_options));
rcode = subprocess.call([cmd,cmd_options]);
print(rcode);




