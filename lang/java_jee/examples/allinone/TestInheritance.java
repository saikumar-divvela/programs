class SuperClass
{
		static protected  int get(int i){
				return 0;
		}
}
public class TestInheritance extends SuperClass
{
		 public static  int  get(int  y){
			SuperClass.get(y);
			return 12;
		}

		public static void main(String... args){
				TestInheritance ti = (TestInheritance)new SuperClass();
				//ti.get(10);
		}
}
