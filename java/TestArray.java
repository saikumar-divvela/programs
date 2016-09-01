package sss.temp;

public class TestArray {
	int n[];
	
	public TestArray(int x[]){
		n = new int[x.length];
		n = x;
		n[1]=20;
	}
	
	public void print(){
		for(int x: n){
			System.out.println(x);
		}
	}
	public static void main(String args[]){
		int x[] = new int[]{1,2,3};
		TestArray t = new TestArray(x);
		t.print();
		
		for(int i: x){
			System.out.println(i);
		}
	}
}
