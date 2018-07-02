//import java.lang.Exception;	

public class TestException
{
		public  static void main(String args[])
		{
				try
				{
					System.out.println(reverse(""));
				}
				catch (RuntimeException exp)
				{
					System.out.println("runtime exp:"+exp.getMessage());
				}
				catch (Exception exp)
				{
					System.out.println("exp:"+exp.getMessage());
				}
				catch (Throwable exp)
				{
					System.out.println("throw:"+exp.getMessage());
				}
				 finally{
					System.out.println("Program completed");
				}
		}

		private static String reverse(String str) throws Throwable
		{
			try
			{
				if(str.length ()<1)
				{
					throw new RuntimeException("String empty");
					//throw new Exception("String empty");
					//throw new Throwable("String empty");
				}
			}
			catch (RuntimeException rexp)
			{
					System.out.println("run time exception:"+rexp.getMessage());
					throw new Throwable("String empty");
			}
			String reverseStr="";
			for(int i=str.length()-1;i>=0; --i)
			{
				reverseStr  = reverseStr + str.charAt(i);
			}
			return reverseStr;
		}
}