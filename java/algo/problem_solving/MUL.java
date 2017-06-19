package com.sss.spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class MUL {

	static void cal() throws Exception {
		int N = Util.getInt();
		String strArray[] = new String[2];
		if(N > 1000) return;
		StringBuffer output = new StringBuffer();
		while( N-- >0) {
			strArray =Util.readLine().split(" ");
			if(strArray[0].length() > 10000 || strArray[1].length() > 10000) return;
			
			LinkedList<Integer> list1 = convertToList(strArray[0]);
			LinkedList<Integer> list2 = convertToList(strArray[1]);
			//System.out.println(list1);
			//System.out.println(list2);
			if(list1.size()==1 && list1.getFirst()==1){
				output.append(getString(list2));
			} else if (list2.size()==1 && list2.getFirst()==1){
				output.append(getString(list1));
			} else {
				output.append(getString(calMUL(list1,list2)));
			}
		}
		System.out.println(output);
	}
	
	static void listCopy(LinkedList<Integer> X,LinkedList<Integer> sum){
		for(Integer i: X){sum.add(i);}
	}
	
	static String getString(LinkedList<Integer> list){
		StringBuffer sb = new StringBuffer();
		if(list == null || list.isEmpty()) {
			return "";
		}
		for(Integer i: list){
			sb.append(i);
		}
		sb.append("\n");
		return sb.toString();
	}
	
	static LinkedList<Integer> convertToList(String str) throws Exception{
		LinkedList<Integer> list = new LinkedList<Integer>();
		if(str == null || str.length() <=0) return list;
		for(int i=0;i<str.length();i++){
			list.addLast((int)str.charAt(i)-48);
		}
		return list;
	}
	
	static LinkedList<Integer> calMUL(LinkedList<Integer> X1,LinkedList<Integer> X2){
		LinkedList<Integer> sum = new LinkedList<Integer>();
		listCopy(X2,sum);
		int carry=0;
		int value=0;
		while(!X1.isEmpty()){
			int s1=X2.size();
			int s2=sum.size();
			carry=0;
			for(int j=s1-1,k=s2-1;j>=0 ;j--,k--){
				value=X2.get(j)+sum.get(k)+carry;
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
			// reduce 1
			int n1 = X1.getLast();
			// 100
			if(n1==0){  //700  n1 0 709 n1=7 799
				int size = X1.size();
				while(n1 ==0){
					n1 = X1.get(size-2);
					X1.remove(size-1);
					X1.addLast(9);
					size = size-1;
				}
				X1.set(size-1, n1-1);
			} else {
				X1.removeLast();
				X1.addLast(n1-1);
			}
			if(X1.get(0)==0){
				X1.removeFirst();
			}
			if(X1.size() == 1 && X1.get(0)==1){
				X1.remove();
			}
			
		}
		return sum;
	}
		
	public static void main(String args[]) throws Exception{
		cal();
	}

	
	static class Util {
		
		public static InputStreamReader istream = new InputStreamReader(System.in) ;
		public static BufferedReader bufRead = new BufferedReader(istream) ;
		
		public static int getInt() throws Exception{
			String str;
			while(((str=bufRead.readLine()).trim()).equals(""));
			return Integer.parseInt(str);
		}

		public static double getDouble() throws Exception{
			String str;
			while(((str=bufRead.readLine()).trim()).equals(""));
			return Double.parseDouble(str);
		}
		
		public static String readLine() throws Exception{
			String str = null;
			while(((str=bufRead.readLine()).trim()).equals(""));
			return str;
		}
	}
}
