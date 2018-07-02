package com.sss.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sss.myapp.model.Customer;
import com.sss.myapp.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService custservicejpa;
	
	
	public CustomerService getCustservicejpa() {
		return custservicejpa;
	}

	public void setCustservicejpa(CustomerService custservicejpa) {
		this.custservicejpa = custservicejpa;
	}

	@RequestMapping(value="/all", method = RequestMethod.GET,produces={"application/json"})
	public @ResponseBody List<Customer> getAll(){
		return custservicejpa.findAll();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET,produces={"application/xml"})
	public @ResponseBody Customer find(@PathVariable ("id") Long customerid ){
		return custservicejpa.find(customerid);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("id") Long customerid){
		custservicejpa.delete(customerid);
		return "success";
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces={"application/json"}, consumes ={"application/json"})
	@ResponseBody
	public String add(@RequestBody Customer customer){
		custservicejpa.add(customer);
		return "success";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String update(@RequestBody Customer customer){
		custservicejpa.update(customer);
		return "success";
	}
}
