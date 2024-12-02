package com.hexaware.simplifly.dto;

public class FlightDTO {
    private int flightId;
    private String flightName;
    private String flightNumber;
    private int ownerId;
    private int totalSeats;
    private int baggageLimit;
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getBaggageLimit() {
		return baggageLimit;
	}
	public void setBaggageLimit(int baggageLimit) {
		this.baggageLimit = baggageLimit;
	}

    
    
}
