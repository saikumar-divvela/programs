package com.sss.myapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sss.myapp.model.Customer;
import com.sss.myapp.service.CustomerService;

public class JDBCTestApp 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring-myapp.xml");
    	CustomerService custservice = (CustomerService) context.getBean("custproxyjdbc"); 
    	
    	List<Customer> customers = null;
    	
    	// insert 2 records
    	Customer customer1 = new Customer("test1","test1",123l,"test1@abc.com");
    	Customer customer2 = new Customer("test2","test2",456l,"test2@abc.com");
    	custservice.add(customer1);
    	custservice.add(customer2);
    	
    	
    	customers = custservice.findAll();
    	for(Customer cust:  customers){
    		System.out.println(cust);
    	}
    	
    	// update the customer
    	customer1.setFirstname("test11");
    	customer1.setLastname("test11");
    	custservice.update(customer1);
    	
    	customers = custservice.findAll();
    	for(Customer cust:  customers){
    		System.out.println(cust);
    	}
    	
    	// delete the customer
    	custservice.delete(customer1);
    	custservice.delete(customer2.getCustomerid());
    	
    	customers = custservice.findAll();
    	for(Customer cust:  customers){
    		System.out.println(cust);
    	}
		
    }
}
