package com.sss.algo;

public class convertDT {
	
	public static void intToString(int i){
		StringBuffer sb = new StringBuffer();
		int q,r;
		while(i>=65536){
			q =  i/100;
			r = i - ((q<<6)+(q<<5)+(q<<2));
			sb.insert(0, (char)(r%10 + 48));
			sb.insert(0,(char)(r/10 + 48));
			i =q;
		}
		for(;;){
		  q = (i * 52429) >>> (16+3);
		  //q = i/10;
		  r = i - ((q<<3)+(q<<1));
		  sb.insert(0,(char)(r%10 + 48));
		  i=q;
		  if(i==0) break;
		}
		System.out.println("converted string:"+sb);
	}
	
	public static void main(String args[]) throws Exception{
		intToString(76);
	}
}

/*
23

75678

75678
75600

00 00001000
0000 0000
 11   1 
*/