package com.sss.myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sss.myapp.model.Order;

@Component(value ="orderDao")
public class OrderDaoImpl implements OrderDao{
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void add(Order order){
		em.persist(order);
	}
	
	@Transactional
	public void update(Order order){
		em.merge(order);
	}
	
	@Transactional
	public void delete(Order order){
		this.delete(order.getOrderid());
	}
	
	@Transactional
	public void delete(Long orderid){
		Order order1 = em.find(Order.class,orderid);
		em.remove(order1);
	}
	public Order find(Long orderid){
		return em.find(Order.class,orderid);
	}
	
	public List<Order> findAll(){
		List<Order> orderlist = em.createQuery(" from order ",Order.class).getResultList();
		return orderlist;
	}
}
