import java.io.*;
public class TestSer {
public static void main(String[] args) {

try {
    SpecialSerial s = new SpecialSerial();
	s.print();
	ObjectOutputStream os = new ObjectOutputStream(
    new FileOutputStream("myFile"));
    os.writeObject(s); os.close();
    System.out.print(++s.z + " ");
    ObjectInputStream is = new ObjectInputStream(
                new FileInputStream("myFile"));
     SpecialSerial s2 = (SpecialSerial)is.readObject();
     is.close();
     System.out.println(s2.y) ;
	 System.out.println(s2.z);
	 s2.print();
    } catch (Exception x) {
     System.out.println("exc"); 
    }
 }
}
class SpecialSerial implements Serializable {
       transient int y = 7;
       static int z=14;
	   void print(){
			System.out.println("y="+y+" z="+z);
	   }
}
