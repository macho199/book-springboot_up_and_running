package com.example.planefinder.controllers;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.planefinder.models.Aircraft;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {
    
    @GetMapping
    public ResponseEntity<Aircraft> index() {
        Aircraft aircraft = new Aircraft();
        aircraft.setId(1L);
        aircraft.setCallsign("callsign");
        aircraft.setSquawk("squawk");
        aircraft.setReg("reg");
        aircraft.setFlightno("flightno");
        aircraft.setRoute("route");
        aircraft.setType("type");
        aircraft.setCategory("category");
        aircraft.setAltitude(10);
        aircraft.setHeading(20);
        aircraft.setSpeed(40);
        aircraft.setVertRate(66);

        aircraft.setLastSeenTime(Instant.ofEpochSecond(0));
        aircraft.setPosUpdateTime(Instant.ofEpochSecond(0));
        aircraft.setBds40SeenTime(Instant.ofEpochSecond(0));

        return ResponseEntity.ok().body(aircraft);
    }
}
