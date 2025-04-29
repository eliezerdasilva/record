package com.example.record;

import java.util.Date;

import com.example.record.model.Customer;
import com.example.record.model.Registry;

public class testeresgistry {
	public static void main(String[] args) {
		Customer customer = new Customer(1L, "JOao", "454545454");
		Registry registry = new Registry();
		Date agora = new Date();
		registry.setData(agora);
		registry.setCollectionPoint("Blumenau");
		registry.setDeleveryLocation("Gaspar");
		registry.setId(1L);
		registry.setCustomer(customer);
		registry.setPaid(false);
		registry.setValue(100D);

		System.out.println(registry);
	}
}
