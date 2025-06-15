package com.example.record.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.record.dtos.RegistryDto;
import com.example.record.mapper.RegistryMapper;
import com.example.record.model.Registry;
import com.example.record.repository.RegistryRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class RegistryService {
	@Autowired
	private final RegistryRepository registryRepository;
	@Autowired
	private final RegistryMapper registryMapper;

	public RegistryService(RegistryRepository registryRepository, RegistryMapper registryMapper) {
		this.registryRepository = registryRepository;
		this.registryMapper = registryMapper;
	}

	public RegistryDto getRegistryId(Long id) {
		if (id < 0) {
			throw new IllegalArgumentException("ID inválido");
		}
		Optional<Registry> Registry = registryRepository.findById(id);
		if (!Registry.isPresent()) {
			throw new IllegalArgumentException("Não ha registro");
		}
		return registryMapper.toDto(Registry.get());
	}

	public List<RegistryDto> getAllRegistry() {
		List<Registry> registries = registryRepository.findAll();
		return registries.stream().map(registryMapper::toDto).collect(Collectors.toList());
	}

	public RegistryDto createRegistry(RegistryDto RegistryDto) {
		Registry Registry = registryMapper.toEntity(RegistryDto);
		Registry saved = registryRepository.save(Registry);

		return registryMapper.toDto(saved);
	}

	public void deleteRegistry(Long id) {
		Registry Registry = registryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Registro não encontrado"));
		registryRepository.delete(Registry);

	}

	public RegistryDto updateRegistry(Long id, @Valid RegistryDto registryDto) {
		registryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro não encontrado"));
		registryDto.setId(id);
		RegistryDto newRegistry = registryMapper.toDto(registryRepository.save(registryMapper.toEntity(registryDto)));
		return newRegistry;
	}
}
