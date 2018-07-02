package com.sss.myapp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.sss.myapp.model.Customer;

/**
 * 
 * @author sadivvel
 * This has operations on customer object and uses jdbcdao support
 */

@Component(value="custdao")
public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao{
	
	
	@Autowired
	public void init(DataSource dataSource) {
	    setDataSource(dataSource);
	}
	
	public void testDBConnection() {
		
		int i = getJdbcTemplate().queryForInt("select 1 from dual");
		System.out.println("int "+i);
	}
	
	public List<Customer> findAll(){
		
		String sql = "select * from sss_customer";
		List<Customer> customers  =  getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Customer.class));
		return customers;
	}
	
	public Customer find(long id){
		String sql = "select * from sss_customer where customerid =?";
		List<Customer> customers = getJdbcTemplate().query(sql, new Object[]{id},new BeanPropertyRowMapper(Customer.class));
		if(customers != null){
			return customers.get(0);
		}
		return new Customer();
	}
	
	public void add(Customer customer){
		String sql = "insert into sss_customer (firstname,lastname,contactnumber,emailid) values(?,?,?,?)";
		System.out.println("inserting ..."+customer);
		getJdbcTemplate().update(sql,new Object[]{customer.getFirstname(),customer.getLastname(),customer.getContactnumber(),customer.getEmailid()});
	}
	
	
	public void delete(long customerid){
		String sql = "delete from sss_customer where customerid=?";
		System.out.println("deleting ..."+customerid);
		getJdbcTemplate().update(sql,new Object[]{customerid});
		
	}
	
	public void deleteAll(){
		
	}
	
	public void delete(Customer customer){
		String sql = "delete from sss_customer where customerid=?";
		System.out.println("deleting ..."+customer);
		getJdbcTemplate().update(sql,new Object[]{customer.getCustomerid()});
	}
	
	public void update(Customer customer){
		String sql = "update sss_customer set firstname=?, lastname=?, contactnumber=?, emailid=? where customerid=?";
		System.out.println("updating ..."+customer);
		getJdbcTemplate().update(sql,new Object[]{customer.getFirstname(),customer.getLastname(),customer.getContactnumber(),customer.getEmailid(),customer.getCustomerid()});
	}
}
