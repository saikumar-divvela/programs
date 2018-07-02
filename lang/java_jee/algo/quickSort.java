/*
	Qucik sort is the one of the fastest sorting algorithm with average complexity O(nlogn)
	It uses divide and conquer with recusrive approach. worst case complexity is O(n*n)
	This algorithm is useful if input list size is > 20. For input size < 20 insertion sort is good.
	Algorithm:
		1) If the number of elements 0 or 1 in S return
		2) pick the pivot element which is median of (left,center,right)
		   left < center < right //   center -> pivot
		    swap center < right-1 // hide the pivot
		   pivot element = right-1
		3) partition the array into 2 parts such that x --> S-U where x < pivot and x--> S-V where x > v
			i = left; j = right -1
			loop 
				move i to right such that i < pivotelement
				move j to left such that j > pivotelement
				if  i<j swap S[i],S[j]
				else 
				break
			end loop
			swap S[pivotelement],S[i]
		4) continue the above process
			Q(S,left,i-1)
			Q(S,i+1,right)
*/		
public class quickSort {
	int a[];
	
	public void displayArray(String msg,int a[]){
		System.out.print(msg);
		for (int x:a ) System.out.print(x+" ");
		System.out.println();
	}
	public quickSort(){
	}
	public quickSort(int size){
		a = new int [ size];
	}
	public quickSort(int[] b ){
		a = b;
	}
	public void sort(){
		displayArray("input:",a);
		QuickSort(0,a.length-1);
		displayArray("output:",a);
	}
	private void QuickSort(int left,int right){
		int i,j,pivot;
		// step1
		if( (right-left) <= 0) return;
		// step2
		medianPivot(left,right);
		if(right - left ==1) return;
		pivot = a[right-1];
		// step3
		i = left ;
		j = right -1;
		for(;;){
			while(a[++i] < pivot);
			while(a[--j] > pivot);
			if(i<j) swap (i,j);
			else break;
		}
		swap(right-1,i);
		// step4
		QuickSort(left,i-1);
		QuickSort(i+1,right);
	}
	private void swap(int index1,int index2){
		int temp;
		temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
	private void medianPivot(int left,int right){
		int temp; // 2 1 3
		int center = (left+right)/2;
		if(a[left] > a[center]) swap(left,center);  
		if(a[left] > a[right]) swap(left,right); 
		if(a[center] > a[right]) swap(center,right); 
		swap(center,right-1);
	}
	public static void main(String args[]) throws Exception{
		int a [] ={-3,-12,-25,-8,1,3,9,6,45,17,12,6,6,6,11,0};
		quickSort sortObj = new quickSort(a);
		sortObj.sort();
	}
}