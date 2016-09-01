package com.sss.algo;

/*
 *  Given a excel sheet coulmn code find the column number
 *  if column number is given find the excel sheet code
 */
public class Excel {

	public static void main(String args[]){
		
		String code ="BC";
		int num = 0;
		int temp = 0;
		for(int i=0;i<code.length();i++){
			temp = code.charAt(i)-64;
			num =  num*26+temp;
		}
		System.out.println("excel sheet input column code:"+code);
		System.out.println("excel sheet column number:"+num);
		StringBuffer outcode = new StringBuffer();
		temp =0;
		while(num > 0){ 
			if(num%26==0){
				temp = 90;
				num = (num/26)-1;
			} else{
				temp = num%26 + 64;
				num = num/26;
			}
			outcode.insert(0, (char)temp);
		}
		
		System.out.println("excel sheet column code:"+outcode);
	}
}
