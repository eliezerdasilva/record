package com.example.record.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.record.dtos.RegistryDto;
import com.example.record.service.RegistryService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/registry")
public class RegistryController {
	@Autowired
	private final RegistryService registryService;

	public RegistryController(RegistryService registryService) {
		this.registryService = registryService;
	}

	@GetMapping(value = "/getall")
	@ResponseBody
	public ResponseEntity<List<RegistryDto>> getAllRegistrys() {
		return ResponseEntity.ok(registryService.getAllRegistry());
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<RegistryDto> create(@RequestBody @Valid RegistryDto RegistryDto) {
		try {
			RegistryDto created = registryService.createRegistry(RegistryDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(created);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<RegistryDto> getIdRegistry(@PathVariable Long id) {
		RegistryDto RegistryDto = registryService.getRegistryId(id);
		if (RegistryDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(RegistryDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<RegistryDto> updateRegistry(@PathVariable Long id,
			@RequestBody @Valid RegistryDto RegistryDto) {
		try {
			RegistryDto updated = registryService.updateRegistry(id, RegistryDto);
			return ResponseEntity.ok(updated);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(path = "{id}")
	public ResponseEntity<String> deleteRegistry(@PathVariable Long id) {
		try {
			registryService.deleteRegistry(id);
			return ResponseEntity.ok("Motorista deletado com sucesso!");
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Motorista não encontrado.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o Motorista.");
		}
	}
}
