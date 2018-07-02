public class  ch1Class1 extends ch1Class2
{
	
	ch1Class1(){
		super(123);
		System.out.println("ch1Class1 constructor");
	}
	void print(){}

	public static void main(String args[]){
		//ch1Class1 c1 = new ch1Class1();
		ch1Class2 c2 = new ch1Class1();
		//c2.printSomething();		
	}

}

abstract class ch1Class2
{
	int x;
	ch1Class2(){
		System.out.println("ch1Class2 constructor");
	}
	ch1Class2(int x){
		System.out.println("ch1Class2 constructor "+x);
	}
	abstract void print();
}