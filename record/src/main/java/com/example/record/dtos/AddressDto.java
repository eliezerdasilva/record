package com.example.record.dtos;

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
public class AddressDto {
	
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
