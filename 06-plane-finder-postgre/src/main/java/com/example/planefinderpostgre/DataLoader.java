package com.example.planefinderpostgre;

import java.time.Instant;

import org.springframework.stereotype.Component;

import com.example.planefinderpostgre.model.Aircraft;
import com.example.planefinderpostgre.repository.AircraftRepository;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataLoader {
    private final AircraftRepository repository;

    @PostConstruct
    private void loadData() {
        System.out.println("loaddata 실행");
        repository.deleteAll();

        repository.save(new Aircraft(81L, "AAL608", "1451", "N754UW", "AA608", "IND-PHX", "A319", "A3", 36000, 255, 423, 0, 36000, 39.150284, -90.684795, 1012.8, 26.575562, 295.501994, true, false, Instant.parse("2020-11-27T21:29:35Z"), Instant.parse("2020-11-27T21:29:34Z"), Instant.parse("2020-11-27T21:29:27Z")));
    }
}
