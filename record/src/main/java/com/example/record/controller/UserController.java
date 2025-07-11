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

import com.example.record.dtos.UserDto;
import com.example.record.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
	@Autowired
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/getall")
	@ResponseBody
	public  ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUser());
	}
	@PostMapping
	@ResponseBody
	public ResponseEntity<UserDto> create(@RequestBody @Valid UserDto UserDto) {
		try {
            UserDto created = userService.createUser(UserDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getIdUser(@PathVariable Long id)	{
		UserDto UserDto = userService.getUserId(id);
		if (UserDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(UserDto);
	}
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto UserDto) {
		try {
			UserDto updated = userService.updateUser(id, UserDto);
			return ResponseEntity.ok(updated);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@DeleteMapping(path = "{id}" )
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		 try {
		        userService.deleteUser(id);
		        return ResponseEntity.ok("Usuário deletado com sucesso!");
		    } catch (EntityNotFoundException e) {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o Usuário.");
		    }
	}
}
