package com.wildcodeschool.festivalorleansjoue.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "society_id")
	private Society society;
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	@ManyToMany
	@JoinTable(name = "game_registration", joinColumns = @JoinColumn(name = "registration_id"), inverseJoinColumns = @JoinColumn(name = "game_id"))
	private List<Game> games = new ArrayList<>();
	private int tablesQuantity;
	private boolean electricalSupplyNeed;
	private boolean saleOption;
	private boolean volunteersNeed;
	private String comments;
	private float registrationCost;
	private String state;

	
	public Registration() {

	}
	

	public Long getId() {

		return this.id;
	}
	

	public void setId(Long id) {

		this.id = id;
	} 
	

	public Society getSociety() {
		
		return this.society;
	}
	

	public void setSociety(Society society) {
		
		this.society = society;
	}
	

	public Event getEvent() {
		
		return this.event;
	}
	

	public void setEvent(Event event) {
		
		this.event = event;
	}
	

	public List<Game> getGames() {
		return this.games;
	}


	public void setGames(List<Game> games) {
		this.games = games;
	}


	public int getTablesQuantity() {
		
		return this.tablesQuantity;
	}
	

	public void setTablesQuantity(int tablesQuantity) {
		
		this.tablesQuantity = tablesQuantity;
	}
	

	public boolean isElectricalSupplyNeed() {
		
		return this.electricalSupplyNeed;
	}
	

	public void setElectricalSupplyNeed(boolean electricalSupplyNeed) {
		
		this.electricalSupplyNeed = electricalSupplyNeed;
	}
	

	public boolean isSaleOption() {
		
		return this.saleOption;
	}
	

	public void setSaleOption(boolean saleOption) {
		
		this.saleOption = saleOption;
	}


	public boolean isVolunteersNeed() {
		
		return this.volunteersNeed;
	}


	public void setVolunteersNeed(boolean volunteersNeed) {
		
		this.volunteersNeed = volunteersNeed;
	}


	public String getComments() {
		
		return this.comments;
	}


	public void setComments(String comments) {
		
		this.comments = comments;
	}


	public float getRegistrationCost() {
		
		return this.registrationCost;
	}


	public void setRegistrationCost(float registrationCost) {
		
		this.registrationCost = registrationCost;
	}


	public String getState() {
		
		return this.state;
	}


	public void setState(String state) {
		
		this.state = state;
	}


}
