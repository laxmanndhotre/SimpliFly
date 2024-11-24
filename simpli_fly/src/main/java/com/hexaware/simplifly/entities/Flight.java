package com.hexaware.simplifly.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Flights")
public class Flight {
	
	public Flight()
	{	
		
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;

    @NotBlank(message = "Flight name is mandatory")
    @Size(max = 100, message = "Flight name must be less than 100 characters")
    @Column(nullable = false, length = 100)
    private String flightName;

    @NotBlank(message = "Flight number is mandatory")
    @Size(max = 20, message = "Flight number must be less than 20 characters")
    @Column(nullable = false, length = 20)
    private String flightNumber;

    @NotNull(message = "Owner ID is mandatory")
    @Column(nullable = false)
    private int ownerId;

    @NotNull(message = "Total seats are mandatory")
    @Min(value = 1, message = "Total seats must be at least 1")
    @Column(nullable = false)
    private int totalSeats;

    @Min(value = 0, message = "Baggage limit cannot be negative")
    private int baggageLimit;

    @NotNull(message = "Creation date is mandatory")
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Flight [flightId=" + flightId + ", flightName=" + flightName + ", flightNumber=" + flightNumber
                + ", ownerId=" + ownerId + ", totalSeats=" + totalSeats + ", baggageLimit=" + baggageLimit
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    public Flight(int flightId, String flightName, String flightNumber, int ownerId, int totalSeats, int baggageLimit,
                  LocalDateTime createdAt, LocalDateTime updatedAt) {
        super();
        this.flightId = flightId;
        this.flightName = flightName;
        this.flightNumber = flightNumber;
        this.ownerId = ownerId;
        this.totalSeats = totalSeats;
        this.baggageLimit = baggageLimit;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}
