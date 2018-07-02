public class TestStaticClass
{
			static class  A {
					void process() throws Exception 
					{ 
						throw new Exception(); 
					}
			}
			static class B extends A {
					void process() 
					{
						System.out.println("B" );
					}
					
			}
			public static void main(String[] args) {
					A a=new B();
					a.process();
			}
}