package com.sss.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sss.myapp.dao.OrderDao;
import com.sss.myapp.model.Order;

@Component(value="orderservice")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderdao;
	
	public void add(Order order){
		orderdao.add(order);
	}
	public void update(Order order){
		orderdao.update(order);
	}
	public void delete(Order order){
		orderdao.delete(order);
	}
	
	public void delete(long orderid){
		orderdao.delete(orderid);
	}
	public Order find(long orderid){
		return orderdao.find(orderid);
	}
	
	public List<Order> findAll(){
		return orderdao.findAll();
	}
}
