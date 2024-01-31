package kr.co.jobkorea.aircraftpositions.controller;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import kr.co.jobkorea.aircraftpositions.model.Aircraft;
import kr.co.jobkorea.aircraftpositions.repository.AircraftRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PositionController {
    @NonNull
    private final AircraftRepository repository;

    @GetMapping("/aircraft")
    public String getCurrentAircraftPositions(Model model) {
        model.addAttribute("currentPositions", repository.findAll());
        return "positions";
    }
}
