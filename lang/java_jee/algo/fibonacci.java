/*
	Fibonacci Series invented by fibonacci
	uses: for calculation of children of rabbit,bees
		  fiboannci rectangles and shell spirals
		  golden section 
	Algorithm: f(n) = 0					if n =0;
					= 1					if n =1;
					= f(n-1) + f(n-2)	if n > 1
	About program:This program takes a input and prints that many fibonacci series values
*/
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class fibonacci {
	static int fib(int n){
		return(n==1?1:n==2?1:fib(n-1)+fib(n-2));
	}
	static int readInt(){
		try {
			int number;
			InputStreamReader stdin = new InputStreamReader(System.in);
			BufferedReader console = new BufferedReader(stdin);
			System.out.print("Enter a number:");
			number  = Integer.parseInt(console.readLine());
			return number;
		} catch(IOException ioe){
			return -9999;
		} catch(NumberFormatException  nfe){
			return -9999;
		}
	}
	public static void main (String args[]){
		int i,X;
		X = readInt();
		System.out.print("Fibonacci series:");
		for(i=1;i<=X;i++){
				System.out.print(" "+fib(i));
		}

	}
}