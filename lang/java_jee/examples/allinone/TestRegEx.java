public class TestRegEx
{
		public static void main(String args[]){
				String  data = "boo1. and2.  foo3";
				String[] tokens = data.split("\\.\\S*");
				for(String s: tokens){
					System.out.println(s);
				}
				System.out.format("Pi is approximately %f", Math.PI);
		}
}