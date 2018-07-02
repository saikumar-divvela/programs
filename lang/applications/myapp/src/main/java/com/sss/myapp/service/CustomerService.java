package com.sss.myapp.service;

import java.util.List;

import com.sss.myapp.model.Customer;

public interface CustomerService {
	public void add(Customer customer);
	public void update(Customer customer);
	public void delete(Customer customer);
	public void delete(long customerid);
	public void deleteAll();
	public Customer find(long customerid);
	public List<Customer> findAll();
}
