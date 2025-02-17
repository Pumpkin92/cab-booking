package com.project.cabFare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fare")
public class FareController {

    private final double FARE_RATE_PER_KM = 2.5; 

    @GetMapping("/calculate")
    public String calculateFare(@RequestParam double distance) {
        double fare = distance * FARE_RATE_PER_KM;
        return "Estimated Fare: £" + fare;
    }
}
