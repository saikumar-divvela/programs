package com.sss.spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Moves {

	static void cal() throws Exception{
		int x;
		while( (x = Util.getInt()) != -1){
			int inputs[] = new int[x];
			int i=0;
			int sum = 0;
			int j=x;
			while( j-- > 0){
				inputs[i] = Util.getInt();
				sum = sum+ inputs[i];
				i++;
			}
			if( sum % x ==0){
				int num = sum/x ;
				int moves=0;
				for(int k=0;k<x;k++){
					if(inputs[k]<num){
						moves = moves+ num-inputs[k];
					}
				}
				System.out.println(moves);
			} else {
				System.out.println("-1");
			}
		}
			
		
	}
	
	public static void main(String args[]) throws Exception{
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
