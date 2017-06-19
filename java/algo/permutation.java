package com.sss.algo;
import java.util.LinkedList;


public class permutation {
	
	public static void displaychars(char[] c){
		for(int i=0;i<c.length;i++){
			System.out.print(c[i]);
		}
		System.out.println();
	}
	
	public static void dopermute(String str){
		int length = str.length();
		char[] in = str.toCharArray();
		boolean[] used = new boolean[length];
		StringBuffer out = new StringBuffer();
		dopermutations(in,out,used,length,0);
	}
	
	
	public static void dopermutations(char[] in,StringBuffer out,boolean[] used,int length,int level){
		if(level == length ){
			System.out.println(out.toString());
			return ;
		}
		for(int i=0;i<length;i++){
			if(used[i]) continue;
			used[i]= true;
			out.append(in[i]);
			dopermutations(in,out,used,length,level+1);
			used[i]=false;
			out.setLength(out.length()-1);
		}
	}
	
	
	static void combine( String str ){
		int length = str.length();
		char[] instr = str.toCharArray();
		StringBuilder outstr = new StringBuilder();
		doCombine( instr, outstr, length, 0 );
	}
	
	static void doCombine( char[] instr, StringBuilder outstr, int length,
			 int start ){
			for( int i = start; i < length; i++ ){
			outstr.append( instr[i] );
			System.out.println(outstr);
			if( i < length - 1 ){
			doCombine( instr, outstr, length, i + 1 );
			}
			outstr.setLength(outstr.length()-1);
			}
	}
	
	public static void docombinations(String in){
		LinkedList<String> list = new LinkedList<String>(); 
		for(int i=0;i<in.length();i++){
			int size = list.size();
			for(int j=0;j<size;j++) {
				String temp =in.charAt(i)+list.get(j); 
				list.add(temp);
			}
			list.add(Character.toString(in.charAt(i)));
		}
		
	   for(int i=0;i<list.size();i++){
		  System.out.println(list.get(i));
	  }
	}
	
	public static void main(String args[]){
		String str = "wxyz";
		System.out.println("Input String:"+str);
	     combine(str);
		//docombinations(str);
	}
}
