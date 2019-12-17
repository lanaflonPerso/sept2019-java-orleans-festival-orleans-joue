package com.wildcodeschool.festivalorleansjoue.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Agent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	String firstName;
	String lastName;
	String mail;
	String phone;
	boolean gardenParty;
	boolean accommodation;
	@ManyToMany(cascade = CascadeType.ALL ,mappedBy = "agents")
	private List<Registration> registrations = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "society_id")
	private Society society;
	
		
	public Agent() {
	}


	public Long getId() {
		return this.id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return this.firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return this.lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMail() {
		return this.mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPhone() {
		return this.phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public boolean isGardenParty() {
		return this.gardenParty;
	}


	public void setGardenParty(boolean gardenParty) {
		this.gardenParty = gardenParty;
	}


	public boolean isAccommodation() {
		return this.accommodation;
	}


	public void setAccommodation(boolean accommodation) {
		this.accommodation = accommodation;
	}


	public List<Registration> getRegistrations() {
		return registrations;
	}


	public void setRegistration(List<Registration> registrations) {
		this.registrations = registrations;
	}


	public Society getSociety() {
		return this.society;
	}


	public void setSociety(Society society) {
		this.society = society;
	}
}
