package com.sss.myapp.dao;

import java.util.List;

import com.sss.myapp.model.Order;


public interface OrderDao {
	public void add(Order order);
	public void update(Order order);
	public void delete(Order order);
	public void delete(Long orderid);
	public Order find(Long orderid);
	public List<Order> findAll();
}
