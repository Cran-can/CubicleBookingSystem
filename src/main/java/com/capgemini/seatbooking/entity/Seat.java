package com.capgemini.seatbooking.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long seatId;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @Column(nullable = false,name="is_booked")
    private boolean isBooked;

 // Constructors, getters, setters...
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seat(Long seatId, Room room, List<Booking> bookings, boolean isBooked) {
		super();
		this.seatId = seatId;
		this.room = room;
		this.bookings = bookings;
		this.isBooked = isBooked;
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", room=" + room + ", bookings=" + bookings + ", isBooked=" + isBooked + "]";
	}
    
    
}