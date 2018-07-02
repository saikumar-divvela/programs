public class TestConstructor
{
		TestConstructor(){
			this("save me");
			System.out.println("Test Constructor");
		}

		TestConstructor(String s){
			this();
			System.out.println("Test Constructor  value:"+s);
		}

		public static void main(String args[]){
				TestConstructor tc =  new TestConstructor();	
		}
}