package com.example.record.service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.record.dtos.AddressDto;
import com.example.record.mapper.AddressMapper;
import com.example.record.model.Address;
import com.example.record.repository.AddressRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class AddressService {
	@Autowired
	private final AddressRepository addressRepository;
	@Autowired
	private final AddressMapper addressMapper;

	public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
		super();
		this.addressRepository = addressRepository;
		this.addressMapper = addressMapper;
	}

	public AddressDto getAddressId(long id) {
		if (id < 0) {
			throw new IllegalArgumentException("ID inválido");
		}
		Optional<Address> address = addressRepository.findById(id);
		if (!address.isPresent()) {
			throw new EntityNotFoundException("Não ha registro");
		}
		return addressMapper.toDto(address.get());
	}

	public AddressDto createAddress(AddressDto addressDto) {
		Address address = addressMapper.toEntity(addressDto);
		Address savedAddress = addressRepository.save(address);

		return addressMapper.toDto(savedAddress);
	}

	public List<AddressDto> getAllAddresses() {
		List<Address> addresses = addressRepository.findAll();
		return addresses.stream().map(addressMapper::toDto).collect(Collectors.toList());
	}

	public AddressDto updateAddress(Long id, @Valid AddressDto addressDto) {
		addressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado"));
		AddressDto addressDto2 = addressMapper.toDto(addressRepository.save(addressMapper.toEntity(addressDto)));
		return addressDto2;
	}

	public void deleteAddress(Long id) {

		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado"));
		addressRepository.delete(address);

	}

}
