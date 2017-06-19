package com.sss.spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Colours{
	static void calColours() throws Exception{
		
		int N = Util.getInt();
		if(N<1 || N > 50000) return;
		String str = Util.readLine();
		char[] input = str.toCharArray();
		if(input.length > 2*N) return;
		
		
		char[] outputChar = new char[2*N];
			
		
		String temp = "ABCD".replace(String.valueOf(input[0]), "").replace(String.valueOf(input[1]), "");
	
		outputChar[0] = temp.charAt(0);
		outputChar[1] = temp.charAt(1);
		
		
		for(int i=2;i<2*N;i=i+2){
			temp = "ABCD".replace(String.valueOf(input[i]), "").replace(String.valueOf(input[i+1]), "");
			
			if(temp.charAt(0) == outputChar[i-1]){
				outputChar[i]= temp.charAt(1);
				outputChar[i+1]= temp.charAt(0);
			} else {
				outputChar[i]= temp.charAt(0);
				outputChar[i+1]= temp.charAt(1);
			}

		}
		System.out.println(outputChar);
	}
	public static void main(String args[]) throws Exception {
		calColours();
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

