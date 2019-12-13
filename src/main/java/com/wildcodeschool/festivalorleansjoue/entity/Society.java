package com.wildcodeschool.festivalorleansjoue.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Society {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	@OneToMany(mappedBy = "society")
	private List<Referent> referents = new ArrayList<Referent>();
	@OneToMany(mappedBy = "society")
	private List<Game> game = new ArrayList<Game>();
	@OneToMany(mappedBy = "society", cascade = CascadeType.ALL)
	private List<Registration> regList = new ArrayList<>();
	@OneToMany(mappedBy = "society")
	private List<Agent> agents = new ArrayList<Agent>();


	public Society() {

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
	

	public List<Referent> getReferents() {

		return this.referents;
	}
	

	public void setReferents(List<Referent> referents) {

		this.referents = referents;
	}
	

	public Address getAddress() {

		return this.address;
	}
	

	public void setAddress(Address address) {

		this.address = address;
	}


	public List<Registration> getRegList() {
		
		return regList;
	}


	public void setRegList(List<Registration> regList) {
		
		this.regList = regList;
	}


	public List<Game> getGame() {
		
		return this.game;
	}


	public void setGame(List<Game> game) {
		
		this.game = game;
	}


	public List<Agent> getAgents() {
		return this.agents;
	}


	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}	

}
