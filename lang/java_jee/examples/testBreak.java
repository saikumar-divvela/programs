public class testBreak
{
	public static void main(String args[]){
		int i=0;
		int j=10;
		ink k=20;
		if(i==0){
			if(j==10)break;
			System.out.println("reached the unreachable statement");
		}
	}
}