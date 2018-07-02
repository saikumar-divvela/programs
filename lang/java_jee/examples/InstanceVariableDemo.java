package sss.temp;

class InstanceVariableDemo {
	private int dummy1,dummy2;
	private int junk;
	{
		dummy2 = 100;
	}
	InstanceVariableDemo(int bigjunk) {
		System.out.println("Inside constructor");
		System.out.println("Dummy1 :"+dummy1);
		System.out.println("Dummy2 :"+dummy2);
		this.junk = bigjunk;
	}
	private void printData() {
		System.out.println("Dummy1 :"+dummy1);
		System.out.println("Dummy2 :"+dummy2);
		System.out.println("Junk :"+junk);
	}
	{
		dummy1 = 20;
	}
	public static void main(String[] args){
	InstanceVariableDemo InstanceDemo = new InstanceVariableDemo(500);
		InstanceDemo.printData();
	}
}
