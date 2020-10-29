package com.uv.springboot.jpa;

import org.springframework.data.repository.CrudRepository;

import com.uv.springboot.model.Customer;


public interface EmployeeJPARepository extends CrudRepository<Customer, String> {
	public Customer findByName(String name);
}
