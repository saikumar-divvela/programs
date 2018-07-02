package com.sss.myapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sss_order")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="myapp_order_seq")
	@SequenceGenerator(name="myapp_order_seq",sequenceName="sss_num_seq")
	private Long id;
	@Column(unique=true,nullable=false)
	private Long  orderid;
	private Customer customer;
	private Long  totalprice;
	
	
	
	public Order(Long orderid, Long totalprice){
		this.totalprice = totalprice;
		this.orderid = orderid;
	}
	
	public Order(){
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customerid",nullable=false)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Long getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Long totalprice) {
		this.totalprice = totalprice;
	}
	
}
