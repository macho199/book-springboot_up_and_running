package kr.co.jobkorea.planefinder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.jobkorea.planefinder.dto.AircraftDTO;

@RestController
@RequestMapping("/")
public class Aircraft {
    @GetMapping("aircraft")
    public ResponseEntity<?> aircraft() {
        double rnd = Math.random();
        int rndVal = (int)(rnd*1000);
        AircraftDTO dto = AircraftDTO.builder()
            .id(Long.valueOf(rndVal))
            .callsign("callsign" + rndVal)
            .squawk("squawk" + rndVal)
            .reg("reg" + rndVal)
            .flightno("flightno" + rndVal)
            .route("route" + rndVal)
            .type("type" + rndVal)
            .category("category" + rndVal)
            .altitude(rndVal)
            .heading(rndVal)
            .speed(rndVal)
            .vertRate(rndVal)
            .selectedAltitude(rndVal)
            .lat(rndVal)
            .lon(rndVal)
            .barometer(rndVal)
            .polarDistance(rndVal)
            .polarBearing(rndVal)
            .isADSB(true)
            .isOnGround(true)
            .build();
        return ResponseEntity.ok().body(dto);

    }

}
