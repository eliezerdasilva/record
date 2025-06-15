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

import com.example.record.dtos.DriverDto;
import com.example.record.service.DriverService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/driver")
public class DriverController {
	@Autowired
	private final DriverService driverService;
	
	
	public DriverController(DriverService driverService) {
		this.driverService = driverService;
	}
	
	@GetMapping(value = "/getall")
	@ResponseBody
	public  ResponseEntity<List<DriverDto>> getAllDrivers(){
		return ResponseEntity.ok(driverService.getAllDriver());
	}
	@PostMapping
	@ResponseBody
	public ResponseEntity<DriverDto> create(@RequestBody @Valid DriverDto DriverDto) {
		try {
            DriverDto created = driverService.createDriver(DriverDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DriverDto> getIdDriver(@PathVariable Long id)	{
		DriverDto DriverDto = driverService.getDriverId(id);
		if (DriverDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(DriverDto);
	}
	@PutMapping("/{id}")
	public ResponseEntity<DriverDto> updateDriver(@PathVariable Long id, @RequestBody @Valid DriverDto DriverDto) {
		try {
			DriverDto updated = driverService.updateDriver(id, DriverDto);
			return ResponseEntity.ok(updated);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@DeleteMapping(path = "{id}" )
	public ResponseEntity<String> deleteDriver(@PathVariable Long id) {
		 try {
		        driverService.deleteDriver(id);
		        return ResponseEntity.ok("Motorista deletado com sucesso!");
		    } catch (EntityNotFoundException e) {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Motorista não encontrado.");
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o Motorista.");
		    }
	}
}
