package com.example.record.mapper;

import org.mapstruct.Mapper;
import com.example.record.dtos.AddressDto;
import com.example.record.model.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDto toDto(Address address);

    Address toEntity(AddressDto addressDto);
}
