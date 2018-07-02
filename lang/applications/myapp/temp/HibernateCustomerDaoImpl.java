package com.sss.myapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.sss.myapp.model.Customer;

@Component(value="custdaohib")
public class HibernateCustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{
	
	@Autowired
	public void init(SessionFactory sessionFactory) {
	    setSessionFactory(sessionFactory);
	}
	 
	 public void add(Customer customer){
		getHibernateTemplate().save(customer);
	}
	
	public void update(Customer customer){
		getHibernateTemplate().update(customer);
	}
	
	public void delete(Customer customer){
		getHibernateTemplate().delete(customer);
	}
	

	public void deleteAll(){
		
	}
	public void delete(long customerid){
		Customer customer = find(customerid);
		if(customer!=null){
			getHibernateTemplate().delete(customer);
		}
	}
	
	
	public Customer find(long id){
		List list = getHibernateTemplate().find(" from Customer where customerid =?",id);
		if(list!= null){
			return (Customer)list.get(0);
		}
		return null;
	}
	
	public List<Customer> findAll(){
		return getHibernateTemplate().find(" from Customer");
	}
}
