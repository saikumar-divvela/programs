#!/usr/bin/env python

import subprocess
import shlex
import sys

def runcmd(cmdln_or_args):
    sout, serr = subprocess.PIPE, subprocess.STDOUT
    cmd, shell = shlex.split(cmdln_or_args), True
    try:
        process = subprocess.Popen(cmdln_or_args, stdout=sout,stderr=serr, shell=shell)
        '''        
        out = process.communicate()[0]
        if out is None:
            out = ''
        '''
        while True:
            nextline = process.stdout.readline()
            if nextline == '' and process.poll() != None:
                break
            sys.stdout.write(nextline)
            sys.stdout.flush()

        output = process.communicate()[0]
        exitCode = process.returncode

    except OSError, exc:
        raise # relay

    #return process.returncode,out
