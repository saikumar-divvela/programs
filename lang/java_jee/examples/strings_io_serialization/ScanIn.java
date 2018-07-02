import java.util.Scanner;

public class ScanIn
{
		public static void main(String args[]){
				System.out.print("input : ");
				System.out.flush();
				try{
						Scanner s = new Scanner(System.in);
						String token;
						do{
								token = s.findInLine(args[0]);
								System.out.println("found  "+ token);
						} while(token!=null);
				} catch(Exception exp){
						System.out.println("scan exception:"+exp.getMessage());
				}
		}
}