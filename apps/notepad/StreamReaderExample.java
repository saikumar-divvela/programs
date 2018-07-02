import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamReaderExample 
{
	public static void main(String args[])
	{
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		try
		{
			isr = new InputStreamReader(System.in);
			osw = new OutputStreamWriter(System.out);
			int b;
			while((b=isr.read())!=-1) osw.write(b);
		}
		catch (Exception e)
		{
			System.out.println(e);
		} finally {
			try{
				if(isr!=null) isr.close();
				if(osw!=null) osw.close();
			} catch(Exception e){
				System.out.println(e);
			}
		}
	}
}
