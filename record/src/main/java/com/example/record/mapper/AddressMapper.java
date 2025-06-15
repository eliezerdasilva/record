package com.example.record.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.record.dtos.AddressDto;
import com.example.record.model.Address;


@Mapper(componentModel = "spring")
public interface AddressMapper {
	AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDto toDto(Address address);

    Address toEntity(AddressDto addressDto);
}
