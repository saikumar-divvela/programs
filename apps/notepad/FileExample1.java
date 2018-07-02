import java.io.File;

public class FileExample1 {
	public static void main(String args[]) throws Exception{
		File f1 = new File("TEST/XYZ");
		File f2 = new File("TEST/ABC");
		if(!f1.exists()){
			File f = new File(f1.getParent());
			if(!f.exists())	f.mkdir();
			f1.createNewFile();
			if(f2.exists()) f2.delete();
			System.out.println(f1.renameTo(new File("TEST/ABC")));
		}
	}
}