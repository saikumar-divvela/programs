package foo;

public class Counter
{
	private  static int count;

	synchronized static public int getCount(){
		count ++;
		return count; 
	}

}