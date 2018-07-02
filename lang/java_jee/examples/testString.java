public class testString
{
	public static void main(String args[]){
		String one="one";
		String two="two";
		String three="three";

		one.concat(two);
		two.concat(three);
		three.concat(one);
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
	}
}