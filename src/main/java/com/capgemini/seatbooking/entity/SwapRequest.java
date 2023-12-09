package com.capgemini.seatbooking.entity;

import com.capgemini.seatbooking.util.SwapStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "swap_requests")
public class SwapRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "swap_request_id")
    private Long swapRequestId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name="swap_status")
    private SwapStatus swapStatus;
    
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    public SwapRequest(Long swapRequestId, SwapStatus swapStatus, Booking booking, User targetUser) {
		super();
		this.swapRequestId = swapRequestId;
		this.swapStatus = swapStatus;
		this.booking = booking;
		this.targetUser = targetUser;
	}

	public SwapStatus getSwapStatus() {
		return swapStatus;
	}

	public void setSwapStatus(SwapStatus swapStatus) {
		this.swapStatus = swapStatus;
	}

	@ManyToOne
    @JoinColumn(name = "target_user_id", nullable = false)
    private User targetUser;

 // Constructors, getters, setters...
	public SwapRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SwapRequest(Long swapRequestId, Booking booking, User targetUser) {
		super();
		this.swapRequestId = swapRequestId;
		this.booking = booking;
		this.targetUser = targetUser;
	}

	public Long getSwapRequestId() {
		return swapRequestId;
	}

	public void setSwapRequestId(Long swapRequestId) {
		this.swapRequestId = swapRequestId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public User getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}

	@Override
	public String toString() {
		return "SwapRequest [swapRequestId=" + swapRequestId + ", swapStatus=" + swapStatus + ", booking=" + booking
				+ ", targetUser=" + targetUser + "]";
	}
    
    
}