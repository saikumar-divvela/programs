import java.io.*;

class Dimension implements Serializable
{
	int height;
	int width;
	public Dimension(){
		this.height = 10;
		this.width =20;
	}
}
public class SerializeClass
{
		public static void main(String args[]){
			File file = null;
			Dimension dim = null;
			try
			{
				file = new File("test3.se")	;
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				dim = new Dimension();
				oos.writeObject(dim);
				oos.close();
				fos.close();
			}
			catch (IOException exp)
			{
				System.out.println(exp.getMessage());
			}
			try
			{
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Dimension dim2 = (Dimension) ois.readObject();
				System.out.println(dim2.height);
				System.out.println(dim2.width);
				ois.close();
				fis.close();
			}
			catch (ClassNotFoundException exp)
			{
				System.out.println(exp.getMessage());
			}
			catch (IOException exp)
			{
				System.out.println(exp.getMessage());
			}
		}
}