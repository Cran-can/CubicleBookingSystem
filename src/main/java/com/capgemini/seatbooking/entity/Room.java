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

//Room.java
@Entity
@Table(name = "rooms")
public class Room {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "room_id")
 private Long roomId;

 @ManyToOne
 @JoinColumn(name = "floor_id", nullable = false)
 private Floor floor;

 @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
 private List<Seat> seats;

 @Column(nullable = false,name = "seatingCapacity")
 private int seatingCapacity;

//Constructors, getters, setters...
public Room() {
	super();
	// TODO Auto-generated constructor stub
}

public Room(Long roomId, Floor floor, List<Seat> seats, int seatingCapacity) {
	super();
	this.roomId = roomId;
	this.floor = floor;
	this.seats = seats;
	this.seatingCapacity = seatingCapacity;
}

public Long getRoomId() {
	return roomId;
}

public void setRoomId(Long roomId) {
	this.roomId = roomId;
}

public Floor getFloor() {
	return floor;
}

public void setFloor(Floor floor) {
	this.floor = floor;
}

public List<Seat> getSeats() {
	return seats;
}

public void setSeats(List<Seat> seats) {
	this.seats = seats;
}

public int getSeatingCapacity() {
	return seatingCapacity;
}

public void setSeatingCapacity(int seatingCapacity) {
	this.seatingCapacity = seatingCapacity;
}

@Override
public String toString() {
	return "Room [roomId=" + roomId + ", floor=" + floor + ", seats=" + seats + ", seatingCapacity=" + seatingCapacity
			+ "]";
}
 
 
}
