package com.example.sburrestdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sburrestdemo.model.Droid;

@RestController
@RequestMapping("/droid")
public class DroidController {

    private final Droid droid;

    public DroidController(Droid droid) {
        this.droid = droid;
    }

    @GetMapping
    String getId() {
        return droid.getId();
    }

    @GetMapping("/description")
    String getDescription() {
        return droid.getDescription();
    }
}
