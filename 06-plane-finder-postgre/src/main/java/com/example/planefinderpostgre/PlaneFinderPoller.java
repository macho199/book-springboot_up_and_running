package com.example.planefinderpostgre;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.planefinderpostgre.model.Aircraft;
import com.example.planefinderpostgre.repository.AircraftRepository;

import io.micrometer.common.lang.NonNull;
import lombok.RequiredArgsConstructor;

@EnableScheduling
@Component
@RequiredArgsConstructor
public class PlaneFinderPoller {
    
    @NonNull
    private final AircraftRepository repository;
    private WebClient client = WebClient.create("http://localhost:7634/aircraft");

    @Scheduled(fixedRate = 1000)
    private void pollPlanes() {
        // repository.deleteAll();

        // client.get()
        //     .retrieve()
        //     .bodyToFlux(Aircraft.class)
        //     .filter(plane -> !plane.getReg().isEmpty())
        //     .toStream()
        //     .forEach(repository::save);
        
        repository.findAll().forEach(System.out::println);
    }
}
