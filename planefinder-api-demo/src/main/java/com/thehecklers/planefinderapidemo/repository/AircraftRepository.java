package com.thehecklers.planefinderapidemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.thehecklers.sburredis.Aircraft;

public interface AircraftRepository extends CrudRepository<Aircraft, Long> {

}
