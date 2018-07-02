public class  TestException  extends A
{
	public void doSomething() throws SomeException { }
	public static void main(String args[]) throws Exception{
			try
			{
				System.out.println("inside try block and throwing an exception");
				throw new Exception("catch me if u can");
			}
			catch (Exception exp)
			{
				System.out.println("oh my god exception occurred what to do now :"+exp.getMessage());
				throw new Exception("i can't handle this its ur job");
			}	finally{
				System.out.println("life saver");
				throw new Exception("let me do some fun");
			}
	}
}
class SomeException  extends RuntimeException{
}

class A {
 public void doSomething() { }
 }
