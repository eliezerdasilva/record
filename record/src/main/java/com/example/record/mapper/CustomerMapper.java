package com.example.record.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.record.dtos.CustomerDto;
import com.example.record.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto toDto(Customer customer);

    Customer toEntity(CustomerDto customerDtooductDto);

}
