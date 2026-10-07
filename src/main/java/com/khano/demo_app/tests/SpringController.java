package com.khano.demo_app.tests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
    @GetMapping("/")
    public String getHome() {
        return "Get Home Page";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "Get About Page";
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return "Get Workout Auto Page";
    }
}
