package com.sss.spoj;
import java.io.*;
import java.util.*;
public class Factorial {
	static void cF() throws Exception{
		int t = Util.getInt();
		int[] input=new int[t];
		int[] sI=new int[t];
		Object[][] output=new Object[t][2];
		for(int i=0;i<t;i++){
			input[i]=sI[i]=Util.getInt();
		}
		Arrays.sort(sI);
		for(int j =0;j<t;j++){
			List<Integer> result=new LinkedList<Integer>();
			output[j][0]=(Integer)sI[j];
			int i=1;
			if(j>0){
				i=(Integer)output[j-1][0]+1;
				lc((List<Integer>)(output[j-1][1]),result);
			} else {
				i=2;
				result.add(new Integer(1));
			}
			for(;i<=sI[j];i++) {
				result =cal(i,result);
			}	
			output[j][1]= result;
		}
		for(int j=0;j<t;j++){
			for(int k=0;k<t;k++){
				if (input[j]== (Integer)output[k][0]){
					for(Integer X: (LinkedList<Integer>)output[k][1]){
						System.out.print(X);
					}
					System.out.println();
					break;
				}
			}
		}
		
	}
	static void lc(List<Integer> X,List<Integer> sum){
		for(Integer i: X){sum.add(i);}
	}
	static List<Integer> cal(int N,List<Integer> X){
		List<Integer> sum = new LinkedList<Integer>();
		lc(X,sum);
		int carry=0;
		int value=0;
		for(int i=1;i<N;i++){
			int s1=X.size();
			int s2=sum.size();
			carry=0;
			for(int j=s1-1,k=s2-1;j>=0;j--,k--){
				value=X.get(j)+sum.get(k)+carry;
				carry=value/10;
				sum.set(k, value%10);
			}
			for(int k=s2-s1-1;k>=0;k--){
				value = sum.get(k)+carry;
				carry = value/10;
				if(value ==10)
				{sum.set(k, value%10);}
				if(value/10==0){sum.set(k,value%10);break;}
			}
			if(carry>0){sum.add(0,carry);}
		}
		return sum;
	}
	public static void main(String args[])throws Exception{cF();}
	static class Util {
		public static BufferedReader bR=new BufferedReader(new InputStreamReader(System.in)) ;
		public static int getInt() throws Exception{
			String s;
			while(((s=bR.readLine()).trim()).equals(""));
			return Integer.parseInt(s);
		}
	}
}

