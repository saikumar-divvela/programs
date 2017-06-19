package com.sss.spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ADDREV {
	static void cal() throws Exception {
		int N = Util.getInt();
		String[] strArray = new String[2];
		StringBuffer output = new StringBuffer();
		while(N-- > 0){
			strArray = Util.readLine().trim().split(" ");
			Integer n1 = Integer.parseInt(new StringBuilder(strArray[0]).reverse().toString());
			Integer n2 = Integer.parseInt(new StringBuilder(strArray[1]).reverse().toString());
			Integer x = n1+n2;
			/*
			System.out.println(n1);
			System.out.println(n2);
			System.out.println(x);
			*/
			
			output.append(Integer.parseInt(new StringBuilder(Integer.toString(x)).reverse().toString())+"\n");
		}
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
