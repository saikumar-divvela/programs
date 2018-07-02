
public class TestInterfaces
{
		interface A { 
			public void aMethod(); 
		}
		interface B {
			public void bMethod(); 
		}
		interface C extends A,B 
		{ 
			public void cMethod(); 
		}
		class D implements B 
		{
			public void bMethod() {System.out.println("bMethod in D" ) ;}
		}
		class E extends D implements C 
		{
				public void aMethod() { }
				public void bMethod() { System.out.println("bMethod in E" ) ;}
				public void cMethod() { }
		}
			
		void testClasses(){
				D e = (D)(new E());
				e.bMethod();
		}
		
		public static void main(String args[])
		{
				(new TestInterfaces()).testClasses();			

		}
}