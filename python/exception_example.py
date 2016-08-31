
var1 = "1"
try:
    var1 = var1+2
except:
    print("exception occurred...")
    print(var1," is not a number so type casting string to integer")
    var1 = int(var1)+2

print(var1)

myTuple = (1,2,3)
print(myTuple)
try:
    myTuple.append(4)
except:
    print("exception occurred... tuple can't be changed")
 
