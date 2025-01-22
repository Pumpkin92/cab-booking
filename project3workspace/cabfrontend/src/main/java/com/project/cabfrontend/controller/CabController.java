package com.project.cabfrontend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.project.cabfrontend.model.CabBooking;

@Controller
public class CabController {
private final String BOOKING_SERVICE_URL = "http://localhost:8081/api/cab";
private final String FARE_SERVICE_URL = "http://localhost:8082/api/fare";

    @GetMapping("/")
    public String homePage() {
        return "index"; 
    }
    @GetMapping("/book")
    public String bookCabForm(Model model) {
        model.addAttribute("cabBooking", new CabBooking());
        return "booking-form"; 
    }

    
    @PostMapping("/book")
    public String bookCab(@ModelAttribute CabBooking cabBooking, Model model) {
        try {
        	RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<CabBooking> response = restTemplate.postForEntity(BOOKING_SERVICE_URL + "/book", cabBooking, CabBooking.class);
            model.addAttribute("message", "Cab booked successfully! Booking ID: " + response.getBody().getId());
        } catch (Exception e) {
            model.addAttribute("message", "Error booking cab. Please try again.");
        }
        return "booking-form"; 
    }

    @GetMapping("/fare")
    public String fareForm() {
        return "fare-form"; 
    }

    @PostMapping("/calculate-fare")
    public String calculateFare(@ModelAttribute("distance") double distance, Model model) {
        try {
    	RestTemplate restTemplate = new RestTemplate();
        String fare = restTemplate.getForObject(FARE_SERVICE_URL + "/calculate?distance=" + distance, String.class);
        model.addAttribute("fare", fare);
       }
        catch(Exception e) {
        	model.addAttribute("message", "Error calculating fare. Please try again.");
        }
        return "fare-form"; 
    }
}
