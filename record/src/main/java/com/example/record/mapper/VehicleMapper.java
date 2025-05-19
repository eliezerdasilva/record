package com.example.record.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.record.dtos.VehicleDto;
import com.example.record.model.Vehicle;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
	VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

	VehicleDto toDto(Vehicle vehicle);

	Vehicle toEntity(VehicleDto vehicleDto);
}
