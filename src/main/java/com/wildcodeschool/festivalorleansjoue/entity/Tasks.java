package com.wildcodeschool.festivalorleansjoue.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	

	public Tasks() {

	}
	

	public Long getId() {

		return this.id;
	}
	

	public void setId(Long id) {

		this.id = id;
	}
	

	public String getName() {

		return this.name;
	}
	

	public void setName(String name) {

		this.name = name;
	}
	
}
