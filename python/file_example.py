#!/usr/bin/python

# this program covers file reading operations
import os

print (os.getcwd())
os.chdir('./sotong')
print (os.getcwd())

f = open("spiral.py",'r')
print("Reading a line "+f.readline())
print("Reading 10 characters "+f.read(10))
print("Read complete file:"+f.read())
f.seek(0) # sets the position to 0

print("\n\nPrinting the file again using for loop....\n")
for line in f:
   print(line)

f.close()

print("\n\n")
f = open("spiral.py",'r')
list1 = []
for line in f:
    list1.append(line)
print(list1)
f.close()


# writing to a new file

f1 = open("test.txt",'w')  # use 'a' to append
f1.write('hello\n')
f1.write('this is a test file for writing text\n')
f1.write('oh yes\n')
f1.close()

f1 = open("test.txt","a")
f1.write("this is appended in the end of file\n")
f1.write("yes\n")
f1.close()
