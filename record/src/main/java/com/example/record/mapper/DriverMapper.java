package com.example.record.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.record.dtos.DriverDto;
import com.example.record.model.Driver;

@Mapper(componentModel = "spring")
public interface DriverMapper {
	DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);

	DriverDto toDto(Driver driver);

    Driver toEntity(DriverDto driverDtooductDto);
}
