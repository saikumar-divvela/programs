package com.sss.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sss.myapp.dao.CustomerDao;
import com.sss.myapp.dao.CustomerDaoImpl;
import com.sss.myapp.model.Customer;

@Component(value="custservice")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao custdao;
	

	public void testDBConnection(){
		//custdao.testDBConnection();
	}
	
	public List<Customer> findAll(){
		return custdao.findAll();
	}

	public Customer find(long id){
		return custdao.find(id);
	}
	
	public void add(Customer customer){
		custdao.add(customer);
	}
	
	public void delete(long customerid){
		custdao.delete(customerid);
	}
	
	public void delete(Customer customer){
		custdao.delete(customer);
	}
	public void deleteAll(){
		
	}
	public void update(Customer customer){
		custdao.update(customer);
	}
}
