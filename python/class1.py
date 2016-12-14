'''
    All about class/instance variables class/instance/static methods
    class variables : attributes declared outside of any instance method
                      Get class.attr or  instance.attr
                          Set using class.attr = new_value if you do instance.attr = new_value it will create new instance variable
    instance variables: attributes declared using self.

    instance method: reference to instance is passed as first parameter, method can be called by instance only
    class method:    reference to class is passed as first parameter, method is bound to class, method can be called by instance or class
    static method:   no reference is required, not bound to any instance or class, method can be called by class or instance
    method without self:  method can be called by class only

'''


class A(object):
    def foo(self,x):   # This instance method can be called by instance only
        print ("Executing foo(%s,%s) "%(self,x))


a = A()
a.foo(12)
A.foo(12,13)

'''
class robot:
    __counter = 0
    def __init__(self):
        self.posx = 11
        self.posy = 22
        #type(self).__counter += 1

    def num_of_instances():  # This method can be called by class only
        print (robot.__counter)
        print ('hello')

    def print_instances(self): # This method can be called by instance only
        print (robot.__counter)

    @staticmethod
    def instances_count():  # This method can be called by class or instance
        print (robot.__counter)

    @classmethod
    def no_of_instances(cls):  # This method can be called by class or instance
       print (robot.__counter)

r1 = robot()
r1.print_instances()
#r1.num_of_instances()
robot.num_of_instances()


r1.instances_count()
robot.instances_count()

r1.no_of_instances()
robot.no_of_instances()

print (r1.__dict__)
print (robot.__dict__)


class mydata:
    def __init__(self,data):
        self.data = data

    @classmethod
    def fromdict(cls,dicta):
        #data = dicta.items()
        return cls(dicta)

print (mydata([1,2,3]).data)
d1 = {"hi":"hello",1:2}
d2 = mydata.fromdict(d1)
print(d2.data)
'''
