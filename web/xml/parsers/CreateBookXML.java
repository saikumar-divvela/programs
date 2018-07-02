/*
	This class generates books.xml
	data is loaded in book objects.
	using DOM api xml is constructed.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.FileNotFoundException;

public class CreateBookXML{
	List myData;
	String fileName;
	Document dom;

	CreateBookXML(String fileName){
		myData = new ArrayList();
		this.fileName = fileName ;
	}
	private void loadData(){
		myData.add(new Book("Head First Java","Kathy....","Junk Java"));
		myData.add(new Book("OOPS","jimmy","OOPS for dummies"));
	}
	private void createDocument(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
				DocumentBuilder db = dbf.newDocumentBuilder();
				dom = db.newDocument();
		} catch(ParserConfigurationException pce){
			System.out.println("Error while trying to instantiate documentbuilder "+pce);
			System.exit(1);
		}
	}

	private void createDOMTree(){
		try {
			Element	rootE = dom.createElement("Books");
			dom.appendChild(rootE);
			Iterator iter = myData.iterator();
			while(iter.hasNext()){
				Book b = (Book)iter.next();
				rootE.appendChild(createBookElement(b));
			}
		} catch(DOMException de){
			System.out.println("Exception :"+de.getMessage());
		}
	}

	private Element createBookElement(Book b){
		try {
			Element bookE = dom.createElement("Book");
			bookE.setAttribute("Subject",b.getSubject());

			Element authorE = dom.createElement("Author");
			Text authT = dom.createTextNode(b.getAuthor());
			authorE.appendChild(authT);
			bookE.appendChild(authorE);

			Element titleE = dom.createElement("Title");
			Text titleT = dom.createTextNode(b.getTitle());
			titleE.appendChild(titleT);
			bookE.appendChild(titleE);
			return bookE;
		} catch(DOMException domEx){
			System.out.println("Exception :"+domEx.getMessage());
		}
		return null;
	}

	private void printToFile(){
		try {
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT,"yes");
			tr.setOutputProperty(OutputKeys.METHOD,"xml");
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount" , "3");

			//to send the output to a file
			tr.transform( new DOMSource(dom),new StreamResult(new FileOutputStream(fileName)));
		} catch (TransformerConfigurationException exp){
			System.out.println(exp.getMessage());
		} catch(FileNotFoundException exp){
			System.out.println(exp.getMessage());
		} catch(TransformerException exp){
			System.out.println(exp.getMessage());
		}
	}
	public void createXML(){
		loadData();
		createDocument();
		createDOMTree();
		printToFile();
	}

	public static void main(String args[]){
		CreateBookXML books = new CreateBookXML("books.xml");
		books.createXML();
	}
}
