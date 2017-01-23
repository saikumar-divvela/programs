#!/usr/bin/python

#from __future__ import braces
#import this


### Program to cover features of python
# Unpack a list or directory using function arguments as * and **
def draw_point (x,y):
    print x,y

point_foo=[3,4]
point_bar = {'y': 3, 'x': 2}

draw_point(*point_foo)
draw_point(**point_bar)

#Chaining comparision operators
x=5
print x < 10 < x*10 < 100
print 5 in [5] is True


# Can not pass non keyword argument after keyword argument
def fun(x,y):
    print x,y
# fun(x=1,2) doesn't work

#Variable arguments, * is used for variable non-keyword  arguments
def fun1(x,*args):
    print x,args


fun1(1,2,3,"test")
fun1(1)

# ** is used for variable keyword arguments
def fun2(**args):
    print args
dict1={'x': 1, 'y': 2, 'z': 3}
fun2(**dict1)
fun2(test1="xyz",test2="abc")

# variable non keyword arguments and variable keyword arguments
def fun3(*args,**kwargs):
    print args
    print kwargs

fun3(1,2,3,x="a",y="b",z="c")

# Decorators --> Used for enhancing function or method
def print_decorator(function):
    print function
    def wrapper(*args,**kwargs):
        print "Arguments",args,kwargs
        return function(*args,**kwargs)
    return wrapper

@print_decorator
def write(text):
    print text
write("hello")

# Mutable default arguments
def fun4(x=[]):
    x.append(1)
    print x
fun4()
fun4()

#solution
def fun5(x=None):
    if x is None:
        x =[]
    x.append(1)
    print x
fun5()
fun5()
