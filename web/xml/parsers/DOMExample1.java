/*
	This program shows how to parse a xml document using DOM parser and displays the xml
	contents on console.
	DOM parser --> uses tree structure, reads xml and keeps it in memory
				   good for small xml files,if we want to modify xml back and forth
				   not suitable to large xml files as it occupies more memory
*/


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class DOMExample1{
	String fileName;
	Document dom;
	List empList;
	DOMExample1(String xmlFileName){
		this.fileName = xmlFileName;
		empList = new ArrayList();
	}
	DOMExample1(){
	}
	private void parseXMLFile(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try
		{
			// using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(fileName);
			parseDocument();
		}catch(ParserConfigurationException pce){
			System.out.println(pce.getMessage());
		} catch(SAXException se){
			System.out.println(se.getMessage());
		} catch(IOException ie){
			System.out.println(ie.getMessage());
		}
	}

	private void parseDocument(){
		Element rootE = dom.getDocumentElement();
		NodeList nl = rootE.getElementsByTagName("Employee");
		if(nl==null || nl.getLength() <1) return;
		for(int i=0;i<nl.getLength();i++){
			Element empE =(Element) nl.item(i);
			Employee empObj = getEmployee(empE);
			empList.add(empObj);
		}
	}

	private Employee getEmployee(Element E){
		String type = E.getAttribute("type");
		String name = getTextValue(E,"Name");
		int age = getIntValue(E,"Age");
		int id = getIntValue(E,"Id");
		return (new Employee(name,type,age,id));
	}

	private String getTextValue(Element ele,String tagName){
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl == null || nl.getLength() <1) return null ;
		return (nl.item(0).getFirstChild().getNodeValue());
	}

	private int getIntValue(Element ele,String tagName){
		return (Integer.parseInt(getTextValue(ele,tagName)));
	}
	public void printData(){
		parseXMLFile();
		Iterator empIter = empList.iterator();
		while(empIter.hasNext()){
			Employee emp = (Employee)empIter.next();
			System.out.println(emp.toString());
		}
	}
	public static void main(String args[]) throws Exception {
		DOMExample1 domex1 = new DOMExample1("employee.xml");
		domex1.printData();
	}
}