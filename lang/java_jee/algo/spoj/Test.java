package com.sss.spoj;    
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
   
    public class Test{
    
    static void test() throws Exception{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	BufferedOutputStream bos =new BufferedOutputStream(System.out);
    	String eol=System.getProperty("line.separator");
    	byte[] eolb=eol.getBytes();
    	
    	int t=Integer.parseInt(br.readLine());
    	while(t-->0)
    	{
    		int n=Integer.parseInt(br.readLine());
    		bos.write((new Long(CalSumOfDivisors(n))).toString().getBytes());
    		bos.write(eolb);
    	}
    	bos.flush();
    }
    
    
    public static int CalSumOfDivisors(int n){
    	int ans=0;
		int sq=new Long(Math.round(Math.sqrt(n))).intValue();
		for(int i=1;i<=sq;i++)
		{
			if(n%i==0)
			{
				if(i!=(n/i))
				{
					ans+=(i+(n/i));
				}
				else
				{
					ans+=i;
				}
			}
		}
		ans-=n;
		return ans;
    }
    
    /*
    public static int CalSumOfDivisors(int num){
    	int value = new Long(Math.round(Math.sqrt(num))).intValue();
    	int sum =1;
    	for(int i=2;i<=value;i++){
    		if(num % i == 0){
    			 if(i==num/i)
    			 {	 
    				 sum=sum+i;
    			 }
    			 else {
    				sum = sum+ i+ num/i;
    			 }
    		}
    	}
    	return sum;
    }*/
    
    public static void main(String args[]) throws Exception {
    		test();
    } 

   }
    
 