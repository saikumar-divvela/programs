import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderExample
{
	public static void main(String args[])
	{
		File file = null;
		FileReader fr = null;	
		FileWriter fw = null;	
		try
		{
			file = new File("test.xls");
			if(!file.exists()){
				System.out.println("File doesn't exist");
				System.exit(0);
			}
			fr = new FileReader(file);
			fw = new FileWriter("Test.java");
			int b;
			while((b=fr.read())!=-1) fw.write(b);
		}
		catch (Exception e)
		{
			System.out.println(e);
		} finally {
			try
			{
				if(fr!=null) fr.close();
				if(fw!=null) fw.close();
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
}