package com.project.cabBooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cabBooking.model.CabBooking;
import com.project.cabBooking.repo.CabRepo;

@Service
public class CabBookingService {

    @Autowired
    private CabRepo cabRepo;

    public CabBooking saveBooking(CabBooking cabBooking) {
        return cabRepo.save(cabBooking);
    }

    public List<CabBooking> getAllBookings() {
        return cabRepo.findAll();
    }
}
