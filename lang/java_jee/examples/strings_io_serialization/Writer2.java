import java.io.*;

public class Writer2
{
	public static void main(String args[]){
		try
		{
			File file = new File("test2.txt");
			if(file.exists()){
				file.delete();
			}
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("hello hello");
			pw.println("how are you doing...");
			pw.flush();
			pw.close();
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String data = null;
			while((data=br.readLine())!=null){
				System.out.println(data);
			}
			br.close();
			fr.close();
		}			
		catch (IOException ioExp)
		{
			System.out.println(ioExp.getMessage());		
		}
	}
}