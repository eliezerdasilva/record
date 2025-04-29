package com.example.record.model;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="resgitry")
@ToString
public class Registry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id; 


    @Column(name = "data")
    private Date data;

    @Column(name = "value")
    private Double value;
    
    @Column(name = "paid")
    private boolean paid;
    
    @Column(name = "collection_point")
    private String collectionPoint;
    
    @Column(name = "delevery_location")
    private String deleveryLocation;

    @ManyToOne
    @JoinColumn(name = "customer_id") 
    private Customer customer;

}
