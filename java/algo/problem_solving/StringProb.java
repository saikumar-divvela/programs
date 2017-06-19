package com.sss.spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 
 ABCDEFGHIJ                    

ABCD
4*3

4
--------- 
 A C
	A D
	B D
	C A
	D A
	D B
6
----------------
10

A - 3
B - 2
C - 2
D - 3

	ACA
	ADA
	ADB
	BDA
	BDB
	CAC
	CAD
	DAC
	DAD
	DCA
-----------------------
16


A-5
B-3
C-3
D-5

---------------------
4 6    10   16 
  4*3-3*2   
--------------------
ABCDEFGHIJ
10 72 520  3754
   10*9-9*2
   10*9*8 -    
100 - 10-18
1000-
A-8  A-57  A- 413
B-7  B-50  B- 362
C-7  C-51  C- 368
D-7  D-51  D- 367
E-7  E-51  E- 3 67
F-7  F-51  F- 367
G-7  G-51  G -367
H-7  H-51  H- 368
I-7  I-50  I- 362
J-8  J-57  J-413
-----------------------


2 3 4 5  
 * 
 */

public class StringProb {
	
	static void cal() throws Exception{
		String[] in = Util.readLine().trim().split(" ");
		String A = in[0];
		String B = in[1];
		long output =0;
		
		if(A.length() > 6 || B.length() > 6 || A.length() > B.length()) return;

		for(int i=0;i<A.length();i++){
			if(A.charAt(i) < 65 || A.charAt(i) > 74) return;
		}
		
		for(int i=0;i<B.length();i++){
			if(B.charAt(i) < 65 || B.charAt(i) > 74) return;
		}
		
		int csize = B.length()- A.length();
		
		if(csize >= 2){
			
		} else if (csize ==0){
			if(A.length()==1){
				output = B.charAt(0)- A.charAt(0)-1;
			}
		} else if (csize==1){
			
		}
		 
		System.out.println(A);
		System.out.println(B);
		System.out.println(output);
		
	}
	public static void main(String args[]) throws Exception {
		cal();
	}
	
	static class Util {
		public static InputStreamReader istream = new InputStreamReader(System.in) ;
		public static BufferedReader bufRead = new BufferedReader(istream) ;
		
		public static int getInt() throws Exception{
			String str;
			while(((str=bufRead.readLine()).trim()).equals(""));
			return Integer.parseInt(str);
		}

		public static double getDouble() throws Exception{
			String str;
			while(((str=bufRead.readLine()).trim()).equals(""));
			return Double.parseDouble(str);
		}
		
		public static String readLine() throws Exception{
			String str = null;
			while(((str=bufRead.readLine()).trim()).equals(""));
			return str;
		}
	}
}
