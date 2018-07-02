import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

public class Writer1
{
		public static void main(String args[]){
				char[] in = new char[5]; 
				int size =0;
				try{
					File  file = new File("test1.txt");
					
					if(!file.exists()){
						System.out.println("File  doesn't exist so creating the file:"+file.createNewFile());
					} else {
						System.out.println("File  exists so deleting it:"+file.delete());
					}
					FileWriter fw = new FileWriter(file);

					System.out.println("is Directory:"+file.isDirectory());
					System.out.println("is File:"+file.isFile());

					fw.write("hellooo  this is a test program to check filereader and filewriter");
					fw.flush();
					fw.close();
					
					FileReader  fr = new FileReader(file);
					while( (fr.read(in,0,5))!=-1){
							for(char c: in){
								System.out.print(c);
							}
					}
					fr.close();
				} catch(IOException ioExp){
					System.out.println("Exception occurred:"+ioExp.getMessage());
				}
		}
}