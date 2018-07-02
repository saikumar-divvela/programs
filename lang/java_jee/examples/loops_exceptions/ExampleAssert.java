public class ExampleAssert
{
	public static void main(String args[]){
		checkNum(-3);
	}
	private static void checkNum(int n){
				assert (n>=0):"n is :"+n;
				System.out.println("positive number "+n);
	}
}