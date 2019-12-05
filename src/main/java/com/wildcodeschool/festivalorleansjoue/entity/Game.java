package com.wildcodeschool.festivalorleansjoue.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@ManyToOne
	@JoinColumn(name = "event_id")
	private  Event event;
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



	public Event getEvent() {
		return this.event;
	}



	public void setEvent(Event event) {
		this.event = event;
	}



	public Society getSociety() {
		return this.society;
	}



	public void setSociety(Society society) {
		this.society = society;
	}
	
	
	
}
