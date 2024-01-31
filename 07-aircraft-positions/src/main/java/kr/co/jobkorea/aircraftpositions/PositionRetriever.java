package kr.co.jobkorea.aircraftpositions;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.jobkorea.aircraftpositions.model.Aircraft;
import kr.co.jobkorea.aircraftpositions.repository.AircraftRepository;

import java.util.List;
import java.util.function.Consumer;

@AllArgsConstructor
@Configuration
public class PositionRetriever {
    private final AircraftRepository repo;

    @Bean
    Consumer<List<Aircraft>> retrieveAircraftPositions() {
        return acList -> {
            repo.deleteAll();
            repo.saveAll(acList);
            repo.findAll().forEach(System.out::println);
        };

    }
    
}
