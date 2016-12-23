'''
    All about class/instance variables class/instance/static methods
'''
class Pizza(object):
    #Class variable. Declared outside of instance methods. This can be accessed in class definition as Pizza.instance_count or cls.instance_count
    #Outside class access directly using  Pizza.instance_count or Pizza(10).instance_count
    #For updating class level variables always use CLASS.attr = xyz , If you do instance.attr=xyz that will create instance variable with same name
    #as class variable
    instance_count = 0

    def __init__(self,size):
        self.size = size   #Instance variable can be accessed directly using instance  Pizza(20).size
        Pizza.instance_count += 1

    def getsize(self):   #Bound to instance. Reference to instance is passed as first parameter. This method can be called by instance only.
        return self.size

    def get_instances(self):
        return self.instance_count  #Class variable is accessed using self

    @staticmethod
    def mix_ingredients(x,y): #Not bound to any instance or class. Static method can be called by class or instance
        return x+y

    @classmethod
    def get_no_of_instances(cls):  #Bound to class. Reference to class is passed as first parameter. This method can be called by class or instance
       return cls.instance_count   #Class variable is accessed using cls

    def cook(self):  ## Instance method
        return self.mix_ingredients(10,20)

    def cook1():  #Method without self,cls. This method works in Python3.x because functions attached to class are simple functions in Python3.x
        print ("Cooking")

    def get_rating(self):  # The instance variable rating is not part of this class definition but declared as  instance variable outside class
        return self.rating

    @classmethod
    def get_address(cls): # The class variable address is not part of this class definition but declared as class variable outside class
        return cls.address

# print Pizza.getsize()  # Doesn't work in Python 2.x. But works in Python 3.x In python 3 , functions attached to class are simple functions

## Access class level and instance level attributes
p1 = Pizza(20)
print (Pizza.instance_count,p1.instance_count)  ## Accessing class level variable
print (p1.size)  # Accessing instance level variable
p1.instance_count =12
print (Pizza.instance_count,p1.get_instances())


## Set new instance and class variables
p1.rating = "good"
print (p1.rating,p1.get_rating())

Pizza.address="bangalore"
print (p1.get_address(),Pizza.get_address())


## Method examples
#Instance method
print (p1.getsize, p1.getsize())
m =  Pizza(42).getsize
print (m.__self__)

p2 = Pizza(20)
print (p2.cook(),p2.get_instances())

#Static method example
print (Pizza.mix_ingredients(2,3),p2.mix_ingredients(12,3))

print (Pizza(42).cook is Pizza(42).cook)
print (p1.mix_ingredients is  p2.mix_ingredients)
print (p1.mix_ingredients is  Pizza.mix_ingredients)
print (p1.get_no_of_instances is Pizza.get_no_of_instances)
print (p1.get_no_of_instances(), Pizza.get_no_of_instances())
# Pizza.cook1()  # works only in python 3.x

'''
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
