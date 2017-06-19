package com.sss.algo;

public class toh {

	public static void printMoves(int n,int src,int dest,int spare){
		if(n==0) return;
		printMoves(n-1,src,spare,dest);
		System.out.println("Moved "+n +" from "+src+ " to "+dest);
		printMoves(n-1,spare,dest,src);
		
	}
	
	public static void main(String args[]) throws Exception{
		printMoves(4,1,2,3);
	}
	
}
