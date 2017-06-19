package com.sss.algo;

public class searchString {

	public static void main(String args[]) throws Exception {
		 String srcStr = "the world is beautiful";
		 String tgtStr = "ld is  ";
		 
		 int srcLength = srcStr.length();
		 int tgtLength = tgtStr.length();
		 
		 if(srcLength < tgtLength){
			 System.out.println ("-1");
			 return ;
		 }
		 char firstChar = tgtStr.charAt(0);
		 for(int i=0;i<=srcLength-tgtLength;i++){
			 if(srcStr.charAt(i)==firstChar){
				 int j =1;
				 int k =i+1;
				for(;k<srcLength&&j<tgtLength && srcStr.charAt(k)==tgtStr.charAt(j);j++,k++){
					
				}
				if(j==tgtLength){
					System.out.println(tgtStr +" found and index is "+i);
					return;
				}
			 }
		 }
		 System.out.println(tgtStr +" not found");
	}
}
