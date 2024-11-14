package com.hexaware.simplifly.entities;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AdminActions")
public class AdminAction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actionId;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private User admin;

    @Column(nullable = false, length = 50)
    private String actionType;

    @Column
    private String actionDetails;

    @Column(nullable = false)
    private LocalDateTime actionTimestamp = LocalDateTime.now();
	
    public AdminAction(int actionId, User admin, String actionType, String actionDetails,
			LocalDateTime actionTimestamp) {
		super();
		this.actionId = actionId;
		this.admin = admin;
		this.actionType = actionType;
		this.actionDetails = actionDetails;
		this.actionTimestamp = actionTimestamp;
	}

	@Override
	public String toString() {
		return "AdminAction [actionId=" + actionId + ", actionType=" + actionType + ", actionDetails=" + actionDetails
				+ ", actionTimestamp=" + actionTimestamp + "]";
	}

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getActionDetails() {
		return actionDetails;
	}

	public void setActionDetails(String actionDetails) {
		this.actionDetails = actionDetails;
	}

	public LocalDateTime getActionTimestamp() {
		return actionTimestamp;
	}

	public void setActionTimestamp(LocalDateTime actionTimestamp) {
		this.actionTimestamp = actionTimestamp;
	}

	
}
