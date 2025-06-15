package com.example.record.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="customer")
@Getter
@Setter
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id; 
	
	@NotBlank
    @NotNull
    @Length(min = 5, max = 200)
	private String name; 
	@NotBlank
    @NotNull
    @Length(min = 11)
	private String fone; 
	@NotBlank
    @NotNull
    @Column(unique = true)
	private String cnpj; 
	@NotBlank
    @NotNull
	private boolean companyRegular;
}
