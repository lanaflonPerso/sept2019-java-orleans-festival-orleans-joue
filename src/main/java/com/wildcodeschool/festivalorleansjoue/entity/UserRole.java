package com.wildcodeschool.festivalorleansjoue.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String wording;
	

	public UserRole() {
		super();
	}

	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getWording() {
		return wording;
	}
	
	
	public void setWording(String wording) {
		this.wording = wording;
	}
}
