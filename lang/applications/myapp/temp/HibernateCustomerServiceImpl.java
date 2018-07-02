package com.sss.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sss.myapp.dao.CustomerDao;
import com.sss.myapp.model.Customer;

@Component(value="custservicehib")
public class HibernateCustomerServiceImpl  implements CustomerService{
	
	@Autowired
	private CustomerDao custdaohib;
	
	

	public void setCustdao(CustomerDao custdao) {
		this.custdaohib = custdao;
	}
	
	
	public void add(Customer customer){
		custdaohib.add(customer);
	}
	
	public void update(Customer customer){
		custdaohib.update(customer);
	}
	
	public void delete(Customer customer){
		custdaohib.delete(customer);
	}
	
	public void delete(long customerid){
		custdaohib.delete(customerid);
	}
	
	public void deleteAll(){
		
	}
	
	public Customer find(long id){
		return custdaohib.find(id);
	}
	
	public List<Customer> findAll(){
		return custdaohib.findAll();
	}
	
}
