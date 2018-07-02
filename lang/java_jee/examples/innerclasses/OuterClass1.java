// inner class examples
interface displayInterface
{
	public void showInfo();
}

class displayClass
{
	int x=10;
	public void showInfo(){
		System.out.println("display class value:"+x);
	}
}

public class OuterClass1
{
	int value;
	static int staticValue;
	// anonymous class extending class
	displayClass dc = new displayClass(){
		int y =20;
		public void showInfo(){
		System.out.println("extended display class value:"+this.y);
		}	
	};
	
	// anonymous class implementing interface
	displayInterface di = new displayInterface(){
		int x=30;
		public void showInfo(){
			System.out.println("implemented interface display interface value:"+this.x);
		}	
	};

	public OuterClass1(){
	}

	public OuterClass1(int value){
		this.value= value;
		dc.showInfo();
		di.showInfo();
	}
	
	// anonymous inner class as method argument
	
	public void doStuffForInterface(displayInterface di){
		di.showInfo();
	}

	public void doStuffForClass(displayClass dc){
		dc.showInfo();
	}

	public void doInterfaceStuff( ){
		doStuffForInterface(new displayInterface(){ // anonymous class as method argument
					int x=40;
					public void showInfo(){
						System.out.println("implemented interface and instantiated in method argument display interface value:"+this.x);
					}
				});	
	}


	public void doClassStuff(){
		doStuffForClass(new displayClass(){ // anonymous class as method argument
			int y =50;
			public void showInfo(){
				System.out.println("extended display and instantiated in method argument class value:"+this.y);
			}
		});	
	}

	public void showValues(){
		final int value1=60;
		// method local inner class
		final class MethodInnerClass
		{
			private int  value;
			public MethodInnerClass(int value){
				System.out.println("MethodInnerClass constructor");	
				this.value = value;
			}
			private void showValues(){
				System.out.println("MethodInnerClass Value:"+this.value);	
				System.out.println("MethodInnerClass Method local variable :"+value1);	
				System.out.println("OuterClass Value:"+OuterClass1.this.value);	
			}
		}
		MethodInnerClass mic = new MethodInnerClass(100);
		mic.showValues();
		InnerClass ic= new InnerClass(10);
		ic.showValues();
	}

	// regular inner class
	final class InnerClass
	{
		int value;
		
		public InnerClass(){

		}
		public InnerClass(int value){
			this.value = value;
		}
		private void showValues(){
			System.out.println("inner class value:"+this.value);
			System.out.println("outer class value:"+OuterClass1.this.value);
		}
	}
	
	// static inner class example
	static class StaticInnerClass
	{
		int value;
		public StaticInnerClass(){

		}
		
		public StaticInnerClass(int x){
			this.value = x;
		}

		public void showValues(){
			System.out.println("static inner class value:"+this.value);
			System.out.println("outer class value:"+OuterClass1.staticValue);
		}
	}

	public static void diplayValues(){
		StaticInnerClass sic = new StaticInnerClass(35);
		sic.showValues();
	}
	
	public static void main(String args[]){

		OuterClass1 oc = new OuterClass1(70);
		OuterClass1.InnerClass ic1 = oc.new InnerClass(80); // instantiation of regualar inner class
		oc.doInterfaceStuff();
		oc.doClassStuff();
		ic1.showValues();
		OuterClass1.InnerClass ic2 = new OuterClass1(90).new InnerClass(100); // instantiation of regular inner class
		ic2.showValues();
		oc.showValues();
		OuterClass1.StaticInnerClass sic = new OuterClass1.StaticInnerClass(125); // instantiation of static inner class
		sic.showValues();
		OuterClass1.diplayValues();
	}
}