package com.project.cabBooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cabBooking.model.CabBooking;

public interface CabRepo extends JpaRepository<CabBooking, Long> {
	
	  
	}


