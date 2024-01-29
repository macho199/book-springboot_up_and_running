package com.example.planefinderpostgre.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 식별자가 기본 데이터베이스 엔진에 의해 생성될 것이다.
    private Long id;
    
    private String callsign, squawk, reg, flightno, route, type, category;
    private int altitude, heading, speed;
    @JsonProperty("vert_rate")
    @Column(name = "vert_rate")
    private int vertRate;
    @JsonProperty("selected_altitude")
    @Column(name = "selected_altitude")
    private int selectedAltitude;
    private double lat, lon, barometer;
    @JsonProperty("polar_distance")
    @Column(name = "polar_distance")
    private double polarDistance;
    @JsonProperty("polar_bearing")
    @Column(name = "polar_bearing")
    private double polarBearing;
    @JsonProperty("is_adsb")
    @Column(name = "is_adsb")
    private boolean isADSB;
    @JsonProperty("is_on_ground")
    @Column(name = "is_on_ground")
    private boolean isOnGround;
    @JsonProperty("last_seen_time")
    @Column(name = "last_seen_time")
    private Instant lastSeenTime;
    @JsonProperty("pos_update_time")
    @Column(name = "pos_update_time")
    private Instant posUpdateTime;
    @JsonProperty("bds40_seen_time")
    @Column(name = "bds40_seen_time")
    private Instant bds40SeenTime;
}
