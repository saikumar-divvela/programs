#!/usr/bin/python

import os

# Returns extension of file
def extension(fn):
    return fn[fn.rfind('.')+1:]

# Retrieves list of files having given extensions
def getfiles(path,extensions=[]):
    filelist = {}
    for dirpath,dirnames,filenames in os.walk(path):
        print "scanning %s..."%(dirpath)
        for fn in  filenames:
            ext = extension(fn)
            if not extensions:
                filelist.setdefault(ext, []).append(os.path.join(dirpath,fn))
            elif ext in extensions:
                filelist.setdefault(ext, []).append(os.path.join(dirpath,fn))
    return filelist

def genhtml(filelist):
    print filelist
    o_html = "<html><head></head><body><font size='3'>"
    for key in filelist.keys():
        for fn in  filelist[key]:
            o_html = o_html+ "<p><a type='text/plain' target='_blank' href='file:///"+fn+"'>"+os.path.basename(fn)+"</a></p>"
    o_html = o_html+"</font></body></html>"
    return o_html


path='/home/sai/sss/'
extensions = ['info']
o_file= '/home/sai/sss/test_info.html'


filelist = getfiles(path,extensions)
o_html = genhtml(filelist)

with open(o_file,'w') as of:
    of.write(o_html)


