package sss.temp;

/**
 * 
 * @author sadivvel
 * A static nested class can't access directly methods defined in the enclosing class. 
 * A static nested class interacts with the instance members of its outer class just
 * like any other top level class.
 */
class OuterClass{
	int var1;
	static int var2 = 100;
	public OuterClass(int var){
		var1 = var;
	}
	public OuterClass(){
		var1 = 0;
	}
	public void printDetails() {
		System.out.println("var1 :"+var1);
	}
	public static class StaticNestedClass {
		int innerVar1;
		public StaticNestedClass(int var) {
			innerVar1 = var;
		}
		public StaticNestedClass() {
			innerVar1 = var2;
		}

		public void printDetails() {
			System.out.println("innervar1 :"+innerVar1);
		}
	}
}

public class StaticInnerClassDemo{
	public static void main(String[] args) {
		OuterClass outerObject = new OuterClass(20);
		outerObject.printDetails();
		OuterClass.StaticNestedClass  staticObject =new  OuterClass.StaticNestedClass();
		staticObject.printDetails();
	}
}
