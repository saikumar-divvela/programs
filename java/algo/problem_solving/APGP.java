package com.sss.spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class APGP {
	static void cal() throws Exception{
		String str=null ;
		long a,b,c;
		while (!(str=Util.readLine()).equals("0 0 0")){
			//System.out.println(str);
			String[] inputs = str.trim().split(" ");
			a = Long.parseLong(inputs[0]);
			b = Long.parseLong(inputs[1]);
			c = Long.parseLong(inputs[2]);
			if((b-a)==(c-b)){
				System.out.println("AP "+((c-b)+c));
			} else {
				System.out.println("GP "+((c/b)*c));
			}
		}
				
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
