import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FileStreamExample 
{
	public static void main(String args[]){
		File f = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try
		{
    		f = new File("FileExample1.java");
			fis = new FileInputStream(f);
			fos = new FileOutputStream("Test.java");
			int b;
			if(!f.exists()) {
				System.out.println("File "+f.getPath()+" doesn't exist");
				System.exit(0);
			}
			while((b=fis.read())!=-1) fos.write(b);
			System.out.println("File Transfer Done");
		}catch (Exception e)
		{
			System.out.println(e);
		} finally {
			try
			{
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
}