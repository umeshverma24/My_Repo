package com.uv.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uv.springboot.jpa.EmployeeJPARepository;
import com.uv.springboot.model.Customer;
import com.uv.springboot.service.SpringService;



@SpringBootTest
//@RunWith(SpringRunner.class)
class SpringbootProjectApplicationTests {
	
	@Mock
	SpringService springService;
	
	@Autowired
	public EmployeeJPARepository repositoryJPA;
	
	

	//@Test
	void contextLoads() {
		System.out.println("Test is invoked");
		Customer cust = new Customer(5,"UV");
	    SpringService springService = Mockito.mock(SpringService.class);
	    springService.setJPACust(cust);
	    Optional<Customer> newCust = springService.findById(3);
	    System.out.println(newCust);
	    assertEquals(cust, newCust);
	    
	}
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void checkMock() {
		System.out.println("Check Mock");
		
		springService.setJPACust(new Customer(6,"New UV"));
		System.out.println("Customer saved:");
		Customer cust = repositoryJPA.findByName("UV");
		Customer cust2= new Customer();
		when(cust).thenReturn(cust2);
		System.out.println("Customer received:" +cust.getName()); 
		System.out.println("Customer received2:" +cust.getName()); 
		assertEquals(cust, cust2);
		  for( Customer customer: repositoryJPA.findAll()) {
		  System.out.println("Customer received:" +customer); };
		 
		
	}
	

}
