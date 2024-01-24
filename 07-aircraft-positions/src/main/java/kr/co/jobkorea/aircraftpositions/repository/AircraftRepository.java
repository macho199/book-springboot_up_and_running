package kr.co.jobkorea.aircraftpositions.repository;

import org.springframework.data.repository.CrudRepository;

import kr.co.jobkorea.aircraftpositions.model.Aircraft;

public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
    
}
