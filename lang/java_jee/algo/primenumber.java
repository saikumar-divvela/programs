/*
	Program checks whether the given number is a prime number or not
	prime number algorithm
	1 is not a prime number
	Algorithm:
				if n = 1 or 2 return true
				for each i = 3 to n/2
					check n%i is 0
				if i==n/2 return true 
	complexity: O(n/2)
	uses : mathematics and computer science
			encryption (uses math operations on prime numbers) used for digital signature of mails, credit card
			secret code
	largest primes known are Mersenne primes.
	A Mersenne number is a number that is 1 less than the power of 2  pow(2,n)-1
	A Mersenne prime is a Mersenne number which is a prime number  pow(2,n)-1 where n is a prime number
	ex: 3,7,11,31
	Mersenne primes are related to perfect numbers, which are equal to the sum of their proper divisors.
	ex:6 (1+2+3) if M is Mersenne prime then M(M+1)/2 is perfect number 
*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class primenumber{
	public static boolean isPrime(int n){
		int i;
		if(n==1 || n==2) return true;
		for(i=3 ; i<n/2 && n%i!=0;i++);
		if(i==n/2)
			return true;
		else
			return false;
	}
	public static int readInt(){
		int number=-9999;
		try {
			System.out.println("Enter a number:");
			InputStreamReader stdin = new InputStreamReader(System.in);
			BufferedReader console = new BufferedReader(stdin);
			number = Integer.parseInt(console.readLine());
		} catch(IOException ioe){
			System.out.println("IO exception message:"+ioe.getMessage());
		} catch(NumberFormatException nfe){
			System.out.println("Number formatted exception message:"+nfe.getMessage());
		}
		return number;
	}
	public static void main(String args[]){
		int x = readInt();
		if(isPrime(x)){
			System.out.println(x+" is a prime number");
		} else {
			System.out.println(x+" is not a prime number");
		}

	}

}
