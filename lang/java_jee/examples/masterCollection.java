import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
public class  masterCollection
{
	public static void main(String args[]) throws Exception{
		/*
		Set<String> xyz = new TreeSet<String>();
		xyz.add("12:30");
		xyz.add("13:30");
		xyz.add("14:30");
		xyz.add("15:30");
		xyz.add("03:30");
		xyz.add("02:30");
		xyz.add("01:30");
		for(Iterator<String> iter = xyz.iterator();iter.hasNext();)
		{
			String  x = iter.next();
			System.out.println(x);
		}
		*/
		Date now = new Date();

		/*
		Calendar calendar  = new GregorianCalendar();
		calendar.setTime(now);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
		StringBuffer timeStr = new StringBuffer();
		if(hour<10)
			timeStr.append("0").append(hour);
		else
			timeStr.append(hour);
		timeStr.append(":");
		if(minute<10)
			timeStr.append("0").append(minute);
		else
			timeStr.append(minute);

		System.out.println(timeStr);
		*/
		String format = "MM/dd/yyyy h:m a";
		String fromDate = "11/06/2008 06:34 AM";
		SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.FRENCH);
		String formattedDate = sdf.format(now);
		System.out.println("Date:"+sdf.format(now));
		System.out.println("Date1:"+sdf.parse(fromDate));
		Locale[] allLocale = Locale.getAvailableLocales();
		for(int i=0;i<allLocale.length;i++){
			//System.out.println("Country:"+allLocale[i].getCountry()+" Language:"+allLocale[i].getLanguage());
		}
		/*
		String dateTime = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT).format(now);
		String date = DateFormat.getDateInstance(DateFormat.SHORT).format(now);
		String time = DateFormat.getTimeInstance(DateFormat.SHORT).format(now);
		System.out.println("Original date: " + now.toString());
		System.out.println("formattedDate: " + formattedDate);
		System.out.println("Date: " + date);
		System.out.println("MINUTE: " + time);
		*/

		//System.out.println(time);
		/*
		Map<String,Map<String,Integer>> outerMap= new HashMap<String,Map<String,Integer>>();
		Map<String,Integer>  map1= new HashMap<String,Integer>();
		map1.put("x1",new Integer(21)) ;
		map1.put("x2",new Integer(22)) ;
		map1.put("x3",new Integer(23)) ;
		Map<String,Integer>  map2= new HashMap<String,Integer>();
		map2.put("y1",new Integer(11));
		map2.put("y2",new Integer(12));
		map2.put("y3",new Integer(13));
		if(outerMap.get("A")==null){
			outerMap.put("A",map1);
		}
		if(outerMap.get("B")==null){
			outerMap.put("B",map2);
		}
		Map<String,Integer> maptest= outerMap.get("A");
		maptest.put("x2",100);

		for(Iterator<String> iter1= outerMap.keySet().iterator();iter1.hasNext();){
			String key = iter1.next();
			System.out.println("key ="+key);
			Map<String,Integer> map= outerMap.get(key);
			for(Iterator<String> iter= map.keySet().iterator();iter.hasNext();){
				String key1 = iter.next();
				System.out.println("key ="+key1+"value="+map.get(key1));
			}
		}*/
	}
}