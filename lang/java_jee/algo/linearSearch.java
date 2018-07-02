/*
	Linear search
	Algorithm : x to be found
		for (each n in input)
		 if x equals n found and quit
	complexity:
		best case O(1)
		worst case O(n)
	Program to find an integer in an array of integers.
*/
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class linearSearch{
	int a[];
	linearSearch(int a[]){
		this.a = a;
	}
	linearSearch(){
	}
	boolean searchElement(int n){
		for(int i:a){
			if (i==n)return true;
		}
		return false;
	}
	public static int readInt(){
		int n =-9999;
		try {
			InputStreamReader stdin = new InputStreamReader(System.in);
			BufferedReader console = new BufferedReader(stdin);
			n = Integer.parseInt(console.readLine());
		} catch (IOException ioe){
			System.out.println(ioe.getMessage());
		} catch(NumberFormatException nfe){
			System.out.println(nfe.getMessage());
		}
		return n;
	}

	public static void main(String args[]){
		int a[] = {5,6,7,8,9};
		linearSearch lS = new linearSearch(a);
		System.out.print("Enter an integer:");
		int n = readInt();
		if(lS.searchElement(n)){
			System.out.println("The value "+n+" found ");
		} else {
			System.out.println("The value "+n+" not found ");
		}
	}
}