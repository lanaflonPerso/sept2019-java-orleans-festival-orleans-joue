package com.wildcodeschool.festivalorleansjoue.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private int tablesQuantity;
	private boolean electricalSupplyNeed;
	private boolean saleOption;
	private boolean volunteersNeed;
	private String comments;
	private float registrationCost;

	
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
	

	public void setEventId(Event event) {
		
		this.event = event;
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
		return registrationCost;
	}


	public void setRegistrationCost(float registrationCost) {
		this.registrationCost = registrationCost;
	}

}
