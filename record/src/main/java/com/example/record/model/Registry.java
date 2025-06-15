package com.example.record.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
@Table(name="registry")
@ToString
public class Registry {

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
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;
}
