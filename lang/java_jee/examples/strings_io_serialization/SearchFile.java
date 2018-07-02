import java.io.*;
import java.util.*;

public class SearchFile
{
		public static void main(String args[]){
			try
			{
				List<String>  fileNames = new ArrayList();
				if(args.length<=0){
					throw new Exception("pass the directory name as argument");
				}
				File file = new File(args[0]);
				fileNames = (List<String>)Arrays.asList(file.list());
				for(String fileName: fileNames){
					System.out.println(fileName);
				}
			}
			catch (IOException exp)
			{
				System.out.println(exp.getMessage());				
			}
			catch (Exception exp)
			{
				System.out.println(exp.getMessage());				
			}
		}
}
