package com.example.record.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.record.dtos.CustomerDto;
import com.example.record.mapper.CustomerMapper;

import com.example.record.model.Customer;
import com.example.record.repository.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class CustomerService {
	@Autowired
	private final CustomerRepository customerRepository;
	@Autowired
	private final CustomerMapper customerMapper;

	public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	public CustomerDto getCustomerId(Long id) {
		if (id < 0) {
			throw new IllegalArgumentException("ID inválido");
		}
		Optional<Customer> customer = customerRepository.findById(id);
		
		if (!customer.isPresent()) {
			throw new IllegalArgumentException("Não ha registro");
		}
		return customerMapper.toDto(customer.get());
	}

	public List<CustomerDto> getAllCustomer() {
		List<Customer> customer = customerRepository.findAll();
		System.out.println(customer);
		return customer.stream().map(customerMapper::toDto).collect(Collectors.toList());
	}

	public CustomerDto createCustomer(CustomerDto customerDto) {
		Customer customer = customerMapper.toEntity(customerDto);
		Customer saved = customerRepository.save(customer);

		return customerMapper.toDto(saved);
	}

	public void deleteCustomer(Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
		customerRepository.delete(customer);

	}

	public CustomerDto updateCustomer(Long id, @Valid CustomerDto customerDto) {
		customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
		customerDto.setId(id);
		CustomerDto newCustomer = customerMapper.toDto(customerRepository.save(customerMapper.toEntity(customerDto)));
		return newCustomer;
	}

}
