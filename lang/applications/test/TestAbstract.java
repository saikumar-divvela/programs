abstract class Abstract
{
	//abstract void print();
	protected void  show(){
		System.out.println("123");
	}
}

public class TestAbstract extends Abstract
{
	/*
	public  void show(){
		System.out.println("456");
		super.show();
	}*/
	public static void main(String args[])	{
		TestAbstract ta = new TestAbstract();
		ta.show();
		System.out.println("hahahah");
	}
}