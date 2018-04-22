package com.akshay.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.flightreservation.dto.ReservationUpdateRequest;
import com.akshay.flightreservation.entities.Reservation;
import com.akshay.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	@Autowired
	ReservationRepository reservationRepo;

	@RequestMapping(value = "/reservations/{id}", method = RequestMethod.GET)
	public @ResponseBody Reservation findReservation(@PathVariable("id") Long id) {
		Reservation reservation = reservationRepo.findById(id).get();
		return reservation;
	}

	@RequestMapping(value = "/reservations", method = RequestMethod.PUT)
	public @ResponseBody Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepo.findById(request.getId()).get();
		reservation.setCheckdIn(Boolean.TRUE);
		reservation.setNumberOfBags(request.getNumberOfBags());
		Reservation savedReservation = reservationRepo.save(reservation);
		return savedReservation;
	}
}
