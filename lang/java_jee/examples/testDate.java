import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParsePosition;

public class testDate
{
	public static void main(String args[]) throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		System.out.println("new date:"+dateFormat.parse("12/01/2008 03:31 PM"));
	}
}