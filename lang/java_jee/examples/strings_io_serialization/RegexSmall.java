import java.util.regex.Pattern;
import java.util.regex.Matcher;

public	class  RegexSmall
{
		public static void main(String args[]){
			String pattern ="\\.";
			String data="ab.ca.bc12";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(data);
			System.out.println("initial string:"+m.toString());
			while(m.find()){
				System.out.println(m.start());
			}
			System.out.println("after  replacing:"+m.replaceAll("xyz").toString());
		}
}