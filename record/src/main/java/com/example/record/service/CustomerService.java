package com.example.record.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.record.model.Customer;
import com.example.record.repository.CustomerRepository;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> getCustomer() {
		
		return customerRepository.findAll();
	}

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getIdCustomer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteCustomer(Long id) {
		
		return false;
	}

}
