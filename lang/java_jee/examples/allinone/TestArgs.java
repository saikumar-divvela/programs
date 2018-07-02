public class TestArgs
{
			public static void main(String... args) {
					try {
						 //args=null;
						 args = new String[]{"test1","test2"};
						 //args[0] = "test0";
						 //args[1] = "test1";
						 System.out.println(args[0]);
				 }  catch(ArrayIndexOutOfBoundsException aexp){
						 System.out.println("arary out of boundary Exception:"+aexp.getMessage());
				 }
				 catch (Exception exp) {
						 System.out.println("Exception:"+exp.getMessage());
					 } 
			}
}
