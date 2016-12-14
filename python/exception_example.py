import sys
import traceback    


def test():
    try:
        var1 = "1" +2
    except Exception as e:
        print type(e)
        print repr(e)
        print str(e)
        print e.message
        print e.args
        print sys.exc_info()
test()

class TestException(Exception):
    pass

try:
    raise TestException("this is raised test expression")
except Exception as e:
    print sys.exc_info()
    print e.args
#   raise

class TestError(Exception):
    def __init__(self,message,errors):
        super(TestError,self).__init__(message)
        self.errors = errors

try:
    raise TestError("this is raised by test error","test")
except Exception as e:
    print sys.exc_info()
    print e.message
    print e.args
    print e.errors
    #print e.foo
#   raise



#Example 1
try:
    sys.exit(0)
except:  #This can catch base exceptions also
    traceback.print_exc()


#Example 2
myTuple = (1,2,3)
print myTuple
try:
    myTuple.append(4)
except Exception as exp:
    print type(exp),exp
    traceback.print_exc()
 

#Example 3
try:
    print "hello"
except Exception as exp:
    print (exp)
else:   #This is executed when try is finished
    print "All fine"
finally:
    print "Cleaning up"

#Example 4
try:
    var1 = "1"
    print "hello"
    var1 = var1+2
except Exception as exp:
    print (exp)
else:
    print "All fine"
finally:
    print "Cleaning up"


#Example 5
try:
    print "Example 5"
except Exception as exp:
    print (exp)
else: #Any exception here is saved and raised after finally block is executed
    print "All fine"
    #var1 = "1"+2
finally:
    print "Cleaning up"


#Example 6  raising exception
try:
    raise ValueError('Test error')
except ValueError as e:
    print e    
    traceback.print_exc()
  
#Example 7  Reraise the exception
try:
    raise ValueError('Test error1')
except ValueError as e:
    print e    
#    raise   # This will keep track of stack trace for exception




