package com.khano.demo_app.tests;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {

    @Value("${dev.name}")
    private String developerName;

    @Value("${dev.occupation}")
    private String developerOccupation;

    @GetMapping("/")
    public String getHome() {
        return "Get Home Page";
    }

    @GetMapping("/info")
    public String getInfo() {
        return "developer: " + this.developerName + ", occupation: " + developerOccupation;
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return "Get Workout Auto Page";
    }
}
