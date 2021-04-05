package com.isa_mrs.project.dto;



public class PharmacyDTO {

	private Long id;

	private String name;

	private String address;
	
	private String description;
	
	private double rating;

	
	public PharmacyDTO() {
	}


	public PharmacyDTO(Long id, String name, String address, String description, double rating) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.rating = rating;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	
}
