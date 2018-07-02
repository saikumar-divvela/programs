
class Outer {
	public static class Inner { public static void foo() { } }
}

public class MyOuter
{
	public static void main(String args[]){
		Outer.Inner m = new Outer.Inner();
	}
}