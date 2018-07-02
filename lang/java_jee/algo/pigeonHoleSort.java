/*
	PIGEONHOLE sorting is a very old unconventional algorithm for sorting of numbers. Its complexity is O(n+N)
	where n is input size and N is the number of pigeon holes. It complexity grows linearly. If the input numbers
	are not denser then algorithm efficiency decreases. BUCKET sort is improved version of this algorithm.
	Algortithm:
		1) Find the range of inputs
		2) Place the input numbers in appropriate holes
		3) Move back the non-empty holes to array
*/
public class pigeonHoleSort
{
	int a[];
	public pigeonHoleSort(int size){
		a = new int[size];
	}
	public pigeonHoleSort(int b[]){
		a = b;
	}
	public void displayArray(String msg,int a[]){
		System.out.print(msg);
		for (int x:a ) System.out.print(x+" ");
		System.out.println();
	}
	public void sort(){
		int min,max,range;
		// display input
		displayArray("input:",a);
		// step1 
		min = max = a[0];
		for(int x:a){
			if(x<min) min =x;
			if(x>max) max =x;
		}
		range = max-min+1;
		int[] holes = new int[range];
		// step 2
		for(int x:a) holes[x-min] = 99;
		// step3
		int i=0;
		for(int count=0; count<range; count++) {
			if(holes[count]==99) a[i++] = count + min;
		}		
		// display result
		displayArray("output:",a);
	}
	public static void main(String args[]) throws Exception{
		int a[] = {25,6,1,45,12,38};
		pigeonHoleSort sortTask = new pigeonHoleSort(a);
		sortTask.sort();
	}
}
