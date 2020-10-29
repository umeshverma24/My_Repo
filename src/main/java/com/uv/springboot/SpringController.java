package com.uv.springboot;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uv.springboot.jpa.EmployeeJPARepository;
import com.uv.springboot.model.Customer;
import com.uv.springboot.model.Employee;
//import com.uv.springboot.mongodb.EmployeeRepository;
import com.uv.springboot.service.SpringService;

@RestController
@RequestMapping("/emp")
public class SpringController {
	
	//@Autowired
	//public EmployeeRepository repository;
	
	@Autowired
	public EmployeeJPARepository repositoryJPA;
	
	@Autowired
	public SpringService springService;
	
	//@RequestMapping(value="/getName/{id}",	method = RequestMethod.GET )
	@GetMapping(value="/getName/{id}")
	public Employee getName(@PathVariable(required = false) int id) {
		System.out.println("id is this:" +id);
		Employee emp = new Employee();
		emp.setName("emp"+id);
		return emp;
		//return new ResponseEntity<String>("emp"+id, HttpStatus.OK);
	}
	
	@GetMapping(value={"/getOptionalName","/getOptionalName/{id}"})
	public Employee getOptionalName(@PathVariable(required = false) Integer id) {
		System.out.println("id is this:" +id);
		Employee emp = new Employee();
		emp.setName("emp"+id);
		return emp;
		//return new ResponseEntity<String>("emp"+id, HttpStatus.OK);
	}

	@GetMapping(value="/getIdName/{id}/{name}")
	public Employee getIdName(@PathVariable Map<String,String> params) {
		System.out.println("id is this:" +params.get("id"));
		System.out.println("name is this:" +params.get("name"));
		Employee emp = new Employee();
		emp.setId(params.get("id"));
		emp.setName(params.get("name"));
		return emp;
		//return new ResponseEntity<String>("emp"+id, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/setName", method=RequestMethod.POST)
	public Employee setName(@RequestParam(name="name", required=false, defaultValue="Umesh") String myName) {
		System.out.println("Name is:-> "+myName);
		Employee emp = new Employee();
		emp.setName(myName+"--kool");
		
		return emp;
	}
	
	/*
	 * @RequestMapping(value="/setEmp", method=RequestMethod.POST) public Employee
	 * setEmp(@RequestBody Employee emp) {
	 * 
	 * System.out.println("Id is:-> "+emp.getId());
	 * System.out.println("Name is:-> "+emp.getName());
	 * 
	 * //Save it repository.save(emp);
	 * 
	 * //Retrieve it for ( Employee tempEmp: repository.findAll()) {
	 * System.out.println("Emp Name for id:"+tempEmp.getId()+" is->"+tempEmp.getName
	 * ()); } //Find by name
	 * System.out.println("Find by Name is:-> "+repository.findByName(emp.getName())
	 * +"id is:" +((Employee)repository.findByName(emp.getName())).getId());
	 * 
	 * System.out.println("repository.count() before delete is:"+
	 * repository.count());
	 * 
	 * //Exist System.out.println("repository.existsById:"+
	 * repository.existsById(String.valueOf(emp.getId())));
	 * 
	 * //delete it repository.deleteAll();
	 * 
	 * System.out.println("repository.count() after delete is:"+
	 * repository.count()); return emp; }
	 */
	
	@RequestMapping(value="/setJPAEmp", method=RequestMethod.POST)
	public Employee setJPAEmp(@RequestBody Employee emp) {
	
		System.out.println("Id is:-> "+emp.getId());
		System.out.println("Name is:-> "+emp.getName());
		
		//Save it
		
		//Employee tempEmp = springService.setEmp(emp);
		//System.out.println("Find by Name is:-> "+repositoryJPA.findByName(tempEmp.getName())+"id is:" +((Employee)repository.findByName(tempEmp.getName())).getId());
		
		return emp;
	}
		
	
	@RequestMapping(value="/setCust", method=RequestMethod.POST)
	public Customer setCust(@RequestBody Customer cust) {
	
		System.out.println("Id is:-> "+cust.getId());
		System.out.println("Name is:-> "+cust.getName());
		
		//Save it
		
		Customer tempCust = springService.setJPACust(cust);
		System.out.println("Find by Name is:-> "+repositoryJPA.findByName(tempCust.getName())+"id is:" +((Customer)repositoryJPA.findByName(tempCust.getName())).getId());
		
		return cust;
	}
}
