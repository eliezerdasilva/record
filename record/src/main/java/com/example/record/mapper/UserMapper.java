package com.example.record.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.record.dtos.UserDto;
import com.example.record.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserDto toDto(User user);

	User toEntity(UserDto UserDto);
}
