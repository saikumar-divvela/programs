#!/usr/bin/env python


# 1 - Ginger 2 - Tomato 0 - Nothing

n = 6
a = [ [0,1,2,0,1,1], 
      [1,0,2,0,2,2],
      [1,0,2,1,1,1],
      [1,0,2,1,1,1],
      [1,0,2,0,1,2],
      [1,2,2,0,2,0]    
       ]

ans  = 0
ansrowcol = -1


rowt = [0 for i in range(n)]
rowg = [0 for i in range(n)]

colt = [0 for i in range(n)]
colg = [0 for i in range(n)]

totalt = 0
totalg = 0

for r in range(n):
    for f in range(n):
        if a[r][f] == 1:
            rowg[r] = rowg[r] +1
            colg[f] = colg[f] +1
        elif a[r][f] == 2:
            rowt[r] = rowt[r] +1
            colt[f] = colt[f] +1
    totalt = totalt + rowt[r]
    totalg = totalg + rowg[r]    

for r in range(n-1):
    ging =  rowg[r] + rowg[r+1]
    tom =   totalt - rowt[r] - rowt[r+1]
 
    if ging+tom > ans:
        ans = ging+tom
        ansrowcol = r

    ging =  colg[r] + colg[r+1]
    tom =   totalt - colt[r] - colt[r+1]
    if ging+tom > ans:
        ans = ging+tom
        ansrowcol = r

print "Answer"
print ans
print ansrowcol


