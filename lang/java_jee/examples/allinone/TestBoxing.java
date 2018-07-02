public class TestBoxing
{
		//public static void go(Object n) {System.out.println("OBJECT:"+n); }
		public static void go(Short n) {System.out.println("SHORT:"+n);}
		public static void go(Long n) {System.out.println(" LONG:"+n); }
		public static void go(Integer n) {System.out.println("INTEGER:"+n); }
		//public static void go(Double  n) {System.out.println("DOUBLE:"+n); }
		public static void go(Float  n) {System.out.println("FLOAT:"+n); }

		//public static void go(short n) {System.out.println("short:"+n);}
		//public static void go(long n) {System.out.println(" long:"+n); }
		//public static void go(int n) {System.out.println("int:"+n); }
		//public static void go(double  n) {System.out.println("double:"+n); }
		public static void go(float  n) {System.out.println("float:"+n); }

		public static void main(String [] args) {
			//int i=10;
			//long l = 15;
			//Integer I = new Integer(15);
			//float f = 10.2f;
			double d = 10.2;
			//go(l);
			//go(i);
			//go(I);
			//go((double)f);
			go(d);
		}
 }
