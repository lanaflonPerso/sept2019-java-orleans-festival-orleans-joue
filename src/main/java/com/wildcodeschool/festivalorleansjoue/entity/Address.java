package com.wildcodeschool.festivalorleansjoue.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String wording;
	private int phoneNumber1;
	private int phoneNumber2;
	private String remarks;
	private String address1;
	private String address2;
	private String address3;
	private int postalCode;
	private String city;
	private String contactEmail;
	

	public Address() {

	}

	public Long getId() {

		return this.id;
	}
	

	public void setId(Long id) {

		this.id = id;
	}
	

	public String getWording() {

		return this.wording;
	}
	

	public void setWording(String wording) {

		this.wording = wording;
	}
	

	public int getPhoneNumber1() {

		return this.phoneNumber1;
	}
	

	public void setPhoneNumber1(int phoneNumber1) {

		this.phoneNumber1 = phoneNumber1;
	}
	

	public int getPhoneNumber2() {

		return this.phoneNumber2;
	}
	

	public void setPhoneNumber2(int phoneNumber2) {

		this.phoneNumber2 = phoneNumber2;
	}
	

	public String getRemarks() {

		return this.remarks;
	}
	

	public void setRemarks(String remarks) {

		this.remarks = remarks;
	}
	

	public String getAddress1() {

		return this.address1;
	}
	

	public void setAddress1(String adress1) {

		this.address1 = adress1;
	}
	

	public String getAddress2() {

		return this.address2;
	}
	

	public void setAddress2(String adress2) {

		this.address2 = adress2;
	}
	

	public String getAddress3() {

		return this.address3;
	}
	

	public void setAddress3(String adress3) {

		this.address3 = adress3;
	}
	

	public int getPostalCode() {

		return this.postalCode;
	}
	

	public void setPostalCode(int postalCode) {

		this.postalCode = postalCode;
	}
	

	public String getCity() {

		return this.city;
	}
	

	public void setCity(String city) {

		this.city = city;
	}
	

	public String getContactEmail() {

		return this.contactEmail;
	}
	

	public void setContactEmail(String contactEmail) {

		this.contactEmail = contactEmail;
	}
}
