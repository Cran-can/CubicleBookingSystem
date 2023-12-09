package com.capgemini.seatbooking.entity;

import java.time.LocalDateTime;

import com.capgemini.seatbooking.util.BookingStatus;

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

//Booking.java
@Entity
@Table(name = "bookings")
public class Booking {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="booking_id")
 private Long bookingId;

 @ManyToOne
 @JoinColumn(name = "user_id", nullable = false)
 private User user;

 @ManyToOne
 @JoinColumn(name = "seat_id", nullable = false)
 private Seat seat;

 @Column(nullable = false,name="start_time")
 private LocalDateTime startTime;

 @Column(nullable = false,name="end_time")
 private LocalDateTime endTime;

 @Enumerated(EnumType.STRING)
 @Column(nullable = false,name="booking_status")
 private BookingStatus bookingStatus;
 // Constructors, getters, setters...
public Booking() {
	super();
	
}
public Booking(Long bookingId, User user, Seat seat, LocalDateTime startTime, LocalDateTime endTime,
		BookingStatus bookingStatus) {
	super();
	this.bookingId = bookingId;
	this.user = user;
	this.seat = seat;
	this.startTime = startTime;
	this.endTime = endTime;
	this.bookingStatus = bookingStatus;
}
public Long getBookingId() {
	return bookingId;
}
public void setBookingId(Long bookingId) {
	this.bookingId = bookingId;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Seat getSeat() {
	return seat;
}
public void setSeat(Seat seat) {
	this.seat = seat;
}
public LocalDateTime getStartTime() {
	return startTime;
}
public void setStartTime(LocalDateTime startTime) {
	this.startTime = startTime;
}
public LocalDateTime getEndTime() {
	return endTime;
}
public void setEndTime(LocalDateTime endTime) {
	this.endTime = endTime;
}
public BookingStatus getBookingStatus() {
	return bookingStatus;
}
public void setBookingStatus(BookingStatus bookingStatus) {
	this.bookingStatus = bookingStatus;
}
@Override
public String toString() {
	return "Booking [bookingId=" + bookingId + ", user=" + user + ", seat=" + seat + ", startTime=" + startTime
			+ ", endTime=" + endTime + ", bookingStatus=" + bookingStatus + "]";
}

}
