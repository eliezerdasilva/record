package com.example.record.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.record.model.Registry;

public interface RegistryRepository extends JpaRepository<Registry, Long> {

}
