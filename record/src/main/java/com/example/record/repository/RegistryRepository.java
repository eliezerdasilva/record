package com.example.record.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.record.model.Registry;
@Repository
public interface RegistryRepository extends JpaRepository<Registry, Long> {

}
