    import java.io.*;
    public class Area{
    	static double[]x;
    	static double[]y;

    	public static void main(String...args) throws Exception{

    		FileReader fread = new FileReader("graph.txt");
    		BufferedReader br = new BufferedReader(fread);
    		String str;

    		String st = "";
    		while((str = br.readLine())!= null){
    			st+=str+" ";

    		}

    		String[] test = st.split("\\s");
    		x = new double[test.length/2];
    		y = new double[test.length/2];
    		for(int i = 0; i < test.length/2;i++){

    			x[i] = Double.parseDouble(test[i]);//Exception here


    		}

    		fread.close();

    	}
    }

