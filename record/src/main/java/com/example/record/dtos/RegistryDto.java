package com.example.record.dtos;

import java.time.LocalDate;

import com.example.record.model.Customer;
import com.example.record.model.Driver;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class RegistryDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "value")
    private Double value;
    
    @Column(name = "paid")
    private boolean paid;
    
    @Column(name = "collection_point")
    private String collectionPoint;
    
    @Column(name = "delivery_location")
    private String deliveryLocation;

    @ManyToOne
    @JoinColumn(name = "customer_id") 
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;
}
