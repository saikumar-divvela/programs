package com.sss.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;

import com.sss.myapp.model.Customer;
import com.sss.myapp.service.CustomerService;
import com.sss.myapp.service.OrderService;

public class JAXBExample {
	static ApplicationContext context = new ClassPathXmlApplicationContext("spring-myapp.xml");
    static CustomerService custservice = (CustomerService) context.getBean("custservicejpa");
    static OrderService orderservice = (OrderService) context.getBean("orderservice");
	
	public static void main(String args[]) throws Exception {
		List<Customer> customers = null;
		customers = custservice.findAll(); 
		JAXBContext jaxbInstance = JAXBContext.newInstance(Customer.class);
		Marshaller marshaller = jaxbInstance.createMarshaller();
		System.out.println(customers);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(customers.get(0),new FileOutputStream("customer.xml"));
		marshaller.marshal(customers.get(0), System.out);
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		marshaller.marshal(customers.get(0), doc);
		System.out.println(doc.getChildNodes().item(0).getChildNodes().item(0).getNodeValue()); 
		System.out.println(doc.toString());
		
		Unmarshaller unmarshaller = jaxbInstance.createUnmarshaller();
		Customer customer = (Customer)unmarshaller.unmarshal(new FileInputStream("customer.xml"));
		System.out.println("Unmarshalled file:"+customer);
		
	}
}
