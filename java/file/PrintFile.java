package com.sss.file;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class PrintFile {
	
	public static void copyFile1() throws FileNotFoundException, IOException{
		FileInputStream reader = new FileInputStream("/Users/sadivvel/sss/programs/algorithms/src/com/sss/file/PrintFile.java");
		//FileReader reader = new FileReader("/Users/sadivvel/sss/programs/algorithms/src/com/sss/file/PrintFile.java");
		
		//FileOutputStream writer = new FileOutputStream("/Users/sadivvel/sss/programs/algorithms/src/com/sss/file/PrintFile11.java");
		BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream("/Users/sadivvel/sss/programs/algorithms/src/com/sss/file/PrintFile11.java"));	
		//FileWriter writer = new FileWriter("/Users/sadivvel/sss/programs/algorithms/src/com/sss/file/PrintFile11.java");
		//BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/sadivvel/sss/programs/algorithms/src/com/sss/file/PrintFile11.java"));
		
		int c;
		while((c=reader.read())!=-1){
			writer.write(c);
		}
		
		reader.close();
		writer.close();
	}
	
	public static void copyFile2() throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferedReader(new FileReader("/Users/sadivvel/sss/programs/algorithms/src/com/sss/file/PrintFile.java"));
		FileWriter writer = new FileWriter("/Users/sadivvel/sss/programs/algorithms/src/com/sss/file/PrintFile11.java");
		//BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/sadivvel/sss/programs/algorithms/src/com/sss/file/PrintFile11.java"));
		
		String str;
		while((str=reader.readLine())!=null){
			writer.write(str+"\n");
		}
		
		reader.close();
		writer.close();
	}
	
	public static void printFile1() throws FileNotFoundException, IOException,InterruptedException{
		FileReader reader = new FileReader("/Users/sadivvel/sss/programs/algorithms/src/com/sss/file/PrintFile.java");
		//BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		//OutputStream out = System.out;
		BufferedOutputStream out = new BufferedOutputStream(System.out);
		 
		int c;
		
		while((c=reader.read())!=-1){
			//System.out.print(c);
			out.write(c);
			out.flush();
		}
		
		reader.close();
		out.close();
	}
	
	public static void printFile2() throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferedReader (new FileReader("/Users/sadivvel/sss/programs/algorithms/src/com/sss/file/PrintFile.java"));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		while( (str = reader.readLine())!= null) {
			//System.out.print(c);
			out.write(str+"\n");
			out.flush();
		}
		reader.close();
		out.close();
	}
	
	public static void printFile3() throws FileNotFoundException, IOException{
		FileInputStream istream = new FileInputStream("/Users/sadivvel/sss/programs/algorithms/src/com/sss/file/PrintFile.java");
		OutputStream out = System.out;
		//BufferedOutputStream out = new BufferedOutputStream(System.out);
		//BufferedWriter out = new BufferedWriter( new OutputStreamWriter(System.out)); 
		
		int  c;
		while( (c= istream.read())  !=-1) {
			//System.out.print(c);
			out.write(c);
			out.flush();
		}
		istream.close();
		out.close();
	}
	
	public static void main(String[] args) throws Exception{
		
		//printFile1();
		//printFile2();
		//printFile3();
		//copyFile1();
		copyFile2();
	}
}
