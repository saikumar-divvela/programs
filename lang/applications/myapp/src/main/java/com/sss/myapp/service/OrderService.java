package com.sss.myapp.service;

import java.util.List;

import com.sss.myapp.model.Order;

public interface OrderService {
	public void add(Order order);
	public void update(Order order);
	public void delete(Order order);
	public void delete(long orderid);
	public Order find(long orderid);
	public List<Order> findAll();
}
