import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class BufferedReaderExample
{
	public static void main(String args[])
	{
		File file = null;
		FileReader fr = null;	
		FileWriter fw = null;	
		BufferedReader br = null;	
		BufferedWriter bw = null;	

		try
		{
			file = new File("FileExample1.java");
			if(!file.exists()){
				System.out.println("File doesn't exist");
				System.exit(0);
			}
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			fw = new FileWriter("Test.java");
			bw = new BufferedWriter(fw);
			String str ;
			while((str=br.readLine())!=null) {
				System.out.println(str);
				bw.write(str);
				//bw.newLine();
			}
			System.out.println("File copy done");
		}
		catch (Exception e)
		{
			System.out.println(e);
		} finally {
			try
			{
				if(bw!=null) bw.close();
				if(br!=null) br.close();
				if(fw!=null) fw.close();
				if(fr!=null) fr.close();
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
}