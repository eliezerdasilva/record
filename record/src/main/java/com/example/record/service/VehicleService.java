package com.example.record.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.record.dtos.VehicleDto;
import com.example.record.mapper.VehicleMapper;
import com.example.record.model.Vehicle;
import com.example.record.repository.VehicleRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class VehicleService {
	@Autowired
	private final VehicleRepository vehicleRepository;
	@Autowired
	private final VehicleMapper vehicleMapper;

	public VehicleService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
		this.vehicleRepository = vehicleRepository;
		this.vehicleMapper = vehicleMapper;
	}

	public VehicleDto getVehicleId(Long id) {
		if (id < 0) {
			throw new IllegalArgumentException("ID inválido");
		}
		Optional<Vehicle> Vehicle = vehicleRepository.findById(id);
		if (!Vehicle.isPresent()) {
			throw new IllegalArgumentException("Não ha registro");
		}
		return vehicleMapper.toDto(Vehicle.get());
	}

	public List<VehicleDto> getAllVehicle() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		return vehicles.stream().map(vehicleMapper::toDto).collect(Collectors.toList());
	}

	public VehicleDto createVehicle(VehicleDto vehicleDto) {
		Vehicle vehicle = vehicleMapper.toEntity(vehicleDto);
		Vehicle saved = vehicleRepository.save(vehicle);

		return vehicleMapper.toDto(saved);
	}

	public void deleteVehicle(Long id) {
		Vehicle vehicle = vehicleRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado"));
		vehicleRepository.delete(vehicle);

	}

	public VehicleDto updateVehicle(Long id, @Valid VehicleDto vehicleDto) {
		vehicleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado"));
		vehicleDto.setId(id);
		VehicleDto newVehicle = vehicleMapper.toDto(vehicleRepository.save(vehicleMapper.toEntity(vehicleDto)));
		return newVehicle;
	}
}
