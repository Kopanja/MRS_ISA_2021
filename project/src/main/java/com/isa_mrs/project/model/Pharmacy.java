package com.isa_mrs.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PHARMACY")
public class Pharmacy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", length = 50)
	private String name;
	
	@Column(name="address", length = 50)
	private String address;
	
	@Column(name="description", length = 250)
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pharmacy")
	private Set<Examination> avaliableExeminations;
	
	@OneToMany(mappedBy = "pharmacy")
    Set<MedicineInPharmacy> avaliableMedication;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pharmacy")
	private Set<Employee> employees;
	
	@Column(name= "rating")
	private double rating;

	
	
	public Pharmacy() {
		super();
	}



	public Pharmacy(Long id, String name, String address, String description, Set<Examination> avaliableExeminations,
			Set<MedicineInPharmacy> avaliableMedication, Set<Employee> employees, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.avaliableExeminations = avaliableExeminations;
		this.avaliableMedication = avaliableMedication;
		this.employees = employees;
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



	public Set<Examination> getAvaliableExeminations() {
		return avaliableExeminations;
	}



	public void setAvaliableExeminations(Set<Examination> avaliableExeminations) {
		this.avaliableExeminations = avaliableExeminations;
	}



	public Set<MedicineInPharmacy> getAvaliableMedication() {
		return avaliableMedication;
	}



	public void setAvaliableMedication(Set<MedicineInPharmacy> avaliableMedication) {
		this.avaliableMedication = avaliableMedication;
	}



	public Set<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}



	public double getRating() {
		return rating;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	

}
