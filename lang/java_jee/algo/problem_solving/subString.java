package com.sss.spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class subString {
	
	static void findLongestSubString() throws Exception {
		String str1 = Util.readLine();
		String str2 = Util.readLine();
		if(str1.length() > 250000 || str2.length()> 250000) return;
		//System.out.println(str1);
		//System.out.println(str2);
		int longStrLength =0;
		int iterations =0;
		for(int i=0;i<str1.length();i++){
			for(int j=0;j<str2.length();j++){
				iterations++;
				if(str1.charAt(i)== str2.charAt(j)){
					int x=i+1;
					int y=j+1;
					int count=1;
					while( x < str1.length() && y < str2.length() && (str1.charAt(x)==str2.charAt(y))){
						//System.out.println(x+" "+y+" "+str1.charAt(x)+" "+count);
						x++;
						y++;
						count++;
					}
					if(count > longStrLength) 	longStrLength = count;
					//break;
				}
			}
		}
		System.out.println(longStrLength);
		System.out.println("Num of iterations:"+iterations);
	}
	
	public static void main(String args[]) throws Exception{
		findLongestSubString();
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
