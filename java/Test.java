package sss.temp;

public class Test {
	
	static int test (){
		try {
			
			return 3;
		} catch(Exception e){
		}	
		finally {
		 return 1;
		}
	}
	public static void main (String args[]) throws Exception {
		String a = new String ("A");
		String b = new String ("A").intern();
		String c = "A";
		String d = "A";
		
		
		if(a==b){
			System.out.println("a == b yes");
		} else {
			System.out.println("no");
		}
		
		if(b==c){
			System.out.println("b == c yes");
		} else {
			System.out.println("no");
		}
		
		if(d==c){
			System.out.println("d == c yes");
		} else {
			System.out.println("no");
		}
		
		System.out.println(test());
		

	}
}
