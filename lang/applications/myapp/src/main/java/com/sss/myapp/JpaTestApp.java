package com.sss.myapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sss.myapp.model.Customer;
import com.sss.myapp.model.Order;
import com.sss.myapp.service.CustomerService;
import com.sss.myapp.service.OrderService;



public class JpaTestApp 
{
    static ApplicationContext context = new ClassPathXmlApplicationContext("spring-myapp.xml");
    static CustomerService custservice = (CustomerService) context.getBean("custservicejpa");
    static OrderService orderservice = (OrderService) context.getBean("orderservice");
	
    
    
    public static void testCustomer(){
		
    	List<Customer> customers = null;
    	
    	// insert 2 records
    	//custservice.deleteAll();
    	
    	//Customer customer1 = new Customer(11,"test1","test1",123l,"test1@abc.com");
    	Customer customer2 = new Customer(12,"test2","test2",456l,"test2@abc.com");
    	//custservice.add(customer1);
    	custservice.add(customer2);
    	
    	customers = custservice.findAll();
    	for(Customer cust:  customers){
    		System.out.println(cust);
    	}
    	
    	custservice.deleteAll();
    	/*
    	// update the customer
    	customer1.setFirstname("test123");
    	customer1.setLastname("test123");
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
		*/
    	
	}
	
    public static void testOrder(){
    	Customer customer1 = new Customer(11,"test1","test1",123l,"test1@abc.com");
    	custservice.add(customer1);
    	Order order = new Order(12L,20L);
    	orderservice.add(order);
    }
    
	public static void main(String[] args )
    {
		testCustomer();
		//testOrder();
    	    	
    }
}
