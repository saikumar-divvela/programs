import urllib.parse
print ("hello");
scheme, netloc = urlsplit("http://168.219.209.58")[0:2]
print(urlunsplit((scheme, netloc, '/'.join(['build', 'devel:2.3:OSLM:Mobile', '_result']), query, '')))