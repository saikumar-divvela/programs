package com.sss.spoj;
import java.util.Scanner;


public class Main1 {
	
	public static int calPoly(String values[][]){
		int count =0;
		//System.out.println(values.length);
		for(int i=0;i<values.length;i++){
			int value = Integer.parseInt(values[i][1]);
			count = count + value * (value+1)/2;
		}
		//System.out.println("count "+count);
		return count;
	}
	
	public static int calPoly(String in){
		int numpoly =0;
		for (int i=0; i < in.length(); i++){
			for(int j=i+1; j<= in.length();j++){
				if(checkPoly(in.substring(i, j))){
					numpoly++;
				}
			}
		}
		return numpoly;
	}
	
	public static boolean checkPoly(String str){
		StringBuffer sb = new StringBuffer(str);
        String rev = sb.reverse().toString();
         
        if (!str.equals(rev))
        {
            return false;
        }
         
        return true;	
	}
	
	public static void main(String args[]){
		System.out.println("Enter input");
		Scanner scan = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int t = scan.nextInt();
		while(t-- > 0) {
			int lines = scan.nextInt();
			String list[][] = new String[lines][2] ;
			int i=0;
			String str = scan.nextLine();
			StringBuffer strin = new StringBuffer();
			while(lines-- >0){
				str = scan.nextLine();
				list[i++] = str.split(" ");
				//sb.append(list[i-1][0]+" "+list[i-1][1]);
				int value = Integer.parseInt(list[i-1][1]);
				for(int j = 0; j < value ; j++) {
					strin.append(list[i-1][0]);
				}
			}
			//System.out.println(strin);
			sb.append("\n"+calPoly(strin.toString()));
//			sb.append("\n"+calPoly(list));
		}
		System.out.println(sb);
	}
}
