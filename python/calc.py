#!/usr/bin/python

"""
 Calculator
"""

from __future__ import division
import math

'''
TODO
app
design the screen
print the screen inputs
calculate and print the result
error handling
'''

import logging
import sys

def rd_calc(p ,time, i, freq):
    print p,i,time,freq

    n = 12/freq  # numnber of times interest is calculated
    r = i / 100
    t = time/12

    maturity =  p * ( math.pow (1 + r/n, t*n) -1 )/ (1 - math.pow (1+ r/n, -n/12))
    print int(math.ceil(maturity))

def fd_calc(p,time,i,freq):
    print p,i,time,freq

    n = 12/freq
    r = i/100
    t = time/12

    maturity =  p * math.pow((1 + r/n),t*n)
    print int(math.ceil(maturity))


def rateof_return(p,m,time,freq):
    n = 12/freq
    print (math.pow(m/p,1/(time*n))-1)*n*100


# EMI = [P x R x (1+R)^N]/[(1+R)^N-1],
'''
The mathematical formula for calculating EMIs is: EMI = [P x R x (1+R)^N]/[(1+R)^N-1], where P stands for the loan amount or principal, R is the interest rate per month [if the interest rate per annum is 11%, then the rate of interest will be 11/(12 x 100)], and N is the number of monthly instalments.
'''
def emi(p,i,n):
    print "EMI: Principle: %s Interest:%s HowManyMonths: %s"%(p,i,n)

    r = i/(12*100)
    emi = p * r * math.pow( 1+r , n)  / (math.pow( 1+r , n) -1)
    print "EMI: ",math.ceil(emi)," Total interest: ", math.ceil((emi* n - p))

    la = p
    count =1;
    print '%6s%10s%10s%10s'%('Month','Int','Pri','Bal')
    yi = 0
    yp = 0
    while la > emi :
        mi = la * r
        mp = emi - mi
        la = la - mp
        #print '%6s%10s%10s%10s'%(count,math.ceil(mi),math.ceil(mp),math.ceil(la))
        yi = yi + mi
        yp = yp + mp
        if count%12 == 0:
            print '%6s%10s%10s%10s'%(count/12,int(math.ceil(yi)),int(math.ceil(yp)),int(math.ceil(la)))
            yi = 0
            yp = 0

        count = count +1

if __name__ == '__main__':
    rd_calc(28000,84,18,12)
    #fd_calc(15000,24,5,3)
    #rateof_return(1000,4000,6,12)
    #print math.ceil(math.pow(4,1/6))
    #emi(2800000,10.5,240)


'''
logger = logging.getLogger('calc')
logger.setLevel(logging.DEBUG)
logging.basicConfig(format='%(levelname)s:%(name)s:%(asctime)s:%(message)s',filemode='w',filename='example.log',datefmt='%d/%m/%Y %I:%M:%S %p')
logger.debug('This message should go to the log file')
logger.info('So should this')
logger.warning('And this, too')
'''
