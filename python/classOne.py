class Person():
    def __init__(self):
        print ("inside constructor")
        self.gender = 'm'
        self.age = 21
        self.name=''
        
        
    def __init__(self,name,gender,age):
        self.gender = gender
        self.name = name
        self.age = age


    def getAge(self):
        return self.age

    def incrementAge(self):
        self.age = self.age +1
