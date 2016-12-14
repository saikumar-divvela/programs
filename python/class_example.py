import sys

class person(object):
    def __init__(self,name,age):
        print("executing constructor with arguments")
        self.name = name
        self.age = age

    def __init__(self):
        print ("executing default constuctor")


    def sayHello(self):
        #print ("Hello ", (self.name))
        sys.stdout.write ("Hello \n")


p1 = person("saikumar",34)
p2 = person()
p1.sayHello()
p2.sayHello()
