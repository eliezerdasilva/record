package com.example.record.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class CustomerDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
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