package com.sss.algo;

public class recursion {
	// hello how are you
	
	public static void reverseString(char[] str){
		int i=0;
		int startIndex =0,endIndex=0;
		for(;i<str.length;) {
			startIndex = i;
			while(i < str.length && str[i] !=' '){
				i++;
			}
			endIndex = i-1;
			i++;
			while(i < str.length && str[i] ==' '){
				i++;
			}
			for(int j= startIndex,k=endIndex;j<(endIndex+startIndex)/2;j++,k--){
				char temp = str[j];
				str[j]= str[k];
				str[k]=temp;
			}
		}
		System.out.println("Reversed string:"+new String(str));
	}	
	
	
	public static void main(String args[]){
		reverseString("hello  how   are you".toCharArray());
	}
}
