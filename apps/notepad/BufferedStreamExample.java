import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;

public class BufferedStreamExample{
	public static void main(String args[]){
		int b;
		File file = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			file = new File("FileExample1.java");
			if(!file.exists()) {
				System.out.println("The file doesn't exists");
				System.exit(0);
			}
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("Test.java");
			bos = new BufferedOutputStream(fos);

			System.out.println("Available bytes:"+bis.available());
			while((b=bis.read())!=-1){
				System.out.print((char)b);
				bos.write(b);
			}
			
		} catch(Exception e){
			System.out.println("Exception :"+e);
		} finally {
			try
			{
				if(bis!=null)	bis.close();
				if(fis!=null)	fis.close();
				if(bos!=null)	bos.close();
				if(fos!=null)	fos.close();	
			}
			catch (Exception e)
			{
				System.out.println("Exception :"+e);
			}
		}
	}
}