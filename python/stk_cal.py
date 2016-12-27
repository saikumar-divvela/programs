#! /usr/bin/env python

import csv

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

stks = {"YESBAN":{"tgt":1100,"max_inv":100000},"HAVIND":{"tgt":350,"max_inv":100000},"BAJFI":{"tgt":800,"max_inv":100000},"DEWHOU":{"tgt":250,"max_inv":100000},"CANHOM":  {"tgt":1600,"max_inv":60000},"INTDES":{"tgt":150,"max_inv":70000},"MANAFI":{"tgt":60,"max_inv":60000},"GRANUL":{"tgt":100,"max_inv":60000}}


data = {}
with open("/home/sai/Downloads/8500610131_PortFolioEqt.csv","rb") as csvfile:
    reader = csv.DictReader(csvfile)
    for row in reader:
        if row['Stock Symbol'] in stks.keys():
            data[row['Stock Symbol']] = {"qty":row['Qty'],"avg_price":row['Average Cost Price'],"curr_price":row["Current Market Price"]}

x2 = 6000
print "inv: %s"%(x2)
for stk in stks.keys():
     n1 = float(data[stk]["qty"])
     p1 = float(data[stk]["avg_price"])
     x1 = p1 * n1
    
     curr_price = float(data[stk]["curr_price"])

     n2 = x2 / curr_price    
     new_price = (x1 + x2 ) / (n1+n2)   
    
     print stk   
     print "%s %s %s curr:%s tgt:%s"%(n1,int(p1),int(x1),int(curr_price),stks[stk]["tgt"])
     print "%s %s %s max_inv:%s remaining:%s"%(round(n2),int(new_price),int(x1+x2),int(stks[stk]["max_inv"]),int(stks[stk]["max_inv"]-x1-x2))
     n2 = (stks[stk]["max_inv"] - x1) / curr_price
     new_price = stks[stk]["max_inv"] / (n1+n2)      

     print "%s %s %s max_inv:%s remaining:%s"%(round(n2),int(new_price),int(stks[stk]["max_inv"]),int(stks[stk]["max_inv"]),0)
