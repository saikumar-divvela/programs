import java.util.List;

public class TestGenerics
{
	public void addStrings(List<? super  String>  list) {
			list.add("foo");
			list.add("bar");
	}
	
	public static <T extends Comparable> T findLarger(T x, T y) 
	{
			 if(x.compareTo(y) > 0) 
			{
				 return x;
			 } else {
				 return y;
			}
	}
 
	public static void main(String args[]){
			int x =findLarger(123, "256");
	}
}