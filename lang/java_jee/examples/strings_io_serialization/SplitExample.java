
public class SplitExample
{
		public static void main(String args[]){
				String[] tokens = args[0].split(args[1]);
				System.out.println("number of tokens:"+tokens.length);
				for(String s:tokens){
					System.out.println(">"+s+"<");
				}
		}
}