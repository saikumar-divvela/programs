package com.sss.problems;

/*
  Finding the max sum of subsequence in array
 */
public class MaxSequence {
	
	
	// improved version
	public static int maxNumber(int[] a){
		int max =a[0];
		int temp = max;
		
		for(int i=1;i<a.length;i++){
			if(a[i]>a[i]+temp){
				temp = a[i];
			} else {
				temp = a[i]+temp;
			}
			if(temp > max){
				max = temp;
			}
		}
		return max;
	}
	
	
	public static void main(String args[]){
		// inputs 1 2 , -1 -2, -2 -1, 1 -2
		int[] a = new int[]{21,-5, -6, 7, 12, -3, 0, -11, -6};
		//int[] a = new int[]{21,-5};
		System.out.println("Max number "+maxNumber(a));
	}
}


