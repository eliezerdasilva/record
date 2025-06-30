package com.example.record.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.record.dtos.CustomerDto;
import com.example.record.service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;


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
	public  ResponseEntity<List<CustomerDto>> getAllCustomers(){
		return ResponseEntity.ok(customerService.getAllCustomer());
	}
	@PostMapping
	@ResponseBody
	public ResponseEntity<CustomerDto> create(@RequestBody @Valid CustomerDto customerDto) {
		try {
            CustomerDto created = customerService.createCustomer(customerDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getIdCustomer(@PathVariable Long id)	{
		CustomerDto customerDto = customerService.getCustomerId(id);
		if (customerDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(customerDto);
	}
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerDto customerDto) {
		try {
			CustomerDto updated = customerService.updateCustomer(id, customerDto);
			return ResponseEntity.ok(updated);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@DeleteMapping(path = "{id}" )
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		 try {
		        customerService.deleteCustomer(id);
		        return ResponseEntity.ok("Cliente deletado com sucesso!");
		    } catch (EntityNotFoundException e) {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o cliente.");
		    }
	}
}
