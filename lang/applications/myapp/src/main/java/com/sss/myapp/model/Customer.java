package com.sss.myapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="sss_customer")
@XmlRootElement
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="myapp_customer_seq") 
	@SequenceGenerator(name="myapp_customer_seq",sequenceName="sss_num_seq", allocationSize=1)
	private long id;
	//@Column(unique=true,nullable=false)
	private long customerid;
	private String firstname;
	private String lastname;
	private long contactnumber;
	private String emailid;
	/*
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer",fetch=FetchType.LAZY)
	private Set<Order> orders = new HashSet<Order>(0);
	*/
	
	public Customer(long customerid,String firstname,String lastname,long contactnumber,String emailid){
		this.customerid = customerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.contactnumber = contactnumber;
		this.emailid = emailid;
	}
	
	public Customer(String firstname,String lastname,long contactnumber,String emailid){
		this.firstname = firstname;
		this.lastname = lastname;
		this.contactnumber = contactnumber;
		this.emailid = emailid;
	}
	
	public Customer(){
		
	}
	
	
	/*
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public long getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(long contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstname="
				+ firstname + ", lastname=" + lastname + ", contactnumber="
				+ contactnumber + ", emailid=" + emailid + "]";
	}
	
}
