#!/usr/bin/python3

print ('hello')

def perm(a):
    # find k such that a[k] < a[k+1]
    k = -1
    l = -1
    for x in range(0,len(a)-1):
        if a[x] < a[x+1]:
            k =x
    if k <0 :
        return     
    for x in range(0,len(a)):
        if a[k] < a[x] :
            l = x

    if l >=0:
        temp = a[k]
        a[k] = a[l]
        a[l]= temp


    reverse(a,k+1,len(a)-1)          
    print (a)
    perm(a)

def reverse(a,start,end):
    y = (start+end)/2
    x = start  
    while start < y:
        temp = a[start]
        a[start] = a[end]
        a[end] = temp
        start += 1
        end -= 1    



a = [5,2,3,4]


print (a)
perm(a)


#for p in perm([1,2,3,4]):
#   print (p)
