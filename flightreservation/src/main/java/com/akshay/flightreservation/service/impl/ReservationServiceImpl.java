package com.akshay.flightreservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.flightreservation.dto.ReservationRequest;
import com.akshay.flightreservation.entities.Flight;
import com.akshay.flightreservation.entities.Passenger;
import com.akshay.flightreservation.entities.Reservation;
import com.akshay.flightreservation.repos.FlightRepository;
import com.akshay.flightreservation.repos.PassengerRepository;
import com.akshay.flightreservation.repos.ReservationRepository;
import com.akshay.flightreservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepo;

	@Autowired
	PassengerRepository passengerRepo;

	@Autowired
	ReservationRepository reservationRepo;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		// Make Payment

		Long flightId = request.getFlightId();
		Flight flight = flightRepo.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger = passengerRepo.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckdIn(false);
		Reservation savedReservation = reservationRepo.save(reservation);

		return savedReservation;
	}

}
