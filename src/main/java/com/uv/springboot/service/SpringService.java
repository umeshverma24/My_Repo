package com.uv.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uv.springboot.jpa.EmployeeJPARepository;
import com.uv.springboot.model.Customer;
//import com.uv.springboot.mongodb.EmployeeRepository;

@Component
public class SpringService {

	//@Autowired
	//public EmployeeRepository repository;
	
	@Autowired
	public EmployeeJPARepository repositoryJPA;
	
	/*
	 * public Employee setEmp(Employee emp) { repository.save(emp); return emp; }
	 */
	
	public Customer setJPACust(Customer cust) {
		repositoryJPA.save(cust);
		return cust;
	}
	
	public Customer findByName(String name) {
		return repositoryJPA.findByName(name);
	}
	
	public Optional<Customer> findById(int id) {
		return repositoryJPA.findById(String.valueOf(id));
	}
}
