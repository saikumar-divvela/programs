package com.sss.spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Basic {
	
	public static void main(String args[]) throws Exception {
		int x;
		while((x=Util.getInt())!=42){
			System.out.println(x);
		}
	}
	static class Util {
		public static BufferedReader bR=new BufferedReader(new InputStreamReader(System.in)) ;
		public static int getInt() throws Exception{
			String s;
			while(((s=bR.readLine()).trim()).equals(""));
			return Integer.parseInt(s);
		}
	}
}
