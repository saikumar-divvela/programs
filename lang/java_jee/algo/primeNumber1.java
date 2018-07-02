/*
	Program to find the list of prime numbers below a given number
	Algorithm:
		a) create a list of numbers starting from 2 to the number (list A)
		b) 2 is a prime number, remove this number and multiples of 2 from list A, add to list B
		c) now the first number in list A is a prime number
		d) move the number and its multiples from list A to list B
		e) follow steps c and d until list A is empty
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class primeNumber1
{
	int maxNum;
	List A;
	List B;
	primeNumber1(int x){
		maxNum = x;
		A = new ArrayList();
		B = new ArrayList();
	}
	void findPrimeNumbers() throws Exception{
		// step a
		for(int i=2;i<=maxNum;i++) A.add(new Integer(i));
		// step b,c,d
		while(!A.isEmpty()){
			B.add(A.get(0));
			int prime = ((Integer)(A.get(0))).intValue();
			List temp = new ArrayList();
			A.remove(0);
			for(int x=prime*prime;x<=maxNum;x=x+prime) temp.add(new Integer(x));
			A.removeAll(temp);
		}
		System.out.println("primary List:"+B);
	}
	static int readInt() throws IOException,NumberFormatException{
		InputStreamReader inReader = new InputStreamReader(System.in);
		BufferedReader bReader = new BufferedReader(inReader);
		return(Integer.parseInt(bReader.readLine()));
	}
	public static void main(String args[]) throws Exception{
		int x;
		System.out.print("Eenter a number:");
		x = readInt();
		primeNumber1 prime = new primeNumber1(x);
		prime.findPrimeNumbers();
	}
}