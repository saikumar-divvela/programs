public class VeryBasic
{
	public static void main(String args[]) throws Exception{
			try
			{
				synchronized(args){
					args.wait();	
				}
			} finally{
				System.out.println("haa thank god  you reached me");
			}
			
	}
}