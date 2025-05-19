package com.example.record.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.record.dtos.UserDto;
import com.example.record.mapper.UserMapper;
import com.example.record.model.User;
import com.example.record.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class UserService {
	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final UserMapper userMapper;

	public UserService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	public UserDto getUserId(Long id) {
		if (id < 0) {
			throw new IllegalArgumentException("ID inválido");
		}
		Optional<User> User = userRepository.findById(id);
		if (!User.isPresent()) {
			throw new IllegalArgumentException("Não ha registro");
		}
		return userMapper.toDto(User.get());
	}

	public List<UserDto> getAllUser() {
		List<User> users = userRepository.findAll();
		return users.stream().map(userMapper::toDto).collect(Collectors.toList());
	}

	public UserDto createUser(UserDto UserDto) {
		User user = userMapper.toEntity(UserDto);
		User saved = userRepository.save(user);

		return userMapper.toDto(saved);
	}

	public void deleteUser(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
		userRepository.delete(user);

	}

	public UserDto updateUser(Long id, @Valid UserDto userDto) {
		userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
		userDto.setId(id);
		UserDto newUser = userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
		return newUser;
	}
}
