package com.wildcodeschool.festivalorleansjoue.entity;

import java.util.ArrayList;
import java.util.List;

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
	@ManyToMany(mappedBy = "agents")
	private List<Agent> agents = new ArrayList<>();
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


	public Society getSociety() {
		return this.society;
	}


	public void setSociety(Society society) {
		this.society = society;
	}


	
}
