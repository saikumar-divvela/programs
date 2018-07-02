import java.io.*;

public class TestSerialization extends Test implements Serializable 
{
		static int s;
		transient int t;
		 private Tree tree = new Tree();
		 class Tree { }
		 public static void main(String [] args) {
				 TestSerialization f= new TestSerialization();
				 try {
						 FileOutputStream fs = new FileOutputStream("Forest.ser");
						 ObjectOutputStream os = new ObjectOutputStream(fs);
						 os.writeObject(f); os.close();
				 } catch (Exception ex) 
				{
						 ex.printStackTrace(); 
				}
	 }
}

 class Test
 {
 }
