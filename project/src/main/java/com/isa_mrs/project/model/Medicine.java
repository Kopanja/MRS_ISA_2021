package com.isa_mrs.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEDICINE")
public class Medicine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", length = 50, unique=true)
	private String name;

	@OneToMany(mappedBy = "medicine")
    Set<MedicineInPharmacy> pharmacies;
	
	
	public Medicine() {
		super();
	}



	public Medicine(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public Medicine(Long id, String name, Set<MedicineInPharmacy> pharmacies) {
		super();
		this.id = id;
		this.name = name;
		this.pharmacies = pharmacies;
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



	public Set<MedicineInPharmacy> getPharmacies() {
		return pharmacies;
	}



	public void setPharmacies(Set<MedicineInPharmacy> pharmacies) {
		this.pharmacies = pharmacies;
	}
	
	
	
}
