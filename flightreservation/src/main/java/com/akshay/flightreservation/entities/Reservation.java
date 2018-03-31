package com.akshay.flightreservation.entities;

public class Reservation {
	private Long id;
	private Boolean checkdIn;
	private int numberOfBags;
	private Passenger passenger;
	private Flight flight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getCheckdIn() {
		return checkdIn;
	}

	public void setCheckdIn(Boolean checkdIn) {
		this.checkdIn = checkdIn;
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
