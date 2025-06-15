package com.example.record.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import com.example.record.dtos.RegistryDto;

import com.example.record.model.Registry;

@Mapper(componentModel = "spring")
public interface RegistryMapper {
	RegistryMapper INSTANCE = Mappers.getMapper(RegistryMapper.class);

	RegistryDto toDto(Registry registry);

	Registry toEntity(RegistryDto registryDtooductDto);
}
