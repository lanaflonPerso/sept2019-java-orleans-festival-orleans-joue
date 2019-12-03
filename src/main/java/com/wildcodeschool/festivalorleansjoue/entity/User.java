package com.wildcodeschool.festivalorleansjoue.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class User {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	private String firstname;
	private String lastname;	
	@OneToOne(cascade = CascadeType.ALL)
    @MapsId
	private Address address;
	
	
	public User() {
		
	}
	

	public Long getId() {
		
		return this.id;
	}
	

	public void setId(Long id) {
		
		this.id = id;
	}
	

	public String getEmail() {
		
		return this.email;
	}
	

	public void setEmail(String email) {
		
		this.email = email;
	}
	

	public String getPassword() {
		
		return this.password;
	}
	

	public void setPassword(String password) {
		
		this.password = password;
	}

	public String getFirstname() {
		
		return this.firstname;
	}
	

	public void setFirstname(String firstname) {
		
		this.firstname = firstname;
	}
	

	public String getLastname() {
		
		return this.lastname;
	}
	

	public void setLastname(String lastname) {
		
		this.lastname = lastname;
	}
	

	public Address getAddress() {
		
		return this.address;
	}
	

	public void setAddress(Address address) {
		
		this.address = address;
	}

}
