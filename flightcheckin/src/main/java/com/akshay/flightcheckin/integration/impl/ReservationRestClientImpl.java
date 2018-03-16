package com.akshay.flightcheckin.integration.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.akshay.flightcheckin.integration.ReservationRestClient;
import com.akshay.flightcheckin.integration.dto.Reservation;
import com.akshay.flightcheckin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {
	private static String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL + id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest reservationUpdateRequest) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL, reservationUpdateRequest, Reservation.class);
		return reservation;
	}

}
