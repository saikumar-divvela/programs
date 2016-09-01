package sss.temp;

/**
 * 
 * @author sadivvel
 * An inner class is associated with an instance of its enclosing class and can access that objects 
 * methods and fields.Objects that are instances of inner class exist within the instance of outer class.
*/
class OuterClass1{
	int var1;
public OuterClass1(int var){
	var1 = var;
}
public OuterClass1(){
	var1 = 0;
}
public void printDetails() {
	System.out.println("var1 :"+var1);
}
public class InnerClass {  // non static inner class
	int innerVar1;
	public InnerClass(int var) {
		innerVar1 = var;
	}
	public InnerClass() {
		innerVar1 = 0;
	}
	public void printDetails() {
		System.out.println("innervar1 :"+innerVar1);
		System.out.println("var1 :"+var1);
	}
}
}

public class InnerClassDemo{
public static void main(String[] args) {
	OuterClass1 outerObject = new OuterClass1(20);
	outerObject.printDetails();
	OuterClass1.InnerClass innerClassObject = outerObject.new InnerClass(40);
	innerClassObject.printDetails();
}
}

