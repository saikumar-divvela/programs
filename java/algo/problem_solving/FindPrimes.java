package com.sss.spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindPrimes {

		public static void GetPrimes() throws Exception{
			int testcases = Util.getInt();
			StringBuffer sb = new StringBuffer();
			long m,n;
			m = n =0;
			while(testcases-- > 0 ){
				String str[] = Util.readLine().split(" ");
				m = Long.parseLong(str[0]);
				n = Long.parseLong(str[1]);
				
				boolean primes[]; 
				primes = new boolean[(int)(n-m)+2];
				Arrays.fill(primes, true);
				primes[0] = false;

				if(m==1) {
					primes[1] = false;
					if(n>=2){
						primes[2] = true;
					}
				}
				
				if(m==2) {
					primes[1] = true;
				}
				
				for(long x = ((m<=2)?2:(m%2 ==0)?m/2:m/2+1); 2*x <=n; x++){
					primes[(int)(2*x-m+1)] = false;
				}
				
				
				
				for(long i = 3; i<=(long)(Math.sqrt(n)); i+=2){
					 long j = m/i;
					 
					 if(j%2==0) j = j+1;
					 if(i*j < m) j = (j%2==0)?j+1:j+2;
					 if(j==1) j=3;
//						 System.out.println(j);
						for(; i*j<=n; j+=2){
//							 System.out.println(i+ " "+j+" "+(i*j-m+1));
							 primes[(int)(i*j-m+1)] = false;

						}
				}
				
				for(int k =1;k<primes.length;k++){
					if(primes[k]){
						sb.append(m+k-1+"\n");
					}
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
		
		static boolean isPrime(long n){
			if( n==2) return true;
			if( n%2 ==0) return false;
			int sq = (int)Math.sqrt(n);
			for(long i= 3; i<= sq;i+=2){
				if(n%i==0) return false;
			}
			return true;
		}
		
		
		public static void main(String args[]) throws Exception {
			GetPrimes();
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

 

