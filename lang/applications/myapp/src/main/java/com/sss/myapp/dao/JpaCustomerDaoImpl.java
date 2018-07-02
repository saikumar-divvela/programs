package com.sss.myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sss.myapp.model.Customer;

@Component(value="custdaojpa")
public class JpaCustomerDaoImpl implements CustomerDao {
	
	
	 @PersistenceContext
	 private EntityManager em;
	
	
	@Transactional
	public void add(Customer customer){
		
		try{
			System.out.println("Adding customer "+customer);
			em.persist(customer);
			//em.flush();
			//em.close();
			System.out.println("hahaha");
			//customer.setFirstname("heheheheh");
		} catch(Exception exp){
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		
		}
		
	}
	
	@Transactional
	public void update(Customer customer){
		em.merge(customer);
	}
	
	@Transactional
	public void delete(Customer customer){
		Customer customer1 = em.find(Customer.class, customer.getCustomerid());
		em.remove(customer1);
	}
	
	@Transactional
	public void delete(long customerid){
		Customer customer = em.find(Customer.class, customerid);
		em.remove(customer);
		
	}
	
	public Customer find(long customerid){
		return em.find(Customer.class, customerid);
	}
	
	public List<Customer> findAll(){
		List<Customer> customers = em.createQuery("from Customer").getResultList();
		return customers;
	}
	
	@Transactional
	public void deleteAll(){
		int cnt =	em.createQuery("DELETE FROM Customer c").executeUpdate();
		em.close();
	}
}
