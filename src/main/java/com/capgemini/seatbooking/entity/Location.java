package com.capgemini.seatbooking.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    @Column(nullable = false,name="location_name")
    private String locationName;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Office> offices;

 // Constructors, getters, setters...
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

public Location(Long locationId, String locationName, List<Office> offices) {
	super();
	this.locationId = locationId;
	this.locationName = locationName;
	this.offices = offices;
}

public Long getLocationId() {
	return locationId;
}

public void setLocationId(Long locationId) {
	this.locationId = locationId;
}

public String getLocationName() {
	return locationName;
}

public void setLocationName(String locationName) {
	this.locationName = locationName;
}

public List<Office> getOffices() {
	return offices;
}

public void setOffices(List<Office> offices) {
	this.offices = offices;
}

@Override
public String toString() {
	return "Location [locationId=" + locationId + ", locationName=" + locationName + ", offices=" + offices + "]";
}

    
}
