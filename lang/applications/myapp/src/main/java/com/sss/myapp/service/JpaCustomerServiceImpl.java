package com.sss.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sss.myapp.dao.CustomerDao;
import com.sss.myapp.model.Customer;

@Component(value="custservicejpa")
public class JpaCustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao custdaojpa;
	
	
	public CustomerDao getCustdao() {
		return custdaojpa;
	}

	public void setCustdao(CustomerDao custdao) {
		this.custdaojpa = custdao;
	}

	public void add(Customer customer){
		custdaojpa.add(customer);
		System.out.println("done");
	}
	
	public void update(Customer customer){
		custdaojpa.update(customer);
	}
	
	public void delete(Customer customer){
		custdaojpa.delete(customer);
	}
	
	public void delete(long customerid){
		custdaojpa.delete(customerid);
	}
	
	public void deleteAll(){
		custdaojpa.deleteAll();
	}
	
	public Customer find(long customerid){
		return custdaojpa.find(customerid);
	}
	
	public List<Customer> findAll(){
		return custdaojpa.findAll();
	}
}
