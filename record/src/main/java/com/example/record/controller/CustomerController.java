package com.example.record.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.record.dtos.CustomerDto;
import com.example.record.model.Customer;
import com.example.record.service.CustomerService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(path = "api/customer")
public class CustomerController {
	@Autowired
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping(value = "/getall")
	@ResponseBody
	public  List<Customer> getCustomer(){
		return customerService.getCustomer();
	}
	@PostMapping("/create")
	@ResponseBody
	public Customer create(@RequestBody @Valid CustomerDto customerDto) {
		return customerService.createCustomer(customerDto);
	}
	
	@GetMapping("/greet/{id}")
	public Customer getIdCustomer(@PathVariable Long id)	{
		return customerService.getIdCustomer(id);
	}
	@DeleteMapping(path = "{customerId}" )
	private boolean deleteCustomer(@PathVariable("customerId") Long id) {
		return customerService.deleteCustomer(id);
	}
}
