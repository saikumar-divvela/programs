package com.sss.spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

		/*
	    public static void SumOfDivisors() throws Exception{
			int testcases = Util.getInt();
			StringBuffer sb = new StringBuffer();
			while(testcases -- > 0 ){
				int value = Util.getInt();
				sb.append(CalSumOfDivisors(value)+"\n");
			}
			System.out.println(sb);
	    }
	    
	    public static int CalSumOfDivisors(int num){
	    	int sq = (int)Math.sqrt(num);
	    	int sum =0;
	    	for(int i=1;i<=sq;i++){
	    		if(num % i ==0){
	    			if(i==num/i)
	    			{
	    				sum +=  i;
	    			} else {
	    				sum +=  i+ num/i;
	    			}
	    		}
	    	}
	    	return sum-num;
	    }
		*/
		public static void GetPrimes() throws Exception{
			int testcases = Util.getInt();
			StringBuffer sb = new StringBuffer();
			int m,n;
			m = n =0;
			while(testcases -- > 0 ){
				String str[] = Util.readLine().split(" ");
				m = Integer.parseInt(str[0]);
				n = Integer.parseInt(str[1]);
				if(m ==1) m=2;
				for(int i = m; i <=n;i++){
					int sq = (int)Math.sqrt(i);
					boolean isprime = true;
					for(int j =2; j<=sq; j++) {
						if(i%j==0){
							isprime = false;
							break;
						}
					}
					if(isprime){
						sb.append(i+"\n");
					}
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
		public static void main(String args[]) throws Exception {
			GetPrimes();
		}
}

class Util {
	
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



