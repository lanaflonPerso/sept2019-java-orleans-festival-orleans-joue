package com.wildcodeschool.festivalorleansjoue.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Event {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;
    private short tables;
    private byte protozoneTables;
    private byte maxTablesPerEditor;
    private Date eventBeginningDate;
    private Date eventEndingDate;
    private Date editorsRegistrationBeginDate;
    private Date editorsRegistrationEndDate;
    private Date shopsRegistrationBeginDate;
    private Date shopsRegistrationEndDate;
    private Date volunteersRegistrationBeginDate;
    private Date volunteersRegistrationEndDate;
    
    @ManyToMany
    @JoinTable(name = "EventTasks",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<EventTasks> tasks = new ArrayList<>();

    
	public Event() {
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
	
	
	public short getTables() {
		
		return this.tables;
	}
	
	
	public void setTables(short tables) {
		
		this.tables = tables;
	}
	
	
	public byte getProtozoneTables() {
		
		return this.protozoneTables;
	}
	
	
	public void setProtozoneTables(byte protozoneTables) {
		
		this.protozoneTables = protozoneTables;
	}
	
	
	public Date getEventBeginningDate() {
		
		return this.eventBeginningDate;
	}
	
	
	public void setEventBeginningDate(Date eventBeginningDate) {
		
		this.eventBeginningDate = eventBeginningDate;
	}
	
	
	public Date getEventEndingDate() {
		
		return this.eventEndingDate;
	}
	
	
	public void setEventEndingDate(Date eventEndingDate) {
		
		this.eventEndingDate = eventEndingDate;
	}
	
	
	public Date getEditorsRegistrationBeginDate() {
		
		return this.editorsRegistrationBeginDate;
	}
	
	
	public void setEditorsRegistrationBeginDate(Date editorsRegistrationBeginDate) {
		
		this.editorsRegistrationBeginDate = editorsRegistrationBeginDate;
	}
	
	
	public Date getEditorsRegistrationEndDate() {
		
		return this.editorsRegistrationEndDate;
	}
	
	
	public void setEditorsRegistrationEndDate(Date editorsRegistrationEndDate) {
		
		this.editorsRegistrationEndDate = editorsRegistrationEndDate;
	}
	
	
	public Date getShopsRegistrationBeginDate() {
		
		return this.shopsRegistrationBeginDate;
	}
	
	
	public void setShopsRegistrationBeginDate(Date shopsRegistrationBeginDate) {
		
		this.shopsRegistrationBeginDate = shopsRegistrationBeginDate;
	}
	
	
	public Date getShopsRegistrationEndDate() {
		
		return this.shopsRegistrationEndDate;
	}
	
	
	public void setShopsRegistrationEndDate(Date shopsRegistrationEndDate) {
		
		this.shopsRegistrationEndDate = shopsRegistrationEndDate;
	}
	
	
	public Date getVolunteersRegistrationBeginDate() {
		
		return this.volunteersRegistrationBeginDate;
	}
	
	
	public void setVolunteersRegistrationBeginDate(Date volunteersRegistrationBeginDate) {
		
		this.volunteersRegistrationBeginDate = volunteersRegistrationBeginDate;
	}
	
	
	public Date getVolunteersRegistrationEndDate() {
		
		return this.volunteersRegistrationEndDate;
	}
	
	
	public void setVolunteersRegistrationEndDate(Date volunteersRegistrationEndDate) {
		
		this.volunteersRegistrationEndDate = volunteersRegistrationEndDate;
	}


	public byte getMaxTablesPerEditor() {
		
		return this.maxTablesPerEditor;
	}


	public void setMaxTablesPerEditor(byte maxTablesPerEditor) {
		
		this.maxTablesPerEditor = maxTablesPerEditor;
	}


	public List<EventTasks> getTasks() {
		
		return this.tasks;
	}


	public void setTasks(List<EventTasks> tasks) {
		
		this.tasks = tasks;
	}
    
	
}
