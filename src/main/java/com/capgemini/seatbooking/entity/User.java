package com.capgemini.seatbooking.entity;

import java.util.List;

import com.capgemini.seatbooking.util.UserType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	@Column(nullable=false)
	private String username;
	@Column(nullable = false, unique=true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "user_type")
    private UserType userType;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> bookings;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String username, String email, String password, UserType userType,
			List<Booking> bookings) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.bookings = bookings;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", userType=" + userType + ", bookings=" + bookings + "]";
	}
	
}