package com.project.cabBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cabBooking.model.CabBooking;
import com.project.cabBooking.service.CabBookingService;



@RestController
@RequestMapping("/api/cab")
public class CabBookingController {

    @Autowired
    private CabBookingService cabBookingService;

    @PostMapping("/book")
    public CabBooking bookCab(@RequestBody CabBooking cabBooking) {
        return cabBookingService.saveBooking(cabBooking);
    }

    @GetMapping("/list")
    public List<CabBooking> getAllBookings() {
        return cabBookingService.getAllBookings();
    }
}
