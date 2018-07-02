package com.sss.algo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class gray {
	
	public static void main(String args[]) throws Exception {
		InputStreamReader ins = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ins);
		Scanner scan = new Scanner(System.in); 
		
		System.out.println("Enter String:");
		String line;
		/*
		while( (line = br.readLine())!=null && line.length()!=0){
			System.out.println("line:"+line);
		}*/
		/*
		while( (line = scan.nextLine())!=null && line.length()!=0){
			System.out.println("line:"+line);
		}*/
		
		line = scan.nextLine();
		char[] c = new char[line.length()];
		for(int i=0;i< line.length();i++){
			c[i] = line.charAt(i);
			}
		System.out.println("Output :"+new String(c));
	}
	
}
