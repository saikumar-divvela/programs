#!/usr/bin/python3


'''
def p(arr,n):
    print([arr[i] for i in range(0,n)])

def combutil(arr,data,start,end,index):
    if index >0:
        p(data,index)

    for x in range(start, end):
        data[index] = arr[x]
        combutil(arr,data,x+1,end,index+1)

def comb(arr,n):
    data = [None]*(n)
    combutil(arr,data,0,n,0)
'''
mincost=1234567890
COST = [350,200,100,50]
N = 4;
A=[ [0,1,1,0],[1,0,0,1,],[1,0,0,0],[0,1,0,0] ]


def p(arr,n):
    print([arr[i] for i in range(0,n)])


def calc_cost(st,n):
    return sum ( COST[st[i]] for i in range(0,n) )

def isconnected(st,n):
    city_status = [False for x in range(0,N)]

    for i in range(0,n):
        st_index= st[i]
        city_status[st_index]=True
        for x in range(0,N):
            if A[st_index][x] == 1:
                city_status[x] =True

    return all(city_status)


def combutil(data,start,end,index):
    allconnected = False
    global mincost
    if index >0:
        allconnected = isconnected(data,index)

    if allconnected:
        cost1 = calc_cost(data,index) 
        if mincost > cost1:
            mincost = cost1
        
        print ("all connected",cost1)
        p(data,index)
        
        return

    for x in range(start, end):
        data[index] = x
        combutil(data,x+1,end,index+1)

def find_mincost():
    data = [None]*(N)
    combutil(data,0,N,0)
    return 0;

find_mincost()
print ("MIN COST::",mincost)
