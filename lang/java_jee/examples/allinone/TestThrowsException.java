public class TestThrowsException
{
		public void methodA() throws Exception{
			methodB();
		}
		public void  methodB() throws Exception{
			//throw new Exception("i am an exception");
		}

		public void methodC(){
				methodD();
		}

		public void methodD(){
				throw new NullPointerException("i am nothing");
		}
		public static void main(String args[]){
				TestThrowsException tte = new TestThrowsException();
				try
				{
					tte.methodA();
				}
				catch (Exception exp)
				{
						System.out.println(exp.getMessage());
				}
		}
}