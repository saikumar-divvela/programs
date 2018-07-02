import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLog {
	public static void main(String args[]){
		File file = new File("C:\\Project\\Msp work\\Patching\\xyz.txt");
		java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
		System.out.println("Date and time:"+timestamp.toString());
		try {
			FileWriter fw = new FileWriter(file,true);
			System.out.println("FileWriter not null");
			fw.write("hello,Hai,hi");
			fw.write(System.getProperty("line.separator"));
			fw.flush();
			fw.close();
			fw = null;
			if (fw==null) {
				System.out.println("FileWriter is null");
			} else {
				System.out.println("FileWriter not null");
				System.out.println(file.exists());
				fw.close();
				//fw.write("hello,Hai,hi");
				//fw.write(System.getProperty("line.separator"));
			}
		} catch (IOException e){
			System.out.println("Exception occurred:"+e.getMessage());
		}
	}
}