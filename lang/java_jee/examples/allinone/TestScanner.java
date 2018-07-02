import java.util.Scanner;
import java.util.regex.MatchResult;

public class TestScanner
{
		public static void main(String args[]){
				String csv = "hello,there5,3";
				Scanner scanner = new Scanner( csv);
				scanner.useDelimiter(",");
				while(scanner.hasNext()){
					System.out.println(scanner.next());
				}
				 String input = "1 fish 2 fish red fish blue fish";
			     Scanner s = new Scanner(input);
			     s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
			     MatchResult result = s.match();
			     for (int i=1; i<=result.groupCount(); i++)
			         System.out.println(result.group(i));
				    s.close(); 
		}
}