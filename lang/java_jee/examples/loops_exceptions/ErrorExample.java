public class ErrorExample
{
	static int i;
	public static void main(String args[]){
		go();
	}
	private static void go(){
		System.out.println("in go:"+i++);
		go();
	}
}