package com.thehecklers.planefinderapidemo;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.thehecklers.planefinderapidemo.repository.AircraftRepository;
import com.thehecklers.sburredis.Aircraft;

@EnableScheduling
@Component
public class PlaneFinderPoller {
    private WebClient client = WebClient.create("http://localhost:7634/aircraft");

    private final RedisConnectionFactory connectionFactory;
    //private final RedisOperations<String, Aircraft> redisOperations;
    private final AircraftRepository repository;

    PlaneFinderPoller(RedisConnectionFactory connectionFactory, AircraftRepository repository) {
        this.connectionFactory = connectionFactory;
        this.repository = repository;
    }

    @Scheduled(fixedRate = 1000)
    private void pollPlanes() {
        connectionFactory.getConnection().serverCommands().flushDb();

        client.get()
            .retrieve()
            .bodyToFlux(Aircraft.class)
            .filter(plane -> !plane.getReg().isEmpty())
            .toStream()
            .forEach(repository::save);
        
        repository.findAll().forEach(System.out::println);
    }
}
