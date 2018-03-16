package com.akshay.flightcheckin.integration.dto;

public class Reservation {
	private Long reservationId;
	private Boolean checkedIn;
	private int numberOfBags;
	private Passenger passenger;
	private Flight flight;

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long id) {
		this.reservationId = id;
	}

	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
