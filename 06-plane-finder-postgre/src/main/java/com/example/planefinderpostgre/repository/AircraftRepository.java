package com.example.planefinderpostgre.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.planefinderpostgre.model.Aircraft;

public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
    
}
