package com.example.record.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.record.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	//Optional<User> findByUserName(String username) ;
		
		
	

}
