package com.example.record.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.record.dtos.DriverDto;

import com.example.record.mapper.DriverMapper;

import com.example.record.model.Driver;

import com.example.record.repository.DriverRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class DriverService {
	@Autowired
	private final DriverRepository driverRepository;
	@Autowired
	private final DriverMapper driverMapper;

	public DriverService(DriverRepository driverRepository, DriverMapper driverMapper) {
		this.driverRepository = driverRepository;
		this.driverMapper = driverMapper;
	}

	public DriverDto getDriverId(Long id) {
		if (id < 0) {
			throw new IllegalArgumentException("ID inválido");
		}
		Optional<Driver> driver = driverRepository.findById(id);
		if (!driver.isPresent()) {
			throw new IllegalArgumentException("Não ha registro");
		}
		return driverMapper.toDto(driver.get());
	}

	public List<DriverDto> getAllDriver() {
		List<Driver> driveres = driverRepository.findAll();
		return driveres.stream().map(driverMapper::toDto).collect(Collectors.toList());
	}

	public DriverDto createDriver(DriverDto driverDto) {
		Driver driver = driverMapper.toEntity(driverDto);
		Driver saved = driverRepository.save(driver);

		return driverMapper.toDto(saved);
	}

	public void deleteDriver(Long id) {
		Driver driver = driverRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Motorista não encontrado"));
		driverRepository.delete(driver);

	}

	public DriverDto updateDriver(Long id, @Valid DriverDto driverDto) {
		driverRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Motorista não encontrado"));
		driverDto.setId(id);
		DriverDto newDriver = driverMapper.toDto(driverRepository.save(driverMapper.toEntity(driverDto)));
		return newDriver;
	}
}
