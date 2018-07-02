package com.sss.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sss.myapp.model.Customer;

public class CustomerRowmapper implements RowMapper {
	public Customer mapRow(ResultSet rs,int rowNum) throws SQLException{
		Customer customer = new Customer();
		customer.setCustomerid(rs.getLong("customerid"));
		customer.setFirstname(rs.getString("firstname"));
		customer.setLastname(rs.getString("lastname"));
		customer.setContactnumber(rs.getLong("contactnumber"));
		customer.setEmailid(rs.getString("emailid"));
		return customer;
	}
}
