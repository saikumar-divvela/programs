/*
	Program to parse the xml using SAX parser and display the XML contents on console
*/

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
// exception classes
import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;


public class SAXParserExample extends DefaultHandler{

	private List myEmpl;
	String fileName;
	private Employee empObj;
	private String tmpVal;
	SAXParserExample(String XMLFileName){
		this.fileName = XMLFileName;
		myEmpl = new ArrayList();
	}
	SAXParserExample(){
	}
	private void parseXML(){
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser sp = spf.newSAXParser();
			sp.parse(fileName,this);
		} catch(ParserConfigurationException  pce){
			System.out.println(pce.getMessage());
		} catch(SAXException  se){
			System.out.println(se.getMessage());
		} catch(IOException  ie){
			System.out.println(ie.getMessage());
		}
	}
	public void characters(char [] ch,int start, int length) throws SAXException{
		tmpVal = new String(ch,start,length);
	}
	public void startElement(String uri, String localName, String qName, Attributes attributes)
								throws SAXException {
		if(qName.equalsIgnoreCase("Employee")){
			empObj = new Employee();
			empObj.setType(attributes.getValue("type"));
		}
	}
	public void endElement(String uri,String localName,String qName)
                throws SAXException {
		if (qName.equals("Employee")){
			myEmpl.add(empObj);
		} else if (qName.equals("Name")){
			empObj.setName(tmpVal);
		} else if (qName.equals("Age")){
			empObj.setAge(Integer.parseInt(tmpVal));
		} else if (qName.equals("Id")){
			empObj.setId(Integer.parseInt(tmpVal));
		}
	}
	public void printData(){
		parseXML();
		Iterator empIter = myEmpl.iterator();
		while(empIter.hasNext()){
			Employee emp =(Employee) empIter.next();
			System.out.println(emp.toString());
		}
	}
	public static void main(String args[])throws Exception {
		SAXParserExample saxE1 = new SAXParserExample("employee.xml");
		saxE1.printData();
	}
}

