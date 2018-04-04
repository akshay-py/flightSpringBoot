package com.akshay.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
