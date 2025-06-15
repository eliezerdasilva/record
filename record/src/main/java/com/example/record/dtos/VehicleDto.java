package com.example.record.dtos;

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
public class VehicleDto {
	@Id
	private Long id; 
	@NotBlank
    @NotNull
	private String plate;
	@NotBlank
    @NotNull
	private String renavam;
	@NotBlank
    @NotNull
	private String nameVehicle; 
}
