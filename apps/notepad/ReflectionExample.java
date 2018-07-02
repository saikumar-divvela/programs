import java.lang.reflect.*;

public class ReflectionExample {
	public void test(){
		return;
	}
	public static void main(String args[]){
		try
		{
			Class c = Class.forName(args[0]);
			Method m[] = c.getDeclaredMethods();
			System.out.println(m.length);
			for(int i=0;i< m.length;i++){
				System.out.println(m[i].toString());
			}

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}