#! /usr/bin/env python

print 'hello'

'''
n1 =  156.5
p1 =  115 

t1 = n1 * p1

p_change = 10
n2 = int(t1 / ((1+ p_change/100.0)* p1))

t_shares = n1
c_price = p1
print "#Total %s #Noshares %s #Avgprice %s #Start price %s #currentprice %s"%(t1,n1,p1,p1,p1)
for x in range(1,2):
    c_price =  round ((1 - 40/100.0) * p1,2)    
    n2 = int((1.0*t1/2.0) / c_price)
    t_shares = t_shares + n2
    t_amount =  t1 * (1.0*x/2.0+1)
    avg_price = round(t_amount/t_shares,2)
    print "#Total %s #Noshares %s #Start price %s #Avgprice %s %.2f %.2f #currentprice %s"%(t_amount,t_shares,p1,avg_price,(avg_price-p1)*100/p1,(c_price-avg_price)*100/avg_price,c_price)
'''

n1 = 207
p1 = 282.49
x1 = p1 * n1

avg_p = 250
x2    = 32000


n2 =  ((x1 + x2)/avg_p) - n1
p2 =  x2/n2

print "%s %s %s"%(n1,int(p1),int(x1))
print "%s %s %s avg: %s"%(round(n2),int(p2),int(x2),int(avg_p))


