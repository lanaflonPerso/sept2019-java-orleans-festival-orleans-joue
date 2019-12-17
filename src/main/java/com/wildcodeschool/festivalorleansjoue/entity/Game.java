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
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	String name;
	String author;
	String description;
	String publicationDate;
	String picture;
	String webLink;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "games")
	//@ManyToMany
	//@JoinTable(name = "game_registration", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "registration_id"))
	private List<Registration> registrations = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "society_id")
	private Society society;
	
		
	public Game() {
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


	public String getAuthor() {
		
		return this.author;
	}


	public void setAuthor(String author) {
		
		this.author = author;
	}


	public String getDescription() {
		
		return this.description;
	}


	public void setDescription(String descrption) {
		
		this.description = descrption;
	}


	public String getPublicationDate() {
		
		return this.publicationDate;
	}


	public void setPublicationDate(String publicationDate) {
		
		this.publicationDate = publicationDate;
	}


	public String getPicture() {
		
		return this.picture;
	}


	public void setPicture(String picture) {
		
		this.picture = picture;
	}


	public String getWebLink() {
		
		return this.webLink;
	}


	public void setWebLink(String webLink) {
		
		this.webLink = webLink;
	}


	public Society getSociety() {
		
		return this.society;
	}


	public void setSociety(Society society) {
		
		this.society = society;
	}


	public List<Registration> getRegistrations() {
		
		return this.registrations;
	}


	public void setRegistrations(List<Registration> registrations) {
		
		this.registrations = registrations;
	}	
	
}
