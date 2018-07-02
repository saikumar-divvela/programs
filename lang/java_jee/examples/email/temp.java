import java.util.*;
public class temp {
public static void main(String args[]) throws Exception
{

	Properties prop= System.getProperties();
	Enumeration names= prop.propertyNames();
	while(names.hasMoreElements()){
		String name =(String)names.nextElement();
		String value = (String)prop.getProperty(name);
		System.out.println(name+" = "+value);
	}

}
}