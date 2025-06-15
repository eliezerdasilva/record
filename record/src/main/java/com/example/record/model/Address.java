package com.example.record.model;



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
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private int cep;
	@NotBlank
	@NotNull
	private String state;
	@NotBlank
	@NotNull
	private String city;
	@NotBlank
	@NotNull
	private String neighborhood;
	@NotBlank
	@NotNull
	private String road;
	@NotBlank
	@NotNull
	private String houseNumber;
}
