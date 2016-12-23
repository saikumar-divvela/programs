import math

def getlcd(x,y):
    x1=x; y1=y
    while (x1 != y1):
        if (x1 > y1):
            y1 = y1+ y
        else:
            x1 = x1+x
    return x1

def getlcd_list(b):
    if  (len(b)  < 1) :
        return None

    if (len(b) == 1):
        return b[0]

    y = b[0]
    for x in b[1:]:
        y = getlcd(x,y)

    return y


a =[2,2,2,2,2,2]
N = 24
count = None

b = [] ; c = []
digits = math.floor(math.pow(10,N))-1
print (digits)
for idx,x in enumerate(a):
    if x == 1:
        b.append(idx+1) # Number should be divisible by this 
    elif x == 0:
        c.append(idx+1) # Number should not be divisible by this 

lcd = getlcd_list(b) 
print ('LCD:',lcd) # very important
if lcd is None:
    if (a[0] == 0):
        count = 0
    elif (a[0] == 2):
        count = digits +1
'''
else:
    count = digits//lcd
    for x in c:
        lcd1 = getlcd (x,lcd)
        if lcd1 is not None:
            count = count - digits//lcd1
    if (len(c) == 0):  # no 0 present in input so add 1
        count = count+1

'''
print ('Final count:',count)

