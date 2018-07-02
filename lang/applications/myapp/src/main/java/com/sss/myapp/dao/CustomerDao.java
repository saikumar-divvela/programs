package com.sss.myapp.dao;

import java.util.List;

import com.sss.myapp.model.Customer;

public interface CustomerDao {
	public void deleteAll();
	public void add(Customer customer);
	public void update(Customer customer);
	public void delete(Customer customer);
	public void delete(long customerid);
	public Customer find(long customerid);
	public List<Customer> findAll();
}
