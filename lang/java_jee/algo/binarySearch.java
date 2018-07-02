/*
	Program to search an integer in a sorted list
	Binary Search is an algorithm to search for a integer in sorted list
	Algorithm: 
				func(input,low,high)
					center = low + high/2
					if number = center element
						return true
					if number > center element
						func(input,center+1, high)
					if number < center element
						func(input,low,center-1)
	complexity:
		best case -> O(1)
		worst case -> O(log(2)n)
	
*/
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class binarySearch{
	int a[];
	binarySearch(int n[]){
		this.a = n;
	}
	binarySearch(){
	}
	public boolean search(int x){
		//return false;
		return binarySearch(x,0,a.length-1);
	}
	public boolean binarySearch(int n,int low,int high){
			int index = (low+high)/2;
			if(low > high){
				return false;
			} else if(n==a[index]) {
				return true;
			} else if (n > a[index]){
				return binarySearch(n,index+1,high);
			} else {
				return binarySearch(n,low,index-1);
			}
			//return (n==a[index]?true:(n>a[index]?binarySearch(n,index+1,high):binarySearch(n,low,index-1)));
	}
	public static int readInt(){
		int n =-9999;
		try {
			InputStreamReader stdin = new InputStreamReader(System.in);
			BufferedReader console = new BufferedReader(stdin);
			n = Integer.parseInt(console.readLine());
		} catch(IOException ioe){
			System.out.println(ioe.getMessage());
		} catch(NumberFormatException nfe){
			System.out.println(nfe.getMessage());
		}
		return n;
	}
	public static void main(String args[]){
		int a[] = {3,4,5,6,7,8,9,10};
		binarySearch bS = new binarySearch(a);
		System.out.print("enter an integer:");
		int x = readInt();
		if(bS.search(x)) System.out.println(x+" found");
		else System.out.println(x+" not found");
	}
}