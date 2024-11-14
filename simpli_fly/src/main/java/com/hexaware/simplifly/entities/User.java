package com.hexaware.simplifly.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(length = 15)
    private String contactNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    public User(String contactNumber, String email, String passwordHash, Role role, int userId, String username) {
        this.contactNumber = contactNumber;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.userId = userId;
        this.username = username;
    }

    public enum Role {
        PASSENGER, FLIGHT_OWNER, ADMIN
    }

    

    public int getUserId() {
        return userId;
    }



    public void setUserId(int userId) {
        this.userId = userId;
    }



    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public String getPasswordHash() {
        return passwordHash;
    }



    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getContactNumber() {
        return contactNumber;
    }



    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }



    public Role getRole() {
        return role;
    }



    public void setRole(Role role) {
        this.role = role;
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

    



    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", passwordHash=" + passwordHash + ", email="
                + email + ", contactNumber=" + contactNumber + ", role=" + role + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "]";
    }



    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

