package com.sss.algo;

/**
 * @author sadivvel
 *
 */
public class Sort {
	
	int[] data;
	int[] helper;
	int size =0;
	
	public Sort(){}
	
	public Sort(int[] array){
		data = array;
		size = array.length;
	}
	
	public void display (){
		//System.out.println("Array length:"+size);
		for(int i=0;i<size;i++){
			System.out.print(data[i]+", ");
		}
		System.out.println();
	}
	
	public void display (int numbers[]){
		if(numbers == null) return;
		for(int i=0;i<numbers.length;i++){
			System.out.print(numbers[i]+", ");
		}
		System.out.println();
	}
	
	/* Order of complexity n*n advantage simple, takes less memory
	 * 
	 * Performance best worst average 0(n*n)
	 */
	
	public void bubblesort(){
		for(int i=0;i<size;i++){
			for(int j=0;j<size-1;j++){
				if(data[j]>data[j+1]){
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
	}
	
	/*
	 *  Performance best , avarge, worst O(n*n)
	 */
	public void selectionsort(){
		for(int i=0;i<size-1;i++){
			display(); 
			int k = i;
			for(int j=i+1;j<size;j++){
				if(data[k] > data[j]){
					k = j;
				}
			}
			// swap i with small number index
			if(k!=i){
				int temp = data[k];
				data[k]= data[i];
				data[i] = temp;
			}
		}
		
	}
	
    /* 
       Advantage for the lists that are nearly sorted initially, also for data 
	   sets that are constantly being added to.
	   example: maintaining sorted highest scores in a game
	   worst average O(n*n) best 0(n)
	 */  
	// 9 7  6
	// 
	public void insertionsort(){
		for(int i=0;i<size;i++){
			int j =i;
			while(j>0 && data[i]<data[j-1]) // finds the smallest number in range
				j--;
			int temp = data[i];
			for(int k=i;k>j;k--){
				System.out.println("i="+i+" j="+j+" k="+k);
				data[k] = data[k-1];
			}
			data[j] = temp;
			display();
		}
		
	// i =1 j =1 0 temp = 6
			
	}

	public void radixsort(){
		
	}
	
	public void mergesort(){
		//data = mergeSort(data);
		helper = new int[data.length];
		mergeSort(0,data.length-1);
	}
	
	/**
	 *   Divide and conquer algorithm
	 *   Divide the array in two groups . sort both groups. 
	 *   compare first element of left group with that of right group
	 *   merge them both.
	 *   Each iteration takes O(n) time and there are O(log n) recusrions
	 *   so total time is O(nlong)
	 * 
	 */
	
	private void mergeSort(int low,int high){
		if(low<high){
			int middle = (low+high)/2;
			mergeSort(low,middle);
			mergeSort(middle+1,high);
			merge(low,middle,high);
		}
	}
	
	private void merge(int low,int middle,int high){
		for (int i = low; i <= high; i++) {
		      helper[i] = data[i];
		 }
	  
		int i=low;
		int j=middle+1;
		int k = low;
		while(i<=middle && j<=high){
			if(helper[i]<=helper[j]){
				data[k]=helper[i];
				i++;
			} else {
				data[k] = helper[j];
				j++;
			}
			k++;
		}
		
		while(i<=middle){
			data[k]=helper[i];
			i++;
			k++;
		}
	}
	/*
	 * The recursive algorithm works like the following: 
	 * move n-1 disk from the starting pole to the spare pole 
	 * move disk n from start pole to the target pole 
	 * move n-1 disk from the intermediate pole to the target pole. 
	 * The n-1 disks are moved recursively. 
	 */
	 
	public void TowersOfHanoi(int n,int startPole,int endPole){
			if (n== 0){
		      return; 
		    }
		    int intermediatePole = 6 - startPole - endPole;
		    TowersOfHanoi(n-1, startPole, intermediatePole);
		    System.out.println("Move " +n + " from " + startPole + " to " +endPole);
		    TowersOfHanoi(n-1, intermediatePole, endPole);
	}
	
	
	/*
	 * Divide and conquer algorithm
	 * Pick an pivot, reorder the list such that all the left elments are less than
	 * pivot and all the elemnts in right are > pivot
	 * Divide the data in two groups (may not equal) sort each group and merge
	 * follow this process recursively
	 * Important thing is identifying the right midpoint to divide into two groups
	 * Performance best case O(nlogn) worst case O(n*n) happens when each group
	 * has only one element in case of sorted output
	 */
	
	public void quicksort(){
		if(data ==null || data.length ==0){
			return;
		}
		quickSort(0,data.length-1);
	}
	
	/*
	 * 
	 */
	public void quickSort(int low,int high){
		int i=low,j = high;
		int pivot = data[low+(high-low)/2];
		while(i<=j){
			while(data[i]<pivot){
				i++;
			}
			while(data[j]>pivot){
				j--;
			}
			if(i<=j){
				int temp = data[i];
				data[i]=data[j];
				data[j] = temp;
				i++;
				j--;
			}
		}
		if(low<j){
			quickSort(low,j);
		}
		if(i<high){
			quickSort(i,high);
		}
		
	}
	//   12
		
	public static void main(String args[]){
		Sort sort = new Sort(new int[] {18,  6,  9,  1,  4, 15, 12,  5,  6,  7, 11});
		//Sort sort = new Sort(new int[]{9,2,5});
		System.out.println("Input");
		//sort.display();
		//sort.bubblesort();
		//sort.selectionsort();
		//sort.insertionsort();
		//sort.mergesort();
		//sort.quicksort();
		//System.out.println("Output");
		//sort.display();
		sort.TowersOfHanoi(3,1,3);
	}
}
