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
@Table(name = "offices")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_id")
    private Long officeId;
    
    @Column(nullable = false,name="office_name")
    private String officeName;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private List<Floor> floors;

 // Constructors, getters, setters...
	public Office() {
		super();
		// TODO Auto-generated constructor stub
	}

public Office(Long officeId, String officeName, Location location, List<Floor> floors) {
	super();
	this.officeId = officeId;
	this.officeName = officeName;
	this.location = location;
	this.floors = floors;
}

public Long getOfficeId() {
	return officeId;
}

public void setOfficeId(Long officeId) {
	this.officeId = officeId;
}

public String getOfficeName() {
	return officeName;
}

public void setOfficeName(String officeName) {
	this.officeName = officeName;
}

public Location getLocation() {
	return location;
}

public void setLocation(Location location) {
	this.location = location;
}

public List<Floor> getFloors() {
	return floors;
}

public void setFloors(List<Floor> floors) {
	this.floors = floors;
}

@Override
public String toString() {
	return "Office [officeId=" + officeId + ", officeName=" + officeName + ", location=" + location + ", floors="
			+ floors + "]";
}

    
}