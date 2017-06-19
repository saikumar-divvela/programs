
package com.sss.spoj;

public class LongestSubsequence {
// -2 -1  -3 4  1  4
	static int findMax(int max[],int n[],int index){
			if(index == max.length)
				return max[index-1];
			index ++;
		return findMax(max,n,index);
	}
	
	public static void main(String args[]) throws Exception{
		//int[] input = new int[]{3,2,-5,4,6,1,-6}; 
		//int[] input = new int[]{-3,-2,5,-4,-6,6}; 
		//int[] input = new int[]{-3,1,7,-4,-6,6};
		//int[] input = new int[]{-1,-13,-8,-9,-5,-2};
		int[] input = new int[]{3,-1,2,-5,-4,-6,-1,-6};
		int[] temp = new int[input.length];
		int[] output = new int[input.length];
		output[0]=temp[0] = input[0];
		int max = temp[0];  // -5 -2, -5 2, 5 2, 5 -2, 2 5,2 -5,-2 -5,-2,5
		for(int i=1;i<input.length;i++){
			
			if(input[i] < input[i-1]){
				if(input[i] + input[i-1] > input[i-1]){
					temp[i] = temp[i-1]+input[i];
					 max = temp[i];
				} else {
					temp[i] = input[i];
				}
			} else {
				if(input[i] + input[i-1] > input[i]){
					temp[i] = temp[i-1]+input[i];
					max = temp[i];
					
				} else {
					if(max < input[i]){
						max = input[i];
					}
					temp[i] = input[i];
				}
			}
			//output[i] = max;
		}
		
		for(int i=0;i<temp.length;i++){
			System.out.println("temp["+i+"]="+temp[i]);
		}
		
		System.out.println("max ="+max);
	}
}
